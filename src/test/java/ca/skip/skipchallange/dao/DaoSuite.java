package ca.skip.skipchallange.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCousineRepository.class, TestCustomerRepository.class, TestProductRepository.class,
		TestStoreRepository.class, TestItemRepository.class, TestOrderRepository.class })
public class DaoSuite {

}
