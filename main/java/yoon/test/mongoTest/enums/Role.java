package yoon.test.mongoTest.enums;

import lombok.Getter;

@Getter
public enum Role {

    GUEST(1, "ROLE_GUEST"),
    USER(2, "ROLE_USER"),
    ADMIN(3, "ROLE_ADMIN");

    private final int key;
    private final String value;

    Role(int key, String value){
        this.key = key;
        this.value = value;
    }
}
