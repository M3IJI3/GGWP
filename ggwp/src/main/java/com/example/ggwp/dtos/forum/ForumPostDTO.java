package com.example.ggwp.dtos.forum;

public class ForumPostDTO {
    private String content;
    private String plainContent;

    public String getPlainContent() {
        return plainContent;
    }

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
