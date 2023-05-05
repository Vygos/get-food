package com.vygos.getfoodorder.infrastructure.adapter.repository;

import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.core.ports.outgoing.OrderRepositoryGateway;
import com.vygos.getfoodorder.infrastructure.mapper.OrderMapper;
import com.vygos.getfoodorder.infrastructure.persistence.entity.OrderEntity;
import com.vygos.getfoodorder.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryAdapter implements OrderRepositoryGateway {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = this.orderMapper.toEntity(order);
        return this.orderMapper.toDomain(this.orderRepository.save(orderEntity));
    }

    @Override
    public Order update(Order order) {
        OrderEntity orderEntity = this.orderMapper.toEntity(order);
        orderEntity.getItems().forEach(item -> item.setOrder(orderEntity));
        return this.orderMapper.toDomain(this.orderRepository.save(orderEntity));
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id).map(orderMapper::toDomain);
    }

}
