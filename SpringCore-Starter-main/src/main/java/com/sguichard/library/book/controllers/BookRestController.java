package com.sguichard.library.book.controllers;

import com.sguichard.library.book.dto.BookDTO;
import com.sguichard.library.book.model.BookEntity;
import com.sguichard.library.book.model.exception.BookCreationException;
import com.sguichard.library.book.model.exception.BookResearchException;
import com.sguichard.library.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookEntity getBookByIsbn(@PathVariable String isbn) throws BookResearchException {
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookEntity> getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO.PostOutput createBook(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {
        BookEntity newBook =  bookService.createBook(input.getBookIsbn(), input.getBookName(), input.getBookPages(), input.getBookDescription());

        return BookDTO.PostOutput.builder()
                .bookId(newBook.getId())
                .bookIsbn(newBook.getIsbn())
                .bookName(newBook.getName())
                .bookPages(newBook.getPages())
                .bookDescription(newBook.getDescription())
                .build();
    }

   /* @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity modifyBook(@Valid @RequestBody BookDTO.PutInput input){

    }*/
}
