package com.practice.project.jsonParser;

import com.google.gson.Gson;
import com.practice.project.model.Item;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {
    public static Item[] getItem() {
        Gson gson = new Gson();
        Item[] questions = null;
        try {
            questions = gson.fromJson(new FileReader("src/main/resources/questions.json"), Item[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  questions;
    }
}
