package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testQuantityNoFilms() {

        Manager manager = new Manager();
        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuantityOneFilm() {
        Manager manager = new Manager();
        manager.addFilm("Bladshot");

        String[] actual = manager.findAll();
        String[] expected = {"Bladshot"};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testQuantitySomeFilms() {
        Manager manager = new Manager();
        manager.addFilm("Vpered");
        manager.addFilm("Hotel");
        manager.addFilm("Gentlemens");
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findAll();
        String[] expected = {"Vpered", "Hotel", "Gentlemens", "Invisible", "Trolls", "Number one"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoreThenLimit() {
        Manager manager = new Manager();
        manager.addFilm("Bladshot");
        manager.addFilm("Vpered");
        manager.addFilm("Hotel");
        manager.addFilm("Gentlemens");
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findLast();
        String[] expected = {"Number one", "Trolls", "Invisible", "Gentlemens", "Hotel"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfEqualToLimit() {
        Manager manager = new Manager();
        manager.addFilm("Hotel");
        manager.addFilm("Gentlemens");
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findLast();
        String[] expected = {"Number one", "Trolls", "Invisible", "Gentlemens", "Hotel"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLessThenLimit() {
        Manager manager = new Manager();
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findLast();
        String[] expected = {"Number one", "Trolls", "Invisible"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoreThenGivenLimit() {
        Manager manager = new Manager(3);
        manager.addFilm("Bladshot");
        manager.addFilm("Vpered");
        manager.addFilm("Hotel");
        manager.addFilm("Gentlemens");
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findLast();
        String[] expected = {"Number one", "Trolls", "Invisible"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfEqualToGivenLimit() {
        Manager manager = new Manager(2);
        manager.addFilm("Hotel");
        manager.addFilm("Gentlemens");

        String[] actual = manager.findLast();
        String[] expected = {"Gentlemens", "Hotel"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLessThenGivenLimit() {
        Manager manager = new Manager(6);
        manager.addFilm("Invisible");
        manager.addFilm("Trolls");
        manager.addFilm("Number one");

        String[] actual = manager.findLast();
        String[] expected = {"Number one", "Trolls", "Invisible"};
        Assertions.assertArrayEquals(expected, actual);
    }
}
