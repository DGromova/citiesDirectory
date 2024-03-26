package org.example;

import org.example.model.City;
import org.example.builder.CityBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Save the cities from the file and output them in the console

        List<City> citiesDirectory = new ArrayList<>();

        try (Scanner cityDirectoryScanner = new Scanner(new File("src/main/resources/Задача ВС Java Сбер.csv"))) {
            while (cityDirectoryScanner.hasNextLine()) {
                citiesDirectory.add(getCityFromLine(cityDirectoryScanner.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException();
        }

        System.out.println();
        System.out.println("_______________________________________________________________________________________________________________________________________");
        System.out.println();

        //Output the directory of cities sorted by city name to the console
        System.out.println("Directory of cities, sorted by city name:");
        CityBuilder.sortByName(citiesDirectory);

        System.out.println();
        System.out.println("_______________________________________________________________________________________________________________________________________");
        System.out.println();

        //Output the directory of cities sorted by city name and district to the console
        System.out.println("Directory of cities, sorted by district and city name:");
        CityBuilder.sortByDistrictAndName(citiesDirectory);

        System.out.println();
        System.out.println("_______________________________________________________________________________________________________________________________________");
        System.out.println();

        //Output the index of the element and the largest population of the city.
        System.out.println("Index of the element and the largest population of the city:");
        CityBuilder.findIndexAndLargestPopulation(citiesDirectory);

    }

    private static City getCityFromLine(String line) {
        City city = new City();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                city.setId(Integer.parseInt(rowScanner.next()));
                city.setName(rowScanner.next());
                city.setRegion(rowScanner.next());
                city.setDistrict(rowScanner.next());
                city.setPopulation(Integer.parseInt(rowScanner.next()));
                if (!rowScanner.hasNext()) {
                    city.setFoundation("");
                    break;
                } else {
                    city.setFoundation(rowScanner.next());
                }
            }
        }
        System.out.println(city);
        return city;
    }

}