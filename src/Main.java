import db.Database;
import enums.Gender;
import models.Book;
import models.Library;
import models.Reader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    1.  Посмотреть все книги
                    2.  Посмотреть всех читателей
                    3.  Посмотреть все библиотеки
                    4.  Посмотреть все книги библиотеки
                    5.  Посмотреть книгу по id
                    6.  Посмотреть читателя по id
                    7.  Посмотреть библиотеку по id
                    8.  Добавить читателя
                    9.  Добавить книгу
                    10. Добавить библиотеку
                    11. Обновить читателя
                    12. Обновить библиотеку
                    13. Удалить книгу
                    14. Удалить библиотеку
                    15. Очистить все книги
                    16. Добавить читателя к библиотеке
                    17. Выйти""");

            String num = scanner.nextLine();
            switch (num) {
                case "1" -> {
                    if (database.getAllBooks().isEmpty()) {
                        System.out.println("Книг нету!");
                    } else {
                        System.out.println("Все книги: ");
                        for (Book book : database.getAllBooks()) {
                            System.out.println(book);
                        }
                    }
                }
                case "2" -> {
                    if (database.getAllReaders().isEmpty()) {
                        System.out.println("Читателей нету!");
                    } else {
                        System.out.println("Все читатели: ");
                        for (Reader reader : database.getAllReaders()) {
                            System.out.println(reader);
                        }
                    }
                }
                case "3" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        System.out.println("Все библиотеки: ");
                        for (Library library : database.getAllLibraries()) {
                            System.out.println(library);
                        }
                    }
                }
                case "4" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        try {
                            System.out.println("Все библиотеки");
                            for (Library library : database.getAllLibraries()) {
                                System.out.println(library);
                            }
                            System.out.print("Введите id библиотеки: ");
                            Long id = scanner.nextLong();
                            Library foundLibrary = null;
                            for (Library library : database.getAllLibraries()) {
                                if (library.getId().equals(id)) {
                                    foundLibrary = library;
                                    break;
                                }
                            }
                            if (foundLibrary != null) {
                                if (foundLibrary.books.isEmpty()) {
                                    System.out.println("Книг нету!");
                                } else {
                                    System.out.println("Все книги: ");
                                    for (Book book : foundLibrary.books) {
                                        System.out.println(book);
                                    }
                                }
                                scanner.nextLine();

                            } else {
                                System.out.println("Библиотека не найдена!");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Введите число!");
                            scanner.nextLine();
                        }

                    }

                }
                case "5" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        try {
                            System.out.println("Все библиотеки");
                            for (Library library : database.getAllLibraries()) {
                                System.out.println(library);
                            }
                            System.out.print("Введите id библиотеки: ");
                            Long id = scanner.nextLong();
                            Library foundLibrary = null;
                            for (Library library : database.getAllLibraries()) {
                                if (library.getId().equals(id)) {
                                    foundLibrary = library;
                                    break;
                                }
                            }
                            if (foundLibrary != null) {
                                if (foundLibrary.books.isEmpty()) {
                                    System.out.println("Книг нету!");

                                } else {
                                    System.out.println("Все Id книг: ");
                                    for (Book book : foundLibrary.books) {
                                        System.out.println(book.getId());
                                    }
                                    boolean exitBook = false;
                                    while (!exitBook) {
                                        try {
                                            System.out.print("Введите id: ");
                                            Long bookId = scanner.nextLong();
                                            boolean found = false;
                                            for (Book book : foundLibrary.books) {
                                                if (book.getId().equals(bookId)) {
                                                    System.out.println(book);
                                                    found = true;
                                                    exitBook = true;
                                                    break;
                                                }
                                            }
                                            if (!found) {
                                                System.out.println("Неправильный id!");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Введите число!");
                                            scanner.nextLine();
                                        }

                                    }

                                }
                                scanner.nextLine();
                            } else {
                                System.out.println("Библиотека не найдена!");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Введите число!");
                            scanner.nextLine();
                        }

                    }
                }
                case "6" -> {
                    if (database.getAllReaders().isEmpty()) {
                        System.out.println("Читателей нету");
                    } else {


                        try {
                            System.out.println("Все id читателей:");
                            for (Reader reader : database.getAllReaders()) {
                                System.out.println(reader.getId());
                            }
                            System.out.println("Введите Id: ");
                            Long id = scanner.nextLong();
                            Reader reader = database.getReaderById(id);
                            if (reader != null) {
                                System.out.println(reader);
                            } else {
                                System.out.println("Читатель не найден!");
                            }
                            scanner.nextLine();

                        } catch (InputMismatchException e) {
                            System.out.println("Введите число!");
                            scanner.nextLine();
                        }
                    }
                }
                case "7" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету");
                    } else {

                        try {
                            System.out.println("Все id библиотек:");
                            for (Library library : database.getAllLibraries()) {
                                System.out.println(library.getId());
                            }
                            System.out.println("Введите Id: ");
                            Long id = scanner.nextLong();
                            Library library = database.getLibraryById(id);
                            if (library != null) {
                                System.out.println(library);
                            } else {
                                System.out.println("Библиотека не найдена!");
                            }
                            scanner.nextLine();

                        } catch (InputMismatchException e) {
                            System.out.println("Введите число!");
                            scanner.nextLine();
                        }
                    }
                }
                case "8" -> {
                    Reader reader = Reader.addReader(database);
                    if (reader != null) {
                        reader.setId((long) database.getAllReaders().size() + 1);
                        database.saveReader(reader);
                    }
                }
                case "9" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Нету библиотек чтобы добавить книгу");
                    } else {
                        Book book = Book.createBook();
                        if (book != null) {
                            book.setId((long) database.getAllBooks().size() + 1);
                            System.out.println("Все библиотеки: ");
                            for (Library library : database.getAllLibraries()) {
                                System.out.println(library);
                            }
                            while (true) {
                                try {
                                    System.out.println("Введите id библиотеки:");
                                    Long id = scanner.nextLong();
                                    boolean found = false;
                                    for (Library library : database.getAllLibraries()) {
                                        if (library.getId().equals(id)) {
                                            found = true;
                                            break;
                                        }
                                    }
                                    if (found) {
                                        database.saveBook(id, book);
                                        System.out.println("Книга успешно добавлена!");
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Неправильное id!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Введите число!");
                                    scanner.nextLine();
                                }

                            }
                        }
                    }

                }
                case "10" -> {
                    Library library = new Library();
                    System.out.print("Введите название: ");
                    library.setName(scanner.nextLine());
                    System.out.print("Введите адрес библиотеки: ");
                    library.setAddress(scanner.nextLine());
                    if (library.getName().isEmpty() || library.getAddress().isEmpty()) {
                        System.out.println("Поля не должны быть пустыми!");
                    } else {
                        library.setId((long) (database.getAllLibraries().size() + 1));
                        database.saveLibrary(library);
                        System.out.println("Библиотека успешно добавлена!");
                    }
                }
                case "11" -> {
                    if (database.getAllReaders().isEmpty()) {
                        System.out.println("Читателей нету!");
                    } else {
                        System.out.println("Все читатели: ");
                        for (Reader reader : database.getAllReaders()) {
                            System.out.println(reader);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id читателя: ");
                                Long id = scanner.nextLong();
                                Reader foundReader = null;
                                for (Reader databaseAllReader : database.getAllReaders()) {
                                    if (databaseAllReader.getId().equals(id)) {
                                        foundReader = databaseAllReader;
                                        break;
                                    }
                                }
                                if (foundReader != null) {
                                    boolean exitChange = false;
                                    scanner.nextLine();
                                    while (!exitChange) {
                                        System.out.println("""
                                                Что вы хотите изменить?
                                                1. Полное имя
                                                2. Пол
                                                3. Email
                                                4. Номер телефона
                                                5. Завершить изменения""");
                                        String number = scanner.nextLine();
                                        switch (number) {
                                            case "1" -> {
                                                while (true) {
                                                    System.out.print("Введите полное имя: ");
                                                    String fullName = scanner.nextLine();
                                                    if (fullName.isEmpty()) {
                                                        System.out.println("Значение не должно быть пустым!");
                                                    } else {
                                                        foundReader.setFullName(fullName);
                                                        break;
                                                    }
                                                }
                                            }
                                            case "2" -> {
                                                while (true) {
                                                    System.out.println("Введите гендер: 1 (Мужчина) 2 (Женщина)");
                                                    String genderNum = scanner.nextLine();
                                                    if (genderNum.equals("1")) {
                                                        foundReader.setGender(Gender.MALE);
                                                        break;
                                                    } else if (genderNum.equals("2")) {
                                                        foundReader.setGender(Gender.FEMALE);
                                                        break;
                                                    } else {
                                                        System.out.println("Введите правильное число!");
                                                    }
                                                }
                                            }
                                            case "3" -> {
                                                while (true) {
                                                    System.out.print("Введите email: ");
                                                    String email = scanner.nextLine();
                                                    if (email.contains("@gmail.com")) {
                                                        foundReader.setEmail(email);
                                                        break;
                                                    } else {
                                                        System.out.println("Неправильный email!");
                                                    }
                                                }
                                            }
                                            case "4" -> {
                                                while (true) {
                                                    System.out.print("Введите номер телефона: ");
                                                    String phoneNumber = scanner.nextLine();
                                                    if (phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                                                        foundReader.setPhoneNumber(phoneNumber);
                                                        break;
                                                    } else {
                                                        System.out.println("Введите правильный номер телефона!");
                                                    }

                                                }
                                            }
                                            case "5" -> {
                                                database.updateReader(foundReader.getId(), foundReader);
                                                System.out.println("Читатель успешно изменен!");
                                                exitChange = true;
                                            }
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Неправильный id!");
                                }
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Введите число!");
                                scanner.nextLine();
                            }
                        }

                    }

                }
                case "12" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        System.out.println("Все библиотеки: ");
                        for (Library library : database.getAllLibraries()) {
                            System.out.println(library);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id библиотеки: ");
                                Long id = scanner.nextLong();
                                Library foundLibrary = null;
                                for (Library library : database.getAllLibraries()) {
                                    if (library.getId().equals(id)) {
                                        foundLibrary = library;
                                        break;
                                    }
                                }
                                if (foundLibrary != null) {
                                    boolean exitChange = false;
                                    scanner.nextLine();
                                    while (!exitChange) {
                                        System.out.println("""
                                                Что вы хотите изменить?
                                                1. Название
                                                2. Адрес
                                                3. Завершить изменения""");
                                        String number = scanner.nextLine();
                                        switch (number) {
                                            case "1" -> {
                                                while (true) {
                                                    System.out.print("Введите название: ");
                                                    String name = scanner.nextLine();
                                                    if (name.isEmpty()) {
                                                        System.out.println("Значение не должно быть пустым!");
                                                    } else {
                                                        foundLibrary.setName(name);
                                                        break;
                                                    }
                                                }
                                            }
                                            case "2" -> {
                                                while (true) {
                                                    System.out.print("Введите адрес: ");
                                                    String address = scanner.nextLine();
                                                    if (address.isEmpty()) {
                                                        System.out.println("Значение не должно быть пустым!");
                                                    } else {
                                                        foundLibrary.setAddress(address);
                                                        break;
                                                    }
                                                }
                                            }
                                            case "3" -> {
                                                database.updateLibrary(foundLibrary.getId(), foundLibrary);
                                                System.out.println("Библиотека успешно изменена!");
                                                exitChange = true;
                                            }
                                        }
                                    }
                                    break;
                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Введите правильное id!");
                                scanner.nextLine();
                            }
                        }

                    }
                }
                case "13" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        System.out.println("Все библиотеки: ");
                        for (Library library : database.getAllLibraries()) {
                            System.out.println(library);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id библиотеки: ");
                                Long libraryId = scanner.nextLong();
                                Library foundLibrary = null;
                                for (Library library : database.getAllLibraries()) {
                                    if (library.getId().equals(libraryId)) {
                                        foundLibrary = library;
                                        break;
                                    }
                                }
                                if (foundLibrary != null) {
                                    if (foundLibrary.books.isEmpty()) {
                                        System.out.println("Книг нету!");
                                        scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Все книги: ");
                                        for (Book book : foundLibrary.books) {
                                            System.out.println(book);
                                        }

                                        while (true) {
                                            System.out.print("Введите id книги: ");
                                            if (scanner.hasNextLong()) {
                                                Long bookId = scanner.nextLong();
                                                boolean found = false;
                                                for (Book book : foundLibrary.books) {
                                                    if (book.getId().equals(bookId)) {
                                                        found = true;
                                                        break;
                                                    }
                                                }
                                                if (found) {
                                                    database.deleteBook(foundLibrary.getId(), bookId);
                                                    System.out.println("Книга успешно удалена!");
                                                    scanner.nextLine();
                                                    break;
                                                } else {
                                                    System.out.println("Неправильное id!");
                                                }
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }

                                    }
                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Введите правильное id!");
                                scanner.nextLine();
                            }

                        }

                    }
                }
                case "14" -> {
                    if (database.getAllLibraries().isEmpty()) {
                        System.out.println("Библиотек нету!");
                    } else {
                        System.out.println("Все библиотеки: ");
                        for (Library library : database.getAllLibraries()) {
                            System.out.println(library);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id: ");
                                Long id = scanner.nextLong();
                                boolean found = false;
                                for (Library library : database.getAllLibraries()) {
                                    if (library.getId().equals(id)) {
                                        found = true;
                                        break;
                                    }
                                }
                                if (found) {
                                    database.deleteLibrary(id);
                                    System.out.println("Библиотека успешно удалена!");
                                    break;
                                } else {
                                    System.out.println("Неправильный id!");
                                }
                            scanner.nextLine();

                            } catch (InputMismatchException e) {
                                System.out.println("Введите правильное id!");
                            }

                        }
                    }
                }
                case "15" -> {
                    if (database.getAllBooks().isEmpty()) {
                        System.out.println("Книг нету!");
                    } else {
                        System.out.println("Все библиотеки: ");
                        for (Library library : database.getAllLibraries()) {
                            System.out.println(library);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id библиотеки: ");
                                Long libraryId = scanner.nextLong();
                                Library foundLibrary = null;
                                for (Library library : database.getAllLibraries()) {
                                    if (library.getId().equals(libraryId)) {
                                        foundLibrary = library;
                                        break;
                                    }
                                }
                                if (foundLibrary != null) {
                                    if (foundLibrary.books.isEmpty()) {
                                        System.out.println("Книг нету!");
                                        break;
                                    } else {
                                        System.out.println("Все книги: ");
                                        for (Book book : foundLibrary.books) {
                                            System.out.println(book);
                                        }

                                        while (true) {
                                            System.out.print("Введите id книги: ");
                                            if (scanner.hasNextLong()) {
                                                Long bookId = scanner.nextLong();
                                                boolean found = false;
                                                for (Book book : foundLibrary.books) {
                                                    if (book.getId().equals(bookId)) {
                                                        found = true;
                                                        break;
                                                    }
                                                }
                                                if (found) {
                                                    database.clearBooksByLibraryId(foundLibrary.getId());
                                                    System.out.println("Книги успешно очищены!");
                                                    break;
                                                } else {
                                                    System.out.println("Неправильное id!");
                                                }
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }

                                    }
                                    scanner.nextLine();

                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Введите правильное id!");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                case "16" -> {
                    if (database.getAllReaders().isEmpty()) {
                        System.out.println("Читателей нету!");
                    } else {
                        System.out.println("Все читатели: ");
                        for (Reader reader : database.getAllReaders()) {
                            System.out.println(reader);
                        }
                        while (true) {
                            try {
                                System.out.print("Введите id читателя: ");
                                Long id = scanner.nextLong();
                                boolean found = false;
                                for (Reader reader : database.getAllReaders()) {
                                    if (reader.getId().equals(id)) {
                                        found = true;
                                        break;
                                    }
                                }
                                if (found) {
                                    System.out.println("Все библиотеки: ");
                                    for (Library library : database.getAllLibraries()) {
                                        System.out.println(library);
                                    }
                                    while (true) {
                                        try {
                                            System.out.print("Введите id библиотеки: ");
                                            Long libraryId = scanner.nextLong();
                                            boolean foundLibrary = false;
                                            for (Reader reader : database.getAllReaders()) {
                                                if (reader.getId().equals(libraryId)) {
                                                    foundLibrary = true;
                                                    break;
                                                }
                                            }
                                            if (foundLibrary) {
                                                database.assignReaderToLibrary(id, libraryId);
                                                System.out.println("Читатель успешно добавлен в библиотеку!");
                                                break;
                                            } else {
                                                throw new InputMismatchException();
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Введите правильное id!");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                } else {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Введите правильное id!");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                case "17" -> {
                    exit = true;
                    System.out.println("Вы успешно вышли!");
                }
                default -> System.out.println("Введите правильное число!");
            }
        }
    }
}