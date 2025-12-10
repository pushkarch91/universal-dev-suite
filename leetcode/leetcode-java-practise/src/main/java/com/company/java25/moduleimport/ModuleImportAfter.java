package com.company.java25.moduleimport;

import module java.base;
import module java.sql;

public class ModuleImportAfter {

    void main() throws SQLException, IOException {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Map<String, Integer> nameLength = new HashMap<>();
        for (String name : names) {
            nameLength.put(name, name.length());
        }

        System.out.println("Name lengths: " + nameLength);

        Set<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toSet());
        System.out.println("Numbers set: " + numbers);

        Random random = new Random();
        System.out.println("Random number: " + random.nextInt(100));

        File tempFile = new File("temp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        // just demo, we won't read content
        reader.close();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        IO.println("Connection established: " + (conn != null));


        BigInteger bigInt = new BigInteger("12345678901234567890");
        BigDecimal bigDec = new BigDecimal("12345.67890");
        IO.println("BigInteger: " + bigInt);


    }
}
