package com.bankApplication.user.core.event;

import com.bankApplication.user.core.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterEvent {
    private  String id;

    private User user;
}
