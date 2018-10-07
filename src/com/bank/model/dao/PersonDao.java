package com.bank.model.dao;

import com.bank.model.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDao {

    private Map<Integer, Person> personMap;

    public PersonDao() {
        initMap();
    }

    public Person getById(int id){
        return personMap.get(id);
    }

    public void transfer(int from, int to, int sum){
        Person personFrom = getById(from);
        Person personTo = getById(to);
        personFrom.setMoney(personFrom.getMoney() - sum);
        personTo.setMoney(personTo.getMoney() + sum);
    }

    public List<Person> getAll(){
        return new ArrayList<>(personMap.values());
    }

    public List<String> getAllIds(){
        List<String> ids = new ArrayList<>();
        for (Person person : personMap.values()){
            ids.add(String.valueOf(person.getId()));
        }
        return ids;
    }

    private void initMap() {
        personMap = new HashMap<>();

        Person person1 = new Person(234,"Nick Kovalsky", 2550);
        Person person2 = new Person(345, "Alexander Shevchenko", 3000);
        Person person3 = new Person(455, "Konor McGregor", 34000);
        Person person4 = new Person(555, "Vitaly Klichko", 4000);
        Person person5 = new Person(233, "Ilon Mask", 70000);

        personMap.put(person1.getId(), person1);
        personMap.put(person2.getId(), person2);
        personMap.put(person3.getId(), person3);
        personMap.put(person4.getId(), person4);
        personMap.put(person5.getId(), person5);
    }
}
