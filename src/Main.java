import java.util.Arrays;
import java.util.Scanner;

interface SortRequirement<T>{
    boolean Sort(T a, T b);
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        Integer[] arr = new Integer[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        sortArray(arr, (a, b) -> a > b);
        System.out.println("Отсортированный массив по возрастанию:");
        System.out.println(Arrays.toString(arr));

        sortArray(arr, (a, b) -> a < b);
        System.out.println("Отсортированный массив по убыванию:");
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void sortArray(T[] array, SortRequirement<T> requirement){
        for (int i = 1; i < array.length; i++){
            T currentEl = array[i];
            int j = i - 1;
            while ( j >= 0 && requirement.Sort(array[j], currentEl)){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentEl;
        }
    }
}