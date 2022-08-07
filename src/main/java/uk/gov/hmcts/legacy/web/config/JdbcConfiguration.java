package uk.gov.hmcts.legacy.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcConfiguration.class);

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        try {
            LOGGER.info("in jdbcTemplate");
            LOGGER.info("datasource." + dataSource.getConnection().toString());
        } catch (SQLException e) {
            LOGGER.error("getConnection error" + e.getMessage());
        }
        return new JdbcTemplate(dataSource);
    }

}
