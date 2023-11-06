package com.facens.ac2;

import com.facens.ac2.controller.UserController;
import org.hamcrest.Matchers;
import org.junit.platform.commons.annotation.Testable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @RunWith(SpringRunner.class)
// @WebMvcTest(controllers = UserController.class)
public class Ac2ApplicationTests {

//   @Autowired
//   private MockMvc mockMvc;

//   @Testable
//   public void testUsersControllerReturnsEmptyArray() throws Exception {
//     mockMvc
//       .perform(MockMvcRequestBuilders.get("/users"))
//       .andExpect(MockMvcResultMatchers.status().isOk()) // Check for HTTP 200 status
//       .andExpect(
//         MockMvcResultMatchers.content().contentType("application/json")
//       ) // Check if response is JSON
//       .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0))); // Check if the JSON array is empty
//   }
}
