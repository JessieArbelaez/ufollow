package com.ufo.ufollow;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        // Configure window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        TextView tvStartTime = findViewById(R.id.tvStartTime);
        TextView tvStartDate = findViewById(R.id.tvStartDate);
        Button btnStartRoute = findViewById(R.id.btnStartRoute);

        // Set the assigned start time and date
        String assignedStartTime = "08:00 AM";
        String assignedStartDate = "26/09/24";

        tvStartTime.setText("Hora de inicio: " + assignedStartTime);
        tvStartDate.setText("Fecha: " + assignedStartDate);

        // Set button click listener
        btnStartRoute.setOnClickListener(v -> {
            // Get current time and date
            String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
            String currentDate = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());

            // Check if current time and date match the assigned time and date
            if (currentTime.equals(assignedStartTime) && currentDate.equals(assignedStartDate)) {
                Toast.makeText(HomePage.this, "Ruta iniciada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(HomePage.this, "Solo se permite iniciar la ruta en el horario y fecha asignados.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
