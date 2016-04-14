package koti.palikka_projekti;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        //takaisin nappi vasemmassa yläkulmassa
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //yläpalkin toiminnallisuutta
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_logout:
                logOutListener();
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    //logout nappi, joka vie takaisin ensimmäiseen login activityyn..
    public void logOutListener() {
        Intent intent4 = new Intent(MainActivity4.this, MainActivity.class);
        //clearaa activity stackin uloskirjautuessa
        intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent4);
        finish();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();



        // Adding child data
        listDataHeader.add("Maanantai");
        listDataHeader.add("Tiistai");
        listDataHeader.add("Keskiviikko");
        listDataHeader.add("Torstai");
        listDataHeader.add("Perjantai");

        // Adding child data
        List<String> Maanantai = new ArrayList<String>();
        Maanantai.add("8.00-12.00 Jumppatunti \n Jani Kärkkäinen, Parkkipaikka");
        Maanantai.add("12.00-12.25 Vessatauko \n Tuure Kettunen, Vessa");
        Maanantai.add("12.30-16.00 Ruokatauko");


        List<String> Tiistai = new ArrayList<String>();
        Tiistai.add("8.00-12.00 Jumppatunti \n Jani Kärkkäinen, Parkkipaikka");

        List<String> Keskiviikko = new ArrayList<String>();
        Keskiviikko.add("8.00-12.00 Jumppatunti \n Jani Kärkkäinen, Parkkipaikka");

        List<String> Torstai = new ArrayList<String>();
        Torstai.add("8.00-12.00 Jumppatunti \n Jani Kärkkäinen, Parkkipaikka");

        List<String> Perjantai = new ArrayList<String>();
        Perjantai.add("8.00-12.00 Jumppatunti \n Jani Kärkkäinen, Parkkipaikka");

        listDataChild.put(listDataHeader.get(0), Maanantai); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Tiistai);
        listDataChild.put(listDataHeader.get(2), Keskiviikko);
        listDataChild.put(listDataHeader.get(3), Torstai);
        listDataChild.put(listDataHeader.get(4), Perjantai);
    }
}
