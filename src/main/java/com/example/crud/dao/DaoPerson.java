package com.example.crud.dao;

import com.example.crud.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DaoPerson {
    private int id;
    private List<Person> persons = new ArrayList<>();
    // добавить нового пользователя
    public void addPerson(Person person){
        persons.add(person);
        person.setId(++id);
    }
    // получить список всех пользователей
    public List<Person> getPerson(){
        return persons;
    }
    // получение объекта из List по id
    public Person getPersonId(int id){
        return persons.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    // редактирование пользователя
    public void updatePerson(int id, Person person){
        Person personUpdate = getPersonId(id);
        personUpdate.setLast_name(person.getLast_name());
        personUpdate.setFirst_name(person.getFirst_name());
        personUpdate.setPatronymic(person.getPatronymic());
        personUpdate.setAge(person.getAge());
        personUpdate.setEmail(person.getEmail());
        personUpdate.setNumber(person.getNumber());
    }
    // удаление пользователя
    public void deletePerson(int id){
        persons.removeIf(person -> person.getId()==id);
    }
}
