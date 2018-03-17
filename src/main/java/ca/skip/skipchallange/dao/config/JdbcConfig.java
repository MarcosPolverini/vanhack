package ca.skip.skipchallange.dao.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.DataAccessStrategy;
import org.springframework.data.jdbc.core.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.DelegatingDataAccessStrategy;
import org.springframework.data.jdbc.core.SqlGeneratorSource;
import org.springframework.data.jdbc.mapping.model.JdbcMappingContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class JdbcConfig {

	@Bean
	DataAccessStrategy defaultDataAccessStrategy(JdbcMappingContext context, DataSource dataSource) {
		NamedParameterJdbcOperations operations = new NamedParameterJdbcTemplate(dataSource);
		DelegatingDataAccessStrategy accessStrategy = new DelegatingDataAccessStrategy();
		accessStrategy.setDelegate(new DefaultDataAccessStrategy(new SqlGeneratorSource(context), operations, context, accessStrategy));
		return accessStrategy;
	}
}
