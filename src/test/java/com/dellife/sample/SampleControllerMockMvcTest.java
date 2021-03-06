package com.dellife.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerMockMvcTest {

    @MockBean
    SampleService sampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void mockMvcTest() throws Exception {
        //given
        when(sampleService.getName())
                .thenReturn("sehee");

        //when
        //then
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello sehee"));

    }
}
