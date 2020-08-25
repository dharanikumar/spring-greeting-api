package com.dhar.restapi.controller.api;

import com.dhar.restapi.dto.model.TaskDto;
import com.dhar.restapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @GetMapping("/addtask")
    public @ResponseBody TaskDto addTask(@RequestParam(value = "name", defaultValue = "World") String name) {
        return todoService.addTaskByName(name);
    }

    @GetMapping("/searchtask")
    public @ResponseBody List<TaskDto> searchTask(@RequestParam(value = "name") String query) {
        return todoService.searchTaskByName(query);
    }
}