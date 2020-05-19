package com.example.accountmanagement.service;

import com.example.accountmanagement.data.AccountEntity;

import java.util.List;

public interface AccountService {

    List<AccountEntity> getAccounts(String userId);

}
