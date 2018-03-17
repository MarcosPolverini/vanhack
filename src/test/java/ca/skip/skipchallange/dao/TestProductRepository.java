package ca.skip.skipchallange.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.ProductRepository;
import ca.skip.skipchallange.domain.Product;

public class TestProductRepository extends AbstractTest {

	@Autowired
	private ProductRepository repository;

	@Test
	public void positiveManager() {
		Long id = shouldBeInsert();
		shoulGetById(id);
		shoulGetProductByName();
	}

	private Long shouldBeInsert() {
		Product p = new Product();
		p.setDescription("New product to test");
		p.setName("teste");
		p.setPrice(BigDecimal.ONE);
		p.setStoreId(2L);
		repository.save(p);
		return p.getId();
	}

	private void shoulGetById(Long id) {
		Optional<Product> product = repository.findById(id);
		Assert.assertTrue(product.isPresent());
		Assert.assertNotNull(product.get());
	}

	private void shoulGetProductByName() {
		List<Product> prod = repository.findAllByName("%e%");
		Assert.assertNotNull(prod);
		Assert.assertTrue(prod.size() > 1);
	}
}
