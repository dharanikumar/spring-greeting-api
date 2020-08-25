package com.dhar.restapi.controller.v1.api;

import com.dhar.restapi.dto.model.TaskDto;
import com.dhar.restapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public TodoController(TodoService service) {
        this.todoService = service;
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @GetMapping("/addtask")
    public ResponseEntity<TaskDto> addTask(@RequestParam(value = "name", defaultValue = "World") String name) {
        Optional<TaskDto> taskOptional = todoService.addTaskByName(name);

        return taskOptional.map(todoTask -> ResponseEntity.ok().body(todoTask))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/searchtask")
    public ResponseEntity<ArrayList<TaskDto>> searchTask(@RequestParam(value = "name", defaultValue = "") String query) {
        Optional<ArrayList<TaskDto>> optionalTaskList = todoService.searchTaskByName(query);

        return optionalTaskList.map(todoTaskList -> ResponseEntity.ok().body(todoTaskList))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}