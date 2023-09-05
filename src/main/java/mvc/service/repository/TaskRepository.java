package mvc.service.repository;

import mvc.model.Task;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }

    public void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    public void completeTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }
}
