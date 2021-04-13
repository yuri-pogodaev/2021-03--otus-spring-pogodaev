package pogodaev.dao;



import pogodaev.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws IOException;
}
