package com.practice.project.dao;

import com.practice.project.jsonParser.Parser;
import com.practice.project.model.Item;
import com.practice.project.model.Options;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemDao {
    private final Item[] items = Parser.getItem();
    private static int count = 0;
    private static int result = 0;
    private List<String> answers = new ArrayList<>();

    public ItemDao() {}

    public void saveIntoFile(Item item) { // сохранение информации об ответе
        try {
            scoring(item); // подсчет кол-ва баллов

            File file = new File("src\\main\\resources\\data.txt");
            FileWriter fw = new FileWriter(file, true);

            answers.add(item.getAnswer());

            count++;

            fw.write( count + ". " + item.getAnswer() + " Number question: " + item + "\n");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Item show(int number) { // представляет элемент по id
        return Arrays.stream(items).filter(i -> i.getNumber() == number).findAny().orElse(null);
    }

    public void scoring(Item item) { // счетчик кол-ва баллов
        for (Options option : item.getOptions()) {
            if (item.getAnswer().equals(option.getText()))
                result += option.getValue();
        }
    }

    public int getItemsLength() {
        return items.length;
    }

    public Item[] getItems() {
        return items;
    }

    public int getResult() {
        return result;
    }

    public static void setResult(int result) {
        ItemDao.result = result;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public StringBuilder getRecommendations(Item item) { // метод сохранения рекомендаций
        StringBuilder resultAnswers = new StringBuilder();

        return resultAnswers;
    }
}
