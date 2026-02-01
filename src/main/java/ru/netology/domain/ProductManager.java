package ru.netology.domain;

public class ProductManager {

    private String[] films;
    private int limit;


    public ProductManager() {
        this.films = new String[0];
        this.limit = 5;
    }


    public ProductManager(int limit) {
        this.films = new String[0];
        this.limit = limit;
    }


    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }


    public String[] findAll() {
        String[] result = new String[films.length];
        for (int i = 0; i < films.length; i++) {
            result[i] = films[i];
        }
        return result;
    }


    public String[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }

        return result;
    }

    public int getLimit() {
        return limit;
    }
}