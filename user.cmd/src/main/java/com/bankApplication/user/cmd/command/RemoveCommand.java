package com.bankApplication.user.cmd.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@Builder
public class RemoveCommand {
    @TargetAggregateIdentifier
    private  String id;
}
