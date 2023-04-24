package com.vygos.getfoodorder.application.web.controller;

import com.vygos.getfoodorder.application.web.dto.input.OrderInputDTO;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.core.service.OrderService;
import com.vygos.getfoodorder.infrastructure.mapper.OrderMapper;
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
        return ResponseEntity.created(URI.create("/orders")).body(orderService.save(order));
    }
}
