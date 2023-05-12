package com.getfood.order.application.controller;

import com.getfood.order.application.dto.input.OrderInputDTO;
import com.getfood.order.core.domain.model.Order;
import com.getfood.order.core.service.OrderService;
import com.getfood.order.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Order> save(@Validated @RequestBody OrderInputDTO orderInput) {
        Order order = this.orderMapper.toDomain(orderInput);
        return ResponseEntity.created(URI.create("/orders")).body(orderService.saveAndDispatchEvent(order));
    }
}
