package ru.geekbrains.acquaintancewithandroid.hw.simplecalculatorstd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mainDisplay;
    private TextView topCalcDisplay;
    private BinaryActions currentBinaryAction;
    private UnaryActions currentUnaryAction;
    private Double currentValue = 0.0;
    private Double memoryValue = 0.0;
    private Double editableValue = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDisplay = findViewById(R.id.mainDisplay);
        topCalcDisplay = findViewById(R.id.topCalcDisplay);

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
                switch (v.getId()) {
                    case R.id.numKey0:
                        addSymbolNum('0');
                        break;
                    case R.id.numKey1:
                        addSymbolNum('1');
                        break;
                    case R.id.numKey2:
                        addSymbolNum('2');
                        break;
                    case R.id.numKey3:
                        addSymbolNum('3');
                        break;
                    case R.id.numKey4:
                        addSymbolNum('4');
                        break;
                    case R.id.numKey5:
                        addSymbolNum('5');
                        break;
                    case R.id.numKey6:
                        addSymbolNum('6');
                        break;
                    case R.id.numKey7:
                        addSymbolNum('7');
                        break;
                    case R.id.numKey8:
                        addSymbolNum('8');
                        break;
                    case R.id.numKey9:
                        addSymbolNum('9');
                        break;
                    case R.id.numKeyPoint:
                        addSymbolNum('.');
                        break;
                }
            }
        };

        View.OnClickListener setBinaryAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.actionKeyAddition:
                        currentBinaryAction = BinaryActions.ADD;
                        preparingArithmeticOperation();
                        break;
                    case R.id.actionKeySubtraction:
                        currentBinaryAction = BinaryActions.SUB;
                        preparingArithmeticOperation();
                        break;
                    case R.id.actionKeyMultiplication:
                        currentBinaryAction = BinaryActions.MUL;
                        preparingArithmeticOperation();
                        break;
                    case R.id.actionKeyDivision:
                        currentBinaryAction = BinaryActions.DIV;
                        preparingArithmeticOperation();
                        break;
                }
            }
        };

        View.OnClickListener setUnaryAction = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.actionKeyNegative:
                        if (mainDisplay.getText().equals("0")) {
                            // ничего пока не делаю
                        } else {
                            mainDisplay.setText("" + (Double.parseDouble(mainDisplay.getText().toString()) * (-1)));
                        }
                        break;
                    case R.id.actionKeySquaring:
                        if (mainDisplay.getText().equals("0")) {
                            // ничего пока не делаю
                        } else {
                            topCalcDisplay.setText(String.format("%s%s%s", currentUnaryAction.SQR.getPref(), mainDisplay.getText(), currentUnaryAction.SQR.getSuff()));
                            mainDisplay.setText(String.format("%s", Math.pow(Double.parseDouble(mainDisplay.getText().toString()), 2.0)));
                        }
                        break;
                    case R.id.actionKeySquareRootExtraction:
                        topCalcDisplay.setText(String.format("%s%s%s", currentUnaryAction.SRE.getPref(), mainDisplay.getText(), currentUnaryAction.SRE.getSuff()));
                        mainDisplay.setText(String.format("%s", Math.sqrt(Double.parseDouble(mainDisplay.getText().toString()))));
                        break;
                    case R.id.actionKeyReverse:
                        topCalcDisplay.setText(String.format("%s%s%s", currentUnaryAction.REV.getPref(), mainDisplay.getText(), currentUnaryAction.REV.getSuff()));
                        mainDisplay.setText(String.format("%s", 1 / (Double.parseDouble(mainDisplay.getText().toString()))));
                        break;
                }
            }
        };

        View.OnClickListener getResult = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult();
            }
        };

        View.OnClickListener backspace = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspaceNum();
            }
        };

        View.OnClickListener clean = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        };

        View.OnClickListener getMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDisplay.setText(String.format("%s", memoryValue));
            }
        };


        View.OnClickListener setAdditionMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoryValue += Double.parseDouble(mainDisplay.getText().toString());
            }
        };

        View.OnClickListener setSubtractionMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoryValue -= Double.parseDouble(mainDisplay.getText().toString());
            }
        };

        View.OnClickListener setCleanMemoryValue = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoryValue = 0.0;
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
        btnActionKeyAddition.setOnClickListener(setBinaryAction);
        btnActionKeySubtraction.setOnClickListener(setBinaryAction);
        btnActionKeyMultiplication.setOnClickListener(setBinaryAction);
        btnActionKeyDivision.setOnClickListener(setBinaryAction);
        btnActionKeySquaring.setOnClickListener(setUnaryAction);
        btnActionKeySquareRootExtraction.setOnClickListener(setUnaryAction);
        btnActionKeyReverse.setOnClickListener(setUnaryAction);
        btnActionKeyPercent.setOnClickListener(setBinaryAction);
        btnActionKeyNegative.setOnClickListener(setUnaryAction);
        btnActionKeyReset.setOnClickListener(clean);
        btnActionKeyBackspace.setOnClickListener(backspace);
        btnActionKeyResult.setOnClickListener(getResult);
        btnActionKeyMemoryRead.setOnClickListener(getMemoryValue);
        btnActionKeyMemoryPlus.setOnClickListener(setAdditionMemoryValue);
        btnActionKeyMemoryMinus.setOnClickListener(setSubtractionMemoryValue);
        btnActionKeyMemoryClear.setOnClickListener(setCleanMemoryValue);
    }

    public void addSymbolNum(char c) {
        // если это первый символ
        if (mainDisplay.getText().equals("0")) {
            if (c != '0' && c != '.') {
                mainDisplay.setText("" + c);
            } else if (c == '.') {
                mainDisplay.setText("0" + c);
            }
            return;
        } else if (c == '.' && mainDisplay.getText().toString().indexOf('.') == -1) {
            mainDisplay.setText(mainDisplay.getText().toString() + c);
        } else if (c != '.') {
            mainDisplay.setText(mainDisplay.getText().toString() + c);
        }
    }

    public void backspaceNum() {
        // проверяем если в строке больше 1 символа и этот единстренный символ не равен 0
        if (mainDisplay.getText().equals("0")) {
            // ничего не делаем пока
        } else if (mainDisplay.getText().length() == 1) {
            mainDisplay.setText("0");
        } else {
            mainDisplay.setText(mainDisplay.getText().toString().substring(0, mainDisplay.getText().length() - 1));
        }
    }

    public void preparingArithmeticOperation() {
        topCalcDisplay.setText(mainDisplay.getText() + currentBinaryAction.getTitle());
        currentValue = Double.parseDouble(mainDisplay.getText().toString());
        mainDisplay.setText("0");
    }

    public void getResult() {
        topCalcDisplay.setText(topCalcDisplay.getText().toString() + mainDisplay.getText().toString() + " = ");
        switch (currentBinaryAction) {
            case ADD:
                currentValue += Double.parseDouble(mainDisplay.getText().toString());
                mainDisplay.setText(currentValue.toString());
                break;
            case SUB:
                currentValue -= Double.parseDouble(mainDisplay.getText().toString());
                mainDisplay.setText(currentValue.toString());
                break;
            case MUL:
                currentValue *= Double.parseDouble(mainDisplay.getText().toString());
                mainDisplay.setText(currentValue.toString());
                break;
            case DIV:
                currentValue /= Double.parseDouble(mainDisplay.getText().toString());
                mainDisplay.setText(currentValue.toString());
                break;
        }
    }

    public void clean() {
        currentBinaryAction = null;
        currentValue = 0.0;
        mainDisplay.setText("0");
        topCalcDisplay.setText("");
    }

}