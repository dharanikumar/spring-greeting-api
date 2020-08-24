package com.dhar.restapi.controller.api;

import com.dhar.restapi.dto.model.TaskDto;
import com.dhar.restapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/addtask")
    public TaskDto addTask(@RequestParam(value = "name", defaultValue = "World") String name) {
        return todoService.addTaskByName(name);
    }

    @GetMapping("/searchtask")
    public List<TaskDto> searchTask(@RequestParam(value = "name") String query) {
        return todoService.searchTaskByName(query);
    }
}