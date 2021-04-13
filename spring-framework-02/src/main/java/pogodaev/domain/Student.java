package pogodaev.domain;

import lombok.Data;

@Data

public class Student {
    private String firstname;
    private String lastname;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
