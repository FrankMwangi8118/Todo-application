package com.codify.Controllers;

import com.codify.Model.Task;
import com.codify.Services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoControllers {

    @Autowired
    private TodoServices todoServices;

    @GetMapping("/")
    public String getTodos(Model model) {
        List<Task> tasks = todoServices.getAll();
        model.addAttribute("tasks", tasks);
        return "task";  // This returns the task.html template
    }


    @PostMapping
    public String createTask(@RequestParam String title){
        todoServices.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        todoServices.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        todoServices.toggleTasks(id);
        return "redirect:/";  // Redirect to the home page or task list
    }
}
