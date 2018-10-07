package com.bank.model.service.validator;

import com.bank.model.entity.Person;

public class PersonValidator {

    public boolean balanceIsPositive(Person person, int sum){
        return person.getMoney() > sum;
    }

    public boolean accountIsNotTheSame(int from, int to){
        return from != to;
    }
}
