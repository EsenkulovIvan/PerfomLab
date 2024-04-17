package task1;

public class Task1 {

    public static void main(String[] args) {
//        String[] arg = {"4", "3"};
        System.out.println(args[0]);
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        for (int i = 0, count = 0; i < n; i++) {
            System.out.print(array[count]);
            count = (count + m - 1) % n;
            if (count == 0) {
                break;
            }
        }
    }
}