package id.sch.smktelkom_mlg.tugas01.xiirpl1003.graphicdesignup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etEmail;
    Button bSU;
    TextView tvHasil;
    RadioGroup rgKelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        bSU = (Button) findViewById(R.id.buttonSU);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);

        bSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            tvHasil.setText("Nama Anda: " + nama + "\nEmail Anda: " + email);
        }

    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (email.isEmpty()) {
            etEmail.setError("Email Anda Belum Diisi");
            valid = false;
        } else if (!email.contains("" + "@" + "" + "." + "")) {
            etEmail.setError("Email Anda Salah");
            valid = false;
        } else {
            etEmail.setError(null);
        }
        return valid;
    }

}

