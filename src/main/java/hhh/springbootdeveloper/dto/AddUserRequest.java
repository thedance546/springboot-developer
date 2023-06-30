//사용자 정보를 담고 있는 DTO
package hhh.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    private String email;
    private String password;
//    private String auth;
}
