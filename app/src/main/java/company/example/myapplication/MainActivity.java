package company.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends ActionBarActivity   {

    private ShareActionProvider mShareActionProvider;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nombre";
    public static final String LastName = "apellido";
    EditText nombre;
    //capmpos de texto
    TextView etiqueta_nombre;
    private String labelN;
    String filename = "myfile";
    String string = "Hello world!";
    private String file = "mydata";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(prefs !=null)
        {
             labelN = prefs.getString("nombre", null);
            etiqueta_nombre = (TextView) findViewById(R.id.name_label);
            etiqueta_nombre.setText(labelN);

        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "File already created on the storage", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "my string");
        intent.putExtra(Intent.EXTRA_TEXT, "another string");
        mShareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    public void guardar(View v)
    {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //obteniendo los nombres de los edittext
        nombre = (EditText) findViewById(R.id.nombre);
        String va =nombre.getText().toString();
        //setting the text
        etiqueta_nombre = (TextView) findViewById(R.id.name_label);
        etiqueta_nombre.setText(va);

        editor.putString(Name, va);
        editor.commit();
        Toast.makeText(MainActivity.this,"Thanks", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {

        //TODO use this method to use the shared preferences
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //obteniendo los nombres de los edittext
        nombre = (EditText) findViewById(R.id.nombre);
        String va =nombre.getText().toString();
        //setting the text
        etiqueta_nombre = (TextView) findViewById(R.id.name_label);
        etiqueta_nombre.setText(va);

        editor.putString(Name, va);
        editor.commit();
        super.onStop();

    }
    public void guardaInterno(View view){

        EditText textS = (EditText) findViewById(R.id.textSave);
        String data = textS.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
        }

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void leerInterno(View view) {
        EditText ponlo = (EditText) findViewById(R.id.textSave);
        try {
            FileInputStream fin = openFileInput(file);
            int c;
            String temp = "";

            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            ponlo.setText(temp);
            Toast.makeText(getBaseContext(), "file read", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }
}
