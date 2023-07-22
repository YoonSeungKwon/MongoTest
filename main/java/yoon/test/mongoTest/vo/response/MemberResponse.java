package yoon.test.mongoTest.vo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private String email;

    private String name;

    private int age;

    private String role;
}
