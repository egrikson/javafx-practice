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
        int[] arr = currentArray;
        if (arr == null || arr.length == 0) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        int N = arr.length;

        // === 1. Найти первый отрицательный элемент ===
        int firstNeg = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                firstNeg = i;
                break;
            }
        }
        if (firstNeg == -1) {
            resultArea.setText("В массиве нет отрицательных элементов");
            return;
        }

        // === 2. Найти самую длинную серию чётных элементов ===
        int bestStart = -1, bestLen = 0;

        int i = 0;
        while (i < N) {
            if (arr[i] % 2 == 0) {
                int len = 1;
                while (i + len < N && arr[i + len] % 2 == 0) len++;

                if (len >= 2 && len > bestLen) {
                    bestLen = len;
                    bestStart = i;
                }

                i += len;
            } else {
                i++;
            }
        }

        if (bestStart == -1) {
            resultArea.setText("Нет серий из чётных элементов длиной ≥ 2");
            return;
        }

        // === 3. Проверить, хватает ли места после первого отрицательного ===
        // Нужно: firstNeg + 1 + bestLen <= N
        if (firstNeg + 1 + bestLen > N) {
            resultArea.setText("Недостаточно места после первого отрицательного элемента");
            return;
        }

        // === 4. Сохранить серию во временный буфер ===
        int[] temp = new int[bestLen];
        for (int k = 0; k < bestLen; k++) {
            temp[k] = arr[bestStart + k];
        }

        // === 5. Удалить серию со старого места (сдвиг влево) ===
        for (int j = bestStart; j < N - bestLen; j++) {
            arr[j] = arr[j + bestLen];
        }

        // === 6. Вставить серию после первого отрицательного (сдвиг вправо) ===
        // Сдвигаем вправо участок [firstNeg+1 .. N-bestLen-1]
        for (int j = N - bestLen - 1; j >= firstNeg + 1; j--) {
            arr[j + bestLen] = arr[j];
        }

        // === 7. Вставляем сохранённую серию ===
        for (int k = 0; k < bestLen; k++) {
            arr[firstNeg + 1 + k] = temp[k];
        }

        resultArea.setText(Arrays.toString(arr));
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

            // Проверяем начало серии
            if ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) ||
                    (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)) {

                int start = i;
                int len = 1;

                // Находим длину серии
                while (i + len < N &&
                        ((arr[i + len] % 2 == 0 && arr[i + len - 1] % 2 == 0) ||
                                (arr[i + len] % 2 != 0 && arr[i + len - 1] % 2 != 0))) {
                    len++;
                }

                if (len >= 2) {
                    // Нужно вставить arr[start] в позицию start + len
                    // Но сначала — сдвиг вправо

                    // Увеличиваем массив на 1 (это допустимо, т.к. сам сдвиг делаем вручную)
                    arr = Arrays.copyOf(arr, N + 1);

                    // Сдвигаем вправо хвост
                    for (int j = N; j > start + len; j--) {
                        arr[j] = arr[j - 1];
                    }

                    // Вставляем первый элемент серии
                    arr[start + len] = arr[start];

                    // Обновляем длину массива
                    N++;

                    // Перескакиваем через вставленную серию
                    i = start + len + 1;
                } else {
                    i++;
                }

            } else {
                i++;
            }
        }

        currentArray = arr;
        resultArea.setText(Arrays.toString(arr));
    }

    private void runTask4() {
        int[] arr = currentArray;
        if (arr == null || arr.length < 2) {
            resultArea.setText("Сначала сгенерируйте массив");
            return;
        }

        int N = arr.length;
        int start = -1, len = 0;

        int i = N - 1;
        while (i > 0) {
            int a = arr[i], b = arr[i - 1];

            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                int count = 1;

                while (i > 0) {
                    int x = arr[i], y = arr[i - 1];
                    if ((x > 0 && y > 0) || (x < 0 && y < 0)) {
                        count++;
                        i--;
                    } else break;
                }

                start = i;
                len = count;
                break;
            }

            i--;
        }

        if (len < 2) {
            resultArea.setText("Нет серий одинакового знака длиной ≥ 2");
            return;
        }

        for (int j = start; j < N - len; j++) {
            arr[j] = arr[j + len];
        }

        int[] trimmed = Arrays.copyOf(arr, N - len);
        currentArray = trimmed;

        resultArea.setText(Arrays.toString(trimmed));
    }


    private void runTask5() {
        int[][] a = currentMatrix;
        if (a == null) {
            resultArea.setText("Сначала сгенерируйте матрицу");
            return;
        }

        int N = a.length;

        // === 1. Найти первый столбец с положительным элементом ===
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

        // === 2. Найти последний столбец с отрицательным элементом ===
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

        // === 3. Считаем сумму столбцов ===
        int s1 = 0, s2 = 0;
        for (int r = 0; r < N; r++) s1 += a[r][firstPos];
        for (int r = 0; r < N; r++) s2 += a[r][lastNeg];
        int val = Math.abs(s1 - s2);

        int cols = N; // текущее количество столбцов

        // === 4. Проходим по столбцам и вставляем новые ===
        int c = 0;
        while (c < cols) {

            // считаем количество чётных в столбце
            int even = 0;
            for (int r = 0; r < N; r++) {
                if (a[r][c] % 2 == 0) even++;
            }

            if (even > 3) {

                // === 4.1 Расширяем каждую строку на 1 столбец ===
                for (int r = 0; r < N; r++) {
                    a[r] = Arrays.copyOf(a[r], cols + 1);
                }

                // === 4.2 Сдвигаем вправо столбцы справа от c ===
                for (int r = 0; r < N; r++) {
                    for (int j = cols; j > c + 1; j--) {
                        a[r][j] = a[r][j - 1];
                    }
                }

                // === 4.3 Вставляем новый столбец ===
                for (int r = 0; r < N; r++) {
                    a[r][c + 1] = val;
                }

                cols++;   // увеличилось количество столбцов
                c += 2;   // пропускаем вставленный столбец
            } else {
                c++;
            }
        }

        currentMatrix = a;

        // === вывод ===
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int j = 0; j < cols; j++) {
                sb.append(a[r][j]).append("\t");
            }
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
