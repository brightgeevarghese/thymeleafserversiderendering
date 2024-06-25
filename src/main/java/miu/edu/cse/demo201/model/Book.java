package miu.edu.cse.demo201.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private Integer year;

    public Book() {

    }
}
