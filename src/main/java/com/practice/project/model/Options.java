package com.practice.project.model;

public class Options {
    private String text;
    private int value;
    private String status;
    private String message;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return "Options{" +
                "text='" + text + '\'' +
                ", value=" + value +
                '}';
    }
}
