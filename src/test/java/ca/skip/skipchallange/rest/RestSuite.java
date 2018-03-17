package ca.skip.skipchallange.rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCousineController.class, TestCustomerController.class, TestOrderController.class,
		TestProductController.class, TestStoreController.class })
public class RestSuite {

}