package com.example.kopo_project.repository;

import com.example.kopo_project.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}