package ru.otus.pogodaev.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private final String question;
    private final String correctAnswer;
}
