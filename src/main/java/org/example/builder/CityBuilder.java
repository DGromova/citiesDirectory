package org.example.builder;

import org.example.model.City;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        for (City city : cityArr) {
            if (max < city.getPopulation()) {
                max = city.getPopulation();
            }
            if (max == city.getPopulation()) {
                index = city.getId();
            }
        }
        System.out.println("[" + index + "]" + " = " + max);
    }

}
