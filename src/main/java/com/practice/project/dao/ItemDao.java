package com.practice.project.dao;

import com.practice.project.jsonParser.Parser;
import com.practice.project.model.Item;
import com.practice.project.model.Options;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemDao {
    private final Item[] items = Parser.getItem();
    private static int count;
    private static int result;
    private List<Item> itemList = new ArrayList<>();
    private StringBuilder recommendations = new StringBuilder();
    private StringBuilder requirements = new StringBuilder();

    public ItemDao() {}

    public void saveIntoFile(Item item) { // сохранение информации об ответе
        itemList.add(item);

        try {
            File file = new File("src\\main\\resources\\data.txt");
            FileWriter fw = new FileWriter(file, true);
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

    public StringBuilder getRecommendations() {
        return recommendations;
    }

    public StringBuilder getRequirements() {
        return requirements;
    }

    public void analyze() { // метод сохранения рекомендаций
        for (Item item : itemList) {
            if (item.getAnswer().equals("requirement")) {
                for (Options option : item.getOptions()) {
                    if (option.getStatus().equals("recommended"))
                        recommendations.append(option.getMessage()).append("\n");
                }
            }

            if (item.getAnswer().equals("inconsistency")) {
                for (Options option : item.getOptions()) {
                    if (option.getStatus().equals("recommended"))
                        recommendations.append(option.getMessage()).append("\n");
                    else if (option.getStatus().equals("requirement"))
                        requirements.append(option.getMessage()).append("\n");
                }
            }

            for (Options option : item.getOptions()) {
                if (item.getAnswer().equals(option.getStatus()))
                    result += option.getValue();
            }
        }
    }
}
