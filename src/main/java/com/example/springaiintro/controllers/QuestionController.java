package com.example.springaiintro.controllers;

import com.example.springaiintro.model.*;
import com.example.springaiintro.services.OpenAIServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private final OpenAIServices openAIServices;
    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question ){
        return openAIServices.getAnswer(question);
    }
    @PostMapping("/capital")
    public GetCapitalResponse askCapital( @RequestBody GetCapitalRequest getCapitalRequest ){
        return openAIServices.getCapital(getCapitalRequest);
    }
    @PostMapping("/capitalWithInfo")
    public GetCapitalWithInfoResponse askCapitalWithInfo( @RequestBody GetCapitalRequest getCapitalRequest ){
        return openAIServices.getCapitalWithInfo(getCapitalRequest);
    }

}
