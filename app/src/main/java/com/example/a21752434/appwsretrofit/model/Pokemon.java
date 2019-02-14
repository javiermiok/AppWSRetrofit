package com.example.a21752434.appwsretrofit.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Pokemon {

    private String nombre;
    private String url;

    public Pokemon(JSONObject jsonObj) {
        try {
            nombre = jsonObj.getString("name");
            url = jsonObj.getString("url");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
