package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class IOActivityExample extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_detail);

        //Implement back button in toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Get and use data from intent
        if (getIntent().hasExtra("pokemonName")) {
            TextView pokemonName = (TextView) findViewById(R.id.title);
            TextView pokemonDescription = (TextView) findViewById(R.id.description);
            pokemonName.setText(getIntent().getStringExtra("pokemonName"));

            //Display custom description according to pokemon name (since adding to model class is tedious process)
            //Pokemon Name: Latias
            if (getIntent().getStringExtra("pokemonName").equalsIgnoreCase("latias")) {
                pokemonDescription.setText(R.string.latias);
            }

            //Pokemon Name: Pokemon Mimikyu
            if (getIntent().getStringExtra("pokemonName").equalsIgnoreCase("pokemon mimikyu")) {
                pokemonDescription.setText(R.string.mimikyu);
            }

            //Pokemon Name: Pikachu
            if (getIntent().getStringExtra("pokemonName").equalsIgnoreCase("pikachu")) {
                pokemonDescription.setText(R.string.pikachu);
            }

            //Pokemon Name: Litten
            if (getIntent().getStringExtra("pokemonName").equalsIgnoreCase("litten")) {
                pokemonDescription.setText(R.string.litten);
            }

            //Pokemon Name: Squirtle
            if (getIntent().getStringExtra("pokemonName").equalsIgnoreCase("squirtle")) {
                pokemonDescription.setText(R.string.squirtle);
            }


        }

        if (getIntent().hasExtra("pokemonSpecies")) {
            TextView pokemonSpecies = (TextView) findViewById(R.id.subtitle);
            pokemonSpecies.setText(getIntent().getStringExtra("pokemonSpecies"));
        }

        if (getIntent().hasExtra("pokemonSprites")) {
            ImageView pokemonSprites = (ImageView) findViewById(R.id.ioexample_backdrop);
            Picasso.get().load(getIntent().getStringExtra("pokemonSprites")).into(pokemonSprites);
        }

    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, IOActivityExample.class));
    }
}