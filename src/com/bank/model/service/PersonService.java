package com.bank.model.service;

import com.bank.model.dao.PersonDao;
import com.bank.model.entity.Person;
import com.bank.model.exception.AccountIsTheSameException;
import com.bank.model.exception.IncorrectBalanceException;
import com.bank.model.service.validator.PersonValidator;

import java.util.List;

public class PersonService {

    private PersonDao personDao;
    private PersonValidator personValidator;
    private LogService logService = LogService.getInstance();

    public PersonService(PersonDao personDao, PersonValidator personValidator) {
        this.personDao = personDao;
        this.personValidator = personValidator;
    }

    public void transfer(int from, int to, int sum) {
        if (!personValidator.balanceIsPositive(personDao.getById(from), sum)) {
            throw new IncorrectBalanceException();
        } else if (!personValidator.accountIsNotTheSame(from, to)) {
            throw new AccountIsTheSameException();
        }
        personDao.transfer(from, to, sum);
        logService.info("Transferred from ID: " + from + " to " + to + " Sum: " + sum);
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public List<String> getAllIds() {
        return personDao.getAllIds();
    }
}
