package com.bank.controller;

import com.bank.model.exception.AccountIsTheSameException;
import com.bank.model.exception.IncorrectBalanceException;
import com.bank.model.service.PersonService;
import com.bank.view.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferButtonController implements ActionListener{

    private Window window;
    private PersonService personService;

    public TransferButtonController(Window window, PersonService personService) {
        this.window = window;
        this.personService = personService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int from = Integer.parseInt(String.valueOf(window.getAccountFromSelector().getSelectedItem()));
            int to = Integer.parseInt(String.valueOf(window.getAccountToSelector().getSelectedItem()));
            int sum = Integer.parseInt(window.getMoneyField().getText());
            personService.transfer(from, to, sum);
            window.refresh(personService.getAll());
        } catch (NumberFormatException | IncorrectBalanceException |AccountIsTheSameException ex){
            JOptionPane.showMessageDialog(window.getjFrame(), ex.getMessage());
        }
    }


}
