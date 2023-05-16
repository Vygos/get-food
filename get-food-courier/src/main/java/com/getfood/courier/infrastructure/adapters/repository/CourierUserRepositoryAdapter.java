package com.getfood.courier.infrastructure.adapters.repository;

import com.getfood.courier.core.domain.CourierUser;
import com.getfood.courier.core.mapper.CourierUserMapper;
import com.getfood.courier.core.ports.outgoing.CourierUserGateway;
import com.getfood.courier.infrastructure.persistence.repository.CourierUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CourierUserRepositoryAdapter implements CourierUserGateway {

    private final CourierUserRepository courierUserRepository;
    private final CourierUserMapper mapper;

    @Override
    public List<CourierUser> findByOnline() {
        return this.courierUserRepository.findByOnline(true)
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }
}
