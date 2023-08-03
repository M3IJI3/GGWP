package com.example.ggwp.models.forum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumArticleModel {
    public long articleID;
    public String articleTitle;
    public String articleContent;
    public String imageURL;
    public String userID;
    public long forumID;
}
