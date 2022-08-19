package org.service.model.exception;

import org.service.model.OrderStatus;

public class OrderRejectException extends Exception {

    public OrderRejectException(OrderStatus orderStatus) {
        super(String.format("Cannot reject order in status: %s", orderStatus.toString()));
    }
}
