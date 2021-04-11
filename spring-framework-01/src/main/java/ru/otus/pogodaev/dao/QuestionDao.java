package ru.otus.pogodaev.dao;

import ru.otus.pogodaev.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws IOException;
}
