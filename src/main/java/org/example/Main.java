package org.example;

import org.example.manipulation.DataManipulation;
import org.example.manipulation.DataManipulationImpl;
import org.example.repository.Repository;
import org.example.repository.RepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Repository repository = new RepositoryImpl();
        List<Integer> integerList = repository.read();

        DataManipulation dataManipulation = new DataManipulationImpl(integerList);

        System.out.println("Max: " + dataManipulation.getMax());
        System.out.println("Min: " + dataManipulation.getMin());
        System.out.println("Middle: " + dataManipulation.getMiddle());
        System.out.println("Average: " + dataManipulation.getAverage());
        System.out.println("Max increasing sequence: " + dataManipulation.getMaxIncreasingSequence());
        System.out.println("Max decreasing sequence: " + dataManipulation.getMaxDecreasingSequence());

        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;
        System.out.println("Time in milliseconds: " + timeElapsed);
    }
}