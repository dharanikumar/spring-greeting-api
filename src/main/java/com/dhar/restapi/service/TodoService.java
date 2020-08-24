package com.dhar.restapi.service;

import com.dhar.restapi.dto.model.TaskDto;

import java.util.List;

public interface TodoService {
    TaskDto addTaskByName(String name);
    List<TaskDto> searchTaskByName(String query);
}