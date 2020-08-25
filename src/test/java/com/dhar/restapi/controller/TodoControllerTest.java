package com.dhar.restapi.controller;

import com.dhar.restapi.controller.v1.api.TodoController;
import com.dhar.restapi.dto.model.TaskDto;
import com.dhar.restapi.service.TodoService;
import org.apache.catalina.security.SecurityConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {
    @InjectMocks
    TodoController todoController;

    @Mock
    private TodoService service;

    @Test
    public void addTaskShouldReturnSuccessResponse() throws Exception {
        TaskDto taskDto = new TaskDto(1, "World");
        when(service.addTaskByName("World")).thenReturn(Optional.of(taskDto));
        final ResponseEntity<TaskDto> responseDto = todoController.addTask("World");

        Assert.assertEquals(200, responseDto.getStatusCodeValue());
        Assert.assertEquals(taskDto, responseDto.getBody());
    }

    @Test
    public void addTaskShouldReturnFailureResponse() throws Exception {
        when(service.addTaskByName("World")).thenReturn(Optional.empty());
        final ResponseEntity<TaskDto> responseDto = todoController.addTask("World");

        Assert.assertEquals(400, responseDto.getStatusCodeValue());
        Assert.assertNull(responseDto.getBody());
    }

    @Test
    public void ShouldReturnSuccessResponseForSearchTodoTasks() throws Exception {
        ArrayList<TaskDto> taskList = new ArrayList<>();
        taskList.add(new TaskDto(1, "World"));

        when(service.searchTaskByName("World")).thenReturn(Optional.of(taskList));
        final ResponseEntity<ArrayList<TaskDto>> responseDto = todoController.searchTask("World");

        Assert.assertEquals(200, responseDto.getStatusCodeValue());
        ArrayList<TaskDto> taskListResponse = responseDto.getBody();
        assert taskListResponse != null;
        Assert.assertEquals(1, taskListResponse.size());
    }

    @Test
    public void ShouldReturnFailureResponseForSearchTodoTasks() throws Exception {
        when(service.addTaskByName("World")).thenReturn(Optional.empty());
        final ResponseEntity<TaskDto> responseDto = todoController.addTask("World");

        Assert.assertEquals(400, responseDto.getStatusCodeValue());
        Assert.assertNull(responseDto.getBody());
    }
}