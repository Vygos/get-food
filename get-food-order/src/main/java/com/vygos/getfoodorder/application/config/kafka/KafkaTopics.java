package com.vygos.getfoodorder.application.config.kafka;

public class KafkaTopics {
    public static final String CREATE_TICKET_TOPIC = "get-food-kitchen.ticket.create";
    public static final String CREATE_TICKET_REPLY_TOPIC = "get-food-kitchen.ticket.create-reply";
    public static final String CREATE_ORDER_REJECT_TOPIC = "get-food-order.order.reject";
    public static final String VERIFY_COURIER_TOPIC = "get-food-courier.courier.verify";
}
