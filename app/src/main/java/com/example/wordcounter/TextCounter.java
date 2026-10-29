package com.example.wordcounter;

public class TextCounter {
    int countWords(String text) {
        String[] words = text.split("[^\\p{L}]+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    int countChars(String text) {
        return text.length();
    }

    int countSent(String text) {
        String[] sentences = text.split("[.!?]+");
        int count = 0;

        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }

    int countNums(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }


}
