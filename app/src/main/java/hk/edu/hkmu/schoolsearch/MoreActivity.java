package hk.edu.hkmu.schoolsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class MoreActivity extends AppCompatActivity {
    static String Position = "Position";
    private TextView information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        information = findViewById(R.id.information);

        Intent intent = getIntent();
        String position = intent.getStringExtra(InputActivity.Position);
        int position1 = Integer.parseInt(position);
        HashMap<String, String> school = SchoolInfo.schoolList.get(position1);
        //to refer to any element in the list in SchoolInfo.java like the NAME or NUMBER just use : school.get(SchoolInfo.NAME) or school.get(SchoolInfo.NUMBER)
        information.setText("School name:" + school.get(SchoolInfo.NAME) + "\n" + "\n" + "School number: " + school.get(SchoolInfo.NUMBER) + "\n" + "\n" + "Category: " + school.get(SchoolInfo.CATEGORY)+ "\n" + "\n" + "Session: " + school.get(SchoolInfo.SESSION)+ "\n"+ "\n" + "School religion: " + school.get(SchoolInfo.RELIGION));

    }
}