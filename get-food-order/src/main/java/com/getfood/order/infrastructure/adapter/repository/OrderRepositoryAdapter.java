package com.getfood.order.infrastructure.adapter.repository;

import com.getfood.order.core.domain.model.Order;
import com.getfood.order.core.ports.outgoing.OrderRepositoryGateway;
import com.getfood.order.infrastructure.mapper.OrderMapper;
import com.getfood.order.infrastructure.persistence.entity.OrderEntity;
import com.getfood.order.infrastructure.persistence.repository.OrderRepository;
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
