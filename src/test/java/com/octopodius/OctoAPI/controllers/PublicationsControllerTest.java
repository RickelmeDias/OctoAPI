package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.publication.req.PublicationCreateReqDTO;
import com.octopodius.OctoAPI.dtos.publication.res.PublicationCreatedResDTO;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.entities.Publication;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import com.octopodius.OctoAPI.services.api.publications.PublicationService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import com.octopodius.OctoAPI.tests.configurations.BaseTest;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublicationsControllerTest extends BaseTest {


    @Autowired
    JacksonTester<PublicationCreateReqDTO> publicationCreateReqJson;

    @Autowired
    JacksonTester<PublicationCreatedResDTO> publicationCreatedResJson;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    @Test
    @DisplayName("It should return status 201, created publication")
    @Order(1)
    void createPublication() throws Exception {
        PublicationService mock = org.mockito.Mockito.mock(PublicationService.class);

        PublicationCreateReqDTO pubRegRequest = new PublicationCreateReqDTO("OlÅ Mundo", "<script>alert('XSS');</script>", "Olá Mundo", CategoryTypeEnum.COMPUTER_SCIENCE, SubCategoryTypeEnum.COMPUTER_PROGRAMMING, null);
        Publication.PublicationsId id = new Publication.PublicationsId("test", "ola-mundo");
        PublicationCreatedResDTO pubRegResponse = new PublicationCreatedResDTO(id, "OlÅ Mundo", "&lt;script&gt;alert(&#39;XSS&#39;);&lt;/script&gt;", "ola-mundo", CategoryTypeEnum.COMPUTER_SCIENCE, SubCategoryTypeEnum.COMPUTER_PROGRAMMING, null);

        User user = (User) userRepository.findByEmail("test@test.com");
        String token = "Bearer " + jwtTokenService.generateToken(user);

        when(mock.create(user, pubRegRequest)).thenReturn(pubRegResponse);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", token);

        MockHttpServletResponse response = mockMvc.perform(post("/publications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(publicationCreateReqJson.write(pubRegRequest).getJson())
                        .headers(httpHeaders))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        String expectedPublicationResponseJson = publicationCreatedResJson.write(pubRegResponse).getJson();

        byte[] responseBytes = response.getContentAsByteArray();
        String responseString = new String(responseBytes, "UTF-8");

        assertThat(responseString).isEqualTo(expectedPublicationResponseJson);
    }
}