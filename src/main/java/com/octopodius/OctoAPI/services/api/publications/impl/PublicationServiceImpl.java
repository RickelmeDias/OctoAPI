package com.octopodius.OctoAPI.services.api.publications.impl;

import com.octopodius.OctoAPI.daos.PublicationRepository;
import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.publication.req.PublicationCreateReqDTO;
import com.octopodius.OctoAPI.entities.Publication;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import com.octopodius.OctoAPI.services.api.publications.PublicationService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    PublicationRepository repository;

    @Override
    public Publication create(User userAuthor, PublicationCreateReqDTO publicationDto) {
        String sanitizedSlug = sanitizeSlug(publicationDto.slug());
        String sanitizedBody = sanitizeAgainstXSS(publicationDto.body());

        Publication.PublicationsId id = new Publication.PublicationsId(userAuthor.getUsername(), sanitizedSlug);

        if (repository.findById_UsernameAuthorAndId_Slug(userAuthor.getUsername(), sanitizedSlug) != null) {
            throw new RuntimeException("you already published a topic with this slug");
        }

        Publication pub = new Publication(id, userAuthor, publicationDto.title(), sanitizedBody, publicationDto.category(), publicationDto.subCategory(),
                publicationDto.tags(), true, null, null, null);
        return repository.save(pub);
    }

    private String sanitizeAgainstXSS(String body) {
        // https://github.com/OWASP/owasp-java-encoder/
        return Encode.forHtml(body);
    }

    public String sanitizeSlug(String input) {
        // Convert the possible slug Olá Mundo to ola-mundo
        return  Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("\\s+", "-").toLowerCase();
    }
}