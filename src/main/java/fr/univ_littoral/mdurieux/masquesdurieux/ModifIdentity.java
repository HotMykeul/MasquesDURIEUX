package fr.univ_littoral.mdurieux.masquesdurieux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class ModifIdentity extends AppCompatActivity {
    EditText editTextLastname;
    EditText editTextFirstname;
    EditText editTextPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_identity);

        editTextFirstname = (EditText) findViewById(R.id.editText_firstname);
        editTextLastname = (EditText) findViewById(R.id.editText_lastname);
        editTextPhone = (EditText) findViewById(R.id.editText_phone);

        Intent intent = getIntent();
        String lastname = intent.getStringExtra(MainActivity.IDENTITY_LASTNAME);
        String firstname = intent.getStringExtra(MainActivity.IDENTITY_FIRSTNAME);
        String phone = intent.getStringExtra(MainActivity.IDENTITY_PHONE);

        editTextLastname.setText(lastname);
        editTextFirstname.setText(firstname);
        editTextPhone.setText(phone);
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                Intent intent = new Intent(this, MainActivity.class);

                intent.putExtra(MainActivity.IDENTITY_LASTNAME, editTextLastname.getText().toString());
                intent.putExtra(MainActivity.IDENTITY_FIRSTNAME, editTextFirstname.getText().toString());
                intent.putExtra(MainActivity.IDENTITY_PHONE, editTextPhone.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.button_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }

    }
}
