package com.dhar.restapi.controller;

import com.dhar.restapi.controller.api.TodoController;
import com.dhar.restapi.dto.model.TaskDto;
import com.dhar.restapi.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        String response = "{\"id\":1,\"content\":\"Hello, World!\"}";
        TaskDto taskDto = new TaskDto(1, "Mock");
        when(service.addTaskByName("Mock")).thenReturn(taskDto);
        this.mockMvc.perform(get("/api/v1/todo/addtask")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(response));
    }
}