package fr.univ_littoral.mdurieux.masquesdurieux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    public static final int MOD_IDENTITY_CODE = 1;
    public static final int MOD_ADRESS_CODE = 2;

    public static final String IDENTITY_LASTNAME = "lastname";
    public static final String IDENTITY_FIRSTNAME = "firstname";
    public static final String IDENTITY_PHONE = "phone";

    public static final String ADRESS_NUM = "num";
    public static final String ADRESS_STREET = "street";
    public static final String ADRESS_CITY = "city";
    public static final String ADRESS_ZIPCODE = "zipcode";

    HashMap<String, TextView> textViewsIdentity;
    HashMap<String, TextView> textViewsAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewsIdentity = new HashMap<>();
        textViewsAdress = new HashMap<>();

        textViewsIdentity.put(IDENTITY_LASTNAME, ((TextView) findViewById(R.id.textView_lastname)));
        textViewsIdentity.put(IDENTITY_FIRSTNAME, ((TextView) findViewById(R.id.textView_firstname)));
        textViewsIdentity.put(IDENTITY_PHONE, ((TextView) findViewById(R.id.textView_phone)));

        textViewsAdress.put(ADRESS_NUM, ((TextView) findViewById(R.id.textView_number)));
        textViewsAdress.put(ADRESS_STREET, ((TextView) findViewById(R.id.textView_street)));
        textViewsAdress.put(ADRESS_ZIPCODE, ((TextView) findViewById(R.id.textView_zipcode)));
        textViewsAdress.put(ADRESS_CITY, ((TextView) findViewById(R.id.textView_city)));
    }

    public void setModifyAdress(View view) {
        String num = textViewsAdress.get(ADRESS_NUM).getText().toString();
        String city = textViewsAdress.get(ADRESS_CITY).getText().toString();
        String street = textViewsAdress.get(ADRESS_STREET).getText().toString();
        String zipcode = textViewsAdress.get(ADRESS_ZIPCODE).getText().toString();

        Intent intent = new Intent(this, ModifAdress.class);
        intent.putExtra(ADRESS_NUM, num);
        intent.putExtra(ADRESS_CITY, city);
        intent.putExtra(ADRESS_STREET, street);
        intent.putExtra(ADRESS_ZIPCODE, zipcode);

        startActivityForResult(intent, MOD_ADRESS_CODE);
    }

    public void setModifyIdentity(View view) {
        String nom = textViewsIdentity.get(IDENTITY_LASTNAME).getText().toString();
        String prenom = textViewsIdentity.get(IDENTITY_FIRSTNAME).getText().toString();
        String phone = textViewsIdentity.get(IDENTITY_PHONE).getText().toString();

        Intent intent = new Intent(this, ModifIdentity.class);
        intent.putExtra(IDENTITY_LASTNAME, nom);
        intent.putExtra(IDENTITY_FIRSTNAME, prenom);
        intent.putExtra(IDENTITY_PHONE, phone);

        startActivityForResult(intent, MOD_IDENTITY_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case MOD_IDENTITY_CODE:
                if (resultCode == RESULT_OK) {
                    textViewsIdentity.get(IDENTITY_LASTNAME).setText(data.getStringExtra(IDENTITY_LASTNAME));
                    textViewsIdentity.get(IDENTITY_FIRSTNAME).setText(data.getStringExtra(IDENTITY_FIRSTNAME));
                    textViewsIdentity.get(IDENTITY_PHONE).setText(data.getStringExtra(IDENTITY_PHONE));
                }
                break;

            case MOD_ADRESS_CODE:
                if (resultCode == RESULT_OK) {
                    textViewsAdress.get(ADRESS_NUM).setText(data.getStringExtra(ADRESS_NUM));
                    textViewsAdress.get(ADRESS_STREET).setText(data.getStringExtra(ADRESS_STREET));
                    textViewsAdress.get(ADRESS_ZIPCODE).setText(data.getStringExtra(ADRESS_ZIPCODE));
                    textViewsAdress.get(ADRESS_CITY).setText(data.getStringExtra(ADRESS_CITY));
                }
                break;

        }
    }
}
