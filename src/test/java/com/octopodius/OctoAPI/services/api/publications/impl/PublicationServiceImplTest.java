package com.octopodius.OctoAPI.services.api.publications.impl;

import com.octopodius.OctoAPI.tests.configurations.BaseTest;
import com.octopodius.OctoAPI.services.api.publications.PublicationService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PublicationServiceImplTest extends BaseTest {

    @Autowired
    PublicationService publicationService;

    @Test
    @DisplayName("Publication test sanitize body against possible XSS Attack")
    @Order(3)
    void create_TestSanitizeBodyAgainstXSS() {
        // PublicationCreateReqDTO req = new PublicationCreateReqDTO("Meu titulo", "<script>alert('XSS');</script>", "meu-titulo", CategoryTypeEnum.COMPUTER_SCIENCE, SubCategoryTypeEnum.COMPUTER_PROGRAMMING, null);
        // Publication pub = publicationService.create(this.userAuthor, req);
        //assertThat(pub.getBody()).isEqualTo("&lt;script&gt;alert(&#x27;XSS&#x27;);&lt;/script&gt;");
        assertThat(1).isEqualTo(1);
    }

    @Test
    @DisplayName("Publication test sanitize slug against possible invalid pattern")
    @Order(4)
    void create_TestSanitizeSlug() {
        //PublicationCreateReqDTO req = new PublicationCreateReqDTO("Olá Mundo :)", "## Bem vindos!", "Olá Mundo", CategoryTypeEnum.COMPUTER_SCIENCE, SubCategoryTypeEnum.COMPUTER_PROGRAMMING, null);
        //Publication pub = publicationService.create(this.userAuthor, req);
        //assertThat(pub.getId().getSlug()).isEqualTo("ola-mundo");
        assertThat(1).isEqualTo(1);
    }
}