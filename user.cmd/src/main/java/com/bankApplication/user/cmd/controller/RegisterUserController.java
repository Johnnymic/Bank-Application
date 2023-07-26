package com.bankApplication.user.cmd.controller;

import com.bankApplication.user.cmd.command.RegistrationCommand;
import com.bankApplication.user.cmd.dto.RegisterResponse;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/register")
@RequiredArgsConstructor
public class RegisterUserController {

    private  final CommandGateway commandGateway;

    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegistrationCommand registrationCommand){
          registrationCommand.setId(UUID.randomUUID().toString());
         RegisterResponse registerResponse = commandGateway.sendAndWait(registrationCommand);
          return  new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
    }





}
