package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    //Simple Task
    @Test
    public void shouldSearchTrueInSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");

        task.matches("хлеб");

        boolean expected = true;
        boolean actual = task.matches("хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchFalseInSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");

        task.matches("батон");

        boolean expected = false;
        boolean actual = task.matches("батон");

        Assertions.assertEquals(expected, actual);
    }

    //Epic
    @Test
    public void shouldSearchTrueInEpicMatches() {
        String[] subtasks = {"Посмотреть лекцию", "Сделать конспект", "Выполнить дз"};
        Epic task = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = task.matches("конспект");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchFalseInEpicMatches() {
        String[] subtasks = {"Посмотреть лекцию", "Сделать конспект", "Выполнить дз"};
        Epic task = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = task.matches("исправить");

        Assertions.assertEquals(expected, actual);
    }

    //Meeting
    @Test
    public void shouldSearchTrueTopicInMeetingMatches() {
        Meeting task = new Meeting(3, "Объемы продаж", "Ракета 2024", "Четверг в 17.30");

        task.matches("Объемы");

        boolean expected = true;
        boolean actual = task.matches("Объемы");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchTrueProjectInMeetingMatches() {
        Meeting task = new Meeting(3, "Объемы продаж", "Ракета 2024", "Четверг в 17.30");

        task.matches("Ракета");

        boolean expected = true;
        boolean actual = task.matches("Ракета");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchFalseInMeetingMatches() {
        Meeting task = new Meeting(3, "Объемы продаж", "Ракета 2024", "Четверг в 17.30");

        task.matches("покупок");

        boolean expected = false;
        boolean actual = task.matches("покупок");

        Assertions.assertEquals(expected, actual);
    }

}