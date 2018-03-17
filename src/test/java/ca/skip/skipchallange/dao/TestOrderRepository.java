package ca.skip.skipchallange.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.OrderRepository;
import ca.skip.skipchallange.domain.Orders;

public class TestOrderRepository extends AbstractTest {

	@Autowired
	private OrderRepository repository;

	@Test
	public void shouldBeInsert() {
		Orders order = new Orders();
		order.setContact("Contact Name");
		order.setCustomerId(6L);
		order.setDeliveryAddress("Address to delivery food");
		order.setStatus("P");
		order.setStoreId(2L);
		order.setTotal(BigDecimal.ONE);
		order.setDateCreation(LocalDateTime.now());
		order.setLastUpdate(LocalDateTime.now());
		repository.save(order);
	}

	@Test
	public void shoulFindById() {
		Optional<Orders> order = repository.findById(4L);
		Assert.assertNotNull(order);
		Assert.assertTrue(order.isPresent());
		Assert.assertNotNull(order.get());
	}
}
