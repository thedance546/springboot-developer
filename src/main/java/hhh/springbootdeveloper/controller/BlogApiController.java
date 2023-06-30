package hhh.springbootdeveloper.controller;

import hhh.springbootdeveloper.domain.Article;
import hhh.springbootdeveloper.dto.AddArticleRequest;
import hhh.springbootdeveloper.dto.ArticleResponse;
import hhh.springbootdeveloper.dto.UpdateArticleRequest;
import hhh.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //자바 객체 데이터를 JSON 으로 반환
public class BlogApiController {

    private final BlogService blogService;

    //요청한 자원이 성공적으로 생성, 저장된 글 정보를 응답 객체에 담아 전송
    //JSON 응답에 해당하는 값을 자바 객체로 변환해서 AddArticleRequest 에 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {

        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //findAll() 메서드를 호출한 뒤 ArticleResponse 에 파싱해 body 에 담아 전송
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok().body(updatedArticle);
    }
}
