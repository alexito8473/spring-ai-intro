package com.example.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalResponse(@JsonPropertyDescription("Esta es el nombre de la ciudad") String answer) {
}
