package ca.skip.skipchallange.dao;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.ItemRepository;
import ca.skip.skipchallange.domain.Item;

public class TestItemRepository extends AbstractTest {

	@Autowired
	private ItemRepository repository;

	@Test
	public void shouldInsert() {
		Item item = new Item();
		item.setOrderId(5L);
		item.setPrice(BigDecimal.ONE);
		item.setProductId(13L);
		item.setQuantity(1L);
		item.setTotal(BigDecimal.ONE);
		repository.save(item);
	}

}
