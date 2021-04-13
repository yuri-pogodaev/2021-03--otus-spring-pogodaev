package ru.otus.pogodaev.service;

import lombok.RequiredArgsConstructor;
import ru.otus.pogodaev.domain.QuizResult;
import ru.otus.pogodaev.domain.Student;

import java.io.IOException;
import java.util.Scanner;

@RequiredArgsConstructor
public class StartServiceImpl implements StartService {
    private final QuizService quizService;

    public void startQuiz() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the testing system!");

        System.out.print("Enter your name: ");
        String firstname = scanner.nextLine();

        Student student = Student.builder().firstname(firstname).build();

        QuizResult quizResult = quizService.start(scanner);

        String resultMessage;
        if (quizResult.isPassed()) {
            resultMessage = String.format("%s, congratulations! Test passed successfully! Number of correct answers: %d.",
                    student.getFirstname(), quizResult.getCorrectAnswersCount());
        } else {
            resultMessage = String.format("%s, unfortunately, the test is failed. Number of correct answers: %d.",
                    student.getFirstname(), quizResult.getCorrectAnswersCount());
        }
        System.out.println(resultMessage);
    }
}
