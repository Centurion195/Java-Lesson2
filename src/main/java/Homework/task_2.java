package Homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class task_2 {
    private static Logger log = Logger.getLogger(task_2.class.getName());
    public static void start() throws IOException {
        log.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("log.txt");
        log.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        log.log(Level.INFO, "Запуск программы");
        int size = 10;
        int min = 0;
        int max = 100;
        int[] array = CreateArray(size, min, max);
        System.out.println(Arrays.toString(array));
        SortArray(array);
        System.out.println(Arrays.toString(array));
    }
    public static int[] CreateArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max);
        }
        log.log(Level.INFO, "Создан массив: " + Arrays.toString(array));
        return array;
    }
    public static void SortArray(int[] array) {
        log.log(Level.INFO, "Начало сортировки");
        int len = array.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            log.log(Level.INFO, "Итерация №" + i + ": " + Arrays.toString(array));
        }
        log.log(Level.INFO, "Конец сортировки");
    }
}
