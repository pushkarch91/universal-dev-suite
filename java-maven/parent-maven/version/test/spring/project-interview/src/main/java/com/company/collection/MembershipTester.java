package com.company.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MembershipTester {

    public static void main(String[] args) {
        List<Number> list = List.of(1, 2, 3);
        Collection<Number> collection = List.of(1, 2, 3);
        List<Number> asList = Arrays.asList(1,2,3);
        List<Number> arrayList = new ArrayList<>(List.of(1, 2, 3));

        //list.remove(1);
        //collection.remove(1);
        //asList.remove(1);
        arrayList.remove(1);

        System.out.println(list);
        System.out.println(collection);
        System.out.println(asList);
        System.out.println(arrayList);

    }

}

