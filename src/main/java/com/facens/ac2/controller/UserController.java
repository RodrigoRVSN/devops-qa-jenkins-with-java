package com.facens.ac2.controller;

import com.facens.ac2.controller.dto.UserDTO;
import com.facens.ac2.model.User;
import com.facens.ac2.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<UserDTO> lista() {
    List<User> users = userRepository.findAll();
    return UserDTO.convert(users);
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    User user = userRepository.findById(id).orElse(null);
    if (user != null) {
      user.setName(updatedUser.getName());
      return userRepository.save(user);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}
