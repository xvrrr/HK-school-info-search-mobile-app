package hk.edu.hkmu.schoolsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class FunctionActivity extends AppCompatActivity {
    static String Position = "Position";
    private TextView textView;
    private Button ContactButton;
    private Button WebButton;
    private Button GeoButton;
    private Button MoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        textView = findViewById(R.id.schoolname);
        ContactButton = findViewById(R.id.CONTACT);
        WebButton = findViewById(R.id.WEB);
        GeoButton = findViewById(R.id.GEO);
        MoreButton = findViewById(R.id.MORE);


        Intent intent = getIntent();
        String position = intent.getStringExtra(InputActivity.Position);
        int positionnum = Integer.parseInt(position); //convert the position to integer
        HashMap<String, String> school = SchoolInfo.schoolList.get(positionnum); // take out the specific school data from the whole list
        textView.setText(school.get(SchoolInfo.NAME)); //set the text as the specific school's name

        MoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(FunctionActivity.this,MoreActivity.class);
                intent1.putExtra(Position, position); //pass the position value to the next activity in str format
                startActivity(intent1);
            }
        });
        WebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(FunctionActivity.this,WebActivity.class);
                intent1.putExtra(Position, position); //pass the position value to the next activity in str format
                startActivity(intent1);
            }
        });
        GeoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(FunctionActivity.this,MapsActivity.class);
                intent1.putExtra(Position, position); //pass the position value to the next activity in str format
                startActivity(intent1);
            }
        });
        ContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s=SchoolInfo.schoolList.get(Integer.parseInt(position)).get(SchoolInfo.TELEPHONE);
                if (!TextUtils.isEmpty(s))
                callPhone(s);
                else
                    Toast.makeText(FunctionActivity.this,"phoneNumber is empty",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }
}