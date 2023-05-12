package com.getfood.kitchen.infrastructure.persistence.repository;

import com.getfood.kitchen.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {

}
