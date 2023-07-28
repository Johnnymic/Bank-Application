package com.bankApplication.user.cmd.command;

import com.bankApplication.user.core.model.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class RegistrationCommand {

   @TargetAggregateIdentifier
   private  String id;

   private User user;

}
