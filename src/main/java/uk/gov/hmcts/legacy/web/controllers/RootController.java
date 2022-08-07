package uk.gov.hmcts.legacy.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Default endpoints per application.
 */
@RestController
public class RootController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    //@Autowired
    //JdbcTemplate jdbcTemplate;

    @Operation(summary = "Get welcome api",
        description = "This is a welcome endpoint"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "A welcome message"),
        @ApiResponse(responseCode = "404", description = "No welcome could be found")
    })
    @RequestMapping(value = "/", method = GET, produces = TEXT_PLAIN_VALUE)

    public ResponseEntity<String> welcome() {

        /*
        String sql = "INSERT INTO recipe (id, user_id, name, ingredients, method) VALUES (?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, 1, 1, "carbonara", "eggs", "my method");
        if (result > 0) {
            LOGGER.error("jdbc insert successful");
        } else {
            LOGGER.info("jdbc insert failure");
        }
        */
        LOGGER.info(" ResponseEntity");
        return ok("Welcome to lgy-iac-web dts-legacy application. My favourite legacy app is "
                      + System.getenv("FAVOURITE_FRUIT"));
    }
}
