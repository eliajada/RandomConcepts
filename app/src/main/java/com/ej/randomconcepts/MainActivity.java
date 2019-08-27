package com.ej.randomconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<String> qList;
    Spinner crSpinner;
    TextView crtextView;

    EditText editNum;
    TextView textNum;
    EditText distance1;
    EditText distance2;
    EditText hist1;
    EditText hist2;


    ArrayList<String> addlist;

    ArrayList<String> testlist;
    ArrayList<String> multipleslist;

    public void clearText(View view){
        textNum.setText(null);
    }

    public void myMethod(View view) {



        if (crSpinner.getSelectedItem().toString() == "yourname"){

            textNum.setText("Elia Jada");

        } else if (crSpinner.getSelectedItem().toString() == "a+bx") {

            String parts[] = editNum.getText().toString().split("\\s+");
            int value = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]) * Integer.parseInt(parts[2]);

            textNum.setText(" " + value);

        } else if (crSpinner.getSelectedItem().toString() == "add-one"){

            String addparts[] = editNum.getText().toString().split("\\s+");
            int i = 0;

            while (i < addparts.length){

                int newAdd = Integer.parseInt(addparts[i]) + 1;

                textNum.append(String.valueOf(newAdd));
                textNum.append(String.valueOf(" "));

                i++;

            }

        } else if (crSpinner.getSelectedItem().toString() == "distance"){

            String distanceAr[] = distance1.getText().toString().split("\\s+");
            String distanceAr2[] = distance2.getText().toString().split("\\s+");

            int x =  Integer.parseInt(distanceAr2[0]) - Integer.parseInt(distanceAr[0]);
            int y =  Integer.parseInt(distanceAr2[1]) - Integer.parseInt(distanceAr[1]);
            int z =  Integer.parseInt(distanceAr2[2]) - Integer.parseInt(distanceAr[2]);
            int x2 = x * x;
            int y2 = y * y;
            int z2 = z * z;
            int xyz = x2 + y2 + z2;
            int rootxyz = (int) Math.sqrt(xyz);


            textNum.setText(" " + rootxyz);
        } else if (crSpinner.getSelectedItem().toString() == "qroots"){   // Quadratic formula

            String qrootsAr[] = editNum.getText().toString().split("\\s+");

            int a = Integer.parseInt(qrootsAr[0]);
            int b = Integer.parseInt(qrootsAr[1]);
            int c = Integer.parseInt(qrootsAr[2]);
            int b2 = Integer.parseInt(qrootsAr[1]) * Integer.parseInt(qrootsAr[1]);
            int ac = Integer.parseInt(qrootsAr[0]) * Integer.parseInt(qrootsAr[2]);
            int bac = b2 - (4 * ac);
            int plus = (int) (-b + Math.sqrt(bac))/(2 * a);
            int minus = (int) (-b - Math.sqrt(bac))/(2 * a);

            textNum.setText(plus + " " + minus);

        } else if (crSpinner.getSelectedItem().toString() == "numbers-only"){

            String numOnly = String.valueOf(editNum.getText());
            numOnly = numOnly.replaceAll("[^\\d.]", " "); // mention in report in parallel with scheme
            textNum.setText(" " + numOnly);



        } else if (crSpinner.getSelectedItem().toString() == "charflip"){


            String str = String.valueOf(editNum.getText());
            StringBuilder build = new StringBuilder(str.length());

            for (int i = 0; i < str.length(); i++) {
                char strChar = str.charAt(i);

                if ((i & 1) == 0) {

                    build.append(str.charAt(i));

                } else {
                    if (Character.isUpperCase(strChar)) {
                        build.append(Character.toLowerCase(strChar));

                    } else if (Character.isLowerCase(strChar)) {

                        build.append(Character.toUpperCase(strChar));

                    }

                }

                textNum.setText(build);
            }

                 /*String str = String.valueOf(editNum.getText());
                 int i = 0;
                 int l = str.length();

                 while( i < l) {

                     if (Character.isUpperCase(Integer.parseInt(str.substring(0, i)))){

                         Toast.makeText(this, "CAPITAL", Toast.LENGTH_SHORT).show();

                     }

                     i++;

                 }*/

               /*  String str = "hello There";
                 String str2 = str.substring(0, 2).toUpperCase() + str.substring(1);
                 textNum.setText(str2);*/
        } else if (crSpinner.getSelectedItem().toString() == "prime") {

            int number = (int) Integer.parseInt(String.valueOf(editNum.getText()));;

            // Toast.makeText(this, "" + number, Toast.LENGTH_SHORT).show();

            int i;

            for (i = 2; i <= number; i++) {
                if (number % i == 0) {
                    Toast.makeText(this, "" + i, Toast.LENGTH_SHORT).show();
                    number /= i;
                    i--;
                }
            }

            textNum.setText(" " + i);


        } else if (crSpinner.getSelectedItem().toString() == "histogram"){

            String histValue = String.valueOf(hist1.getText());
            String histCount[] = hist2.getText().toString().split("\\s+");
            int histLength = histCount.length;

            int i = 0;

            //Toast.makeText(this, "" + histLength, Toast.LENGTH_SHORT).show();

            while ( i < histLength)
            {
                int c = 0;
                while (c < Integer.parseInt(histCount[i])){
                    c++;
                    textNum.append(histValue);
                }
                textNum.append(" ");
                i++;
            }




        } else if (crSpinner.getSelectedItem().toString() == "multiples") {

            String multiAr[] = editNum.getText().toString().split("\\s+");

            int base = Integer.parseInt(multiAr[0]);
            int N = Integer.parseInt(multiAr[1]);
            int newBase = base;
            textNum.append(String.valueOf(Integer.parseInt(multiAr[0])) + " ");

            while(base < N) {

                newBase = newBase + Integer.parseInt(multiAr[0]);


                if (newBase < N) {
                    textNum.append(String.valueOf(newBase) + " ");
                }

                base++;

            }


        }


    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if (crSpinner.getSelectedItem().toString() == "distance"){
            distance1.setVisibility(View.VISIBLE);
            distance2.setVisibility(View.VISIBLE);
            editNum.setVisibility(View.INVISIBLE);
        } else  {
            distance1.setVisibility(View.INVISIBLE);
            distance2.setVisibility(View.INVISIBLE);
            editNum.setVisibility(View.VISIBLE);
        }
        if (crSpinner.getSelectedItem().toString() == "histogram"){
            hist1.setVisibility(View.VISIBLE);
            hist2.setVisibility(View.VISIBLE);
            editNum.setVisibility(View.INVISIBLE);
        } else {
            hist1.setVisibility(View.INVISIBLE);
            hist2.setVisibility(View.INVISIBLE);
            editNum.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum = (EditText) findViewById(R.id.editNum);
        textNum = (TextView) findViewById(R.id.textNum);
        // String parts[] = editNum.getText().toString().split("\\s+");

        addlist = new ArrayList<String>();

        distance1 = (EditText) findViewById(R.id.distance1);
        distance2 = (EditText) findViewById(R.id.distance2);

        hist1 = (EditText) findViewById(R.id.hist1);
        hist2 = (EditText) findViewById(R.id.hist2);

        testlist = new ArrayList<String>();
        multipleslist = new ArrayList<String>();







        crtextView = (TextView) findViewById(R.id.crtextView);
        //   editText2 = (EditText) findViewById(R.id.editText2);

        crSpinner = findViewById(R.id.cr4Spinner); String[] choices = new String[]{"yourname", "a+bx", "add-one", "distance", "qroots", "numbers-only", "multiples","histogram", "charflip", "prime"};
        qList = new ArrayList<>(Arrays.asList(choices));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, choices);

        crSpinner.setAdapter(adapter);
        crSpinner.setOnItemSelectedListener(this);
    }
}
