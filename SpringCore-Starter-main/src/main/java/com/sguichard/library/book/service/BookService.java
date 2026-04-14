package com.sguichard.library.book.service;

import com.sguichard.library.book.model.exception.BookCreationException;
import com.sguichard.library.book.model.exception.BookResearchException;
import com.sguichard.library.book.persistence.BookRepository;
import com.sguichard.library.book.model.BookEntity;
import io.micrometer.common.util.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBook(){
        return bookRepository.findAll();
    }

    public BookEntity getBookByIsbn(String isbn) throws BookResearchException{
        if(!BookService.isValidISBN(isbn)) throw new BookResearchException("Il faut un ISBN valide");
        BookEntity book = bookRepository.findByIsbn(isbn);
        if(book == null) throw new BookResearchException("Le livre n'existe pas");
        return book;
    }

    public BookEntity createBook(String isbn, String bookName, Integer bookPages, String description) throws BookCreationException {

        if(!BookService.isValidISBN(isbn)) throw new BookCreationException("Il faut un ISBN valide");
        if(StringUtils.isBlank(bookName)) throw new BookCreationException("Il manque le titre du livre");
        if(bookPages == null || bookPages <= 0) throw new BookCreationException("Il manque le nombre de pages du livre");

        BookEntity existingBook = bookRepository.findByIsbn(isbn);

        if(existingBook != null){
            throw new BookCreationException("Le livre existe déjà");
        }

        BookEntity newBook = BookEntity.builder()
                .isbn(isbn)
                .name(bookName)
                .pages(bookPages)
                .description(description)
                .build();

        bookRepository.save(newBook);

        return newBook;
    }

    public static boolean isValidISBN(String rawISBN){
        if(StringUtils.isBlank(rawISBN)) return false;
        String isbn = rawISBN.replaceAll("[\\s-]+", "");
        if(!isbn.matches("\\d{13}")) return false;
        return true;
    }
}
