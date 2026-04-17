import java.util.Arrays;

public class ArraySortSumAvg {
    public static void main(String[] args) {
        int[] my_array1 = {1789, 2035, 1899, 1456, 2013};

        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));

        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }

        double avg = (double) sum / my_array1.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}