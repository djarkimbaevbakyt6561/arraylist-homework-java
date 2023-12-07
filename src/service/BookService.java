package service;

import models.Book;

import java.util.List;

public interface BookService {
    void saveBook(Long libraryId, Book book);
    List<Book> getAllBooksByLibraryId(Long libraryId);
    List<Book> getAllBooks();

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
