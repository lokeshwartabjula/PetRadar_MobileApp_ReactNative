package com.Group1.PetRadar.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Service.PostService;
import com.Group1.PetRadar.Controller.*;
import com.Group1.PetRadar.Service.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
//@ContextConfiguration(classes = {PostController.class, PostService.class})
class PostControllerTest {
	
	@InjectMocks
	PostController postController;
	
	@Mock
	PostService postServiceMock;

	@Test
	public void createPostTest() throws Exception {
		AddPostDTO dummyAddPostDto = new AddPostDTO();
		PostModel dummyPostModel = new PostModel();
		
		dummyPostModel.setDescription("notNullDesc");
		when(postServiceMock.savePost(any(AddPostDTO.class))).thenReturn(dummyPostModel);
		Assert.assertEquals(dummyPostModel, postController.createPost(dummyAddPostDto));
	}
	
	@Test
	public void getPostByIdTest() {
		PostModel dummyPostModel = new PostModel();
		UUID dummyUUID = new UUID(2l, 3l);
		
		dummyPostModel.setDescription("notNulDesc");
		when(postServiceMock.getPostById(any(UUID.class))).thenReturn(dummyPostModel);
		Assert.assertEquals(dummyPostModel, postController.getPostById(dummyUUID));
	}
	
	@Test
	public void updatePostTest1() {
		PostModel dummyPostModel = new PostModel();
		
		dummyPostModel.setDescription("notNulDesc");
		when(postServiceMock.updatePost(any(PostModel.class))).thenReturn(dummyPostModel);
		Assert.assertEquals(dummyPostModel, postController.updatePost(dummyPostModel));
	}
	
	@Test
	public void deletePostByIdTest() {
		UUID dummyUUID = new UUID(2l, 3l);
		when(postServiceMock.deletePostById(any(UUID.class))).thenReturn("deleteString");
		Assert.assertEquals("deleteString", postController.deletePostById(dummyUUID));
	}

}
