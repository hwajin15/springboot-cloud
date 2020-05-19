package com.example.accountmanagement.controller;


import com.example.accountmanagement.data.AccountEntity;
import com.example.accountmanagement.model.AccountResponseModel;
import com.example.accountmanagement.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("users/{id}/account")
public class AccountController {

    @Autowired
    Environment env;
    @Autowired
    AccountService accountService;


    @GetMapping("status/check")
    public String status(){
        return String.format("working on account %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public List<AccountResponseModel> userAccount(@PathVariable String id) {

        List<AccountResponseModel> returnValue = new ArrayList<>();

        List<AccountEntity> accountEntities = accountService.getAccounts(id);

        if(accountEntities == null || accountEntities.isEmpty())
        {
            return returnValue;
        }

        Type listType = new TypeToken<List<AccountResponseModel>>(){}.getType();

        returnValue = new ModelMapper().map(accountEntities, listType);
        log.info("Returning " + returnValue.size() + " accounts");
        return returnValue;
    }
}
