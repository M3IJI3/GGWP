package com.example.ggwp.models.forum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FORUM_ARTICLE")
public class ForumArticleEntity {
    @Id
    @Column(name = "ARTICLE_ID")
    public long articleID;
    @Column(name = "ARTICLE_TITLE")
    public String articleTitle;
    @Column(name = "CONTENT")
    public String articleContent;
    @Column(name = "IMAGE_URL")
    public String imageURL;
    @Column(name = "USER_ID")
    public String userID;
    @Column(name = "FORUM_ID")
    public long forumID;
    @Column(name = "CONTENT_AS_HTML")
    public String contentAsHtml;
}
