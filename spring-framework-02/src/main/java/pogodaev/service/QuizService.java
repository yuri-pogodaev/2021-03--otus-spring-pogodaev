package pogodaev.service;



import pogodaev.domain.QuizResult;

import java.io.IOException;
import java.util.Scanner;

public interface QuizService {
    QuizResult start(Scanner scanner) throws IOException;
}
