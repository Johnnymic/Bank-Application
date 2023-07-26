package com.bankApplication.user.core.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document( collection="users")
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNo;



   private  Account account;


}
