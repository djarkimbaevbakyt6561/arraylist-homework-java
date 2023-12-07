package db;

import models.Book;
import models.Library;
import models.Reader;
import service.BookService;
import service.LibraryService;
import service.ReaderService;

import java.util.ArrayList;
import java.util.List;

public class Database implements BookService, LibraryService, ReaderService {
    private final List<Library> libraries = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    @Override
    public void saveBook(Long libraryId, Book book) {
        for (Library library : libraries) {
            if(library.getId().equals(libraryId)){
                library.books.add(book);
            }
        }
        books.add(book);
    }

    @Override
    public List<Book> getAllBooksByLibraryId(Long libraryId) {
        for (Library library : libraries) {
            if(library.getId().equals(libraryId)){
                return library.books;
            }
        }
        return null;
    }
    public List<Book> getAllBooks(){
        return books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if(library.getId().equals(libraryId)){
                for (Book book : library.books) {
                    if(book.getId().equals(libraryId)){
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : libraries) {
            if(library.getId().equals(libraryId)){
                for (Book book : library.books) {
                    if(book.getId().equals(libraryId)){
                        books.remove(book);
                        library.books.remove(book);
                        return "Успешно удалено";
                    }
                }
            }
        }
        return "Неправильный ID";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : libraries) {
            if(libraryId.equals(library.getId())){
                library.books.clear();
            }
        }
    }

    @Override
    public void saveLibrary(Library library) {
        libraries.add(library);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : libraries) {
            if(library.getId().equals(id)){
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < libraries.size(); i++) {
            if(libraries.get(i).getId().equals(id)){
                libraries.set(i, library);
                return library;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : libraries) {
            if(library.getId().equals(id)){
                libraries.remove(library);
                return "Успешно удалено";
            }
        }
        return "Неправильный ID";
    }

    @Override
    public void saveReader(Reader reader) {
      readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : readers) {
            if(reader.getId().equals(id)){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i).getId().equals(id)){
                readers.set(i, reader);
                return reader;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library : libraries) {
            if(library.getId().equals(libraryId)){
                for (Reader reader : readers) {
                    if(reader.getId().equals(readerId)){
                        library.readers.add(reader);
                    }
                }
            }
        }
    }
}
