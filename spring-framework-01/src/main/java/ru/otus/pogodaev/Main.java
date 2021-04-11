package ru.otus.pogodaev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.pogodaev.service.StartService;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        StartService startService = ctx.getBean(StartService.class);
        startService.startQuiz();
    }
}
