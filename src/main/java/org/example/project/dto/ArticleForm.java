package org.example.project.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.project.entity.Article;

@Getter
@Setter
public class ArticleForm {
    private String title;
    private String content;



    public Article toEntity() {
        return new Article(null, title, content);
    }
}
