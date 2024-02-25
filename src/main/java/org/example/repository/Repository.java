package org.example.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
    File INTEGERS = new File("10m.txt");

    List<Integer> integers = new ArrayList<>();

    List<Integer> read();
}
