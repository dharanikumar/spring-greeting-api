package com.dhar.restapi.service;

import com.dhar.restapi.dto.model.TaskDto;

import java.util.ArrayList;
import java.util.Optional;


public interface TodoService {
    Optional<TaskDto> addTaskByName(String name);
    Optional<ArrayList<TaskDto>> searchTaskByName(String query);
}