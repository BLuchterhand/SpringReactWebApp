package com.benlu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benlu.demo.model.Person;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Person, Long>{

    List<Person> findById(long id);

    List<Person> findByIdentifier(String identifier);
    List<Person> findByIdentifierAndName(String identifier, String name);
    List<Person> findByIdentifierAndBirthYear(String identifier, String byear);
    List<Person> findByIdentifierAndDeathYear(String identifier, String dyear);
    List<Person> findByIdentifierAndProfession(String identifier, String profession);
    List<Person> findByIdentifierAndNameAndBirthYear(String identifier, String name, String byear);
    List<Person> findByIdentifierAndNameAndDeathYear(String identifier, String name, String dyear);
    List<Person> findByIdentifierAndNameAndProfession(String identifier, String name, String profession);
    List<Person> findByIdentifierAndBirthYearAndDeathYear(String identifier, String byear, String dyear);
    List<Person> findByIdentifierAndBirthYearAndProfession(String identifier, String byear, String profession);
    List<Person> findByIdentifierAndDeathYearAndProfession(String identifier, String dyear, String profession);
    List<Person> findByIdentifierAndNameAndBirthYearAndDeathYear(String identifier, String name, String byear, String dyear);
    List<Person> findByIdentifierAndNameAndBirthYearAndProfession(String identifier, String name, String byear, String profession);
    List<Person> findByIdentifierAndNameAndDeathYearAndProfession(String identifier, String name, String dyear, String profession);
    List<Person> findByIdentifierAndBirthYearAndDeathYearAndProfession(String identifier, String byear, String dyear, String profession);

    List<Person> findByName(String name);
    List<Person> findByNameAndBirthYear(String name, String byear);
    List<Person> findByNameAndDeathYear(String name, String dyear);
    List<Person> findByNameAndProfession(String name, String profession);
    List<Person> findByNameAndBirthYearAndDeathYear(String name, String byear, String dyear);
    List<Person> findByNameAndBirthYearAndProfession(String name, String byear, String profession);
    List<Person> findByNameAndDeathYearAndProfession(String name, String dyear, String profession);

    List<Person> findByBirthYear(String byear);
    List<Person> findByBirthYearAndDeathYear(String byear, String dyear);
    List<Person> findByBirthYearAndProfession(String byear, String profession);
    List<Person> findByBirthYearAndDeathYearAndProfession(String byear, String dyear, String profession);

    List<Person> findByDeathYear(String dyear);
    List<Person> findByDeathYearAndProfession(String dyear, String profession);

    List<Person> findByProfession(String profession);

    List<Person> findByIdentifierAndNameAndBirthYearAndDeathYearAndProfession(String identifier, String name, String byear, String dyear, String profession);

}