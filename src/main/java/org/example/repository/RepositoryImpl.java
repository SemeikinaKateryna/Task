package org.example.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RepositoryImpl implements Repository{
    @Override
    public List<Integer> read() {
        try(BufferedReader br = new BufferedReader(new FileReader(INTEGERS)))
        {
            String s;
            while((s=br.readLine())!=null){
                integers.add(Integer.valueOf(s));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return integers;
    }
}
