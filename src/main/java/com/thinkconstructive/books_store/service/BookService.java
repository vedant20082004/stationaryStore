package com.thinkconstructive.books_store.service;

import com.thinkconstructive.books_store.Entity.Book;
import com.thinkconstructive.books_store.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBookName(BookDto bookDto);

    public void  deleteBookByBookId(String bookId);

}
