package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.publication.req.PublicationCreateReqDTO;
import com.octopodius.OctoAPI.entities.Publication;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.services.api.publications.PublicationService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publications")
public class PublicationsController {

    @Autowired
    PublicationService service;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Publication> create(@RequestBody @Valid PublicationCreateReqDTO req) {
        Publication pub = service.create(userService.getUserInformation(), req);
        return ResponseEntity.status(HttpStatus.CREATED).body(pub);
    }
}
