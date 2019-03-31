package com.example.leeascars;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.leasecars.R;
import com.example.leasecars.TextInputLayout;

import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity {
    public class MainActivity extends AppCompatActivity {


        private TextView check_title;
        private TextInputLayout duration;
        private TextInputLayout down_payment;
        private TextInputLayout lease;
        private TextInputLayout car_amount;
        private Button next;
        private TextView testing;
        public NumberFormat money = NumberFormat.getCurrencyInstance();



        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



            check_title = (TextView) findViewById(R.id.checkID);
            duration = (TextInputLayout) findViewById(R.id.duration_monthID);
            down_payment = (TextInputLayout) findViewById(R.id.down_paymentID);
            lease = (TextInputLayout) findViewById(R.id.leaseID);
            car_amount = (TextInputLayout) findViewById(R.id.car_valueID);
            testing = (TextView) findViewById(R.id.test);
            next = (Button) findViewById(R.id.nextID);





            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate(duration.getEditText().getText().toString(), down_payment.getEditText().getText().toString(), lease.getEditText().getText().toString(), car_amount.getEditText().getText().toString());



                    //calculation for monthly car rent
                    String month = duration.getEditText().getText().toString();
                    String down = down_payment.getEditText().getText().toString();
                    String rate = lease.getEditText().getText().toString();
                    String amount = car_amount.getEditText().getText().toString();



                    try {
                        //transition to the next Activity and passing data through intent action
                        Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
                        Bundle params = new Bundle();
                        params.putDouble("months", Double.valueOf(month));
                        params.putDouble("downs", Double.valueOf(down));
                        params.putDouble("rates", Double.valueOf(rate));
                        params.putDouble("amounts", Double.valueOf(amount));
                        intent.putExtras(params);


                        startActivity(intent);
                    } catch (NumberFormatException nfe) {

                        //pop up an alert view here

                    }

                }
            });


        }



        private void calculate(String duration_month, String payment, String leases, String amount) {

            if (duration_month.isEmpty() && payment.isEmpty() && leases.isEmpty() && amount.isEmpty()) {
                duration.setError("Field cant be empty");
                down_payment.setError("Field cant be empty");
                lease.setError("Field cant be empty");
                car_amount.setError("Field cant be empty");
            } else {
                duration.setError(null);
                down_payment.setError(null);
                lease.setError(null);
                car_amount.setError(null);
                next.setEnabled(true);

            }


        }

    }}

}
