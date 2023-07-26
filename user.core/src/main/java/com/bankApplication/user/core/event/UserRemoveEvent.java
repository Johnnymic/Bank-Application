package com.bankApplication.user.core.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRemoveEvent {

    private  String Id;
}
