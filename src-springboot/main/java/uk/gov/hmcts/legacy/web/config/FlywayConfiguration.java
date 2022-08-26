package uk.gov.hmcts.legacy.web.config;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.hmcts.legacy.web.data.migration.FlywayNoOpStrategy;


@AutoConfigureAfter({
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
@AutoConfigureBefore(FlywayAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Flyway.class)
@ConditionalOnProperty(prefix = "dbMigration", name = "runOnStartup", havingValue = "false")
public class FlywayConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayConfiguration.class);

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        LOGGER.info("In flywayMigrationStrategy");
        return new FlywayNoOpStrategy();
    }
}
