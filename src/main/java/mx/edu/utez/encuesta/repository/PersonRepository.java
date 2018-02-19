/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author dvd
 */
@Configuration
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findById(Integer idPerson);
}

