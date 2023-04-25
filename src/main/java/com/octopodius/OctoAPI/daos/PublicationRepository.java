package com.octopodius.OctoAPI.daos;

import com.octopodius.OctoAPI.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Publication.PublicationsId> {
}
