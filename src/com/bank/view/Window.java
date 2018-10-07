package com.bank.view;

import com.bank.model.entity.Person;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Window {

    private JFrame jFrame;
    private JPanel panel;
    private JComboBox accountFromSelector;
    private JComboBox accountToSelector;
    private JTextField moneyField;
    private JButton operationButton;

    private JLabel accountsLabel;
    private Map<Integer, JLabel> accounts;

    private String title;
    private int width;
    private int height;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void initFrame(String title, int width, int height) {
        jFrame.setTitle(title);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
    }

    public void init() {
        initFrame(title, width, height);
        addComponents();
        customizeComponents();
        jFrame.setVisible(true);
    }

    private void addComponents() {
        jFrame.add(panel);
        panel.add(accountFromSelector);
        panel.add(accountToSelector);
        panel.add(moneyField);
        panel.add(operationButton);
        panel.add(accountsLabel);
        addAccountsToPanel();
    }

    private void customizeComponents() {
        panel.setLayout(new GridLayout(5, 1));
        operationButton.setText("Transfer");
        accountsLabel.setText("Accounts:");
    }

    private void addAccountsToPanel(){
        for (JLabel label : accounts.values()){
            panel.add(label);
        }
    }

    public void addAccounts(List<Person> people) {
        if(accounts == null) accounts = new HashMap<>();
        for (Person person : people) {
            accounts.put(person.getId(), new JLabel(person.toString()));
        }
    }

    public void refresh(List<Person> people){
        for (Person person : people){
            accounts.get(person.getId()).setText(person.toString());
        }
    }

    public void fillDropDown(List<String> items, JComboBox<String> comboBox) {
        for (String item : items) {
            comboBox.addItem(item);
        }
    }

    public JButton getOperationButton() {
        return operationButton;
    }

    public void setOperationButton(JButton operationButton) {
        this.operationButton = operationButton;
    }

    public JTextField getMoneyField() {
        return moneyField;
    }

    public void setMoneyField(JTextField moneyField) {
        this.moneyField = moneyField;
    }

    public JComboBox getAccountToSelector() {
        return accountToSelector;
    }

    public void setAccountToSelector(JComboBox accountToSelector) {
        this.accountToSelector = accountToSelector;
    }

    public JComboBox getAccountFromSelector() {
        return accountFromSelector;
    }

    public void setAccountFromSelector(JComboBox accountFromSelector) {
        this.accountFromSelector = accountFromSelector;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getAccountsLabel() {
        return accountsLabel;
    }

    public void setAccountsLabel(JLabel accountsLabel) {
        this.accountsLabel = accountsLabel;
    }

    public Map<Integer, JLabel> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, JLabel> accounts) {
        this.accounts = accounts;
    }
}