package mvc.service;
import mvc.model.Task;
import mvc.service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public void removeTask(int taskId) {
        taskRepository.removeTask(taskId);
    }

    public void completeTask(int taskId) {
        taskRepository.completeTask(taskId);
    }
}
