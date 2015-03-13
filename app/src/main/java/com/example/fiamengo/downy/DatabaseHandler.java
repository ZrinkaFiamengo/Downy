package com.example.fiamengo.downy;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
        // All Static variables
        // Database Version
        private static final int DATABASE_VERSION = 1;

        // Database Name
        private static final String DATABASE_NAME = "Downy_DB";

        // Table name
        private static final String TABLE_RIJECI1 = "rijeci_lagano";
        private static final String TABLE_RIJECI2 = "rijeci_srednje";
        private static final String TABLE_RIJECI3 = "rijeci_tesko";
        private static final String TABLE_PRIJEDLOZI="prijedlozi";

        // Contacts Table Columns names
        private static final String KEY_ID = "_id";
        private static final String KEY_NAZIV = "naziv";
        private static final String KEY_PUTANJA = "putanja";

        private static final String[] COLUMNS = {KEY_ID,KEY_NAZIV,KEY_PUTANJA};

        public DatabaseHandler(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
                }

        // Creating Tables
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_RIJECI1_TABLE ="CREATE TABLE IF NOT EXISTS "+TABLE_RIJECI1 +" ( "+KEY_ID+" INTEGER PRIMARY KEY NOT NULL, "+KEY_NAZIV+" TEXT NOT NULL,"+KEY_PUTANJA+" TEXT NOT NULL)";
                db.execSQL(CREATE_RIJECI1_TABLE);
                String ADD_TO_DATABASE;
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (1, 'auto', 'auto')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (2, 'beba', 'beba')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (3, 'boca', 'boca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (4, 'boja', 'boja')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (5, 'bor', 'bor')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (6, 'dječak', 'djecak')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (7, 'duga', 'duga')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (8, 'dupin', 'dupin')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (9, 'golub', 'golub')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (10, 'jabuka', 'jabuka')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (11, 'jagoda', 'jagoda')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (12, 'jaje', 'jaje')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (13, 'jelen', 'jelen')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (14, 'jež', 'jez')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (15, 'kamen', 'kamen')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (16, 'kiša', 'kisa')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (17, 'ključ', 'kljuc')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (18, 'kokoš', 'kokos')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (19, 'konj', 'konj')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (20, 'koza', 'koza')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (21, 'kuća', 'kuca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (22, 'lav', 'lav')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (23, 'limun', 'limun')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (24, 'medo', 'medo')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (25, 'miš', 'mis')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (26, 'noga', 'noga')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (27, 'noj', 'noj')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (28, 'nož', 'noz')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (29, 'oči', 'oci')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (30, 'otok', 'otok')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (31, 'pas', 'pas')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (32, 'pile', 'pile')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (33, 'riba', 'riba')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (34, 'roda', 'roda')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (35, 'ruka', 'ruka')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (36, 'ruža', 'ruza')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (37, 'sir', 'sir')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (38, 'stol', 'stol')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (39, 'tava', 'tava')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (40, 'žaba', 'zaba')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_lagano (_id, Naziv, Putanja) VALUES (41, 'zec', 'zec')"; db.execSQL(ADD_TO_DATABASE);

            String CREATE_RIJECI2_TABLE ="CREATE TABLE IF NOT EXISTS "+TABLE_RIJECI2 +" ( "+KEY_ID+" INTEGER PRIMARY KEY NOT NULL, "+KEY_NAZIV+" TEXT NOT NULL,"+KEY_PUTANJA+" TEXT NOT NULL)";
            db.execSQL(CREATE_RIJECI2_TABLE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (1, 'avion', 'avion')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (2, 'češalj', 'cesalj')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (3, 'djevojčica', 'djevojcica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (4, 'dvorac', 'dvorac')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (5, 'gitara', 'gitara')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (6, 'gumica', 'gumica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (7, 'haljina', 'haljina')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (8, 'kamion', 'kamion')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (9, 'karte', 'karte')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (10, 'knjiga', 'knjiga')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (11, 'krava', 'krava')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (12, 'majica', 'majica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (13, 'mjesec', 'mjesec')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (14, 'olovka', 'olovka')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (15, 'paun', 'paun')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (16, 'šešir', 'sesir')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (17, 'stolica', 'stolica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (18, 'svijeća', 'svijeca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (19, 'svinja', 'svinja')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (20, 'tigar', 'tigar')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (21, 'trava', 'trava')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (22, 'trešnja', 'tresnja')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (23, 'tuljan', 'tuljan')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (24, 'vatra', 'vatra')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (25, 'violina', 'violina')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (26, 'vrata', 'vrata')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (27, 'zebra', 'zebra')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (28, 'zemlja', 'zemlja')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_srednje (_id, Naziv, Putanja) VALUES (29, 'žirafa', 'zirafa')"; db.execSQL(ADD_TO_DATABASE);

            String CREATE_RIJECI3_TABLE ="CREATE TABLE IF NOT EXISTS "+TABLE_RIJECI3 +" ( "+KEY_ID+" INTEGER PRIMARY KEY NOT NULL, "+KEY_NAZIV+" TEXT NOT NULL,"+KEY_PUTANJA+" TEXT NOT NULL)";
            db.execSQL(CREATE_RIJECI3_TABLE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (1, 'ananas', 'ananas')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (2, 'brod', 'brod')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (3, 'bubamara', 'bubamara')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (4, 'bubanj', 'bubanj')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (5, 'bundeva', 'bundeva')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (6, 'čarobnjak', 'carobnjak')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (7, 'čizme', 'cizme')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (8, 'cvijet', 'cvijet')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (9, 'dinosaur', 'dinosaur')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (10, 'gljiva', 'gljiva')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (11, 'grožđe', 'grozde')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (12, 'gušter', 'guster')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (13, 'helikopter', 'helikopter')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (14, 'hladnjak', 'hladnjak')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (15, 'hobotnica', 'hobotnica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (16, 'kišobran', 'kisobran')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (17, 'kist', 'kist')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (18, 'kornjača', 'kornjaca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (19, 'krokodil', 'krokodil')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (20, 'kruška', 'kruska')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (21, 'kukuruz', 'kukuruz')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (22, 'leptir', 'leptir')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (23, 'limunada', 'limunada')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (24, 'lopta', 'lopta')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (25, 'lubenica', 'lubenica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (26, 'mačka', 'macka')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (27, 'magarac', 'magarac')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (28, 'majmun', 'majmun')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (29, 'mornar', 'mornar')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (30, 'mrkva', 'mrkva')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (31, 'naočale', 'naocale')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (32, 'naranča', 'naranca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (33, 'oblak', 'oblak')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (34, 'ormar', 'ormar')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (35, 'ovca', 'ovca')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (36, 'palma', 'palma')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (37, 'paprika', 'paprika')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (38, 'patka', 'patka')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (39, 'panda', 'panda')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (40, 'pingvin', 'pingvin')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (41, 'prozor', 'prozor')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (42, 'ptica', 'ptica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (43, 'računalo', 'racunalo')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (44, 'sendvič', 'sendvic')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (45, 'sladoled', 'sladoled')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (46, 'srce', 'srce')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (47, 'stablo', 'stablo')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (48, 'sunce', 'sunce')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (49, 'televizija', 'televizija')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (50, 'tenisice', 'tenisice')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (51, 'torba', 'torba')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (52, 'usta', 'usta')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (53, 'vješalica', 'vjesalica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (54, 'žlica', 'zlica')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (55, 'zmaj', 'zmaj')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (56, 'zmija', 'zmija')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE ="INSERT INTO rijeci_tesko (_id, Naziv, Putanja) VALUES (57, 'zvijezda', 'zvijezda')"; db.execSQL(ADD_TO_DATABASE);


            String CREATE_PRIJEDLOZI_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_PRIJEDLOZI+" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+KEY_NAZIV+" TEXT NOT NULL, "+KEY_PUTANJA+" TEXT NOT NULL)";
                db.execSQL(CREATE_PRIJEDLOZI_TABLE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (1, 'ispod', 'ispod')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (2, 'ispred', 'ispred')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (3, 'iza', 'iza')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (4, 'između', 'izmedu')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (5, 'iznad', 'iznad')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (6, 'na', 'na')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (7, 'pored', 'pored')"; db.execSQL(ADD_TO_DATABASE);
                ADD_TO_DATABASE="INSERT INTO prijedlozi (_id, Naziv, Putanja) VALUES (8, 'u', 'u')"; db.execSQL(ADD_TO_DATABASE);

        }

        // Upgrading database
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // Drop older table if existed
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_RIJECI1);
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_RIJECI2);
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_RIJECI2);
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRIJEDLOZI);

                // Create tables again
                onCreate(db);
                }

        public slike_info getSlika(int _id, int tezina){

            // 1. get reference to readable DB
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor;

            // 2. build query
            if(tezina==1) {
                cursor =
                        db.query(TABLE_RIJECI1, // a. table
                                COLUMNS, // b. column names
                                " _id = ?", // c. selections
                                new String[]{String.valueOf(_id)}, // d. selections args
                                null, // e. group by
                                null, // f. having
                                null, // g. order by
                                null); // h. limit
            }
            else if(tezina==2) {
                cursor = db.query(TABLE_RIJECI2, COLUMNS, " _id = ?", new String[]{String.valueOf(_id)}, null, null,null, null);
            }
            else {
                cursor = db.query(TABLE_RIJECI3, COLUMNS, " _id = ?", new String[]{String.valueOf(_id)}, null, null,null, null);
            }

            if (cursor != null)
                cursor.moveToFirst();

            slike_info slika = new slike_info(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

            // 5. return
            return slika;
        }

    public slike_info getPrijedlog(int _id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRIJEDLOZI, COLUMNS, " _id = ?", new String[]{String.valueOf(_id)}, null, null,null, null);

        if (cursor != null)
            cursor.moveToFirst();

        slike_info slika = new slike_info(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        return slika;
    }

    public int maxSlike(int tezina)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        if(tezina==1)
            cursor=db.rawQuery("SELECT MAX(_id) FROM rijeci_lagano", null);
        else if(tezina==2)
            cursor=db.rawQuery("SELECT MAX(_id) FROM rijeci_srednje", null);
        else
            cursor=db.rawQuery("SELECT MAX(_id) FROM rijeci_tesko", null);
        if (cursor != null)
            cursor.moveToFirst();
        return Integer.parseInt(cursor.getString(0));
    }

    public int maxPrijedlog()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT MAX(_id) FROM prijedlozi", null);
        if (cursor != null)
            cursor.moveToFirst();
        return Integer.parseInt(cursor.getString(0));
    }
}
