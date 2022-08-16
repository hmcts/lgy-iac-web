package uk.gov.hmcts.legacy.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FilePrint {
    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    public void printAllJavaFiles(File directory) {
        if (directory.isDirectory()) {
            File[] subDirectories = directory.listFiles();

            if (subDirectories != null) {
                for (File file : subDirectories) {
                    printAllJavaFiles(file);
                }
            }
        } else {
            printFile(directory);
        }
    }

    private void printFile(File file) {
        LOGGER.info(file.getPath() + "/" + file.getName());
    }
}
