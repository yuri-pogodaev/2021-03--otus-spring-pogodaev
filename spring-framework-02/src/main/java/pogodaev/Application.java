package pogodaev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pogodaev.service.StartService;

@ComponentScan
@Configuration
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        StartService startService = ctx.getBean(StartService.class);
        startService.startQuiz();
    }
}
