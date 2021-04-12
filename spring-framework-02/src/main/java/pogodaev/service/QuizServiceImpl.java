package pogodaev.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pogodaev.dao.QuestionDao;
import pogodaev.domain.Question;
import pogodaev.domain.QuizResult;


import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuestionDao questionDao;
    private final int minimumPassRate;
    private final MessageSource messageSource;

    public QuizServiceImpl(QuestionDao questionDao, @Value("${minimum.pass.rate}") int minimumPassRate, MessageSource messageSource) {
        this.questionDao = questionDao;
        this.minimumPassRate = minimumPassRate;
        this.messageSource = messageSource;
    }

    public QuizResult start(Scanner scanner) throws IOException {
        List<Question> questionList = questionDao.getQuestions();
        AtomicInteger correctAnswersCount = new AtomicInteger(0);

        for (Question question : questionList) {
            System.out.print(messageSource.getMessage("ask.1", null, Locale.getDefault()));
            System.out.println(messageSource.getMessage(question.getQuestion(), null, Locale.getDefault()));
            System.out.println(messageSource.getMessage("ask.2", null, Locale.getDefault()));
            String answer = scanner.nextLine();
            String correctAnswer = messageSource.getMessage(question.getCorrectAnswer(), null, Locale.getDefault());
            if (correctAnswer.equalsIgnoreCase(answer)) {
                correctAnswersCount.getAndIncrement();
            }
        }
        return new QuizResult(correctAnswersCount.get(), minimumPassRate);
    }
}
