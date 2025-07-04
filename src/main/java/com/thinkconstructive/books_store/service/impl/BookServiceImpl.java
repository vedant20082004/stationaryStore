package com.thinkconstructive.books_store.service.impl;

import com.thinkconstructive.books_store.Entity.Book;
import com.thinkconstructive.books_store.dto.BookDto;
import com.thinkconstructive.books_store.mapper.BookMapper;
import com.thinkconstructive.books_store.repository.BookRepository;
import com.thinkconstructive.books_store.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    BookRepository bookRepository;

    public  BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBook(String bookId) {
        Book book = bookRepository.findBookByBookId(bookId);
        BookDto bookDto = BookMapper.toDto(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for(Book book : books){
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        Book book = bookRepository.findBookByBookId(bookDto.bookId());
        if (book == null) {
            throw new RuntimeException("Book not found with bookId: " + bookDto.bookId());
        }
        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }
}
