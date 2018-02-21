/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.encuesta.service;

import mx.edu.utez.encuesta.entity.User;


/**
 * @author dvd
 */
public interface UserService {
    public User findByEmail(String email);

    public void save(User user);
}
