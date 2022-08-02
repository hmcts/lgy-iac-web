package uk.gov.hmcts.legacy.web.exception;

public class PendingMigrationScriptException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public PendingMigrationScriptException(String script) {
        super("Found migration not yet applied: " + script);
    }
}
