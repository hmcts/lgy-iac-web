package uk.gov.hmcts.legacy.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Default endpoints per application.
 */
@RestController
public class RootController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    @Value("${env.dbhost}")
    private String dbHost;

    @Value("${env.dbport}")
    private String dbPort;

    @Value("${env.dbname}")
    private String dbName;

    @Value("${env.dbuser}")
    private String dbUser;

    @Value("${env.dbpass}")
    private String dbPass;

    @Value("${spring.flyway.password}")
    private String flywayPass;

    @Value("${dbMigration.runOnStartup}")
    private String dbRunAtStartup;

    @Operation(summary = "Get welcome api",
        description = "This is a welcome endpoint"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "A welcome message"),
        @ApiResponse(responseCode = "404", description = "No welcome could be found")
    })
    @RequestMapping(value = "/", method = GET, produces = TEXT_PLAIN_VALUE)

    @SuppressWarnings({"PMD.CloseResource", "PMD.AvoidLiteralsInIfCondition"})
    public ResponseEntity<String> welcome() {

        LOGGER.info("Run migration is <" + dbRunAtStartup + ">");
        LOGGER.info("dbUser <" + dbUser + ">");
        LOGGER.info("dbPass <" + dbPass + ">");
        LOGGER.info("flywayPass <" + flywayPass + ">");
        LOGGER.info("dbHost <" + dbHost + ">");
        LOGGER.info("dPort <" + dbPort + ">");
        LOGGER.info("dbName <" + dbName + ">");

        if (!"localhost".equals(dbHost)) {

            Properties connectionInfo = new Properties();
            connectionInfo.setProperty("user", dbUser);
            connectionInfo.setProperty("password", dbPass);

            String dbUrl = String.format("jdbc:postgresql://%s:%s/%s?ssl_mode=require", dbHost, dbPort, dbName);
            LOGGER.info("testing connection to database.... with url <" + dbUrl + "> user <" + dbUser + ">");

            try (Connection conn = DriverManager.getConnection(dbUrl, connectionInfo)) {
                LOGGER.info("connection OK - select from fees table");
                try (PreparedStatement pstmt = conn.prepareStatement("SELECT 1 FROM dbo.fees")) {
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        LOGGER.info("retrieved record from table");
                    } else {
                        LOGGER.info("Error: no data retrieved");
                    }
                }
            } catch (SQLException e) {
                LOGGER.error("jdbc failure: " + e.getMessage() + ":" + e.getSQLState());
            }
        }

        return ok("Welcome to lgy-iac-web dts-legacy application. My favourite legacy app is "
                      + System.getenv("FAVOURITE_FRUIT"));
    }
}
