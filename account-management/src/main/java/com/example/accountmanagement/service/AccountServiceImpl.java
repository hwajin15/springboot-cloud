package com.example.accountmanagement.service;

import com.example.accountmanagement.data.AccountEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public List<AccountEntity> getAccounts(String userId) {
        List<AccountEntity> returnValue = new ArrayList<>();

         AccountEntity accountEntity = new AccountEntity();
         accountEntity.setUserId(userId);
         accountEntity.setDescription("album 1 description");
         accountEntity.setId(1L);

        AccountEntity accountEntity2 = new AccountEntity();
        accountEntity2.setUserId(userId);
        accountEntity2.setDescription("account 2 description");
        accountEntity2.setId(2L);

        returnValue.add(accountEntity);
        returnValue.add(accountEntity2);
        return returnValue;

    }
}
