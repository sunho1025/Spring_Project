package com.example.kopo_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //해당클래스가 엔티티임을 명시 -> 테이블 생성
public class Article {
    @Id
    @GeneratedValue //자동으로 id값 1씩 증가
    private Long id;

    @Column //컬럼임을 명시해주는 애노테이션
    private String title;

    @Column
    private String content;
    /*
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    //기본생성자
    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    */
}
