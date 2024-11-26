package com.example.springaiintro.services;

import com.example.springaiintro.model.*;

public interface OpenAIServices {
    GetCapitalResponse getCapital( GetCapitalRequest getCapitalRequest );
    GetCapitalWithInfoResponse getCapitalWithInfo( GetCapitalRequest getCapitalRequest );
    Answer getAnswer( Question question);
}
