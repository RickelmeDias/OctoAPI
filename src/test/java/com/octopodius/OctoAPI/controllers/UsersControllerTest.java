package com.octopodius.OctoAPI.controllers;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class UsersControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JacksonTester<UserRegisterReqDTO> userRegisterReqJson;

    @Autowired
    JacksonTester<UserRegisterResDTO> userRegisterResJson;

    @Test
    @DisplayName("It should return status 400, error for duplicated user")
    void createCloneAccount() throws Exception {
        UserRegisterReqDTO userRegRequest = new UserRegisterReqDTO("test", "test", "test@test.com");

        MockHttpServletResponse response = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRegisterReqJson.write(userRegRequest).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}