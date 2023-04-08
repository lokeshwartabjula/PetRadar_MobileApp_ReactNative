package com.Group1.PetRadar.Service.Implementation;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.DTO.post.UdpatePostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.PostRepository;
import com.Group1.PetRadar.Repository.UserRepository;
import com.Group1.PetRadar.Service.PostService;
import com.Group1.PetRadar.Service.UserService;
import com.Group1.PetRadar.utils.AwsService;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Autowired
    AwsService awsService;

    @Autowired
    UserRepository userRepository;

    private void sendNotifications(BigDecimal latitude, BigDecimal longitude) {
        try {
            Collection<User> nearByUsers = userRepository.findUserByLocation(latitude, longitude);

            ArrayList<String> userOSID = new ArrayList<String>();
            nearByUsers.forEach(user -> {
                if (user.getOnesignalUserId() != null)
                    userOSID.add(user.getOnesignalUserId());
            });
            try {
                String jsonResponse;

                URL url = new URL("https://onesignal.com/api/v1/notifications");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setUseCaches(false);
                con.setDoOutput(true);
                con.setDoInput(true);

                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestMethod("POST");

                String strJsonBody = "{"
                        + "\"app_id\": \"89e439d6-260c-4aba-900c-347009c530e5\","
                        + "\"include_player_ids\":" + "[\"" + String.join("\",\"", userOSID) + "\"]" + ","
                        + "\"contents\": {\"en\": \"URGENT!!! Pet Missing, Help!!!\"},"
                        + "\"android_channel_id\": \"39c7e4cb-f83e-40b7-991e-e41e980fa8d0\""
                        + "}";
                byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                con.setFixedLengthStreamingMode(sendBytes.length);

                OutputStream outputStream = con.getOutputStream();
                outputStream.write(sendBytes);

                int httpResponse = con.getResponseCode();

                if (httpResponse >= HttpURLConnection.HTTP_OK
                        && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                    Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                    jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                    scanner.close();
                } else {
                    Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                    jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                    scanner.close();
                }

            } catch (Throwable t) {
                t.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PostModel savePost(AddPostDTO postmodel) throws Exception {
        PostModel newPost = new PostModel();
        User user = null;
        try {
            String userId = postmodel.getUserId().toString();
            user = userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Please enter valid user ID");
        }

        newPost.setDescription(postmodel.getDescription());
        newPost.setPostDate(postmodel.getPostDate());
        newPost.setLatitude(postmodel.getLatitude());
        newPost.setLongitude(postmodel.getLongitude());
        newPost.setImageUrl(awsService.save(postmodel.getImage()));
        newPost.setUserName(postmodel.getUserName());
        newPost.setUserProfilePicture(postmodel.getUserProfilePicture());
        newPost.setUser(user);

        newPost = postRepository.save(newPost);

        sendNotifications(newPost.getLatitude(), newPost.getLongitude());

        return newPost;
    }

    @Override
    public List<PostModel> getPostById(BigDecimal latitude, BigDecimal longitude) {
        Collection<PostModel> posts = postRepository.findPostByLocation(latitude, longitude);
        List<PostModel> postList = new ArrayList<PostModel>();
        posts.forEach(post -> {
            postList.add(post);
        });

        return postList;
    }

    @Override
    public PostModel updatePost(UdpatePostDTO postmodel, UUID id) {
        PostModel existingpost = postRepository.findById(id).orElse(null);
        if (postmodel.getPostDate() != null)
            existingpost.setPostDate(postmodel.getPostDate());
        if (postmodel.getDescription() != null)
            existingpost.setDescription(postmodel.getDescription());
        if (postmodel.getImage() != null) {
            existingpost.setImageUrl(awsService.save(postmodel.getImage()));
        }

        return postRepository.save(existingpost);
    }

    @Override
    public String deletePostById(UUID id) {
        postRepository.deleteById(id);
        return "post deleted!";
    }

}
