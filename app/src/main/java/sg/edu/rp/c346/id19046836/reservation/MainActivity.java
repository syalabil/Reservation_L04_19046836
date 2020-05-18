package sg.edu.rp.c346.id19046836.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name ;
    EditText phone;
    EditText size;
    DatePicker date;
    TimePicker time;
    CheckBox check;
    Button confirm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextPhone);
        size = findViewById(R.id.editTextSize);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        check = findViewById(R.id.checkBoxSmoking);
        confirm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.buttonReset);

        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        date.updateDate(2020,5,1);

        //Confirm button
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sentence = "         Reservation Information \n";
                sentence += "Name : " + name.getText().toString() + " \n";
                sentence += "Phone : " + phone.getText().toString() + " \n";
                sentence += "Group Size : " + size.getText().toString() + " \n";
                sentence += String.format("%s %d / %s / %d \n", "Date of booking : ",date.getDayOfMonth()
                        ,date.getMonth() + 1,date.getYear());
                sentence += String.format("%s %d : %d \n", "Time of booking : ", time.getCurrentHour(),
                        time.getCurrentMinute());
                if(check.isChecked()){
                    sentence += "Type of table : Smoking Area ";
                }
                else{
                    sentence += "Type of table : Non - Smoking Area ";
                }

                Toast.makeText(MainActivity.this,sentence,Toast.LENGTH_SHORT).show();





            }
        });


        //Reset button
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,5,1);
                name.setText(null);
                phone.setText(null);
                size.setText(null);
                check.setChecked(false);




            }
        });


    }
}
