package com.bankApplication.user.cmd.Aggregate;

import com.bankApplication.user.cmd.command.RegistrationCommand;
import com.bankApplication.user.cmd.command.RemoveCommand;
import com.bankApplication.user.cmd.command.UpdateUserCommand;
import com.bankApplication.user.core.event.UserRegisterEvent;
import com.bankApplication.user.core.event.UserRemoveEvent;
import com.bankApplication.user.core.event.UserUpdatedEvent;
import com.bankApplication.user.core.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Aggregate
@NoArgsConstructor

public class UserAggregate {

    @AggregateIdentifier
    private String id;

    private User user;

    private   PasswordEncoder passwordEncoder;



    @CommandHandler
    public UserAggregate(RegistrationCommand registrationCommand){
         User user = registrationCommand.getUser();
         user.setId(registrationCommand.getId());

         var  passwordE=   passwordEncoder.encode(user.getAccount().getPassword());
         user.getAccount().setPassword(passwordE);

         UserRegisterEvent event = UserRegisterEvent.builder()
                 .id(registrationCommand.getId())
                 .user(registrationCommand.getUser())
                 .build();
        AggregateLifecycle.apply(event); // this will store the event in the event store and publish it to the event bus

    }

    @CommandHandler
    public  UserAggregate(RemoveCommand removeCommand){
        UserRemoveEvent event =UserRemoveEvent.builder()
                .Id(removeCommand.getId())
                .build();
        AggregateLifecycle.apply(event);

    }

    @CommandHandler
    public UserAggregate(UpdateUserCommand userCommand){// set a placeholder that will get the user from the usercommand
        User update = userCommand.getUser();       //
        var  password = passwordEncoder
                .encode(update.getAccount().getPassword());
        update.getAccount().setPassword(password);
        UpdateUserCommand event= UpdateUserCommand.builder()
                .id(UUID.randomUUID().toString())
                .user(userCommand.getUser())
                .build();
        AggregateLifecycle.apply(event);

    }

    @EventSourcingHandler  // this will alter the state of the aggregate
    public void on(UserRemoveEvent userRemoveEvent){// method will delete the actual aggregate
      AggregateLifecycle.markDeleted();
    }
    @EventSourcingHandler//and this will public an event;
    public void on(UserRegisterEvent userRegisterEvent){// set the Aggregate id to the event id, then it will publish the event to the event bus;
       this.id = userRegisterEvent.getId();
       this.user = userRegisterEvent.getUser();

    }
    @EventSourcingHandler
    public void on(UserUpdatedEvent userUpdatedEvent){ //set only the user field of the Aggregate  Object to the event
        // and then publish the vent to the event bus
        this.user = userUpdatedEvent.getUser();
    }

}
