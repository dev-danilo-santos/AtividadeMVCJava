package mvc.controller;

import mvc.model.Task;
import mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks", tasks);

        model.addAttribute("task", new Task());

        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) {
        taskService.addTask(task);

        return "redirect:/";
    }

    @GetMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        taskService.removeTask(taskId);

        return "redirect:/";
    }

    @GetMapping("/completeTask/{taskId}")
    public String completeTask(@PathVariable int taskId) {
        taskService.completeTask(taskId);

        return "redirect:/";
    }
}
