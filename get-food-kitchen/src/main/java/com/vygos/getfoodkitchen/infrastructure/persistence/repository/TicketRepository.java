package com.vygos.getfoodkitchen.infrastructure.persistence.repository;

import com.vygos.getfoodkitchen.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {

}
