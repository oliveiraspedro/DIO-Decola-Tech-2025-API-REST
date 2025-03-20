package com.dio.exemple_rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTest {

    @Autowired
    private MockMvc mockMvc;

    // Simulando requisição MVC
    @Test
    public void deveRetornarSucessoComCredenciaisValidas() throws Exception{
        URI uri = new URI("/auth/signin");

        String content = "{ \"username\" : \"karantes\" : \"senha\" : \"123456\"}";

        //Construindo a requisição
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveRetornarErroComCredenciaisInvalidas() throws Exception{
        URI uri = new URI("/auth/signin");

        String content = "{ \"username\" : \"karantes\" : \"senha\" : \"134568\"}";

        //Construindo a requisição
        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
}
