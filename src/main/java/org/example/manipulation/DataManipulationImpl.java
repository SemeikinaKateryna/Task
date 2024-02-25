package org.example.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.example.sorting.QuickSort.quickSort;

public class DataManipulationImpl implements DataManipulation{

    private final List<Integer> normalIntegers;

    private final List<Integer> sortedIntegers;

    public DataManipulationImpl(List<Integer> integers) {
        this.normalIntegers = new ArrayList<>(integers);
        Integer[] array = normalIntegers.toArray(new Integer[0]);
        quickSort(array, 0, integers.size() - 1);
        this.sortedIntegers = Arrays.stream(array).toList();
    }

    @Override
    public Integer getMax() {
        return sortedIntegers.getLast();

    }

    @Override
    public Integer getMin() {
        return sortedIntegers.getFirst();
    }

    @Override
    public Integer getMiddle() {
        Integer middle = null;
        int halfIndex = sortedIntegers.size() / 2;
        if(sortedIntegers.size() % 2 == 1){
           middle = sortedIntegers.get( (int) Math.ceil((double) halfIndex));
        }else{
            middle = (sortedIntegers.get(halfIndex - 1) + sortedIntegers.get(halfIndex + 1)) / 2;
        }
        return middle;
    }

    @Override
    public Integer getAverage() {
        Integer average = null;

        int sum = 0;
        for(Integer i: sortedIntegers){
            sum += i;
        }
        average = sum/sortedIntegers.size();
        return average;
    }

    @Override
    public List<Integer> getMaxIncreasingSequence() {
        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> maxSequence = new ArrayList<>();

        int currentSize = 0;
        int maxSize = 0;

        Iterator<Integer> i = normalIntegers.iterator();
        Integer candidate = i.next();

        while (i.hasNext()) {
            Integer next = i.next();
            if (next > candidate){
                if(!currentSequence.contains(candidate)) {
                    currentSequence.add(candidate);
                }
                currentSequence.add(next);
                currentSize = currentSequence.size();
            }else{
                if(currentSize > maxSize){
                maxSequence = new ArrayList<>(currentSequence);
                maxSize = currentSequence.size();
                }
                currentSequence.clear();
                currentSize = 0;
            }
                candidate = next;
        }

       return maxSequence;

    }

    @Override
    public List<Integer> getMaxDecreasingSequence() {
        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> maxSequence = new ArrayList<>();

        int currentSize = 0;
        int maxSize = 0;

        Iterator<Integer> i = normalIntegers.iterator();
        Integer candidate = i.next();

        while (i.hasNext()) {
            Integer next = i.next();
            if (next < candidate){
                if(!currentSequence.contains(candidate)) {
                    currentSequence.add(candidate);
                }
                currentSequence.add(next);
                currentSize = currentSequence.size();
            }else{
                if(currentSize > maxSize){
                    maxSequence = new ArrayList<>(currentSequence);
                    maxSize = currentSequence.size();
                }
                currentSequence.clear();
                currentSize = 0;
            }
            candidate = next;
        }

        return maxSequence;
    }
}
