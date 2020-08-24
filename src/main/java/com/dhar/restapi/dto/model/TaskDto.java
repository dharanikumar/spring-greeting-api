package com.dhar.restapi.dto.model;

public class TaskDto {
    private final long id;
    private final String content;

    public TaskDto(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
