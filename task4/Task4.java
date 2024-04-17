package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputStrFile = "";
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            inputStrFile += (sc.nextLine() + ",");
        }
        StringTokenizer tokenizer1 = new StringTokenizer(inputStrFile, ",");
        int tokenCount1 = tokenizer1.countTokens();
        int[] nums = new int[tokenCount1];
        for (int i = 0; i < tokenCount1; i++) {
            nums[i] = Integer.parseInt(tokenizer1.nextToken());
        }
        int count = 0;
//        int[] nums = {1, 5, 8, 6, 2};
        sort(nums);
        int middle = nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            count += abs(nums[i]- middle);
        }
        System.out.println(count);
    }
}
