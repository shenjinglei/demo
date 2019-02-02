package com.example;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.web.HelloController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception{
        userRepository.save(new User(1L,"didi", 30));
        userRepository.save(new User(2L,"nana", 40));
        userRepository.save(new User(3L, "kaka", 50));
        Assert.assertEquals(3,userRepository.findAll().size());

        User u = userRepository.findById(1L).get();
        userRepository.delete(u);
        Assert.assertEquals(2,userRepository.findAll().size());

        u = userRepository.findByUsername("nana");
        userRepository.delete(u);
        Assert.assertEquals(1,userRepository.findAll().size());
    }
}

