package com.company.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ImporterServiceTest {

    @Test
    public void test() {
        new ImporterService(new CsvImporter()).importAll();
        new ImporterService(new JsonImporter()).importAll();
    }

}