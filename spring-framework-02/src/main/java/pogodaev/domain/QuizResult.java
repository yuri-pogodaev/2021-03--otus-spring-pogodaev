package pogodaev.domain;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class QuizResult {
    private final int correctAnswersCount;
    private final int minimumPassRate;
    private final boolean isPassed;

    public QuizResult(int correctAnswersCount, int minimumPassRate) {
        this.correctAnswersCount = correctAnswersCount;
        this.minimumPassRate = minimumPassRate;
        this.isPassed = correctAnswersCount >= minimumPassRate;
    }
}
