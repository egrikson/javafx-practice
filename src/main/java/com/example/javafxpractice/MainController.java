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
    private int[][] currentMatrix;

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
            currentMatrix = matrix;
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

            // Проверяем, начинается ли серия
            if ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) ||
                    (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)) {

                int start = i;
                int len = 1;

                // Считаем длину серии
                while (i < N - 1 &&
                        ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) ||
                                (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0))) {
                    len++;
                    i++;
                }

                // Если серия меньше 2 — пропускаем
                if (len < 2) {
                    i++;
                    continue;
                }

                // Вставляем первый элемент серии в её конец
                int insertPos = start + len;
                int value = arr[start];

                // Сдвиг вправо
                for (int j = N - 1; j > insertPos; j--) {
                    arr[j] = arr[j - 1];
                }

                // Вставка
                arr[insertPos] = value;

                // Пропускаем вставленный элемент
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

        int start = -1;   // начало последней серии
        int len = 0;      // длина последней серии

        // ===== ПОИСК ПОСЛЕДНЕЙ СЕРИИ =====
        int i = N - 1;

        while (i > 0) {

            // Проверяем, одинаковый ли знак
            if ((arr[i] > 0 && arr[i - 1] > 0) ||
                    (arr[i] < 0 && arr[i - 1] < 0)) {

                int end = i;
                len = 1;

                // Считаем длину серии, двигаясь влево
                while (i > 0 &&
                        ((arr[i] > 0 && arr[i - 1] > 0) ||
                                (arr[i] < 0 && arr[i - 1] < 0))) {
                    len++;
                    i--;
                }

                start = i;   // i — индекс начала серии
                break;       // нашли последнюю серию
            }

            i--;
        }

        // ===== ЕСЛИ СЕРИИ НЕТ =====
        if (len < 2) {
            resultArea.setText("В массиве нет серий одинакового знака длиной ≥ 2");
            return;
        }

        // ===== УДАЛЕНИЕ СЕРИИ ЧЕРЕЗ СДВИГ =====
        for (int j = start; j < N - len; j++) {
            arr[j] = arr[j + len];
        }

        // Последние len элементов можно игнорировать (они «стерты» логически)

        resultArea.setText(
                "Последняя серия удалена.\n" +
                        "Начало серии: " + start + "\n" +
                        "Длина серии: " + len + "\n\n" +
                        "Массив после удаления:\n" + Arrays.toString(arr)
        );
    }


    private void runTask5() {
        int[][] matrix = currentMatrix;

        if (matrix == null) {
            resultArea.setText("Сначала сгенерируйте матрицу");
            return;
        }

        int N = matrix.length;

        // ===== 1. Ищем столбец с первым положительным элементом =====
        int firstPosCol = -1;

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                if (matrix[r][c] > 0) {
                    firstPosCol = c;
                    break;
                }
            }
            if (firstPosCol != -1) break;
        }

        // ===== 2. Ищем столбец с последним отрицательным элементом =====
        int lastNegCol = -1;

        for (int c = N - 1; c >= 0; c--) {
            for (int r = 0; r < N; r++) {
                if (matrix[r][c] < 0) {
                    lastNegCol = c;
                    break;
                }
            }
            if (lastNegCol != -1) break;
        }

        if (firstPosCol == -1 || lastNegCol == -1) {
            resultArea.setText("Нет положительных или отрицательных элементов — задача не выполняется");
            return;
        }

        // ===== 3. Считаем суммы столбцов =====
        int sumPos = 0, sumNeg = 0;

        for (int r = 0; r < N; r++) {
            sumPos += matrix[r][firstPosCol];
            sumNeg += matrix[r][lastNegCol];
        }

        int value = Math.abs(sumPos - sumNeg);

        // ===== 4. Проходим столбцы и вставляем новые =====
        int c = 0;
        while (c < N) {

            // считаем чётные
            int evenCount = 0;
            for (int r = 0; r < N; r++) {
                if (matrix[r][c] % 2 == 0) evenCount++;
            }

            if (evenCount > 3) {

                // ===== 5. Сдвиг вправо =====
                for (int col = N; col > c + 1; col--) {
                    for (int row = 0; row < N; row++) {
                        matrix[row][col] = matrix[row][col - 1];
                    }
                }

                // вставляем новый столбец
                for (int row = 0; row < N; row++) {
                    matrix[row][c + 1] = value;
                }

                N++;   // матрица стала шире
                c += 2; // пропускаем вставленный столбец

            } else {
                c++;
            }
        }

        // ===== 6. Вывод =====
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            for (int col = 0; col < matrix.length; col++) {
                sb.append(matrix[r][col]).append("\t");
            }
            sb.append("\n");
        }

        resultArea.setText(sb.toString());
    }

    private void runTask6() {

    }
    // ===== ВЫПОЛНЕНИЕ ЗАДАНИЯ =====

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
