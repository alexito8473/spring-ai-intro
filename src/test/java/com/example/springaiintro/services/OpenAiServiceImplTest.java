package com.example.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpenAiServiceImplTest {
@Autowired
    OpenAIServices openAIServices;
    @Test
    void getAnswer() {
        String answer= openAIServices.getAnswer("Como esta el tiempo hoy");
        System.out.println("La respuesta es ->");
        System.out.println(answer);
    }
}