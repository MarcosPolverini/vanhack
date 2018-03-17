package ca.skip.skipchallange.rest.v1.domain;

import java.math.BigDecimal;

public final class OrderItemTO {

	public Long id;
	public Long orderId;
	public Long productId;
	public BigDecimal price;
	public Long quantity;
	public BigDecimal total;

	public OrderItemTO(Long id, Long orderId, Long productId, BigDecimal price, Long quantity, BigDecimal total) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}

	public OrderItemTO() {
	}

}