package mx.edu.utez.encuesta.service.impl;

import mx.edu.utez.encuesta.entity.Role;
import mx.edu.utez.encuesta.entity.User;
import mx.edu.utez.encuesta.repository.RoleRepository;
import mx.edu.utez.encuesta.repository.UserRepository;
import mx.edu.utez.encuesta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findRoleByRole("ADMIN");
        System.out.println(userRole.toString());
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}