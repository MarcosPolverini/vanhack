package ca.skip.skipchallange.rest.v1;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.skipchallange.dao.repository.ItemRepository;
import ca.skip.skipchallange.dao.repository.OrderRepository;
import ca.skip.skipchallange.rest.v1.domain.OrderItemTO;
import ca.skip.skipchallange.rest.v1.domain.OrderTO;

@Component
@RestController
@RequestMapping("Order")
public class OrderController {

	@Autowired
	private OrderRepository repository;	
	
	private ItemRepository itemRepository;
	
	@RequestMapping(path = "/{orderId}", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
	public OrderTO getById(@PathVariable(name = "orderId") Long orderId) {
		final OrderTO to = new OrderTO();
		repository.findById(orderId).ifPresent(o -> {
			to.contact = o.getContact();
			to.customerId = o.getCustomerId();
			to.date = o.getDateCreation();
			to.deliveryAddress = o.getDeliveryAddress();
			to.id = o.getId();
			to.lastUpdate = o.getLastUpdate();
			to.status = o.getStatus();
			to.storeId = o.getStoreId();
			to.total = o.getTotal();
		});
		to.orderItems = itemRepository.findAllByOrderId(orderId)
			.stream()
			.map(i -> new OrderItemTO(i.getId(), i.getOrderId(), i.getProductId(), i.getPrice(), i.getQuantity(), i.getTotal()))
			.collect(Collectors.toList());
		return to;
	}
	
	@RequestMapping(consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void newOrder(@RequestBody OrderTO order) {

	}
	
}
