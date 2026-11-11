package ru.netology.javaqa__inheritance_extensibility_challenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }


    private Todos todos;

    // Создаем тестовые задачи
    private final SimpleTask simpleTask = new SimpleTask(1, "Команда разработчиков");
    private final Meeting meeting = new Meeting(2, "Команда тестирования проекта", "Планировщик задач", "08:00");
    private final Epic epic = new Epic(3, new String[]{"Структура проекта", "План тестирования", "Планировщик"});

    @BeforeEach
    void setUp() {
        todos = new Todos();
        // Добавляем все задачи в менеджер перед каждым тестом
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
    }

    @Test
    void shouldFindMultipleTasksWhenQueryMatchesSeveral() {
        // Запрос "Команда" есть и в simpleTask, и в meeting
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Команда");

        // Сравнивнение массивов
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneTaskWhenQueryMatchesOnlyOne() {
        // Запрос "Структура проекта" есть только в epic
        Task[] expected = {epic};
        Task[] actual = todos.search("Структура проекта");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoTasksMatch() {
        // Запроса "Java" нет ни в одной задаче
        Task[] expected = {};
        Task[] actual = todos.search("Java");

        assertArrayEquals(expected, actual);
    }

}
