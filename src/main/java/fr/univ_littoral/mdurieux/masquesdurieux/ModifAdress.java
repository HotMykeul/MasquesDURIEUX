package fr.univ_littoral.mdurieux.masquesdurieux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ModifAdress extends AppCompatActivity {
    EditText editTextNumber;
    EditText editTextStreet;
    EditText editTextZipcode;
    EditText editTextCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_adress);

        editTextNumber = (EditText) findViewById(R.id.editText_number);
        editTextStreet = (EditText) findViewById(R.id.editText_street_name);
        editTextZipcode = (EditText) findViewById(R.id.editText_zipcode);
        editTextCity = (EditText) findViewById(R.id.editText_city);

        Intent intent = getIntent();
        String number = intent.getStringExtra(MainActivity.ADRESS_NUM);
        String street = intent.getStringExtra(MainActivity.ADRESS_STREET);
        String zipcode = intent.getStringExtra(MainActivity.ADRESS_ZIPCODE);
        String city = intent.getStringExtra(MainActivity.ADRESS_CITY);

        editTextNumber.setText(number);
        editTextStreet.setText(street);
        editTextZipcode.setText(zipcode);
        editTextCity.setText(city);
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                Intent intent = new Intent(this, MainActivity.class);

                intent.putExtra(MainActivity.ADRESS_NUM, editTextNumber.getText().toString());
                intent.putExtra(MainActivity.ADRESS_STREET, editTextStreet.getText().toString());
                intent.putExtra(MainActivity.ADRESS_ZIPCODE, editTextZipcode.getText().toString());
                intent.putExtra(MainActivity.ADRESS_CITY, editTextCity.getText().toString());

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
