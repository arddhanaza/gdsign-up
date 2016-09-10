package id.sch.smktelkom_mlg.tugas01.xiirpl1003.graphicdesignup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    CheckBox cbPS, cbAI, cbCD;
    EditText etNama, etEmail;
    Button bSU;
    TextView tvHasil;
    RadioGroup rgKelas;
    Spinner spKelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAI = (CheckBox) findViewById(R.id.checkBoxAI);
        cbPS = (CheckBox) findViewById(R.id.checkBoxPS);
        cbCD = (CheckBox) findViewById(R.id.checkBoxCorel);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        bSU = (Button) findViewById(R.id.buttonSU);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgKelas = (RadioGroup) findViewById(R.id.radioGroupKelas);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        bSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }


    private void doClick() {
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String hasil = null;
        String hasilcb = "\nSoftware yang Anda Kuasai: \n";
        int startlen = hasilcb.length();

        if (isValid()) {

            if (rgKelas.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgKelas.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvHasil.setText("Jenis Kelamin Belum Diisi");
            } else {
                if (cbAI.isChecked()) hasilcb += cbAI.getText() + "\n";
                if (cbCD.isChecked()) hasilcb += cbCD.getText() + "\n";
                if (cbPS.isChecked()) hasilcb += cbPS.getText() + "\n";
                if (hasilcb.length() == startlen) hasilcb += "Tidak ada Pilihan";

                tvHasil.setText("Nama Anda: " + nama + "\n\nEmail Anda: " + email + "\n\nKelas: " + (spKelas.getSelectedItem().toString()) + "\n\nJenis Kelamin: " + hasil + hasilcb);
            }


        }


    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        final EditText emailval = (EditText) findViewById(R.id.editTextEmail);
        String email2 = emailval.getText().toString().trim();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


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
        } else if (!email2.matches(emailpattern)) {
            etEmail.setError("Silakan Cek Kembali Email Anda");
            valid = false;
        } else {
            etEmail.setError(null);
        }
        return valid;
    }
}

