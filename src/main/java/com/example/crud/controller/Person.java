package com.example.crud.controller;

import com.example.crud.dao.DaoPerson;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class Person {
    private final DaoPerson daoPerson;

    public Person(DaoPerson daoPerson) {
        this.daoPerson = daoPerson;
    }
    // получение списка всех пользователей
    @GetMapping("/person")
    public String index(Model model){
        model.addAttribute("person", daoPerson.getPerson());
        return "person";
    }
    // получение объекта по id
    @GetMapping("/person/{id}")
    public String infoPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", daoPerson.getPersonId(id));
        return "person_info";
    }
    // форма добавления товара
    @GetMapping("/person/add")
    public String newPerson(Model model){
        model.addAttribute("person", new com.example.crud.models.Person());
        return "add_person";
    }
    // добавление из формы в лист
    @PostMapping("/person/add")
    public String newPerson(@ModelAttribute("person") @Valid com.example.crud.models.Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add_person";
        }
        daoPerson.addPerson(person);
        return "redirect:/person";
    }
    // получение продукта по id и возврат его формы
    @GetMapping("person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("edit_person", daoPerson.getPersonId(id));
        return "edit_person";
    }
    // обновление информации объекта
    @PostMapping("person/edit/{id}")
    public String edit_Person(@ModelAttribute("edit_person") @Valid com.example.crud.models.Person person, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "edit_person";
        }
        daoPerson.updatePerson(id,person);
        return "redirect:/person/" + id;
    }
    // удаление пользователя
    @GetMapping("person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id){
        daoPerson.deletePerson(id);
        return "redirect:/person";
    }
}
