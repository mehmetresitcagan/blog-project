package com.mresitcagan.blog.mapper.impl;

import com.mresitcagan.blog.dto.AccountDto;
import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<Account, AccountDto> {

    private ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto mapTo(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public Account mapFrom(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }
}
