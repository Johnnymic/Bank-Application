package com.bankApplication.user.query.handler;

import com.bankApplication.user.core.event.UserRegisterEvent;
import com.bankApplication.user.core.event.UserRemoveEvent;
import com.bankApplication.user.core.event.UserUpdatedEvent;
import com.bankApplication.user.query.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("user-group")//basically means when a consumer(event handler) consumes an  event
@RequiredArgsConstructor
public class UserEventHandlerImp  implements UserEventHandler{

    private  final UserRepository userRepository;


    //Event handler handles the business logic
    @EventHandler
    @Override
    public void on(UserRegisterEvent event) {
        userRepository.save(event.getUser());

    }

    @EventHandler
    @Override
    public void on(UserUpdatedEvent event) {
        userRepository.save(event.getUser());

    }

    @EventHandler
    @Override
    public void on(UserRemoveEvent event) {
         userRepository.deleteById(event.getId());
    }
}
