package com.thinkconstructive.books_store.repository;

import com.thinkconstructive.books_store.Entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface BookRepository extends MongoRepository<Book, String> {

    // @Query("{ bookId : ?0 }")
    @Query(value = "{ 'bookId' : {$eq : ?0} }")
    Book findBookByBookId(String bookId);

    @Query(value = "{ 'bookId' : {$eq : ?0} }")
    @Update(pipeline = { " {'$set' : { 'name' : ?1} } " } )
    void updateBookNameByBookId(String bookId, String bookName);

    @DeleteQuery
    void deleteBookByBookId(String bookId);

}
