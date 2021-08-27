package com.example.medicaresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMedicalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] city = { "Kota", "Ajmer", "Jaipur", "Udaipur", "Bhilwada","Jodhpur,Alwar","Chittor",
    "Kumbhalgarh","Jaisalmer","Ahemdabad","Surat","Gandhinagar","Vadodra","Patna","Mumbai"};
    String[] medicineTypes = { "Allopathy", "Homeopathy", "Ayurvedic"};
    Spinner city_spinner,medical_spinner;
    private EditText shopEditText,addressEditText,areaEditText,nameEditText,numberEditText,emailEditText,passwordEditText
            ,openEditText,closeEditText;
    private Button submit_btn;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical);
        medical_spinner=findViewById(R.id.medicalSpinner);
        city_spinner=findViewById(R.id.spinnerCity);
        shopEditText=findViewById(R.id.editTextshop);
        addressEditText=findViewById(R.id.editTextaddress);
        areaEditText=findViewById(R.id.editTextarea);
        nameEditText=findViewById(R.id.editTextcontact);
        numberEditText=findViewById(R.id.editTextcontactnumber);
        emailEditText=findViewById(R.id.editTextemail);
        passwordEditText=findViewById(R.id.editTextpassword);
        openEditText=findViewById(R.id.editTextOpen);
        closeEditText=findViewById(R.id.editTextClose);
        submit_btn=findViewById(R.id.buttonSubmit);
        ref= FirebaseDatabase.getInstance().getReference().child("Shop Details");
        medical_spinner.setOnItemSelectedListener(this);
        city_spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,medicineTypes);
        ArrayAdapter aaa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medical_spinner.setAdapter(aa);
        city_spinner.setAdapter(aaa);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shopName=shopEditText.getText().toString();
                String address=addressEditText.getText().toString();
                String area=areaEditText.getText().toString();
                String name=nameEditText.getText().toString();
                String number=numberEditText.getText().toString();
                String emails=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                String open=openEditText.getText().toString();
                String close=closeEditText.getText().toString();
                String medicalType=medical_spinner.getSelectedItem().toString();
                String cityName=city_spinner.getSelectedItem().toString();
                    String key=ref.push().getKey();
                    ref.child(key).child("ShopName").setValue(shopName);
                    ref.child(key).child("Address").setValue(address);
                    ref.child(key).child("Area").setValue(area);
                    ref.child(key).child("Name").setValue(name);
                    ref.child(key).child("Number").setValue(number);
                    ref.child(key).child("Email").setValue(emails);
                    ref.child(key).child("Password").setValue(password);
                    ref.child(key).child("Shop Open Time").setValue(open);
                    ref.child(key).child("Shop Close Time").setValue(close);
                    ref.child(key).child("MedicalTypes").setValue(medicalType);
                    ref.child(key).child("CityName").setValue(cityName);
                    Toast.makeText(AddMedicalActivity.this,"success",Toast.LENGTH_SHORT).show();

            }
        });



    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
