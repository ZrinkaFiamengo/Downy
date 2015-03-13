package com.example.fiamengo.downy;

public class slike_info {

    //private variables
    int _id;
    String _naziv;
    String _putanja;

    // Empty constructor
    public slike_info(){

    }

    // constructor
    public slike_info(int _id, String naziv, String putanja){
        this._id = _id;
        this._naziv = naziv;
        this._putanja = putanja;
    }

    // constructor
    public slike_info(String naziv, String putanja){
        this._naziv = naziv;
        this._putanja = putanja;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // getting naziv
    public String getnaziv(){
        return this._naziv;
    }


    // getting phone number
    public String getputanja(){
        return this._putanja;
    }

}