package com.company.makkkkkkkks.service;

import com.company.makkkkkkkks.entity.Books;
import com.company.makkkkkkkks.entity.User;
import com.company.makkkkkkkks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Books getBookById(Long id) {
        return bookRepository.getBooksById(1l);
    }

    public boolean addBook(Books book) {
        bookRepository.createBooks(book);
        return true;
    }

    public List<Books> findAllBooks(Long id) {
        return bookRepository.showAllBooks(id);
    }

    public boolean updateBook(Long id, String name) {
        Books book = bookRepository.getBooksById(id);
        book.setName(name);
        return bookRepository.updateBooks(book);
    }

    public void createBook(Books book) {
        bookRepository.createBooks(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBooks(id);
    }
}
