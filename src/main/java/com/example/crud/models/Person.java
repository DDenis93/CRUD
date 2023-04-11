package com.example.crud.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Person {
    private int id;
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть в диапазоне от 2 до 30 символов")
    private String last_name;
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в диапазоне от 2 до 30 символов")
    private String first_name;
    private String patronymic;
    @Min(value = 18, message = "Возраст не может быть меньше 18")
    private int age;
    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Вы ввели неверный email")
    private String email;
    @NotEmpty(message = "Номер не может быть пустым")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Номер телефона должен быть в формате +7/7/8...")
    private String number;

    public Person(int id, String last_name, String first_name,String patronymic, int age, String email, String number) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
        this.number = number;
    }
    public Person(){}

    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public String getLast_name() {
        return last_name;}
    public void setLast_name(String last_name) {
        this.last_name = last_name;}
    public String getFirst_name() {
        return first_name;}
    public void setFirst_name(String first_name) {
        this.first_name = first_name;}
    public String getPatronymic() {
        return patronymic;}
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;}
    public int getAge() {
        return age;}
    public void setAge(int age) {
        this.age = age;}
    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;}
    public String getNumber() {
        return number;}
    public void setNumber(String number) {
        this.number = number;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", number=" + number +
                '}';
    }
}
