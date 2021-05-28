package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //инициализируем все кнопки
        Button btn0 = findViewById(R.id.numKey0);
        Button btn1 = findViewById(R.id.numKey1);
        Button btn2 = findViewById(R.id.numKey2);
        Button btn3 = findViewById(R.id.numKey3);
        Button btn4 = findViewById(R.id.numKey4);
        Button btn5 = findViewById(R.id.numKey5);
        Button btn6 = findViewById(R.id.numKey6);
        Button btn7 = findViewById(R.id.numKey7);
        Button btn8 = findViewById(R.id.numKey8);
        Button btn9 = findViewById(R.id.numKey9);
        Button btnPoint = findViewById(R.id.numKeyPoint);
        Button btnActionKeyAddition = findViewById(R.id.actionKeyAddition);                         // клавиша операции сложения
        Button btnActionKeySubtraction = findViewById(R.id.actionKeySubtraction);                   // клавиша операции вычитания
        Button btnActionKeyMultiplication = findViewById(R.id.actionKeyMultiplication);             // клавиша операции умножения
        Button btnActionKeyDivision = findViewById(R.id.actionKeyDivision);                         // клавиша операции деления
        Button btnActionKeySquaring = findViewById(R.id.actionKeySquaring);                         // клавиша операции возведения в квадрат
        Button btnActionKeySquareRootExtraction = findViewById(R.id.actionKeySquareRootExtraction); // клавиша операции извлечения квадратного корня
        Button btnActionKeyReverse = findViewById(R.id.actionKeyReverse);                           // клавиша обратной функции
        Button btnActionKeyPercent = findViewById(R.id.actionKeyPercent);                           // клавиша операции процента
        Button btnActionKeyNegative = findViewById(R.id.actionKeyNegative);                         // клавиша операции смены знака аргумента
        Button btnActionKeyReset = findViewById(R.id.actionKeyReset);                               // клавиша операции сброса
        Button btnActionKeyBackspace = findViewById(R.id.actionKeyBackspace);                       // клавиша операции затирания последнего символа
        Button btnActionKeyResult = findViewById(R.id.actionKeyResult);                             // клавиша операции получения результата
        Button btnActionKeyMemoryRead = findViewById(R.id.actionKeyMemoryRead);                     // клавиша операции чтения значения в память
        Button btnActionKeyMemoryPlus = findViewById(R.id.actionKeyMemoryPlus);                     // клавиша операции прибавления значения к значению хранящемуся в памяти
        Button btnActionKeyMemoryMinus = findViewById(R.id.actionKeyMemoryMinus);                   // клавиша операции вычитания значения из значения хранящегося в памяти
        Button btnActionKeyMemoryClear = findViewById(R.id.actionKeyMemoryClear);                   // клавиша операции очистки (сброса) значения регистра памяти
        // объявляем разные лисенеры
        View.OnClickListener setNum = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Добавляю цифру в число", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener setAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Записываю арифметическое действие в строку", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener getResult = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "даю команду на вычисление результата арифметического выражения", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener backspace = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Стираю поседний введенный символ", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener clean = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Выполняю общий сброс в 0", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener getMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Даю команду получить значение из регистра памяти и записать его в строку", Toast.LENGTH_SHORT).show();
            }
        };


        View.OnClickListener setAdditionMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Даю команду прибавить текущее значение результата к значению в регистре памяти", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener setSubtractionMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Даю команду вычесть текущее значение результата из значения в регистре памяти", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener setCleanMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Даю команду очистить значение регистра памяти (прировнять к 0)", Toast.LENGTH_SHORT).show();
            }
        };

        // навешиваем на каждую кнопочку своего группового или уникального слушателя
        btn0.setOnClickListener(setNum);
        btn1.setOnClickListener(setNum);
        btn2.setOnClickListener(setNum);
        btn3.setOnClickListener(setNum);
        btn4.setOnClickListener(setNum);
        btn5.setOnClickListener(setNum);
        btn6.setOnClickListener(setNum);
        btn7.setOnClickListener(setNum);
        btn8.setOnClickListener(setNum);
        btn9.setOnClickListener(setNum);
        btnPoint.setOnClickListener(setNum);
        btnActionKeyAddition.setOnClickListener(setAction);
        btnActionKeySubtraction.setOnClickListener(setAction);
        btnActionKeyMultiplication.setOnClickListener(setAction);
        btnActionKeyDivision.setOnClickListener(setAction);
        btnActionKeySquaring.setOnClickListener(setAction);
        btnActionKeySquareRootExtraction.setOnClickListener(setAction);
        btnActionKeyReverse.setOnClickListener(setAction);
        btnActionKeyPercent.setOnClickListener(setAction);
        btnActionKeyNegative.setOnClickListener(setAction);
        btnActionKeyReset.setOnClickListener(clean);
        btnActionKeyBackspace.setOnClickListener(backspace);
        btnActionKeyResult.setOnClickListener(getResult);
        btnActionKeyMemoryRead.setOnClickListener(getMemoryValue);
        btnActionKeyMemoryPlus.setOnClickListener(setAdditionMemoryValue);
        btnActionKeyMemoryMinus.setOnClickListener(setSubtractionMemoryValue);
        btnActionKeyMemoryClear.setOnClickListener(setCleanMemoryValue);
    }
}