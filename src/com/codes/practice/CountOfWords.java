package com.codes.practice;
import java.io.*;

public class CountOfWords {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Examples\\src\\com\\Interview\\dictionary.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        long wordCount = 0;
        long characterCount = 0;
        long paraCount = 0;
        long whiteSpaceCount = 0;
        long sentenceCount = 0;
        // https://www.jrebel.com/blog/java-regular-expressions-cheat-sheet
        // .	Any character
        // \d	A digit: [0-9]
        // \D	A non-digit: [\^0-9]
        // \s	A whitespace character: [ \t\n\x0B\f\r]
        // \S	A non-whitespace character: [\^\s]
        // \w	A word character: [a-zA-Z_0-9]
        // \W	A non-word character: [\^\w]
        // *	Matches zero or more occurrences.
        // +	Matches one or more occurrences.
        // ?	Matches zero or one occurrence.
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                paraCount += 1;
            } else {
                characterCount += line.length();
                String words[] = line.split("\\s+");    //whitespace characters
                wordCount += words.length;
                whiteSpaceCount += wordCount - 1;
                String sentence[] = line.split("[!?.:]+");
                sentenceCount += sentence.length;
            }
        }
        if (sentenceCount >= 1) {
            paraCount++;
        }
        System.out.println("Total word count = " + wordCount);
        System.out.println("Total number of sentences = " + sentenceCount);
        System.out.println("Total number of characters = " + characterCount);
        System.out.println("Number of paragraphs = " + paraCount);
        System.out.println("Total number of whitespaces = " + whiteSpaceCount);
    }
}
