package com.company;

import com.company.service.CsvImporter;
import com.company.service.ImporterService;
import com.company.service.JsonImporter;

public class LooseCouplingTester {

    public static void main(String[] args) {
        var csvImporter = new CsvImporter();
        var importerService = new ImporterService(csvImporter);
        importerService.importAll();

        var jsonImporter = new JsonImporter();
        importerService = new ImporterService(jsonImporter);
        importerService.importAll();
    }

}
