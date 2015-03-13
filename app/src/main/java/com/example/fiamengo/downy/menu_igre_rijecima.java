package com.example.fiamengo.downy;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class menu_igre_rijecima extends FragmentActivity {

    public void Igra1OnClick(View v)
    {
        Intent intent = new Intent(this,igra1.class);
        startActivity(intent);
    }

    public void Igra2OnClick(View v)
    {
        Intent intent = new Intent(this,igra2.class);
        startActivity(intent);
    }

    public void Igra3OnClick(View v)
    {
        Intent intent = new Intent(this,igra3.class);
        startActivity(intent);
    }

    public void Igra4OnClick(View v)
    {
        Intent intent = new Intent(this,igra4.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_igre_rijecima);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_igre_rijecima, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
