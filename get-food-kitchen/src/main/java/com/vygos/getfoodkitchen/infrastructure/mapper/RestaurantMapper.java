package com.vygos.getfoodkitchen.infrastructure.mapper;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
import com.vygos.getfoodkitchen.infrastructure.persistence.entity.RestaurantEntity;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {


    Restaurant toDomain(RestaurantEntity restaurant);


    default Restaurant toDomainOpen(RestaurantEntity restaurant) {
        var domain = toDomain(restaurant);
        domain.setIsOpen(restaurant.getOpen());
        return domain;
    };

}
