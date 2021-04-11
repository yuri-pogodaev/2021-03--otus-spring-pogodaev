package ru.otus.pogodaev.service;

import lombok.RequiredArgsConstructor;
import ru.otus.pogodaev.dao.QuestionDao;
import ru.otus.pogodaev.domain.Question;
import ru.otus.pogodaev.domain.QuizResult;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuestionDao questionDao;
    private final int minimumPassRate;

    public QuizResult start(Scanner scanner) throws IOException {
        List<Question> questionList = questionDao.getQuestions();
        int correctAnswersCount = 0;

        for (Question question : questionList) {
            System.out.println("Question: " + question.getQuestion());
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
                correctAnswersCount++;
            }
        }

        return new QuizResult(correctAnswersCount, minimumPassRate);
    }
}
