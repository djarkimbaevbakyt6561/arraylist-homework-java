package models;

import db.Database;
import enums.Genre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {
    private Long id;
    private String name;
    private String author;
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book " + name +
                ", id=" + id +
                ", author='" + author +
                ", genre=" + genre;
    }

    public static Book createBook() {
        Book newBook = new Book();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название книги: ");
        newBook.setName(scanner.nextLine());
        System.out.print("Введите автора: ");
        newBook.setAuthor(scanner.nextLine());
        while (true) {
            for (int i = 0; i < Genre.values().length; i++) {
                System.out.println((i + 1) + ". " + Genre.values()[i]);
            }
            System.out.print("Введите жанр: ");
            String name = scanner.nextLine();
            boolean found = false;
            for (Genre genre : Genre.values()) {
                if (genre.toString().equals(name.toUpperCase())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                newBook.setGenre(Genre.valueOf(name.toUpperCase()));
                break;
            } else {
                System.out.println("Неправильный жанр!");
            }
        }
        if (newBook.getName().isEmpty() || newBook.getAuthor().isEmpty()) {
            System.out.println("Поле не должны быть пустыми!");
        } else {
            return newBook;
        }
        return null;

    }
}
