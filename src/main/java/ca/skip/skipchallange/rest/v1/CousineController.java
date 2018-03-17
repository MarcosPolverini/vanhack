package ca.skip.skipchallange.rest.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.skipchallange.dao.repository.CousineRepository;
import ca.skip.skipchallange.dao.repository.StoreRepository;
import ca.skip.skipchallange.domain.Cousine;
import ca.skip.skipchallange.rest.v1.domain.CousineTO;
import ca.skip.skipchallange.rest.v1.domain.StoreTO;

@Component
@RestController
@RequestMapping("Cousine")
public final class CousineController {

	@Autowired
	private CousineRepository repository;

	@Autowired
	private StoreRepository storeRepository;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<CousineTO> getAll() {
		return convert(repository.findAll());
	}

	@RequestMapping(path = "search/{searchText}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<CousineTO> getByName(@PathVariable String searchText) {
		return convert(repository.findByName("%" + searchText + "%"));
	}

	@RequestMapping(path = "{cousineId}/stores", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<StoreTO> getByCousineId(@PathVariable Long cousineId) {
		return storeRepository.findAllByCousinId(cousineId)
				.stream()
				.map(s -> new StoreTO(s.getId(), s.getName(), s.getAddress(), s.getCousineId()))
				.collect(Collectors.toList());
	}

	private List<CousineTO> convert(Iterable<Cousine> it){
		List<Cousine> list = new ArrayList<>();
		it.forEach(list::add);
		return list
				.stream()
				.map(c -> new CousineTO(c.getId(), c.getName()))
				.collect(Collectors.toList());
	}

}