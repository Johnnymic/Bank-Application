package com.bankApplication.user.cmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




public class RegisterResponse  extends BaseResponse {
   private String Id;

    public RegisterResponse(String message) {
        super(message);
    }
}
