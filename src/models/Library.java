package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private Long id;
    private String name;
    private String address;
    public List<Book> books = new ArrayList<>();
    public List<Reader> readers = new ArrayList<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Library " + name +
                ", id=" + id +
                ", address='" + address;
    }
}
