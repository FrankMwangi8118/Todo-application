package com.codify.Services;

import com.codify.Model.Task;
import com.codify.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {
    @Autowired
    private TodoRepository todoRepository;

    //get all tasks

    public List<Task> getAll() {
      return   todoRepository.findAll();
    }

   // create new tasks

    public void createTask(String title) {
        Task task= new Task();
        task.setTitle(title);
        task.setCompleted(false);
        todoRepository.save(task);
    }

    //delete tasks

    public void deleteTask(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleTasks(Long id) {
        Task task=  todoRepository.findAllById(id)
                .orElseThrow(()=> new IllegalArgumentException("invalid task id"))
        task.setCompleted();


    }
}
