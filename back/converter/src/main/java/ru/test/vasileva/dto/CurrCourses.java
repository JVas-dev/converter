package ru.test.vasileva.dto;

import java.util.List;

public class CurrCourses {
    private String date;
    private String name;
    private List<Currency> currency;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CurrCourses{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                '}';
    }
}