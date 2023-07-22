package yoon.test.mongoTest.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberRequest {

    private String email;

    private String password;

    private String name;

    private int age;

}
