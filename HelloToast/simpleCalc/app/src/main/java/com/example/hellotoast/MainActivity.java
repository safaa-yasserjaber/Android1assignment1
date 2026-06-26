//MOB1-ass1
package com.example.hellotoast;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // زر Zero يكون رمادي بالبداية
        mainBinding.buttonZero.setBackgroundColor(Color.GRAY);
    }

    // Toast Button
    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    // Count Button
    public void increase_count(View view) {

        count++;

        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // تغيير لون زر Count
        if (count % 2 == 0) {

            // even = blue
            mainBinding.buttonCount.setBackgroundColor(Color.BLUE);

        } else {

            // odd = green
            mainBinding.buttonCount.setBackgroundColor(Color.GREEN);
        }

        // تفعيل زر Zero
        mainBinding.buttonZero.setBackgroundColor(Color.rgb(255,165,0));
    }

    // Zero Button
    public void showZero(View view) {

        count = 0;

        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // يرجع رمادي
        mainBinding.buttonZero.setBackgroundColor(Color.GRAY);
    }
}