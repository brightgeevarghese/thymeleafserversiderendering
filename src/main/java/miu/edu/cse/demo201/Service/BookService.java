package miu.edu.cse.demo201.Service;

import miu.edu.cse.demo201.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static List<Book> books;

    static {
        books = new ArrayList<>();
        books.add(new Book("t1", 2020));
        books.add(new Book("t2", 2021));
        books.add(new Book("t3", 2022));
        books.add(new Book("t4", 2023));
    }

    public List<Book> getAllBooks(String login) {
        if (login != null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getYear() < 2022)
                .toList();
    }

    public void save(Book book) {
        books.add(book);
    }
}
