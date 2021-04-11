package ru.otus.pogodaev.service;

import ru.otus.pogodaev.domain.QuizResult;

import java.io.IOException;
import java.util.Scanner;

public interface QuizService {
    QuizResult examine(Scanner scanner) throws IOException;
}
