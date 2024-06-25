package miu.edu.cse.demo201.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    private LocalDate birthday;
    private String profession;
}
