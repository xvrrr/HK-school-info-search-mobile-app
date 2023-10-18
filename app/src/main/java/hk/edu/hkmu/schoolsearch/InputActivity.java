package hk.edu.hkmu.schoolsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;


public class InputActivity extends AppCompatActivity {
    static String Position = "Position";
    private String TAG = "InputActivity";
    SearchView searchView;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        searchView =findViewById(R.id.search);
        listView=findViewById(R.id.listView);
        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();
        jsonHandlerThread.start();
        try{
            jsonHandlerThread.join();

            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,SchoolInfo.schoolnames);


            listView.setAdapter(adapter);

            listView.setOnItemClickListener(
                    new  AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> adapterView, View view, int p, long id) {
                            Intent intent = new Intent(InputActivity.this,FunctionActivity.class);
                            String Nameofschool = adapterView.getItemAtPosition(p).toString();
                            int positionint = SchoolInfo.schoolnames.indexOf(Nameofschool);
                            String position = String.valueOf(positionint); //convert position to string to send it to next activity
                            intent.putExtra(Position, position);
                            startActivity(intent);
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    adapter.getFilter().filter(query);

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    adapter.getFilter().filter(newText);


                    return false;
                }
            });




        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException: " + e.getMessage());
        }
    }
}

