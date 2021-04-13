package pogodaev.service;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pogodaev.domain.QuizResult;
import pogodaev.domain.Student;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

@Service
public class StartServiceImpl implements StartService {
    private final QuizService quizService;
    private final MessageSource messageSource;
    private final String locale;

    public StartServiceImpl(QuizService quizService, MessageSource messageSource, @Value("${application.locale}") String locale) {
        this.quizService = quizService;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public void startQuiz() throws IOException {
        Locale.setDefault(LocaleUtils.toLocale(locale));
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("welcome", null, Locale.getDefault()));

        System.out.println(messageSource.getMessage("enter.firstname", null, Locale.getDefault()));
        String firstname = scanner.nextLine();

        System.out.println(messageSource.getMessage("enter.lastname", null, Locale.getDefault()));
        String lastname = scanner.nextLine();

        Student student = new Student(firstname, lastname);
        QuizResult quizResult = quizService.start(scanner);

        String resultMessage;
        if (quizResult.isPassed()) {
            resultMessage = messageSource.getMessage("congratulation",
                    new Object[] { student.getFirstname() + " " + student.getLastname(), quizResult.getCorrectAnswersCount() }, Locale.getDefault());
        } else {
            resultMessage = messageSource.getMessage("fail",
                    new Object[] { student.getFirstname() + " " + student.getLastname(), quizResult.getCorrectAnswersCount() }, Locale.getDefault());
        }
        System.out.println(resultMessage);
    }
}
