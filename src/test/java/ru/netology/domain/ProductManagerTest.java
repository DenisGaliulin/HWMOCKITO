package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    private String[] testFilms;

    @BeforeEach
    void setUp() {
        testFilms = new String[] {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель Белград",
                "Вперед",
                "Бладшот"
        };
    }

    @Test
    void emptyManager() {
        ProductManager manager = new ProductManager();
        String[] actual = manager.findAll();
        String[] expected = new String[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void testDefaultLimitConstructor() {
        ProductManager manager = new ProductManager();
        int actual = manager.getLimit();
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void limitConstructor() {
        int actual1 = new ProductManager(3).getLimit();
        int expected1 = 3;

        int actual2 = new ProductManager(7).getLimit();
        int expected2 = 7;

        int actual3 = new ProductManager(10).getLimit();
        int expected3 = 10;

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void testAddFilm() {
        ProductManager manager = new ProductManager();
        manager.addFilm("Номер один");
        String[] actual = manager.findAll();
        String[] expected = {"Номер один"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testAddAllFilms() {
        ProductManager manager = new ProductManager();
        for (String film : testFilms) {
            manager.addFilm(film);
        }
        String[] actual = manager.findAll();
        String[] expected = testFilms;

        assertArrayEquals(expected, actual);
    }

    @Test
    void defaultLimit() {
        ProductManager manager = new ProductManager();
        for (String film : testFilms) {
            manager.addFilm(film);
        }
        String[] actual = manager.findLast();
        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Джентльмены", "Человек-невидимка"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void Limit3() {
        ProductManager manager = new ProductManager(3);
        for (String film : testFilms) {
            manager.addFilm(film);
        }
        String[] actual = manager.findLast();
        String[] expected = {"Бладшот", "Вперед", "Отель Белград"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void Limit7() {
        ProductManager manager = new ProductManager(7);
        for (String film : testFilms) {
            manager.addFilm(film);
        }
        String[] actual = manager.findLast();
        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Джентльмены",
                "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};

        assertArrayEquals(expected, actual);
    }

    @Test
    void lessFilmsThanLimit() {
        ProductManager manager = new ProductManager(10);
        manager.addFilm("Фильм 1");
        manager.addFilm("Фильм 2");
        int actual = manager.findLast().length;
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void emptyFindLast() {
        ProductManager manager = new ProductManager();
        int actual = manager.findLast().length;
        int expected = 0;

        assertEquals(expected, actual);
    }
}