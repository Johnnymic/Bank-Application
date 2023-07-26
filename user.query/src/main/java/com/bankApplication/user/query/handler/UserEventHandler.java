package com.bankApplication.user.query.handler;


import com.bankApplication.user.core.event.UserRegisterEvent;
import com.bankApplication.user.core.event.UserRemoveEvent;
import com.bankApplication.user.core.event.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisterEvent event);

    void on(UserUpdatedEvent event);

    void on(UserRemoveEvent event);
}
