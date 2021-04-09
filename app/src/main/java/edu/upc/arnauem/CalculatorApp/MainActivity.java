package edu.upc.arnauem.CalculatorApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView calcTextView;
    TextView resultTextView;
    Button angleBtn;

    String calculation = "";

    boolean additionFlag;
    boolean subtractionFlag;
    boolean multiplicationFlag;
    boolean divisionFlag;

    boolean cosinusFlag;
    boolean sinusFlag;
    boolean tangentFlag;

    float num1 = 0; float num2 = 0;
    float result;

    char angleUnit = 'd';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

    }

    private void initializeComponents()
    {
        calcTextView = (TextView)findViewById(R.id.calcTextView);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        angleBtn = (Button)findViewById(R.id.angleBtn);
    }

    private void setCalculation(String value)
    {
        calculation = calculation + value;
        calcTextView.setText(calculation);
    }

    private void setResult(float value)
    {
        result = value;
        resultTextView.setText(Float.toString(result));
    }

    private void clearCalculation()
    {
        calculation = "";
        calcTextView.setText("");

        clearFlags();
        num1 = 0;
        num2 = 0;

    }

    public void oneOnClick(View w)
    {
        calcTextView.setText("HOLAAA LOCOO");
        setCalculation("1");
        numberInput(1);
    }

    public void twoOnClick(View w)
    {
        setCalculation("2");
        numberInput(2);
    }

    public void threeOnClick(View w)
    {
        setCalculation("3");
        numberInput(3);
    }

    public void fourOnClick(View w)
    {
        setCalculation("4");
        numberInput(4);
    }

    public void fiveOnClick(View w)
    {
        setCalculation("5");
        numberInput(5);
    }

    public void sixOnClick(View w)
    {
        setCalculation("6");
        numberInput(6);
    }

    public void sevenOnClick(View w)
    {
        setCalculation("7");
        numberInput(7);
    }

    public void eightOnClick(View w)
    {
        setCalculation("8");
        numberInput(8);
    }

    public void nineOnClick(View w)
    {
        setCalculation("9");
        numberInput(9);
    }

    public void zeroOnClick(View w)
    {
        setCalculation("0");
        numberInput(0);
    }

    public void additionOnClick(View w)
    {
        setCalculation("+");
        operationInput("+");
    }

    public void subtractionOnClick(View w)
    {
        setCalculation("-");
        operationInput("-");
    }

    public void multiplicationOnClick(View w)
    {
        setCalculation("*");
        operationInput("*");
    }

    public void divisionOnClick(View w)
    {
        setCalculation("/");
        operationInput("/");
    }

    public void clearOnClick(View w)
    {
        clearCalculation();
        setResult(0.0f);
    }


    public void equalOnClick(View w)
    {
        operationInput("=");
    }

    public void dotOnClick(View w)
    {
        setCalculation(".");
    }

    private void operationInput(String op)
    {
        if(isAnyFlagOn())
        {
            if (additionFlag) {
                num1 = num1 + num2;
                additionFlag = false;
            }
            else if(subtractionFlag) {
                num1 = num1 - num2;
                subtractionFlag = false;
            }
            else if(multiplicationFlag) {
                num1 = num1 * num2;
                multiplicationFlag = false;
            }
            else if(divisionFlag) {
                num1 = num1 / num2;
                divisionFlag = false;
            }


            if(op == "=")
            {
                double radians;
                if(angleUnit == 'd')
                    radians = Math.toRadians(num2);
                else
                    radians = num2;

                if(cosinusFlag) {
                    result = (float) Math.cos(radians);
                    setResult(result);
                    cosinusFlag = false;
                }
                else if(sinusFlag) {
                    setResult((float) Math.sin(radians));
                    sinusFlag = false;
                }
                else if(tangentFlag) {
                    setResult((float) Math.tan(radians));
                    tangentFlag = false;
                }
                else
                    setResult(num1);

                num2 = 0;
            }
        }

        switch(op)
        {
            case "+":
                additionFlag = true;
                break;
            case "-":
                subtractionFlag = true;
                break;
            case "*":
                multiplicationFlag = true;
                break;
            case "/":
                divisionFlag = true;
                break;
        }
    }

    private void numberInput(int num)
    {
        String num1String, num2String, numString;
        num1String = Integer.toString((int)num1);
        num2String = Integer.toString((int)num2);
        numString = Integer.toString(num);
        if(isAnyFlagOn())
        {
            num2String = num2String + numString;
            num2 = Float.valueOf(num2String);
        }
        else
        {
            num1String = num1String + numString;
            num1 = Float.valueOf(num1String);
        }
    }

    private boolean isAnyFlagOn()
    {
        if(additionFlag || subtractionFlag || multiplicationFlag || divisionFlag
            || cosinusFlag || sinusFlag || tangentFlag)
            return true;
        else
            return false;
    }

    private void clearFlags()
    {
        additionFlag = false;
        subtractionFlag = false;
        multiplicationFlag = false;
        divisionFlag = false;
        cosinusFlag = false;
        sinusFlag = false;
        tangentFlag = false;
    }

    public void angleOnClick(View v)
    {
        if(angleUnit == 'd')
        {
            angleUnit = 'r';
            angleBtn.setText("RAD");
        }
        else
        {
            angleUnit = 'd';
            angleBtn.setText("DEG");
        }
    }

    public void cosinusOnClick(View v)
    {
        clearCalculation();
        setResult(0.0f);

        setCalculation("cos(");
        cosinusFlag = true;
    }

    public void sinusOnClick(View v)
    {
        clearCalculation();
        setResult(0.0f);

        setCalculation("sin(");
        sinusFlag = true;
    }

    public void tangentOnClick(View v)
    {
        clearCalculation();
        setResult(0.0f);

        setCalculation("tan(");
        tangentFlag = true;
    }
}