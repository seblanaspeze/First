package com.example.lanas.seminairemai;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import CodeSource.Dressing.Dressing;
import CodeSource.Dressing.ScenarioSem3;
import CodeSource.Vetement.Vetement;


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
    Button dressing;

    //Declaration des attribut graphique relatif au menu du dressing
    RelativeLayout menu_dressing;
    Button favori;
    Button type;
    Button couleur;
    Button multiple;
    ListView resultatTrie;

    // Declaration des attributs relatif au bluetooth
    RelativeLayout menu_bluetooth;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

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
        dressing = (Button) findViewById(R.id.dressing);

        // Affectation des identités relative au menu du dressing
        menu_dressing = (RelativeLayout) findViewById(R.id.menu_dressing);
        favori = (Button) findViewById(R.id.favoris);
        type = (Button) findViewById(R.id.type);
        couleur = (Button) findViewById(R.id.couleur);
        multiple = (Button) findViewById(R.id.multiple);
        resultatTrie = (ListView) findViewById(R.id.resultatTrie);


        //Initialisation des relative layout
        menu_login.setVisibility(View.VISIBLE);
        menu_action.setVisibility(View.INVISIBLE);
        menu_dressing.setVisibility(View.INVISIBLE);

        //initialisation bluetooth

        // Initialisation du scenario

        final Dressing monDressing = ScenarioSem3.senario();
        final ArrayList<String> trie1 = new ArrayList<String>();
        final ArrayAdapter<String> liste = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,trie1);

        // Initialisation du bluetooth

        BA = BluetoothAdapter.getDefaultAdapter();

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

        dressing.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                menu_action.setVisibility(v.INVISIBLE);
                racine_arbre.setBackgroundResource(R.drawable.dressing);
                menu_dressing.setVisibility(v.VISIBLE);
            }
        });

        favori.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ArrayList<Vetement> trie = monDressing.trieFavori();


                int s = trie.size();
                for (int i = 0; i < s; i++){
                    trie1.add(trie.get(i).getNom());
                    System.out.println("favori");
                }
                trie1.add("Retour");

                resultatTrie.setAdapter(liste);
                menu_dressing.setVisibility(v.INVISIBLE);
            }
        });

        resultatTrie.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id){

                String mot = (String) av.getItemAtPosition(pos);

                if (mot.compareTo("Retour") == 0){

                    resultatTrie.setVisibility(v.INVISIBLE);
                    menu_dressing.setVisibility(v.VISIBLE);
                    trie1.clear();
                }

            }
        });
    }


    public void on(View v){
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(), "Turned on", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Already on", Toast.LENGTH_LONG).show();
        }


    }

    public void off(View v){
        BA.disable();
        Toast.makeText(getApplicationContext(),"Turned off" ,Toast.LENGTH_LONG).show();
    }

    public  void visible(View v){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }

    public void list(View v){
        pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();

        for(BluetoothDevice bt : pairedDevices)
            list.add(bt.getName());
        Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        resultatTrie.setAdapter(adapter);
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
        racine_arbre = (RelativeLayout) findViewById(R.id.racine_arbre);
        if (id == R.id.action_settings1) {
            menu_action.setVisibility(View.INVISIBLE);
            menu_login.setVisibility(View.VISIBLE);
            racine_arbre.setBackgroundResource(R.drawable.login);
        }
        if (id == R.id.action_settings2 ){

            menu_dressing.setVisibility(View.INVISIBLE);
            menu_login.setVisibility(View.INVISIBLE);
            menu_action.setVisibility(View.INVISIBLE);





        }
        return super.onOptionsItemSelected(item);
    }
}
