package com.example.ggwp.dtos.forum;

public class ForumPostDTO {
    private String content;

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ForumPostDTO{" +
                "content='" + content + '\'' +
                '}';
    }
}
