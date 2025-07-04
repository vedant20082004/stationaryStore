package com.thinkconstructive.books_store.controller;

import com.thinkconstructive.books_store.dto.BookDto;
import com.thinkconstructive.books_store.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/book-store")
public class BookControler {

    BookService bookService;


    public BookControler(BookService bookService){
        this.bookService= bookService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String>  welcomeMessage(){
        return new ResponseEntity<>("WELCOME TO MY PROJ.", HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBooks(){

        List<BookDto> bookDtoList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto){
        BookDto bookDto1 = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> updateBooks(@RequestBody BookDto bookDto){

        BookDto bookDto1 = bookService.updateBookName(bookDto);

        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBooks(@PathVariable String bookId){
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book Deletion Done" + bookId, HttpStatus.OK);
    }

}
