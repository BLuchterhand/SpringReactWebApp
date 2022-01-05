package com.benlu.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "death_year")
    private String deathYear;

    @Column(name = "profession")
    private String profession;

    @Column(name = "titles")
    private String titles;

    public Person() {

    }

    public Person(String identifier, String name, String birthYear, String deathYear, String profession, String titles) {
        super();
        this.identifier = identifier;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.profession = profession;
        this.titles = titles;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }
    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTitles() {
        return titles;
    }
    public void setTitles(String titles) {
        this.titles = titles;
    }
}