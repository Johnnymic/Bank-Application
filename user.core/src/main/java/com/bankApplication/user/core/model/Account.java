package com.bankApplication.user.core.model;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Account {

    private String username;

    private  String password;

     private Set<Role> roleset;

    private AccountType AccountType;

}
