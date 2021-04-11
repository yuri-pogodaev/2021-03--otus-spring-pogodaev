package ru.otus.pogodaev.dao;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import ru.otus.pogodaev.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao{
    private final String path;

    public List<Question> getQuestions() throws IOException {
        InputStream is = this.getClass().getResourceAsStream(path);
        List<Question> questionList = new ArrayList<>();

        try(InputStreamReader reader = new InputStreamReader(is);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(';')))
        {
            csvParser.getRecords().forEach(record -> questionList.add(Question.builder()
                    .question(record.get(0))
                    .correctAnswer(record.get(1))
                    .build()));
        }
        return questionList;
    }
}
