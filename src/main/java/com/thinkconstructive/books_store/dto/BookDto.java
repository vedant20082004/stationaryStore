package com.thinkconstructive.books_store.dto;

public record BookDto(String bookId, String name,
                      String price, String author, String description) {
}
