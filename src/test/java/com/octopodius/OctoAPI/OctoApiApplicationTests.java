package com.octopodius.OctoAPI;

import com.octopodius.OctoAPI.tests.configurations.BaseTest;
import com.octopodius.OctoAPI.tests.configurations.ClearDatabase;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.services.api.users.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ClearDatabase
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class OctoApiApplicationTests extends BaseTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	JacksonTester<UserRegisterReqDTO> userRegisterReqJson;

	@Autowired
	JacksonTester<UserRegisterResDTO> userRegisterResJson;
	@Test
	@DisplayName("It should create user to tests. Returning 201 status, because it was using the controller.")
	void createWithSuccess() throws Exception {
		UserService mock = org.mockito.Mockito.mock(UserService.class);

		UserRegisterReqDTO userRegRequest = new UserRegisterReqDTO("test", "test", "test@test.com");
		UserRegisterResDTO userRegResponse = new UserRegisterResDTO("test", "test@test.com");

		when(mock.createUser(userRegRequest)).thenReturn(userRegResponse);

		MockHttpServletResponse response = mockMvc.perform(post("/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userRegisterReqJson.write(userRegRequest).getJson()))
				.andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

		String expectedUserResponseJson = userRegisterResJson.write(userRegResponse).getJson();

		assertThat(response.getContentAsString()).isEqualTo(expectedUserResponseJson);
	}
}
