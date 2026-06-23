package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Random;

public class MainController {

    // Левое меню
    @FXML private Button task1Button;
    @FXML private Button task2Button;
    @FXML private Button task3Button;
    @FXML private Button task4Button;
    @FXML private Button task5Button;
    @FXML private Button task6Button;

    // Ввод массива
    @FXML private TextField arraySizeField;
    @FXML private TextField minValueField;
    @FXML private TextField maxValueField;
    @FXML private Button generate1DButton;
    @FXML private Button generate2DButton;
    @FXML private TextArea inputArrayArea;

    // Результат
    @FXML private TextArea taskDescriptionArea;
    @FXML private TextArea resultArea;
    @FXML private Button executeButton;

    private int currentTask = 0;

    private int[] currentArray;

    @FXML
    private void initialize() {
        taskDescriptionArea.setEditable(false);
        resultArea.setEditable(false);
    }

    // ===== КНОПКИ ЗАДАНИЙ =====

    @FXML
    private void onTask1() {
        currentTask = 1;
        taskDescriptionArea.setText("23.Дан целочисленный одномерный массив размера N. Серия – это\n" +
                "последовательность элементов массива, идущих друг за другом.\n" +
                "Значения всех элементов серии одинаково. Серия должна содержать\n" +
                "минимум 2 элемента. Длина серии – количество элементов в серии.\n" +
                "Найти первую серию в массиве и последнюю серию в массиве. Вывести\n" +
                "с какой позиции начинается каждая серия и длины серий.\n");
    }

    @FXML
    private void onTask2() {
        currentTask = 2;
        taskDescriptionArea.setText("23: Дан целочисленный одномерный массив размера N. Серия – это\n" +
                "последовательность элементов массива, идущих друг за другом.\n" +
                "Значения всех элементов серии четные. Серия должна содержать\n" +
                "минимум 2 элемента. Длина серии – количество элементов в серии.\n" +
                "Перенести после первого отрицательного элемента серию с наибольшей\n" +
                "длиной (если достаточно места в массиве после первого\n" +
                "отрицательного).\n");
    }

    @FXML
    private void onTask3() {
        currentTask = 3;
        taskDescriptionArea.setText("Внимание! Делать с использованием операций сдвига, а не\n" +
                "перестройкой массива!\n" +
                "Дан целочисленный одномерный массив размера N. Серия – это\n" +
                "последовательность элементов массива, идущих друг за другом.\n" +
                "Значения элементов серии либо все четные, либо все нечетные. Серия\n" +
                "должна содержать минимум 2 элемента. Длина серии – количество\n" +
                "элементов в серии. Добавить в конец каждой его серии еще один элемент\n" +
                "(добавляется первый элемент в серии).\n");
    }

    @FXML
    private void onTask4() {
        currentTask = 4;
        taskDescriptionArea.setText("Внимание! Делать с использованием операций сдвига, а не\n" +
                "перестройкой массива!\n" +
                "Дан целочисленный одномерный массив размера N. Серия – это\n" +
                "последовательность элементов массива, идущих друг за другом. Знаки\n" +
                "значений всех элементов серии одинаковы (все положительные или все\n" +
                "отрицательные). Серия должна содержать минимум 2 элемента. Длина\n" +
                "серии – количество элементов в серии. Удалить из массива последнюю\n" +
                "серию.\n");
    }

    @FXML
    private void onTask5() {
        currentTask = 5;
        taskDescriptionArea.setText("Внимание! Делать с использованием операций сдвига, а не\n" +
                "перестройкой массива!\n" +
                "Дан целочисленный двумерный массив размера N*N. Добавить столбец,\n" +
                "содержащий сумму по модулю между столбцами с первым\n" +
                "положительным и последним отрицательным элементом после каждого\n" +
                "столбца, в котором количество четных элементов больше 3.");
    }

    @FXML
    private void onTask6() {
        currentTask = 6;
        taskDescriptionArea.setText(".Дан целочисленный двумерный массив размера N*N. Отсортировать\n" +
                "матрицу по возрастанию ниже побочной диагонали. Направление: слева\n" +
                "направо, сверху вниз.\n" +
                "Пример:\n" +
                "1 6 3\n" +
                "4 7 9\n" +
                "0 3 6\n" +
                "после сортировки:\n" +
                "1 6 3\n" +
                "4 7 3\n" +
                "0 6 9\n");
    }

    // ===== ГЕНЕРАЦИЯ МАССИВОВ =====

    @FXML
    private void onGenerate1D() {
        try {
            int size = Integer.parseInt(arraySizeField.getText());
            int min = Integer.parseInt(minValueField.getText());
            int max = Integer.parseInt(maxValueField.getText());

            if (size <= 0) {
                inputArrayArea.setText("Ошибка! Размер должен быть больше нуля");
            }

            if (min > max) {
                inputArrayArea.setText("Ошибка! Минимальный элемент не может быть больше максимального");
            }

            int[] arr = new int[size];
            Random r = new Random();

            for (int i = 0; i < size; i++) {
                arr[i] = r.nextInt(max - min + 1) + min;
            }

            inputArrayArea.setText(Arrays.toString(arr));
            currentArray = arr;
        } catch (NumberFormatException e) {
            inputArrayArea.setText("Ошибка! Ведите корректные числа");
        }
    }

    @FXML
    private void onGenerate2D() {
        try {
            int size = Integer.parseInt(arraySizeField.getText());
            int min = Integer.parseInt(minValueField.getText());
            int max = Integer.parseInt(maxValueField.getText());

            if (size <= 0) {
                inputArrayArea.setText("Ошибка! Размер должен быть больше нуля");
            }

            if (min > max) {
                inputArrayArea.setText("Ошибка! Минимальный элемент не может быть больше максимального");
            }

            int[][] matrix = new int[size][size];
            Random r = new Random();

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = r.nextInt(max - min + 1) + min;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    sb.append(matrix[j][k]).append("\t");
                }
                sb.append("\n");
            }

            inputArrayArea.setText(sb.toString());

        } catch (NumberFormatException e) {
            inputArrayArea.setText("Ошибка! Введите корректные числа");
        }
    }
    // ===== Логика заданий =====
    private void runTask1() {
        int[] arr = currentArray;

        if (arr == null || arr.length == 0) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        int firstStart = -1;
        int firstLength = 0;

        int lastStart = -1;
        int lastLength = 0;

        // ===== ПОИСК ПЕРВОЙ СЕРИИ =====
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;

            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            if (count >= 2) {
                firstStart = i - count + 1;
                firstLength = count;
                break;
            }
        }

        // ===== ПОИСК ПОСЛЕДНЕЙ СЕРИИ =====
        for (int i = arr.length - 1; i > 0; i--) {
            int count = 1;

            while (i > 0 && arr[i] == arr[i - 1]) {
                count++;
                i--;
            }

            if (count >= 2) {
                lastStart = i;
                lastLength = count;
                break;
            }
        }

        // ===== ВЫВОД =====
        if (firstStart == -1) {
            resultArea.setText("В массиве нет ни одной серии (подряд идущих одинаковых элементов)");
            return;
        }

        resultArea.setText(
                "Первая серия:\n" +
                        "  позиция = " + firstStart + "\n" +
                        "  длина = " + firstLength + "\n\n" +
                        "Последняя серия:\n" +
                        "  позиция = " + lastStart + "\n" +
                        "  длина = " + lastLength
        );
    }

    // ===== ВЫПОЛНЕНИЕ ЗАДАНИЯ =====

    @FXML
    private void onExecute() {
        switch (currentTask) {
            case 1 -> runTask1();
        }
    }
}
