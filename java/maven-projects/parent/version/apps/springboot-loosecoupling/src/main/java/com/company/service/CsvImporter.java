package com.company.service;

public class CsvImporter implements BaseImporter {


    @Override
    public void importFile() {
        System.out.println("Importing Csv File");
    }

    @Override
    public void getHeaders() {
        System.out.println("Providing list of headers present in Csv file");
    }
}
