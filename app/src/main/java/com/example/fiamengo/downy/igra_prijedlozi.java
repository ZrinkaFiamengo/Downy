package com.example.fiamengo.downy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;


public class igra_prijedlozi extends FragmentActivity {

    DatabaseHandler db;
    int id;
    slike_info slika_iz_baze;
    int broj_tocnog;

    public static int randInt(int max)  //odaberi broj [1-max_id]
    {
        Random rand = new Random();
        return rand.nextInt(max)+1;
    }

    public void PostaviIzbore(int broj)
    {
        RadioButton izbor1=(RadioButton)findViewById(R.id.izbor1);
        RadioButton izbor2=(RadioButton)findViewById(R.id.izbor2);
        RadioButton izbor3=(RadioButton)findViewById(R.id.izbor3);
        slike_info random1;
        slike_info random2;

        id=randInt(db.maxPrijedlog());
        slika_iz_baze= db.getPrijedlog(id);

        ImageView image=(ImageView)findViewById(R.id.igra_prijedlozislika);
        int broj_slike = getResources().getIdentifier(slika_iz_baze.getputanja(), "drawable", getPackageName());
        image.setImageResource(broj_slike);

        do {
            random1 = db.getPrijedlog(randInt(db.maxPrijedlog()));
        }while(random1.getID()==slika_iz_baze.getID());

        do {
            random2 = db.getPrijedlog(randInt(db.maxPrijedlog()));
        }while(random2.getID()==slika_iz_baze.getID()||random2.getID()==random1.getID());

        if(broj==1)
        {
            izbor1.setText(slika_iz_baze.getnaziv());
            izbor2.setText(random1.getnaziv());
            izbor3.setText(random2.getnaziv());
        }
        else if(broj==2)
        {
            izbor2.setText(slika_iz_baze.getnaziv());
            izbor1.setText(random1.getnaziv());
            izbor3.setText(random2.getnaziv());
        }
        else if(broj==3)
        {
            izbor3.setText(slika_iz_baze.getnaziv());
            izbor1.setText(random1.getnaziv());
            izbor2.setText(random2.getnaziv());
        }
    }

    public void onRadioButtonClicked(View view) {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.izbor1:
                if (checked)
                    if(broj_tocnog==1)
                    {
                        alertDialog.setMessage("Bravo! Točan odgovor!");
                        alertDialog.setTitle(":)");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}});

                        broj_tocnog=randInt(3);
                        PostaviIzbore(broj_tocnog);
                    }
                    else
                    {
                        alertDialog.setMessage("Nije točno! Pokušaj ponovo!");
                        alertDialog.setTitle(":(");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}});
                    }
                    alertDialog.show();
                    break;
            case R.id.izbor2:
                if (checked)
                    if(broj_tocnog==2)
                    {
                        alertDialog.setMessage("Bravo! Točan odgovor!");
                        alertDialog.setTitle(":)");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}});

                        broj_tocnog=randInt(3);
                        PostaviIzbore(broj_tocnog);
                    }
                    else
                    {
                        alertDialog.setMessage("Nije točno! Pokušaj ponovo!");
                        alertDialog.setTitle(":(");
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}});
                    }
                alertDialog.show();
                break;
            case R.id.izbor3:
                if (checked)
                        if(broj_tocnog==3)
                        {
                            alertDialog.setMessage("Bravo! Točan odgovor!");
                            alertDialog.setTitle(":)");
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                            broj_tocnog = randInt(3);
                            PostaviIzbore(broj_tocnog);
                        }

                        else
                        {
                            alertDialog.setMessage("Nije točno! Pokušaj ponovo!");
                            alertDialog.setTitle(":(");
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {}});
                        }
                alertDialog.show();
                break;
        }
        RadioGroup grupa=(RadioGroup)findViewById(R.id.grupa);
        grupa.clearCheck();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra_prijedlozi);

        db = new DatabaseHandler(this);
        broj_tocnog=randInt(3);
        PostaviIzbore(broj_tocnog);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_igra_prijedlozi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
