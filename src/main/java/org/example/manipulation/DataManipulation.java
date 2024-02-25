package org.example.manipulation;

import java.util.List;

public interface DataManipulation {

    Integer getMax();
    Integer getMin();
    Integer getMiddle();
    Integer getAverage();

    List<Integer> getMaxIncreasingSequence();
    List<Integer> getMaxDecreasingSequence();
}
