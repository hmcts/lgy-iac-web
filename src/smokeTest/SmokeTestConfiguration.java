package uk.gov.hmcts.legacy.lgyiacweb.smoketests;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("uk.gov.hmcts.lgy-iac-web.smoketests")
@PropertySource("application.properties")
public class SmokeTestConfiguration {
  //TODO: implement smoke tests here
}
