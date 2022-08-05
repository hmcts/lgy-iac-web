package uk.gov.hmcts.legacy.web.data.migration;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import uk.gov.hmcts.legacy.web.exception.PendingMigrationScriptException;

import java.util.stream.Stream;


public class FlywayNoOpStrategy implements FlywayMigrationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayNoOpStrategy.class);

    @Override
    public void migrate(Flyway flyway) {
        LOGGER.info("FlywayNoOpStrategy.migrate....");
        Stream.of(flyway.info().all())
            .filter(info -> !info.getState().isApplied())
            .findFirst()
            .ifPresent(info -> {
                throw new PendingMigrationScriptException(info.getScript());
            });
    }
}
