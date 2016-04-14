package koti.palikka_projekti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private static Button Food_Button;
    private static Button Timetable_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FoodListener();
        TimetableListener();
    }

    //yläpalkki
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //yläpalkin toiminnallisuutta
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_logout) {
            logOutListener();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //logout nappi, joka vie takaisin ensimmäiseen login activityyn..
    public void logOutListener() {
        Intent intent4 = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent4);
        finish();
    }
    //Ruoka-napin joka vie seuraavaan näkymään
    public void FoodListener() {
        Food_Button = (Button) findViewById(R.id.foodButton);
        Food_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent3);
                    }

                }
        );
    }
    //lukujärjestys-nappi joka vie seuraavaan näkymään
    public void TimetableListener() {
        Timetable_Button = (Button) findViewById(R.id.timeTableButton);
        Timetable_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent4 = new Intent(MainActivity2.this, MainActivity4.class);
                        startActivity(intent4);
                    }
                }
        );
    }
    //disabloi puhelimen back napin
    @Override
    public void onBackPressed(){
    }
}
