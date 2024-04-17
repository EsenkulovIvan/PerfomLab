package task2;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task2 {
    public static void main(String[] args) throws Exception {
        String[] inputStrFile = {"", ""};
        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                inputStrFile[i] += (sc.nextLine() + ",");
            }
        }
        StringTokenizer tokenizer1 = new StringTokenizer(inputStrFile[0], ",");
        int tokenCount1 = tokenizer1.countTokens();
        String[] stringArray1 = new String[tokenCount1];
        for (int i = 0; i < tokenCount1; i++) {
            stringArray1[i] = tokenizer1.nextToken();
        }
        StringTokenizer tokenizer2 = new StringTokenizer(inputStrFile[1], ",");
        int tokenCount2 = tokenizer2.countTokens();
        String[] stringArray2 = new String[tokenCount2];
        for (int i = 0; i < tokenCount2; i++) {
            stringArray2[i] = tokenizer2.nextToken();
        }
        String[] centerPoint = stringArray1[0].split(" ");
        int radius = Integer.parseInt(stringArray1[1]);
        double xCenterPoint = Double.parseDouble(centerPoint[0]);
        double yCenterPoint = Double.parseDouble(centerPoint[1]);
        for (String s : stringArray2) {
            String[] str = s.split(" ");
            double xPoint = Double.parseDouble(str[0]);
            double yPoint = Double.parseDouble(str[1]);

            double x = xPoint - xCenterPoint;
            double y = yPoint - yCenterPoint;

            double result = x * x + y * y;

            if (result > (radius * radius)) {
                System.out.println("2");
            } else if (result < (radius * radius)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
