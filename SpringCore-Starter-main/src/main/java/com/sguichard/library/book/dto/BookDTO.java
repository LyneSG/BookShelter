package com.sguichard.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BookDTO {

    @Data
    @AllArgsConstructor
    @Builder
    public static class PostInput{

        @NotNull @NotBlank
        String bookIsbn;

        @NotNull @NotBlank
        String bookName;

        @NotNull @NotBlank
        String bookAuthor;

        @NotNull
        Integer bookPages;

        String bookDescription;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class PostOutput{
        Long bookId;
        String bookIsbn;
        String bookName;
        String bookAuthor;
        Integer bookPages;
        String bookDescription;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class PutInput{
        @NotNull @NotBlank
        String bookIsbn;
        String bookName;
        String bookAuthor;
        Integer bookPages;
        String bookDescription;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class PutOutput{
        Long bookId;
        String bookIsbn;
        String bookName;
        String bookAuthor;
        Integer bookPages;
        String bookDescription;
    }
}
