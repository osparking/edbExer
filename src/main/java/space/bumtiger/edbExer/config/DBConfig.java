package space.bumtiger.edbExer.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DBConfig {
	@Bean
	public DataSource dataSource() {

		var builder = new EmbeddedDatabaseBuilder();
		var db = builder.setType(EmbeddedDatabaseType.H2) // HSQL or DERBY
				.addScript("db/schema.sql").addScript("db/data.sql").build();
		return db;
	}

	@Bean
	public JdbcTemplate createJdbcTeamplate() {

		var template = new JdbcTemplate();
		template.setDataSource(dataSource());

		return template;
	}
}
