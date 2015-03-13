package com.example.fiamengo.downy;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;



public class igra2 extends FragmentActivity { //fragment jer ne želim traku s nazivom activityja na vrhu

    DatabaseHandler db; //varijabla za vezu s bazom
    int id; //id trenutno odabrane slike
    slike_info slika_iz_baze;   //podaci o trenutno odabranoj slici
    int level;    //trenutna tezina
    int[] max_id = new int[4]; //ukupan broj redaka u tablici na trenutnoj tezini
    /*Ova igra nema razine težine, tj. sve riječi se boduju jednako, po 5 bodova.
    Ostala pravila ostaju ista kao i u drugim igrama, tj.
    -preskoćena riječ oduzima 5 bodova,
    -pogreška smanjuje dobitak riječi u rasponu [1,5], tj za točnu riječ nije moguće dobiti manje od jednog boda*/
    int broj_bodova=0;
    int trenutno_bodova;


    public static int randInt(int max)  //odaberi broj [1-max_id]
    {
        Random rand = new Random();
        return rand.nextInt(max)+1;
    }


    public void KrajOnClick()
    {
        //prikaz osvojenih bodova
        Context context = getApplicationContext();
        CharSequence text;
        if(broj_bodova%10==1)
            text= "Osvojio si "+broj_bodova+" bod";
        else if(broj_bodova%10>1&&broj_bodova%10<5)
            text = "Osvojio si "+broj_bodova+" boda";
        else
            text = "Osvojio si "+broj_bodova+" bodova";
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();

        //povratak na glavni izbornik
        Intent intent = new Intent(this,main.class);
        startActivity(intent);

    }



    public void Postavi()   //postavi novu sliku
    {
        //dohvati objekt slike
        ImageView image=(ImageView)findViewById(R.id.igra2slika);

        level=randInt(3); //biramo random tablicu
        id=randInt(max_id[level]);  //random odaberi id nove slike na trenutnoj razini tezine
        slika_iz_baze= db.getSlika(id, level);  //procitaj podatke o odabranoj slici iz baze

        //promijeni sliku
        int broj_slike = getResources().getIdentifier(slika_iz_baze.getputanja(), "drawable", getPackageName());
        image.setImageResource(broj_slike);

        //inicijalno je za svaku rijec moguce dobiti maximalno bodova
        trenutno_bodova=5;
    }


    public void Igra2OnClickPotvrdi (View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        //dohvati tekst koji je korisnik unio
        final EditText edittext = (EditText) findViewById(R.id.igra2unos);
        String unesena_vrijednost = edittext.getText().toString().toLowerCase();


        //provjeri da korisnik nije pokušao potvrditi prije unosa
        if (unesena_vrijednost.length() == 0) {
            //obavijesti korisnika da je pogrijesio
            alertDialog.setMessage("Nisi unio odgovor!");
            alertDialog.setTitle(":(");
            //postavi OK tipku
            alertDialog.setButton("Pokušaj ponovo!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        } else {
                //uzmi prvo slovo iz rijeci iz baze i iz korisnickog unosa
                String prvo_slovo_unosa = unesena_vrijednost.substring(0, 1);
                String prvo_slovo_rijeci = (slika_iz_baze.getnaziv()).substring(0, 1);


                //usporedi prvo slovo trazene rijeci i prvo slovo unosa
                if (prvo_slovo_rijeci.contentEquals(prvo_slovo_unosa)) {
                    //ako je korisnik unio tocnu vrijednost
                    //pribroji osvojene bodove ukupnom broju
                    broj_bodova += trenutno_bodova;
                    //postavi pozdravnu poruku
                    alertDialog.setMessage("Bravo! " + prvo_slovo_unosa + "-" + slika_iz_baze.getnaziv() + " je točan odgovor!");
                    alertDialog.setTitle(slika_iz_baze.getnaziv());
                    //izbrisi tekst koji je korisnik unio
                    edittext.setText("");
                    //ponudi korisniku da zavrsi igru
                    alertDialog.setButton("Kraj igre!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // vrati se na glavni izbornik
                            KrajOnClick();
                        }
                    });
                    //postavi OK tipku
                    alertDialog.setButton2("Igraj dalje!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Postavi(); //postavi sljedeću sliku
                        }
                    });

                } else {
                    //obavijesti korisnika da je pogrijesio
                    alertDialog.setMessage("Nije točno!");
                    alertDialog.setTitle(":(");

                    //izbrisi tekst koji je korisnik unio
                    edittext.setText("");

                    //svaka pogreska smanjuje broj bodova za 1
                    if (trenutno_bodova > 1) //da prevelik broj pogreski ne bi izazvao dodavanje negativnih bodova
                        trenutno_bodova--;
                    //postavi OK tipku
                    alertDialog.setButton("Pokušaj ponovo!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alertDialog.setButton2("Promijeni sliku!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Postavi();//postavi novu sliku
                            broj_bodova -= 5;
                        }
                    });
                }
                //prikazi dijalog
                alertDialog.show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra2);

        db = new DatabaseHandler(this); //stvori konekciju s bazom
        max_id[0]=0; //radi jednostavnosti ne koristimo ovu vrijednost
        max_id[1]=db.maxSlike(1); //postavi ukupan broj redaka u tablici na laganoj tezini
        max_id[2]=db.maxSlike(2); //postavi ukupan broj redaka u tablici na srednjoj tezini
        max_id[3]=db.maxSlike(3); //postavi ukupan broj redaka u tablici na srednjoj tezini
        Postavi();
    }

//MENU

    public void Prikazi_pomoc ()    //funkcija za prikaz pomoci
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();   //koristi alert dialog
        alertDialog.setMessage("Cilj igre je pogoditi prvo slovo riječi na slici.\n\n"+
                "Pogodak riječi nosi 5 bodova.\n" +
                "Svaka pogrješka smanjuje broj bodova za tu riječ za 1 bod do najmanje jednog boda.\n" +
                "Svaka preskocena riječ smanjuje ukupni osvojeni broj bodova za 5.");
        alertDialog.setTitle("Pomoć");
        //postavi OK tipku
        alertDialog.setButton2("Igraj dalje!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_igra2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //pokreni akciju ovisno o opciji koju korisnik odabere
        if (id == R.id.pomoc) {
            Prikazi_pomoc();
            return true;
        }
        if (id == R.id.kraj_igre) {
            KrajOnClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
