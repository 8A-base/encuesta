/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.repository;

import mx.edu.utez.encuesta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author dvd
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    public User save(User user);

}
