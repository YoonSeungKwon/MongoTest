package yoon.test.mongoTest.domain;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import yoon.test.mongoTest.enums.Role;

@Data
@Document(collection = "member")
public class Members {
    @Id
    private String id;

    private String email;

    private String password;

    private String name;

    private Role role;

    private int age;

    @Builder
    public Members(String email, String name, String password, Role role, int age){
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public String getRoleValue(){
        return this.role.getValue();
    }
}
