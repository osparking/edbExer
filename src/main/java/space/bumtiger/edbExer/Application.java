package space.bumtiger.edbExer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import space.bumtiger.edbExer.model.Car;

@ComponentScan(basePackages = "space.bumtiger.edbExer")
public class Application {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);

	public static void main(String[] args) {

		var ctx = new AnnotationConfigApplicationContext(Application.class);
		var app = ctx.getBean(Application.class);

		app.run();

		ctx.close();
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private void run() {

		var sql = "SELECT * FROM cars";

		var cars = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Car.class));

		cars.forEach(car -> logger.info("{}", car));
	}
}
