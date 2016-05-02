package com.example.lanas.seminairemai;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MyActivity extends Activity {


    RelativeLayout racine_arbre;

    // Déclaration des attribut graphique relatif au login
    EditText identifiant;
    EditText password;
    Button login;
    TextView login_explication;
    RelativeLayout menu_login;

    // Déclaration des attribut graphique relatif au menu des actions
    String pathName;
    RelativeLayout menu_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        racine_arbre = (RelativeLayout) findViewById(R.id.racine_arbre);

        // Affectation des identités relatives au login
        identifiant = (EditText) findViewById(R.id.identifiant);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login_explication = (TextView) findViewById(R.id.login_explication);
        menu_login = (RelativeLayout) findViewById(R.id.menu_login);

        // Affectation des identités relative au menu des actions

        menu_action = (RelativeLayout) findViewById(R.id.menu_action);

        // Méthode permettant la validation du mots de passe et de l'identifiant.

        login.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public  void onClick(View v) {

                String id = identifiant.getText().toString();
                String pass = password.getText().toString();

                if (id.compareTo("admin") == 0){

                    if (pass.compareTo("admin") == 0){
                        menu_login.setVisibility(v.INVISIBLE);
                        menu_action.setVisibility((v.VISIBLE));

                        pathName = "drawable/menu_action.png";
                        racine_arbre.setBackgroundResource(R.drawable.menu_action);
                        identifiant.setText("identifiant");
                        password.setText("Password");
                    }
                    else{

                        login_explication.setText("@string/pass_faux");
                        login_explication.setVisibility(v.VISIBLE);
                    }
                }
                else {
                    login_explication.setText("@string/id_faux");
                    login_explication.setVisibility(v.VISIBLE);
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings1) {
            menu_action.setVisibility(View.INVISIBLE);
            menu_login.setVisibility(View.VISIBLE);
            racine_arbre.setBackgroundResource(R.drawable.login);
        }
        return super.onOptionsItemSelected(item);
    }
}
