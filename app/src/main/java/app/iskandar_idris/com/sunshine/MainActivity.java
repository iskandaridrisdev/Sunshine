package app.iskandar_idris.com.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.iskandar_idris.com.sunshine.Controllers.CloudConnecting;
import app.iskandar_idris.com.sunshine.Controllers.CloudResult;
import app.iskandar_idris.com.sunshine.Controllers.CloudUrl;
import app.iskandar_idris.com.sunshine.Controllers.adapter.ListAdapter;

public class MainActivity extends AppCompatActivity {

    CloudConnecting cloudConnecting;
    CloudUrl cloudUrl;
    CloudConnecting connecting;
    private String cityName;

    RecyclerView lstSunshineItem;
    LinearLayoutManager linearLayoutManager;
    List<ItemObject> itemObjects;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);
        cloudConnecting = new CloudConnecting();
        cloudUrl = new CloudUrl();

        getDate();
        linearLayoutManager = new LinearLayoutManager(this);
        lstSunshineItem = (RecyclerView) findViewById(R.id.lst_sunshine_item);
        lstSunshineItem.setLayoutManager(linearLayoutManager);

        itemObjects = new ArrayList<>();
        itemObjects.add(new ItemObject("Hari ini"));
        itemObjects.add(new ItemObject("Besoknya"));
        itemObjects.add(new ItemObject("Besoknya lagi"));
        itemObjects.add(new ItemObject("Lusa kemaren"));
        itemObjects.add(new ItemObject("Besoknya lusa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));
        itemObjects.add(new ItemObject("Udah gak tahu hari apa"));

        listAdapter = new ListAdapter(this, itemObjects);
        lstSunshineItem.setAdapter(listAdapter);


    }

    private void getDate(){
        cloudConnecting.getData(this, cloudUrl.getCurrentWeather("Jakarta"), new CloudResult() {
            @Override
            public void resultData(String response) {
                Log.d("TEST",response);
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void errorResultData(String errorResponse) {
                Log.d("ERROR",errorResponse);
            }
        });
    }

}
