package ca.skip.skipchallange.rest.v1.domain;

import java.math.BigDecimal;

public final class ProductTO {

	public Long id;
	public Long storeId;
	public String name;
	public String description;
	public BigDecimal price;

	public ProductTO(Long id, Long storeId, String name, String description, BigDecimal price) {
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public ProductTO() {
	}

}