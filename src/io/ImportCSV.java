package io;

import bookHandling.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class ImportCSV {

    public static void readFile(String path, List<Book> books) {
        String line = "";

        try {
            // reading the csv file
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();

            while((line = br.readLine()) != null) {

                // regex
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // if the boxes is not equal to 23 skip
                if (values.length != 23) {
                    continue;
                }
                // parsing through csv file
                for (int i = 0; i < values.length; i++){
                    // saving to add to array
                    values[i] = values[i].replaceAll("\"","");
                    //System.out.println(i + ": " + values[i]);
                }
                // add book to list
                books.add(new Book(values));
            }
            // error handling
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
