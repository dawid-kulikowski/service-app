package org.service.model;

import org.service.model.exception.OrderRejectException;

public enum OrderStatus {
    IN_ORDER {
        @Override
        public OrderStatus nextStatus() {
            if (!isAccepted) {
                return READY_TO_RECEIVE;
            }
            return VALUATION;
        }
        @Override
        public void reject() {
            OrderStatus.changeToReject();
        }
    },
    VALUATION {
        public OrderStatus nextStatus() {
            if (!isAccepted) {
                return READY_TO_RECEIVE;
            }
            return WAITING_FOR_ACCEPTANCE;
        }
        @Override
        public void reject() {
            OrderStatus.changeToReject();
        }
    },
    WAITING_FOR_ACCEPTANCE {
        public OrderStatus nextStatus() {
            if (isAccepted) {
                return PRICE_ACCEPTED;
            }
            return PRICE_REJECTED;
        }
        @Override
        public void reject() {
            OrderStatus.changeToReject();
        }
    },
    PRICE_ACCEPTED {
        @Override
        public OrderStatus nextStatus() {
            if (!isAccepted) {
                return READY_TO_RECEIVE;
            }
            return PARTS_ORDERED;
        }
        @Override
        public void reject() {
            OrderStatus.changeToReject();
        }
    },
    PRICE_REJECTED {
        @Override
        public OrderStatus nextStatus() {
            return READY_TO_RECEIVE;
        }
        @Override
        public void reject() {
            OrderStatus.changeToReject();
        }
    },
    PARTS_ORDERED {
        @Override
        public OrderStatus nextStatus() {
            return PARTS_DELIVERED;
        }
        @Override
        public void reject() throws OrderRejectException {
            throw new OrderRejectException(PARTS_ORDERED);
        }
    },
    PARTS_DELIVERED {
        @Override
        public OrderStatus nextStatus() {
            return IN_REPAIR;
        }
        @Override
        public void reject() throws OrderRejectException {
            throw new OrderRejectException(PARTS_DELIVERED);
        }
    },
    IN_REPAIR {
        @Override
        public OrderStatus nextStatus() {
            return READY_TO_RECEIVE;
        }
        @Override
        public void reject() throws OrderRejectException {
            throw new OrderRejectException(IN_REPAIR);
        }
    },
    READY_TO_RECEIVE {
        @Override
        public OrderStatus nextStatus() {
            return RECEIVED;
        }
        @Override
        public void reject() throws OrderRejectException {
            throw new OrderRejectException(PARTS_DELIVERED);
        }
    },
    RECEIVED {
        @Override
        public OrderStatus nextStatus() {
            return RECEIVED;
        }
        @Override
        public void reject() throws OrderRejectException {
            throw new OrderRejectException(PARTS_DELIVERED);
        }
    };

    private static boolean isAccepted = true;

    private static void changeToReject() {
        isAccepted = false;
    }

    public abstract OrderStatus nextStatus();

    public abstract void reject() throws OrderRejectException;
}
