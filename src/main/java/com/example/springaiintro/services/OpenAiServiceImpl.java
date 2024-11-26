package com.example.springaiintro.services;

import com.example.springaiintro.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class OpenAiServiceImpl implements OpenAIServices {
    @Autowired
    private final ChatModel chatModel;
    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;
    @Value("classpath:templates/get-capital-with-info-prompt-st")
    private Resource getCapitalWithInfoPrompt;

    private OpenAiServiceImpl( ChatModel chatModel ) {
        this.chatModel = chatModel;
    }

    @Override
    public GetCapitalResponse getCapital( GetCapitalRequest getCapitalRequest ) {
        return callChatWithParser(new BeanOutputConverter<>(GetCapitalResponse.class), getCapitalRequest);
    }

    @Override
    public GetCapitalWithInfoResponse getCapitalWithInfo( GetCapitalRequest getCapitalRequest ) {
        return callChatWithParser(new BeanOutputConverter<>(GetCapitalWithInfoResponse.class), getCapitalRequest);
    }

    @Override
    public Answer getAnswer( Question question ) {
        return new Answer(callChat(new PromptTemplate(question.question()).create()));
    }

    private <T> T callChatWithParser( BeanOutputConverter<T> parser, GetCapitalRequest getCapitalRequest ) {
        return parser.convert(callChat(new PromptTemplate(getCapitalPrompt).create(Map.of("stateOfCountry", getCapitalRequest.stateOfCountry(),
                  "format", parser.getFormat()))));
    }

    private String callChat( Prompt prompt ) {
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
