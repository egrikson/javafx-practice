package com.example.javafxpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    @FXML
    private void initialize() {
        taskDescriptionArea.setEditable(false);
        resultArea.setEditable(false);
    }

    // ===== КНОПКИ ЗАДАНИЙ =====

    @FXML
    private void onTask1() {
        currentTask = 1;
        taskDescriptionArea.setText("Описание задания 1...");
    }

    @FXML
    private void onTask2() {
        currentTask = 2;
        taskDescriptionArea.setText("Описание задания 2...");
    }

    @FXML
    private void onTask3() {
        currentTask = 3;
        taskDescriptionArea.setText("Описание задания 3...");
    }

    @FXML
    private void onTask4() {
        currentTask = 4;
        taskDescriptionArea.setText("Описание задания 4...");
    }

    @FXML
    private void onTask5() {
        currentTask = 5;
        taskDescriptionArea.setText("Описание задания 5...");
    }

    @FXML
    private void onTask6() {
        currentTask = 6;
        taskDescriptionArea.setText("Описание задания 6...");
    }

    // ===== ГЕНЕРАЦИЯ МАССИВОВ =====

    @FXML
    private void onGenerate1D() {
        inputArrayArea.setText("Тут будет генерация 1D массива...");
    }

    @FXML
    private void onGenerate2D() {
        inputArrayArea.setText("Тут будет генерация 2D массива...");
    }

    // ===== ВЫПОЛНЕНИЕ ЗАДАНИЯ =====

    @FXML
    private void onExecute() {
        resultArea.setText("Тут будет результат выполнения задания № " + currentTask);
    }
}
