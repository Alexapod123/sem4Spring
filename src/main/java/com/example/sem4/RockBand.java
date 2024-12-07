package com.example.sem4;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;


@Entity
public class RockBand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Обязательное поле!")
    @Column(name = "Название")
    private String name;

    @NotBlank(message = "Обязательное поле!")
    @Column(name = "Год основания")
    private int yearOfBirth;

    @NotBlank(message = "Обязательное поле!")
    @Column(name = "Страна")
    private String country;

    public RockBand() {};

    public RockBand(String name, int yearOfBirth, String country) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
