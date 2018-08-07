package com.example.surainrsinnasamy.makingminiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private PokemonModelClass pokemonModelClassList;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //Get and use data from intent
        if (getIntent().hasExtra("pokemonHeight")) {
            TextView pokemonHeight = (TextView) findViewById(R.id.childRightText2);
            pokemonHeight.setText("" + getIntent().getIntExtra("pokemonHeight", 0));
        }


        if (getIntent().hasExtra("pokemonName")) {
            TextView pokemonName = (TextView) findViewById(R.id.pokemonName);
            pokemonName.setText(getIntent().getStringExtra("pokemonName"));
        }

        if (getIntent().hasExtra("pokemonWeight")) {
            TextView pokemonWeight = (TextView) findViewById(R.id.childRightText3);
            pokemonWeight.setText("" + getIntent().getIntExtra("pokemonWeight", 0));
        }

        if (getIntent().hasExtra("pokemonAbility")) {
            TextView pokemonBaseExperience = (TextView) findViewById(R.id.childRightText4);
            pokemonBaseExperience.setText("" + getIntent().getIntExtra("pokemonAbility", 0));
        }

        if (getIntent().hasExtra("pokemonSpecies")) {
            TextView pokemonSpecies = (TextView) findViewById(R.id.childRightText5);
            pokemonSpecies.setText(getIntent().getStringExtra("pokemonSpecies"));
        }

        if (getIntent().hasExtra("pokemonSprites")) {
            ImageView pokemonSprites = (ImageView) findViewById(R.id.image);
            Picasso.get().load(getIntent().getStringExtra("pokemonSprites")).into(pokemonSprites);
        }
    }
}
