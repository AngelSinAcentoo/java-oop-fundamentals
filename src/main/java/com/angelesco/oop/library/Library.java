package com.angelesco.oop.library;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/** In-memory library catalog with normalized title lookup. */
public final class Library {
    private final Map<String, Book> books = new LinkedHashMap<>();

    public void add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        String key = normalize(book.title());
        if (books.containsKey(key)) {
            throw new IllegalArgumentException("a book with that title already exists");
        }
        books.put(key, book);
    }

    public Optional<Book> findByTitle(String title) {
        return Optional.ofNullable(books.get(normalize(title)));
    }

    public boolean removeByTitle(String title) {
        return books.remove(normalize(title)) != null;
    }

    public List<Book> inventory() {
        return List.copyOf(books.values());
    }

    private String normalize(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        return title.trim().toLowerCase(Locale.ROOT);
    }
}
