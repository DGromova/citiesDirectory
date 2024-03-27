package org.example.builder;

import org.example.model.City;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityBuilder {

    public static void sortByName(List<City> list) {
        Comparator<City> compareByName = Comparator
                .comparing(City::getName, String::compareToIgnoreCase);
        List<City> newList = list.stream().sorted(compareByName).toList();
        newList.forEach(System.out::println);
    }

    public static void sortByDistrictAndName(List<City> list) {
        Comparator<City> compareByDistrictAndName = Comparator
                .comparing(City::getDistrict)
                .thenComparing(City::getName);
        List<City> newList = list.stream().sorted(compareByDistrictAndName).toList();
        newList.forEach(System.out::println);
    }

    public static void findIndexAndLargestPopulation(List<City> list) {
        City[] cityArr = list.toArray(City[]::new);

        int max = 0;
        int index = 0;
        for (int i = 0; i < cityArr.length; i++) {
            if (max < cityArr[i].getPopulation()) {
                max = cityArr[i].getPopulation();
            }
            if (max == cityArr[i].getPopulation()) {
                index = i;
            }
        }
        System.out.println("[" + index + "]" + " = " + max);
    }

    public static void getNumberOfCitiesByRegion(List<City> list) {
        list.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()))
                .forEach((k, v) -> System.out.println("\u2022 " + k + " = " + v));
    }

}
