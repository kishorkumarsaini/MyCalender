package world.chat.kishor.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button dot;
    private Button clear;
    private Button equal;
    private EditText result;
    boolean Addition,Subtraction,Multiplication,Division;
    float valueOne,valueTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.oneButton);
        two = (Button) findViewById(R.id.twoButton);
        three = (Button) findViewById(R.id.threeButton);
        four = (Button) findViewById(R.id.fourButton);
        five = (Button) findViewById(R.id.fifthButton);
        six = (Button) findViewById(R.id.sixButton);
        seven = (Button) findViewById(R.id.sevenButton);
        eight = (Button) findViewById(R.id.eightButton);
        nine = (Button) findViewById(R.id.nineButton);
        zero = (Button) findViewById(R.id.zeroButton);
        add = (Button) findViewById(R.id.plusButton);
        sub=(Button)findViewById(R.id.minusButton);
        mul = (Button) findViewById(R.id.multiplyButton);
        div = (Button) findViewById(R.id.divisionButton);
        dot = (Button) findViewById(R.id.dotButton);
        clear = (Button) findViewById(R.id.clearButton);
        equal =(Button)findViewById(R.id.equalButton);
        result = (EditText) findViewById(R.id.ResultEditor);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "4");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+ "5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+ "9");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "0");
            }
        });

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().equals(""))
                {
                    result.setText(" ");
                } else {
                    valueOne = Float.parseFloat(result.getText() + " ");
                    Addition = true;
                    result.setText(null);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if (result.getText().toString().equals("")) {
                    result.setText("");
                } else
                {
                    valueOne = Float.parseFloat(result.getText() + "");
                Subtraction = true;
                result.setText(null);
            }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result.getText().toString().equals(""))
                {
                    result.setText("");
                }
                else {
                    valueOne = Float.parseFloat(result.getText() + "");
                    Multiplication = true;
                    result.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result.getText().toString().equals(""))
                {
                    result.setText("");
                }
                else {
                    valueOne = Float.parseFloat(result.getText() + "");
                    Division = true;
                    result.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (result.getText().toString().equals(""))
                {
                    result.setText("");
                }
                else {
                    valueTwo = Float.parseFloat(result.getText() + "");
                    if (Addition == true) {
                        result.setText(valueOne + valueTwo + "");
                        Addition = false;
                    }

                    if (Subtraction == true) {
                        result.setText(valueOne - valueTwo + "");
                        Subtraction = false;
                    }
                    if (Multiplication == true) {
                        result.setText(valueOne * valueTwo + "");
                        Multiplication = false;
                    }
                    if (Division == true) {
                        result.setText(valueOne / valueTwo + "");
                        Division = false;
                    }
                }
            }
        });



        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
            }
        });


    }
}