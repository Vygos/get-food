package com.getfood.kitchen.infrastructure.mapper;

import com.getfood.kitchen.core.domain.model.Restaurant;
import com.getfood.kitchen.infrastructure.persistence.entity.RestaurantEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {


    Restaurant toDomain(RestaurantEntity restaurant);


    default Restaurant toDomainOpen(RestaurantEntity restaurant) {
        var domain = toDomain(restaurant);
        domain.setIsOpen(restaurant.getOpen());
        return domain;
    };

}
