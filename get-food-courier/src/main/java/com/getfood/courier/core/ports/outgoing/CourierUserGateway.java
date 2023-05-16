package com.getfood.courier.core.ports.outgoing;

import com.getfood.courier.core.domain.CourierUser;

import java.util.List;
import java.util.Optional;

public interface CourierUserGateway {

    List<CourierUser> findByOnline();
}
