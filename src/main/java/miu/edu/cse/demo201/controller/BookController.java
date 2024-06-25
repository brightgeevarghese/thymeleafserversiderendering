package miu.edu.cse.demo201.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.demo201.Service.BookService;
import miu.edu.cse.demo201.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getBookPage(
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String email,
            Model model
            ) {
//        System.out.println(login + ":" + email);
        //pass data to client
        model.addAttribute("login", login);
//        model.addAttribute("email", email);
        List<Book> books = bookService.getAllBooks(login);
        model.addAttribute("books", books);
        return "book_page";
    }

    @GetMapping("/create")
    public String createBookPage(
            Model model
    ) {
        model.addAttribute("newBook", new Book());
        return "create_book_page";
    }

    @PostMapping("/createBook")
    public String createBook(
            @ModelAttribute Book book
    ) {
        bookService.save(book);
        return "redirect:/books";
    }


}
