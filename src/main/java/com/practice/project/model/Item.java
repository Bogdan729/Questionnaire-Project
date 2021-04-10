package com.practice.project.model;

import java.util.List;

public class Item {
    private int number;
    private List<Options> options;
    private String question;
    private String answer;
    private int scope;

    public int getScope() { return scope; }
    public void setScope(int scope) { this.scope = scope; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public List<Options> getOptions() {
        return options;
    }
    public void setOptions(List<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Item{" +
                "number=" + number +
                ", options=" + options +
                '}';
    }
}