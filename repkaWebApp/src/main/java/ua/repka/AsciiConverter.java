package ua.repka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AsciiConverter {

    private String fileName;

    public AsciiConverter(String fileName) {
        this.fileName = fileName;
    }

    List<String> convertWord(String inputWord) {
        List<String> listOfSigns = new ArrayList<>();
        List<String> listToOut = new ArrayList<>();
        Scanner scanner = new Scanner(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)));
        int L = Integer.parseInt(scanner.nextLine());
        int H = Integer.parseInt(scanner.nextLine());

        while (scanner.hasNextLine()) {
            String ROW = scanner.nextLine();
            listOfSigns.add(ROW);
        }
        scanner.close();
        List<Integer> textNumValues = new ArrayList<>();
        for (int i = 0; i < (inputWord.length()); i++) {
            char let = inputWord.charAt(i);
            int numb = Character.getNumericValue(let);
            if ((numb > 9) && (numb < 36)) textNumValues.add(numb - 10);
            else textNumValues.add(26);
        }
        for (int j = 0; j < textNumValues.size(); j++) {
            for (int i = 0; i < H; i++) {
                String line = listOfSigns.get(i);
                int charNum = textNumValues.get(j) * L;
                if (j == 0) {
                    listToOut.add(i, line.substring(charNum, charNum + L));
                } else {
                    String newLine = listToOut.get(i) + line.substring(charNum, charNum + L);
                    listToOut.set(i, newLine);
                }
            }
        }
        return listToOut;
    }
}

