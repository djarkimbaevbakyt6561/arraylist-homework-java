package models;

import db.Database;
import enums.Gender;

import java.util.Scanner;

public class Reader {
    private Long id;
    private String fullName;
    private String email;

    private String phoneNumber;
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static Reader addReader(Database database) {
        Reader newReader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        newReader.fullName = scanner.nextLine();
        System.out.print("Фамилия: ");
        newReader.fullName = newReader.fullName + " " + scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        while (true) {
            String num = scanner.nextLine();
            if (num.length() == 10 && num.matches("\\d+")) {
                newReader.phoneNumber = num;
                break;
            } else {
                System.out.println("Введите правильный номер телефона!");
            }

        }
        System.out.println("Введите гендер: 1 (Мужчина) 2 (Женщина)");
        while (true){
            String genderNum = scanner.nextLine();
            if(genderNum.equals("1")){
              newReader.setGender(Gender.MALE);
              break;
            } else if (genderNum.equals("2")) {
                newReader.setGender(Gender.FEMALE);
                break;
            } else {
                System.out.println("Введите правильное число!");
            }
        }

        System.out.print("Введите email: ");
        newReader.email = scanner.nextLine();
        boolean foundUserEmail = false;
        for (Reader reader : database.getAllReaders()) {
            if (reader.email.equals(newReader.email)) {
                foundUserEmail = true;
                break;
            }
        }

        if (newReader.fullName.isEmpty() || newReader.email.isEmpty()) {
            System.out.println("Поля не должны быть пустыми!❌");
        } else if (!newReader.email.contains("@gmail.com")) {
            System.out.println("Не корректый адрес эл.почты!❌");
        } else if (foundUserEmail) {
            System.out.println("Пользователь с таким email уже существует!❌");
        } else {
            System.out.println("Читатель успешно создан!✅");
            return newReader;
        }
        return null;

    }
    @Override
    public String toString() {
        return "Читатель " + fullName +
                ", почта: " + email +
                ", номер телефона: " + phoneNumber +
                ", id: " + id;
    }
}