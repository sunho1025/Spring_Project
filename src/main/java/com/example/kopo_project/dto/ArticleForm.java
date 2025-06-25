package com.example.kopo_project.dto;

import com.example.kopo_project.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ArticleForm {
    private String title;
    private String content;

        //toString, getter, setter 지움
        public Article toEntity() {
            return new Article(null, title, content);
    }
}