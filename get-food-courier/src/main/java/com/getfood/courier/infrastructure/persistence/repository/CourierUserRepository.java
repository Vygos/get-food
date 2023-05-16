package com.getfood.courier.infrastructure.persistence.repository;

import com.getfood.courier.infrastructure.persistence.entity.CourierUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourierUserRepository extends JpaRepository<CourierUserEntity, UUID> {

    List<CourierUserEntity> findByOnline(Boolean active);
}
