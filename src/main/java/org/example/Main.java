package org.example;

import org.example.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> citiesDirectory = new ArrayList<>();
        try (Scanner cityDirectoryScanner = new Scanner(new File("src/main/resources/Задача ВС Java Сбер.csv"))) {
            while (cityDirectoryScanner.hasNextLine()) {
                citiesDirectory.add(getCityFromLine(cityDirectoryScanner.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException();
        }
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