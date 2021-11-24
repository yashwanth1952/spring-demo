package com.springboot.thymeleafdemo;

import com.springboot.project.dao.MovieRepository;
import com.springboot.project.entity.Movie;
import com.springboot.project.service.MovieService;
import com.springboot.project.service.MovieServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafdemoApplicationTests {

	@Test
	public void contextLoads() {
	}


}

