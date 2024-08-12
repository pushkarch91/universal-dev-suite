package com.company.service;

public class JsonImporter implements BaseImporter {


    @Override
    public void importFile() {
        System.out.println("Importing Json File");
    }

    @Override
    public void getHeaders() {
        System.out.println("Providing list of headers present in Json file");
    }
}

