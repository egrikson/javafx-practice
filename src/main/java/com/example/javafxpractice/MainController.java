package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class MainController {

    @FXML private Button task1Button;
    @FXML private Button task2Button;
    @FXML private Button task3Button;
    @FXML private Button task4Button;
    @FXML private Button task5Button;
    @FXML private Button task6Button;

    @FXML private TextField arraySizeField;
    @FXML private TextField minValueField;
    @FXML private TextField maxValueField;
    @FXML private Button generate1DButton;
    @FXML private Button generate2DButton;
    @FXML private TextArea inputArrayArea;

    @FXML private TextArea taskDescriptionArea;
    @FXML private TextArea resultArea;
    @FXML private Button executeButton;

    private int currentTask = 0;

    private int[] currentArray;
    private int[][] currentMatrix;

    @FXML
    private void initialize() {
        taskDescriptionArea.setEditable(false);
        resultArea.setEditable(false);
    }

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
                "23. Дан целочисленный одномерный массив размера N. Серия – это\n" +
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
                "23. Дан целочисленный одномерный массив размера N. Серия – это\n" +
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
                "23. Дан целочисленный двумерный массив размера N*N. Добавить столбец,\n" +
                "содержащий сумму по модулю между столбцами с первым\n" +
                "положительным и последним отрицательным элементом после каждого\n" +
                "столбца, в котором количество четных элементов больше 3.");
    }

    @FXML
    private void onTask6() {
        currentTask = 6;
        taskDescriptionArea.setText("23. Дан целочисленный двумерный массив размера N*N. Отсортировать\n" +
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
            currentMatrix = matrix;
        } catch (NumberFormatException e) {
            inputArrayArea.setText("Ошибка! Введите корректные числа");
        }
    }
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

    private void runTask2() {
        int firstNegIdx = -1;
        int arr[] = currentArray;

        if (arr == null || arr.length == 0) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        // находим первый отрицательный элемент
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                firstNegIdx = i;
                break;
            }
        }

        int maxSeriesStart = -1;
        int maxSeriesLen = 0;

        int i = 0;
        while(i < arr.length) {
            if (arr[i] % 2 == 0) {
                int count = 1;
                while (i + count < arr.length && arr[i + count] % 2 == 0) {
                    count++;
                }
                if (count >= 2 && count > maxSeriesLen) {
                    maxSeriesLen = count;
                    maxSeriesStart = i;
                }
                i += count;
            } else {
                i++;
            }
        }

        // ===== ПРОВЕРКИ =====
        if (firstNegIdx == -1) {
            resultArea.setText("В массиве нет отрицательных элементов");
            return;
        }

        if (maxSeriesStart == -1) {
            resultArea.setText("В массиве нет серий из четных элементов длиной >= 2");
            return;
        }

        int insertPos = firstNegIdx + 1;
        if (insertPos + maxSeriesLen > arr.length) {
            resultArea.setText(
                    "Первый отрицательный элемент: индекс = " + firstNegIdx + ", значение = " + arr[firstNegIdx] + "\n" +
                            "Серия с наибольшей длиной: позиция = " + maxSeriesStart + ", длина = " + maxSeriesLen + "\n\n" +
                            "Недостаточно места после первого отрицательного элемента для вставки серии"
            );
            return;
        }

        // ===== ВСТАВКА =====
        // Запоминаем серию до сдвига
        int[] series = new int[maxSeriesLen];
        for (int j = 0; j < maxSeriesLen; j++) {
            series[j] = arr[maxSeriesStart + j];
        }

        // Сдвигаем элементы вправо начиная с конца
        for (int j = arr.length - 1; j >= insertPos + maxSeriesLen; j--) {
            arr[j] = arr[j - maxSeriesLen];
        }

        // Копируем серию на нужное место
        for (int j = 0; j < maxSeriesLen; j++) {
            arr[insertPos + j] = series[j];
        }

        // ===== ВЫВОД =====
        StringBuilder sb = new StringBuilder();
        sb.append("Первый отрицательный элемент: индекс = ").append(firstNegIdx)
                .append(", значение = ").append(arr[firstNegIdx]).append("\n");
        sb.append("Серия с наибольшей длиной: позиция = ").append(maxSeriesStart)
                .append(", длина = ").append(maxSeriesLen).append("\n\n");
        sb.append("Массив после вставки:\n");
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
            if (j < arr.length - 1) sb.append(", ");
        }

        resultArea.setText(sb.toString());
    }

    private void runTask3() {
        int[] arr = currentArray;

        if (arr == null || arr.length < 2) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        int N = arr.length;
        int i = 0;

        while (i < N - 1) {

            if ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) ||
                    (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)) {

                int start = i;
                int len = 1;

                while (i < N - 1 &&
                        ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) ||
                                (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0))) {
                    len++;
                    i++;
                }

                if (len < 2) {
                    i++;
                    continue;
                }

                int insertPos = start + len;
                int value = arr[start];

                for (int j = N - 1; j > insertPos; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[insertPos] = value;

                i = insertPos + 1;

            } else {
                i++;
            }
        }

        resultArea.setText("Готово! Массив после обработки:\n" + Arrays.toString(arr));
    }

    private void runTask4() {
        int[] arr = currentArray;

        if (arr == null || arr.length < 2) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        int N = arr.length;

        int start = -1;
        int len = 0;

        int i = N - 1;

        while (i > 0) {

            if ((arr[i] > 0 && arr[i - 1] > 0) ||
                    (arr[i] < 0 && arr[i - 1] < 0)) {

                int end = i;
                len = 1;

                while (i > 0 &&
                        ((arr[i] > 0 && arr[i - 1] > 0) ||
                                (arr[i] < 0 && arr[i - 1] < 0))) {
                    len++;
                    i--;
                }

                start = i;
                break;
            }

            i--;
        }

        if (len < 2) {
            resultArea.setText("В массиве нет серий одинакового знака длиной ≥ 2");
            return;
        }

        for (int j = start; j < N - len; j++) {
            arr[j] = arr[j + len];
        }

        resultArea.setText(
                "Последняя серия удалена.\n" +
                        "Начало серии: " + start + "\n" +
                        "Длина серии: " + len + "\n\n" +
                        "Массив после удаления:\n" + Arrays.toString(arr)
        );
    }


    private void runTask5() {
        int[][] a = currentMatrix;
        if (a == null) {
            resultArea.setText("Сначала сгенерируйте матрицу");
            return;
        }

        int N = a.length;

        int firstPos = -1;
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                if (a[r][c] > 0) {
                    firstPos = c;
                    break;
                }
            }
            if (firstPos != -1) break;
        }

        int lastNeg = -1;
        for (int c = N - 1; c >= 0; c--) {
            for (int r = 0; r < N; r++) {
                if (a[r][c] < 0) {
                    lastNeg = c;
                    break;
                }
            }
            if (lastNeg != -1) break;
        }

        if (firstPos == -1 || lastNeg == -1) {
            resultArea.setText("Нет подходящих столбцов");
            return;
        }

        int s1 = 0, s2 = 0;
        for (int r = 0; r < N; r++) s1 += a[r][firstPos];
        for (int r = 0; r < N; r++) s2 += a[r][lastNeg];
        int val = Math.abs(s1 - s2);

        int c = 0;
        while (c < N) {
            int even = 0;
            for (int r = 0; r < N; r++) if (a[r][c] % 2 == 0) even++;

            if (even > 3) {
                int pos = c + 1;

                for (int col = N - 1; col > pos; col--) {
                    for (int row = 0; row < N; row++) {
                        a[row][col] = a[row][col - 1];
                    }
                }

                for (int row = 0; row < N; row++) a[row][pos] = val;

                c += 2;
            } else {
                c++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int col = 0; col < N; col++) sb.append(a[r][col]).append("\t");
            sb.append("\n");
        }

        resultArea.setText(sb.toString());
    }

    private void runTask6() {
        int[][] matrix = currentMatrix;

        if (matrix == null) {
            resultArea.setText("Сначала сгенерируйте матрицу");
            return;
        }

        int N = matrix.length;

        List<Integer> list = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r + c > N - 1) {
                    list.add(matrix[r][c]);
                }
            }
        }

        Collections.sort(list);

        int index = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r + c > N - 1) {
                    matrix[r][c] = list.get(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(matrix[r][c]).append("\t");
            }
            sb.append("\n");
        }

        resultArea.setText(sb.toString());
    }

    @FXML
    private void onExecute() {
        switch (currentTask) {
            case 1 -> runTask1();
            case 2 -> runTask2();
            case 3 -> runTask3();
            case 4 -> runTask4();
            case 5 -> runTask5();
            case 6 -> runTask6();
        }
    }
}
