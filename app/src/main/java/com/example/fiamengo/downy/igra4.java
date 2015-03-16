package com.example.fiamengo.downy;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;



public class igra4 extends FragmentActivity { //fragment jer ne želim traku s nazivom activityja na vrhu

    DatabaseHandler db; //varijabla za vezu s bazom
    int id; //id trenutno odabrane slike
    slike_info slika_iz_baze;   //podaci o trenutno odabranoj slici
    int level=1;    //trenutna tezina-igra pocinje s laganom tezinom
    int max_id; //ukupan broj redaka u tablici na trenutnoj tezini
    int duljina; //duljina trenutno odabrane riječi
    /*pogodak na "lagano" nosi 5 bodova, na "srednje" 10 i na "teško" 15
    Svaka pogrješka smanjuje broj bodova za tu riječ za 1 bod.
    Minimalno koliko pogodjena rijec moze vrijediti je 1 bod, tj nemoguce je pogoditi rijec i za nju dobiti negativne bodove
    Svaka preskocena rijec smanjuje ukupni osvojeni broj bodova za 5 (moguc "kazneni" negativan ukupni broj bodova)*/
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
        //dohvati objekt slike i teksta ostatka riječi
        ImageView image=(ImageView)findViewById(R.id.igra4slika);
        TextView text=(TextView)findViewById(R.id.igra4kraj_rijeci);


        id=randInt(max_id);  //random odaberi id nove slike na trenutnoj razini tezine
        slika_iz_baze= db.getSlika(id, level);  //procitaj podatke o odabranoj slici iz baze

        //promijeni sliku
        int broj_slike = getResources().getIdentifier(slika_iz_baze.getputanja(), "drawable", getPackageName());
        image.setImageResource(broj_slike);

        //postavi ostatak riječi
        duljina= slika_iz_baze.getnaziv().length();
        text.setText(slika_iz_baze.getnaziv().substring(3, duljina));

        //promijeni naslov
        TextView naslov=(TextView)findViewById(R.id.igra4opis);
        if(level==1)
            naslov.setText("Što je na slici? (Razina 1)");
        else if(level==2)
            naslov.setText("Što je na slici? (Razina 2)");
        else
            naslov.setText("Što je na slici? (Razina 3)");



        //inicijalno je za svaku rijec moguce dobiti maximalno bodova
        trenutno_bodova=5*level;
    }


    public void Igra4OnClickPotvrdi (View v)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        //dohvati tekst koji je korisnik unio
        final EditText edittext = (EditText) findViewById(R.id.igra4unos);
        String unesena_vrijednost = edittext.getText().toString().toLowerCase();

        String kraj_rijeci= (slika_iz_baze.getnaziv()).substring(0,3);


        if (kraj_rijeci.contentEquals(unesena_vrijednost))
        {
            //ako je korisnik unio tocna prva tri slova
            //pribroji osvojene bodove ukupnom broju
            broj_bodova+=trenutno_bodova;
            //postavi pozdravnu poruku
            alertDialog.setMessage("Bravo! " + slika_iz_baze.getnaziv() + " je točan odgovor!");
            alertDialog.setTitle(":)");
            //izbrisi tekst koji je korisnik unio
            edittext.setText("");

            if(level==1||level==2)
            {
                //ponudi korisniku da poveca razinu
                alertDialog.setButton("Povećaj težinu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        level++;
                        max_id=db.maxSlike(level); //postavi ukupan broj redaka u tablici na trenutnoj tezini
                        Postavi(); //postavi sljedeću sliku vece tezine
                    }
                });
            }
            else //ako je tezina vec maksimalna
            {
                //ponudi korisniku da zavrsi igru
                alertDialog.setButton("Kraj igre!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // vrati se na glavni izbornik
                        KrajOnClick();
                    }
                });
            }
            //postavi OK tipku
            alertDialog.setButton2("Igraj dalje!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Postavi(); //postavi sljedeću sliku iste težine
                }
            });

        }
        else
        {
            //obavijesti korisnika da je pogrijesio
            alertDialog.setMessage("Nije točno!");
            alertDialog.setTitle(":(");


            //svaka pogreska smanjuje broj bodova za 1
            if(trenutno_bodova>1) //da prevelik broj pogreski ne bi izazvao dodavanje negativnih bodova
                trenutno_bodova--;
            //postavi OK tipku
            alertDialog.setButton("Pokušaj ponovo!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.setButton2("Promijeni sliku!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //izbrisi tekst koji je korisnik unio
                    edittext.setText("");
                    Postavi();//postavi novu sliku
                    broj_bodova-=5;
                }
            });
        }
        //prikazi dijalog
        alertDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra4);

        db = new DatabaseHandler(this); //stvori konekciju s bazom
        max_id=db.maxSlike(level); //postavi ukupan broj redaka u tablici na trenutnoj tezini
        Postavi();
    }


//MENU

    public void Prikazi_pomoc ()    //funkcija za prikaz pomoci
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();   //koristi alert dialog
        alertDialog.setMessage("Cilj igre je točno napisati riječ na slici.\n\n"+
                "Pogodak na \"lagano\" nosi 5 bodova, na \"srednje\" 10 i na \"teško\" 15.\n" +
                "Svaka pogrješka smanjuje broj bodova za tu riječ za 1 bod do najmanje jednog boda.\n" +
                "Svaka preskočena riječ smanjuje ukupni osvojeni broj bodova za 5.");
        alertDialog.setTitle("Pomoć");
        //postavi OK tipku
        alertDialog.setButton2("Igraj dalje!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    public void Promijeni_razinu()  //funkcija za promjenu trenutne razine
    {
        final Dialog d = new Dialog(igra4.this);    //deklaracija i inicijalizacija novog dijaloga u trenutnom activitiju
        d.setTitle("Odaberi razinu");   //postavi naslov dijaloga
        d.setContentView(R.layout.dialog);  //povezi dijalog s xml layoutom
        //povezi tipke u dijalogu
        Button b1 = (Button) d.findViewById(R.id.button1);//=postavi
        Button b2 = (Button) d.findViewById(R.id.button2);//=odustani
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker);  //povezi number picker
        np.setMaxValue(3); // najveca razina koju mozes odabrati je 3
        np.setMinValue(1);   // najmanja razina koju mozes odabrati je 1
        //kada korisnik klikne na potvrdi
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                level=np.getValue();    //postavi level na odabrani
                max_id=db.maxSlike(level); //postavi ukupan broj redaka u tablici na trenutnoj tezini
                Postavi();  //postavi novu sliku odabrane tezine
                d.dismiss();    //zatvori dijalog
            }
        });
        //kada korisnik klikne na odustani
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss(); // zatvori dijalog
            }
        });
        d.show();   //prikazi dijalog
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_igra4, menu);
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
        if (id == R.id.promijeni_razinu) {
            Promijeni_razinu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
