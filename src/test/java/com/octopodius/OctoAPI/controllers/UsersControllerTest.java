package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import com.octopodius.OctoAPI.tests.configurations.BaseTest;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    JacksonTester<UserRegisterReqDTO> userRegisterReqJson;

    @Autowired
    JacksonTester<UserRegisterResDTO> userRegisterResJson;

    @Test
    @DisplayName("It should return status 201, and create new user.")
    @Order(1)
    void createWithSuccess() throws Exception {
        UserService mock = org.mockito.Mockito.mock(UserService.class);

        UserRegisterReqDTO userRegRequest = new UserRegisterReqDTO("usercreating", "usercreating", "usercreating@usercreating.com");
        UserRegisterResDTO userRegResponse = new UserRegisterResDTO("usercreating", "usercreating@usercreating.com");

        when(mock.createUser(userRegRequest)).thenReturn(userRegResponse);

        MockHttpServletResponse response = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRegisterReqJson.write(userRegRequest).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        String expectedUserResponseJson = userRegisterResJson.write(userRegResponse).getJson();

        assertThat(response.getContentAsString()).isEqualTo(expectedUserResponseJson);
    }

    @Test
    @DisplayName("It should return status 400, duplicated username")
    @Order(2)
    void createDuplicatedUsernameAccount() throws Exception {
        UserRegisterReqDTO userRegRequest = new UserRegisterReqDTO("usercreating", "usercreating", "notSame@notSame.com");

        MockHttpServletResponse response = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRegisterReqJson.write(userRegRequest).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("It should return status 403, group not allowed to access all users")
    @Order(3)
    void getAllUsers() throws Exception {
        User user = (User) userRepository.findByEmail("usercreating@usercreating.com");
        String token = "Bearer " + jwtTokenService.generateToken(user);

        MockHttpServletResponse response = mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
    }

    @Test
    @DisplayName("It should return status 400, duplicated email")
    @Order(4)
    void createDuplicatedEmailAccount() throws Exception {
        UserRegisterReqDTO userRegRequest = new UserRegisterReqDTO("notSame", "usercreating", "usercreating@usercreating.com");

        MockHttpServletResponse response = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRegisterReqJson.write(userRegRequest).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("It should return status 200, delete user")
    @Order(5)
    void deleteUser() throws Exception {
        User user = (User) userRepository.findByEmail("usercreating@usercreating.com");
        String token = "Bearer " + jwtTokenService.generateToken(user);

        MockHttpServletResponse response = mockMvc.perform(delete("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}