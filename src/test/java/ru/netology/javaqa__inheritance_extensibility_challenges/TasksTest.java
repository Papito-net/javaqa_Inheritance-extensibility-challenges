package ru.netology.javaqa__inheritance_extensibility_challenges;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    void testMeetingMatches() {
        // Создаём объект и передаём аргументы в конструктор
        Meeting meeting = new Meeting(1, "Команда тестирования проекта", "Планировщик задач", "08:00");

        // Cовпадение по topic
        assertTrue(meeting.matches("Команда"));
        assertTrue(meeting.matches("тестирования"));

        // Cовпадение по project
        assertTrue(meeting.matches("Планировщик"));

        // Cовпадений нет ни в одном поле
        assertFalse(meeting.matches("Java"));

        // Пограничный случай - пустая строка
        assertTrue(meeting.matches(""));
    }

    @Test
    void testSimpleTaskMatches() {
        // Создаём объект и передаём аргументы в конструктор
        SimpleTask simpleTask = new SimpleTask(1, "Команда разработчиков");

        // Совпадение по title
        assertTrue(simpleTask.matches("Команда"));
        assertTrue(simpleTask.matches("разработчиков"));

        // Совпадения нет
        assertFalse(simpleTask.matches("Java"));

        // Пограничный случай - пустая строка
        assertTrue(simpleTask.matches(""));
    }

    @Test
    void testEpicMatches() {
        // Создаем массив подзадач, где одна из них — "Команда тестирования"
        String[] subtasks = {"Структура команды", "Команда тестирования", "Планировщик"};

        // Создаем объект Epic (id = 1, передаем массив подзадач в конструктор)
        Epic epic = new Epic(1, subtasks);

        // Совпадение есть в одной из подзадач
        assertTrue(epic.matches("Команда"));
        assertTrue(epic.matches("тестирования"));

        // Совпадений ни в одной подзадаче нет
        assertFalse(epic.matches("Java"));

        // Пограничный случай - пустая строка
        assertTrue(epic.matches(""));
    }

}
