package com.vygos.getfoodkitchen.infrastructure.mapper;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
import com.vygos.getfoodkitchen.infrastructure.persistence.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant toDomain(RestaurantEntity restaurant);


    default void setIsOpen(Boolean value) {
        this.setIsOpen(value);
    }
}
