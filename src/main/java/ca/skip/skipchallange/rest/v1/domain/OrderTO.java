package ca.skip.skipchallange.rest.v1.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public final class OrderTO {

    public Long id;

    public LocalDateTime date;

    public Long customerId;

    public String deliveryAddress;

    public String contact;

    public Long storeId;

    public BigDecimal total;

    public String status;

    public LocalDateTime lastUpdate;
    
    public List<OrderItemTO> orderItems;

}