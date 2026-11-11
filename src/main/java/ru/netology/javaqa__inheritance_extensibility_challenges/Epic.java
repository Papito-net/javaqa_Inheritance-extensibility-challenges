package ru.netology.javaqa__inheritance_extensibility_challenges;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true; // Если есть совпадение строки из массива и запроса, то возвращаем true
            }
        }
        return false;
    }

}
