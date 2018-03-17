package ca.skip.skipchallange.rest.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.skipchallange.dao.repository.ProductRepository;
import ca.skip.skipchallange.domain.Product;
import ca.skip.skipchallange.rest.v1.domain.ProductTO;

@Component
@RestController
@RequestMapping("Product")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	private static final Function<Product, ProductTO> CONVERTER = p -> new ProductTO(p.getId(),p.getStoreId(),p.getName(),p.getDescription(), p.getPrice());
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductTO> getAll() {
		List<Product> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list.stream().map(CONVERTER).collect(Collectors.toList());
	}

	@RequestMapping(path = "/search/{searchText}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ProductTO> getAllFilteredByName(@PathVariable String searchText) {
		return repository.findAllByName(searchText).stream().map(CONVERTER).collect(Collectors.toList());
	}

	@RequestMapping("/{productId}")
	public ProductTO getById(@PathVariable Long productId) {
		return CONVERTER.apply(repository.findById(productId).orElse(new Product()));
	}	
}
