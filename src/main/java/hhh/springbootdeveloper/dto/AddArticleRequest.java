//단순 데이터를 옮기기 위해 사용하는 전달자 역할을 하는 객체
//컨트롤러에서 요청 본문을 받을 객체
package hhh.springbootdeveloper.dto;

import hhh.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {

    private String title;
    private String content;

    //DTO를 entity로
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
