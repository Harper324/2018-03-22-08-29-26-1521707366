package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List tripleList = new ArrayList();
        for (Integer ele : array) {
            tripleList.add(ele * 3);
        }
        return tripleList;
    }

    public List<String> mapLetter() {
        List<String> letterList = new ArrayList<>();
        for (Integer ele : array) {
            letterList.add(Character.toString((char) (ele + 96)));
        }
        return letterList;
    }

    public List<String> mapLetters() {
        List<String> letterList = new ArrayList<>();
        int firstNumber = 0;
        int secondNumber = 0;
        for (Integer ele : array) {
            if (ele < 26) {
                letterList.add(Character.toString((char) (ele + 96)));
            } else {
                firstNumber = (ele - 1) / 26;
                secondNumber = (ele - 1) % 26;
                letterList.add(Character.toString((char) (firstNumber + 96)) + Character.toString((char) (secondNumber + 97)));
            }
        }
        return letterList;
    }

    public List<Integer> sortFromBig() {
        Collections.sort(array, Collections.reverseOrder());
        return array;
    }

    public List<Integer> sortFromSmall() {
        Collections.sort(array);
        return array;
    }
}
