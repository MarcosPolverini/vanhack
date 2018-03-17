package ca.skip.skipchallange.rest.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.skipchallange.dao.repository.ProductRepository;
import ca.skip.skipchallange.dao.repository.StoreRepository;
import ca.skip.skipchallange.domain.Store;
import ca.skip.skipchallange.rest.v1.domain.ProductTO;
import ca.skip.skipchallange.rest.v1.domain.StoreTO;

@Component
@RestController
@RequestMapping("Store")
public class StoreController {

	@Autowired
	private StoreRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Function<Store, StoreTO> CONVERTER = s -> new StoreTO(s.getId(), s.getName(), s.getAddress(), s.getCousineId());
	
	@RequestMapping
	public List<StoreTO> getAll(){
		return convert(repository.findAll());
	}
	
	@RequestMapping("search/{searchText}")
	public List<StoreTO> getByNamed(@PathVariable(name = "searchText") String searchText){
		return convert(repository.findByName(searchText));
	}
	
	@RequestMapping("/{storeId}")
	public StoreTO getById(@PathVariable(name = "storeId") Long storeId) {
		return CONVERTER.apply(repository.findById(storeId).orElse(new Store()));
	}
	
	@RequestMapping("/{storeId}/products")
	public List<ProductTO> getProductsByStore(@PathVariable(name = "storeId") Long storeId) {
		return productRepository.findByStoreId(storeId)
				.stream()
				.map(p -> new ProductTO(p.getId(), p.getStoreId(), p.getName(), p.getDescription(), p.getPrice()))
				.collect(Collectors.toList());
	}
	
	private List<StoreTO> convert(Iterable<Store> it){
		List<Store> list = new ArrayList<>();
		it.forEach(list::add);
		return list
				.stream()
				.map(CONVERTER)
				.collect(Collectors.toList());
	}
}
