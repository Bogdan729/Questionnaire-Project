package com.practice.project;

import com.google.gson.Gson;
import com.practice.project.model.Item;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Item[] questions = gson.fromJson(new FileReader("src/main/resources/questions.json"), Item[].class);

        System.out.println(questions[0].getOptions().get(1).getStatus());
    }
}
