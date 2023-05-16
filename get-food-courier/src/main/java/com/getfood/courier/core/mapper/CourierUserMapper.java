package com.getfood.courier.core.mapper;

import com.getfood.courier.core.domain.CourierUser;
import com.getfood.courier.infrastructure.persistence.entity.CourierUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourierUserMapper {

    CourierUserEntity toEntity(CourierUser domain);

    CourierUser toDomain(CourierUserEntity entity);
}
