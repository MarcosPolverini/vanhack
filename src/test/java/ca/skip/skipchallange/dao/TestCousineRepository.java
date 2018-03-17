package ca.skip.skipchallange.dao;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.CousineRepository;
import ca.skip.skipchallange.domain.Cousine;

public class TestCousineRepository extends AbstractTest {

	@Autowired
	private CousineRepository repository;

	@Autowired
	private JdbcTemplate template;

	@Before
	public void cleanBase() {
		template.execute("DELETE FROM cousine WHERE name = 'teste'");
	}

	@Test
	public void positiveManager() {
		Long id = shouldBeInsert();
		shoulGetByName();
		shoulGetById(id);
	}

	private Long shouldBeInsert() {
		Cousine c = new Cousine();
		c.setName("chinese");
		repository.save(c);
		return c.getId();
	}

	private void shoulGetByName() {
		List<Cousine> list = repository.findByName("%chi%");
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 1);
	}

	private void shoulGetById(Long id) {
		Optional<Cousine> chinese = repository.findById(id);
		Assert.assertTrue(chinese.isPresent());
		Assert.assertTrue(chinese.get().getName().equalsIgnoreCase("chinese"));
	}
}
