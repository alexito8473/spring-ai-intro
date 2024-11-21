package com.example.springaiintro.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpenAiServiceImpl implements OpenAIServices{
    private final ChatModel chatModel;
    public OpenAiServiceImpl(ChatModel chatModel) {
        this.chatModel=chatModel;
    }
    @Override
    public String getAnswer( String question ) {
        PromptTemplate promptTemplate= new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse response= chatModel.call(prompt);
        return response.getResult().getOutput().getContent();
    }
}
