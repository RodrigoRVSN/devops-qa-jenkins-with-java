// package com.facens.ac2.controller.dto;

// import java.util.List;
// import java.util.stream.Collectors;

// import com.facens.ac2.model.User;


// public class UserDTO {
// 	private Long id;
// 	private String name;
// 	private String email;
	
// 	public UserDTO(User user) {
// 		super();
// 		this.id = user.getId();
// 		this.name = user.getName();
// 		this.email = user.getEmail();
// 	}

// 	public Long getId() {
// 		return id;
// 	}

// 	public String getName() {
// 		return name;
// 	}
	

// 	public String getEmail() {
// 		return email;
// 	}
	

// 	public static List<UserDTO> convert(List<User> usuarios) {
// 		return usuarios.stream().map(UserDTO::new).collect(Collectors.toList());
// 	}

// }
