package com.example.webapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity {

    private EditText edtWidth, edtHeight;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        edtWidth = findViewById(R.id.edtWidth);
        edtHeight = findViewById(R.id.edtHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(v -> calculateArea());
    }

    private void calculateArea() {
        String widthStr = edtWidth.getText().toString();
        String heightStr = edtHeight.getText().toString();

        if (!widthStr.isEmpty() && !heightStr.isEmpty()) {
            double width = Double.parseDouble(widthStr);
            double height = Double.parseDouble(heightStr);
            double area = width * height;
            txtResult.setText("Kết quả diện tích: " + area);
        } else {
            txtResult.setText("Vui lòng nhập đầy đủ dữ liệu!");
        }
    }
}
