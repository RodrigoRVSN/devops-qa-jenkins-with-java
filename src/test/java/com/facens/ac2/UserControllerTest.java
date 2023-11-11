package com.facens.ac2;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
  //   @Autowired
  //   private MockMvc mockMvc;

  //   @Mock
  //   private UserRepository userRepository;

  //   private ObjectMapper objectMapper;

  //   @BeforeEach
  //   public void setUp() {
  //     objectMapper = new ObjectMapper();
  //   }
  /// @Test
  // @Transactional
  // public void testListUsers() throws Exception {
  // // Create some test users
  // User user1 = new User("testuser1", "testuser1@example.com", "");
  // User user2 = new User("testuser2", "testuser2@example.com", "");
  //
  // // Define how the UserRepository should behave
  // when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
  //
  // // Perform the request to list users
  // MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
  // .contentType(MediaType.APPLICATION_JSON))
  // .andExpect(MockMvcResultMatchers.status().isOk())
  // .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
  // .andExpect(jsonPath("$[0].name").value(user1.getName()))
  // .andExpect(jsonPath("$[0].email").value(user1.getEmail()))
  // .andExpect(jsonPath("$[1].name").value(user2.getName()))
  // .andExpect(jsonPath("$[1].email").value(user2.getEmail()))
  // .andReturn();
  //
  // // Check if the response content is not empty
  // String content = result.getResponse().getContentAsString();
  // List<UserDTO> users = Arrays.asList(objectMapper.readValue(content,
  /// UserDTO[].class));
  // assertEquals(2, users.size());
  // }

  // @Test
  // public void testCreateUser() throws Exception {
  // 	UserForm userForm = new UserForm();
  // 	userForm.setName("testuser");
  // 	userForm.setEmail("testuser@example.com");
  // 	userForm.setPassword("testpassword");

  // 	String userJson = objectMapper.writeValueAsString(userForm);

  // 	mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON).content(userJson))
  // 			.andExpect(MockMvcResultMatchers.status().isCreated())
  // 			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
  // 			.andExpect(jsonPath("$.name").value(userForm.getName()))
  // 			.andExpect(jsonPath("$.email").value(userForm.getEmail()));
  // }

}
