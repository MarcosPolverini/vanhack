package ca.skip.skipchallange.dao.repository;

import org.springframework.data.repository.CrudRepository;

import ca.skip.skipchallange.domain.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

}
