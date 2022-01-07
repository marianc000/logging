package folder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@ServletComponentScan 
@Configuration
public class Init {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(JdbcTemplate jdbcTemplate) {
        return args -> {
            log.info("Creating tables");

            jdbcTemplate.execute("CREATE TABLE ITEMS( ID SERIAL,DESCRIPTION VARCHAR(255))");
 

            jdbcTemplate.update("INSERT INTO ITEMS(DESCRIPTION) VALUES(? )", "Default" );

            jdbcTemplate.query(
                    "SELECT ID,DESCRIPTION FROM ITEMS",
                    (rs, rowNum) -> new Item(rs.getInt("ID"), rs.getString("DESCRIPTION"))
            ).forEach(customer -> log.info(customer.toString()));
        };
    }
}
