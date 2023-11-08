// package com.facens.ac2.controller;

// import com.facens.ac2.controller.dto.UserDTO;
// import com.facens.ac2.controller.form.UserForm;
// import com.facens.ac2.model.User;
// import com.facens.ac2.repository.UserRepository;
// import java.net.URI;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.util.UriComponentsBuilder;

// @RestController
// @CrossOrigin
// @RequestMapping("/users")
// public class UserController {

//   @Autowired
//   private UserRepository userRepository;

//   @GetMapping
//   public List<UserDTO> listUsers() {
//     List<User> users = userRepository.findAll();
//     System.out.println("users:" + users);
//     return UserDTO.convert(users);
//   }

//   @PostMapping
//   public ResponseEntity<UserDTO> createUser(
//     @RequestBody UserForm form,
//     UriComponentsBuilder uriBuilder
//   ) {
//     User user = form.convert(userRepository);
//     userRepository.save(user);

//     URI uri = uriBuilder
//       .path("/users/{id}")
//       .buildAndExpand(user.getId())
//       .toUri();
//     return ResponseEntity.created(uri).body(new UserDTO(user));
//   }
// }
