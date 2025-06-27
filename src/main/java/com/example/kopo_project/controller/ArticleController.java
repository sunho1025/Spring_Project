package com.example.kopo_project.controller;

import com.example.kopo_project.dto.ArticleForm;
import com.example.kopo_project.entity.Article;
import com.example.kopo_project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class ArticleController {
    //DI = 의존성 주입
    @Autowired //의존성 주입 애노테이션  DI
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")  //생성 요청
    public String newArticle(ArticleForm articleForm){ //DTO로 데이터 수집
        //System.out.println(articleForm.toString());
        log.info(articleForm.toString());
        // DTO -> Entity
        Article article = articleForm.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        //Repository -> DB
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        //view
        return"redirect:/articles/"+saved.getId(); //리다이렉트 redirect: 주소
        //1번글이면, redirect:/articles/1
    }

    @GetMapping("/articles/{number}")
    public String articleShow(@PathVariable Long number, Model model) {
        //@PathVariable 요청변수 수집
        //게시글 번호를 확인해서 view 처리
        log.info("number :" + number);

        //id값을 조회 -DB
        //Optional<Article> saved = articleRepository.findById(number);

        Article saved = articleRepository.findById(number).orElse(null);
        log.info(saved.toString());

        //arrAttr - 활용해서 모델에 데이터 등록
        model.addAttribute("article", saved);

        //view 화면에 보여주기
        return "articles/show";
    }
    //모든 게시물을 출력
    @GetMapping("/articles")
        public String articleAllShow(Model model){
            /**
            //List<Article> saved = articleRepository.findAll();
            1. 다운 캐스팅
            List<Article> saved = (List<Article>) articleRepository.findAll();
            log.info(saved.toString());

            //2. 업 캐스팅
            Iterable<Article> saved_2 = articleRepository.findAll();
            log.info(saved_2.toString());
             **/
            //3. ArrayList
            ArrayList<Article> articles = articleRepository.findAll();

            //addAttribute - 활용해서 모델에 데이터 등록
            model.addAttribute("articles", articles);

            //view 화면에 보여주기
            return  "articles/list";
    }
    @GetMapping("/img")
    public String articleimg(Model model){
        model.addAttribute("imgPath","/cat_02.jpg");
        return "img";
    }
}