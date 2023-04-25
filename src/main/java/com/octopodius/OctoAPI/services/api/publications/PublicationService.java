package com.octopodius.OctoAPI.services.api.publications;

import com.octopodius.OctoAPI.dtos.publication.req.PublicationCreateReqDTO;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;
import com.octopodius.OctoAPI.entities.Publication;

import java.util.List;

public interface PublicationService {
    Publication create(PublicationCreateReqDTO publicationDto);

}
