package com.company;

public class Main {

    public static void main(String[] args) {
        LineEditor text = new LineEditor();
        System.out.println(text);
        text.setText("\0");
     //   text.insertString("er gøy!");
        System.out.println(text);
        text.setInsertionIndex(3);
        System.out.println(text);
        text.deleteRight();
        System.out.println(text);
        text.deleteRight();
        System.out.println(text);

    }
}
