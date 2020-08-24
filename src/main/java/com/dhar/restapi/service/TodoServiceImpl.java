package com.dhar.restapi.service;

import com.dhar.restapi.dto.model.TaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoServiceImpl implements TodoService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public TaskDto addTaskByName(String name) {
        return new TaskDto(counter.incrementAndGet(), String.format(template, name));
    }

    @Override
    public List<TaskDto> searchTaskByName(String query) {
        return new ArrayList<>();
    }
}