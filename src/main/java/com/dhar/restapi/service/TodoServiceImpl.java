package com.dhar.restapi.service;

import com.dhar.restapi.dto.model.TaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoServiceImpl implements TodoService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Optional<TaskDto> addTaskByName(String name) {
        return Optional.of(new TaskDto(counter.incrementAndGet(), String.format(template, name)));
    }

    @Override
    public Optional<ArrayList<TaskDto>> searchTaskByName(String query) {
        ArrayList<TaskDto> taskLists = new ArrayList<>();
        taskLists.add(new TaskDto(1, String.format(template, "ABC")));
        taskLists.add(new TaskDto(2, String.format(template, "ABB")));
        taskLists.add(new TaskDto(3, String.format(template, "ABA")));
        taskLists.add(new TaskDto(4, String.format(template, "ACC")));
        taskLists.add(new TaskDto(5, String.format(template, "AAC")));
        return Optional.of(taskLists);
    }
}