package com.gcu.data;

import org.springframework.stereotype.Indexed;

public class UserEntity {
    @Id
    String ID;
    @Indexed(unique=true)
    String username;
    String password;


}
