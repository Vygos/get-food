package com.getfood.kitchen.application.controller;

import com.getfood.kitchen.core.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("ticket")
public class TicketController {

    private final KitchenService kitchenService;

    @PutMapping("{id}/accept")
    public ResponseEntity<Void> accept(@PathVariable("id") UUID id) {
        this.kitchenService.accept(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/preparing")
    public ResponseEntity<Void> preparing(@PathVariable("id") UUID id) {
        this.kitchenService.accept(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/reject")
    public ResponseEntity<Void> reject(@PathVariable("id") UUID id) {

        return ResponseEntity.ok().build();
    }
}
