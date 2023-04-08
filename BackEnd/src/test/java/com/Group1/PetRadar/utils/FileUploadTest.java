package com.Group1.PetRadar.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.jayway.jsonpath.InvalidPathException;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class FileUploadTest {
	
	@InjectMocks
	FileUpload fileUpload;
	
	@Mock
	Path pathMock;
	
	@Mock
	MultipartFile multipartFileMock;


	@Test
	public void saveFileTest() throws IOException {
		byte[] b = new byte[20];
		new Random().nextBytes(b);		
		MultipartFile multiPartFile = new MockMultipartFile("mock", b);
		
		File dummyFile = new File("");
		Assertions.assertEquals("file", fileUpload.saveFile("file","dd", multiPartFile));
		
	}
	
	@Test
	public void saveFileTestNegative() throws IOException {
		byte[] b = new byte[20];
		new Random().nextBytes(b);		
		MultipartFile multiPartFile = new MockMultipartFile("mock", b);
		
		File dummyFile = new File("");
		Assertions.assertNotEquals("wrongFile", fileUpload.saveFile("file","dd", multiPartFile));
		
	}
	
	@Test
	public void saveFileTestNegativeException() throws IOException {
		byte[] b = null;
//		new Random().nextBytes(b);		
		MultipartFile multiPartFile = new MockMultipartFile("mock", b);
		
		File dummyFile = new File("");
		when(multipartFileMock.getInputStream()).thenThrow(IOException.class);
		when(pathMock.resolve(anyString())).thenThrow(InvalidPathException.class);
		Assertions.assertThrows(IOException.class,()->{ fileUpload.saveFile("file","dd", multipartFileMock);});
		
	}

}
