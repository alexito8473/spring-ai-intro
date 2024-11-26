package com.example.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalWithInfoResponse(@JsonPropertyDescription("Nombre de la ciudad") String city,
                                         @JsonPropertyDescription("Numero de la población")int population,
                                         @JsonPropertyDescription("La región de la ciudad")String region,
                                         @JsonPropertyDescription("El lenguaje de la ciudad")String language) {
}
