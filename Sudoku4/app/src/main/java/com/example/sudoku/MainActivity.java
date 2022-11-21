package com.example.sudoku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static CustomButton[][] buttons;
    public void check()
    {
        boolean [][] is_red = new boolean[9][9];
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                int value = buttons[i][j].value;
                if(crosscheck(i,j))
                {
                    is_red[i][j]=true;
                }
                if(i<=2)
                {
                    if(j<=2)
                    {
                        for(int t=0; t<=2; t++)
                        {
                            for(int k=0; k<=2; k++)
                            {
                                if(i==t && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=5)
                    {
                        for(int t=0; t<=2; t++)
                        {
                            for(int k=3; k<=5; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=8)
                    {
                        for(int t=0; t<=2; t++)
                        {
                            for(int k=6; k<=8; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }

                            }
                        }
                    }
                }
                else if(i<=5)
                {
                    if(j<=2)
                    {
                        for(int t=3; t<=5; t++)
                        {
                            for(int k=0; k<=2; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=5)
                    {
                        for(int t=3; t<=5; t++)
                        {
                            for(int k=3; k<=5; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=8)
                    {
                        for(int t=3; t<=5; t++)
                        {
                            for(int k=6; k<=8; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(i<=8)
                {
                    if(j<=2)
                    {
                        for(int t=6; t<=8; t++)
                        {
                            for(int k=0; k<=2; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=5)
                    {
                        for(int t=6; t<=8; t++)
                        {
                            for(int k=3; k<=5; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                    else if(j<=8)
                    {
                        for(int t=6; t<=8; t++)
                        {
                            for(int k=6; k<=8; k++)
                            {
                                if(t==i && j==k) continue;
                                if(value==0) continue;
                                if(buttons[t][k].value==value)
                                {
                                    is_red[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(is_red[i][j]) buttons[i][j].setBackgroundResource(R.drawable.layer_button_conflict);
                else buttons[i][j].setBackgroundResource(R.drawable.button_selector);
            }
        }
    }
    public boolean crosscheck(int i, int j)
    {
        int a = buttons[i][j].value;
        if(a==0) return false;
        for(int t=0; t<9; t++)
        {
            if(buttons[t][j].value==a && t!=i)
            {
                return true;
            }
        }

        for(int t=0; t<9; t++)
        {
            if(buttons[i][t].value==a && t!=j)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] x = {0};
        final int[] y = {0};
        setContentView(R.layout.activity_main);
        TableLayout table;
        TableLayout input = (TableLayout) findViewById(R.id.input) ;
        table = (TableLayout)findViewById(R.id.tb);
        //Button[][] buttons = new Button[9][9];
        buttons = new CustomButton[9][9];
        BoardGenerator board = new BoardGenerator();
        for(int i=0; i<9; i++)
        {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
            TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
            TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
            TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
            layoutParams1.setMargins(0,0,0,0);
            layoutParams2.setMargins(0,0,15,0);
            layoutParams3.setMargins(0,0,0,15);
            layoutParams4.setMargins(0,0,15,15);
            table.addView(tableRow);
            for(int j=0; j<9; j++)
            {
                boolean is_right = false;
                boolean is_bottom = false;
                buttons[i][j] = new CustomButton(this,i,j);
                int num = board.get(i,j);

                if(i==2 || i==5)
                {
                    is_bottom = true;
                }
                if(j==2 || j==5)
                {
                    is_right = true;
                }
                if(is_right && is_bottom)
                {
                    buttons[i][j].setLayoutParams(layoutParams4);
                }
                else if(is_bottom)
                {
                    buttons[i][j].setLayoutParams(layoutParams3);
                }
                else if(is_right)
                {
                    buttons[i][j].setLayoutParams(layoutParams2);
                }
                else
                {
                    buttons[i][j].setLayoutParams(layoutParams1);
                }


                buttons[i][j].set(num);
                //buttons[i][j].setTextSize(30);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomButton temp = (CustomButton) view;
                        x[0] =temp.i;
                        y[0] =temp.j;
                        input.setVisibility(View.VISIBLE);
                    }
                });
                tableRow.addView(buttons[i][j]);
            }
        }
        int count =0;
        Random random = new Random();
        while(count<15)
        {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            if(buttons[i][j].get()==null)
            {
                continue;
            }
            else
            {
                buttons[i][j].set(0);
                count++;
            }
        }

        //입력 테이블 레이아웃
        Button [][] inputbtn = new Button[3][3];
        Button [] Controlbtn = new Button[2];
        inputbtn[0][0] = (Button) findViewById(R.id.button1);
        inputbtn[0][1] = (Button) findViewById(R.id.button2);
        inputbtn[0][2] = (Button) findViewById(R.id.button3);
        inputbtn[1][0] = (Button) findViewById(R.id.button4);
        inputbtn[1][1] = (Button) findViewById(R.id.button5);
        inputbtn[1][2] = (Button) findViewById(R.id.button6);
        inputbtn[2][0] = (Button) findViewById(R.id.button7);
        inputbtn[2][1] = (Button) findViewById(R.id.button8);
        inputbtn[2][2] = (Button) findViewById(R.id.button9);
        Controlbtn[0] = (Button) findViewById(R.id.button11);
        Controlbtn[1] = (Button) findViewById(R.id.button12);
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                inputbtn[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button temp = (Button) findViewById(view.getId());
                        String a = (String) temp.getText();
                        buttons[x[0]][y[0]].set(Integer.parseInt(a));
                        input.setVisibility(View.INVISIBLE);
                        check();
                    }
                });
            }
        }
        Controlbtn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setVisibility(View.INVISIBLE);
            }
        });
        Controlbtn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttons[x[0]][y[0]].set(0);
                check();
            }
        });
    }
}