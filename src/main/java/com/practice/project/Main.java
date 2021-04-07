package com.practice.project;

import com.google.gson.Gson;
import com.practice.project.dao.ItemDao;
import com.practice.project.model.Item;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ItemDao id = new ItemDao();

        Item[] questions = gson.fromJson(new FileReader("src/main/resources/questions.json"), Item[].class);

        System.out.println(Arrays.toString(questions));

    }

//    public static Item show(Item[] items, int id) {
//        return Arrays.stream(items).filter(i -> i.getNumber() == id).findAny().orElse(null);
//    }
}
