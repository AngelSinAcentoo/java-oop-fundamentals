package com.angelesco.oop.library;

/** Immutable book value object. */
public record Book(String title, String author) {
    public Book {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author cannot be blank");
        }
        title = title.trim();
        author = author.trim();
    }
}
