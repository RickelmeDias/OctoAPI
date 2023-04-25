package com.octopodius.OctoAPI.services.api.publications.impl;

import com.octopodius.OctoAPI.daos.PublicationRepository;
import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.publication.req.PublicationCreateReqDTO;
import com.octopodius.OctoAPI.entities.Publication;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import com.octopodius.OctoAPI.services.api.publications.PublicationService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    PublicationRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    UserService userService;

    @Override
    public Publication create(PublicationCreateReqDTO publicationDto) {
        User userAuthor = (User) userRepository.findByEmail(jwtTokenService.getUserEmail());
        Publication.PublicationsId id = new Publication.PublicationsId(userAuthor.getUsername(), publicationDto.slug());
        Publication pub = new Publication(id, userAuthor, publicationDto.title(), publicationDto.body(), publicationDto.category(), publicationDto.subCategory(),
                publicationDto.tags(), true, null, null, null);
        return repository.save(pub);
    }
}