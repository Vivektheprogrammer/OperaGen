package com.example.operagen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    private LinearLayout lnrDynamicEditTextHolder;
    private EditText edtNoCreate;
    private EditText edtMaxMarks;
    private Button btnCreate;
    private Button btnCalculate;
    private TextView txtTotalMarks;
    private TextView txtMaxMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lnrDynamicEditTextHolder = findViewById(R.id.lnrDynamicEditTextHolder);
        edtNoCreate = findViewById(R.id.edtNoCreate);
        edtMaxMarks = findViewById(R.id.edtMaxMarks);
        btnCreate = findViewById(R.id.btnCreate);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtTotalMarks = findViewById(R.id.txtTotalMarks);
        txtMaxMarks = findViewById(R.id.txtMaxMarks);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNoCreate.getText().toString().length() > 0) {
                    try {
                        lnrDynamicEditTextHolder.removeAllViews();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    int length = Integer.parseInt(edtNoCreate.getText().toString());

                    for (int i = 0; i < length; i++) {
                        EditText editText = new EditText(MainActivity2.this);
                        editText.setId(i + 1);
                        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        editText.setHint("Enter Subject " + (i + 1) + " Marks");
                        lnrDynamicEditTextHolder.addView(editText);
                    }

                    edtMaxMarks.setVisibility(View.VISIBLE);
                    txtMaxMarks.setVisibility(View.VISIBLE);
                    btnCalculate.setVisibility(View.VISIBLE);
                }
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfSubjects = lnrDynamicEditTextHolder.getChildCount();
                int totalMarks = 0;
                int maxMarks = 0;
                String maxMarksString = edtMaxMarks.getText().toString().trim();
                if (!maxMarksString.isEmpty()) {
                    maxMarks = Integer.parseInt(maxMarksString);
                }

                for (int i = 0; i < numberOfSubjects; i++) {
                    View view = lnrDynamicEditTextHolder.getChildAt(i);
                    if (view instanceof EditText) {
                        EditText editText = (EditText) view;
                        String marksString = editText.getText().toString().trim();
                        if (!marksString.isEmpty()) {
                            int marks = Integer.parseInt(marksString);
                            totalMarks += marks;
                        }
                    }
                }


               double percentage = (totalMarks / (double) maxMarks) * 100;
                double cgpa = (double) percentage / 9.5;
                if (cgpa > 10.0) {
                    cgpa = 10.0;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                double cgpaFormatted = Double.parseDouble(decimalFormat.format(cgpa));
                double percentageFormatted = Double.parseDouble(decimalFormat.format(percentage));

                String result = "Total Marks: " + totalMarks + "\nCGPA: " + cgpaFormatted +  "\nPercentage " + percentageFormatted + "%";
                txtTotalMarks.setText(result);
                txtTotalMarks.setVisibility(View.VISIBLE);
            }
        });

    }
}
