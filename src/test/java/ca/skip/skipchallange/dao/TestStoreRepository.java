package ca.skip.skipchallange.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.CousineRepository;
import ca.skip.skipchallange.dao.repository.StoreRepository;
import ca.skip.skipchallange.domain.Cousine;
import ca.skip.skipchallange.domain.Store;

public class TestStoreRepository extends AbstractTest {

	@Autowired
	private StoreRepository repository;

	@Autowired
	private CousineRepository cousineRepo;

	@Test
	public void shouldFindById() {
		Optional<Store> store = repository.findById(1L);
		Assert.assertTrue(store.isPresent());
		Assert.assertNotNull(store.get());
	}

	@Test
	public void shoudFindAllByCousinId() {
		List<Store> list = repository.findAllByCousinId(3L);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void shouldFindByName() {
		List<Store> list = repository.findByName("%s%");
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 1);
	}

	@Test
	public void shouldFindAll() {
		Iterable<Store> it = repository.findAll();
		List<Store> list = new ArrayList<>();
		it.forEach(list::add);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 1);
	}

	@Test
	public void shouldBeInsertNewCousine() {
		Cousine cousine = new Cousine();
		cousine.setName("Mexican");
		cousineRepo.save(cousine);
		Store store = new Store();
		store.setAddress("New address");
		store.setCousineId(cousine.getId());
		store.setName("skip");
		repository.save(store);
	}

}
