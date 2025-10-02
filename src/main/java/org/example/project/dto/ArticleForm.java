package org.example.project.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.project.entity.Article;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleForm {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public ArticleForm(String title, String content, String author, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null , title, content, author, createdAt);
    }
}
