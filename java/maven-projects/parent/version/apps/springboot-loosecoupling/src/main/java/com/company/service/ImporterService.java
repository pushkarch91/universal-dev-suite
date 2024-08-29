package com.company.service;

public class ImporterService {

    private final BaseImporter baseImporter;

    public ImporterService(BaseImporter baseImporter) {
        this.baseImporter = baseImporter;
    }

    public void importAll() {
        System.out.println("Importing file using importer " + baseImporter);
        baseImporter.importFile();
        baseImporter.getHeaders();
    }
}
