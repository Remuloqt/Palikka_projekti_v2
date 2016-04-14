package koti.palikka_projekti;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button login_Button;

    //kirjautumissysteemi
    public void loginListener(){
        login_Button = (Button) findViewById(R.id.loginButton);
        final EditText name_id = (EditText) findViewById(R.id.nameField);
        final EditText pass_id = (EditText) findViewById(R.id.passwordField);
        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        login_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //voisi implementoida database haun jos olisi database...
                        if (name_id.getText().toString().equals(" . ") && pass_id.getText().toString().equals(".")) {
                            Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                            String firstName = " ";
                            String lastName = " ";
                            intent2.putExtra("name", firstName);
                            intent2.putExtra("surname", lastName);
                            Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
                            startActivity(intent2);
                            finish();
                        } else {
                            dlgAlert.setMessage("Wrong username or password.");
                            dlgAlert.setTitle("Error Message...");
                            dlgAlert.setPositiveButton("OK", null);
                            dlgAlert.setCancelable(true);
                            dlgAlert.create().show();
                        }
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loginListener();
        }
}
