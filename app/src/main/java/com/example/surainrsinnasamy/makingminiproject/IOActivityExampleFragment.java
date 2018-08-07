package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class IOActivityExampleFragment extends Fragment {

    public IOActivityExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        //Get and use data from intent
        if (getActivity().getIntent().hasExtra("pokemonName")) {
            TextView pokemonName = (TextView) getActivity().findViewById(R.id.title);
            TextView pokemonDescription = (TextView) getActivity().findViewById(R.id.description);
            pokemonName.setText(getActivity().getIntent().getStringExtra("pokemonName"));

            //Display custom description according to pokemon name (since adding to model class is tedious process)
            //Pokemon Name: Latias
            if (getActivity().getIntent().getStringExtra("pokemonName").equalsIgnoreCase("latias")) {
                pokemonDescription.setText(R.string.latias);
            }

            //Pokemon Name: Pokemon Mimikyu
            if (getActivity().getIntent().getStringExtra("pokemonName").equalsIgnoreCase("pokemon mimikyu")) {
                pokemonDescription.setText(R.string.mimikyu);
            }

            //Pokemon Name: Pikachu
            if (getActivity().getIntent().getStringExtra("pokemonName").equalsIgnoreCase("pikachu")) {
                pokemonDescription.setText(R.string.pikachu);
            }

            //Pokemon Name: Litten
            if (getActivity().getIntent().getStringExtra("pokemonName").equalsIgnoreCase("litten")) {
                pokemonDescription.setText(R.string.litten);
            }

            //Pokemon Name: Squirtle
            if (getActivity().getIntent().getStringExtra("pokemonName").equalsIgnoreCase("squirtle")) {
                pokemonDescription.setText(R.string.squirtle);
            }
        }

        if (getActivity().getIntent().hasExtra("pokemonSpecies")) {
            TextView pokemonSpecies = (TextView) getActivity().findViewById(R.id.subtitle);
            pokemonSpecies.setText(getActivity().getIntent().getStringExtra("pokemonSpecies"));
        }

        if (getActivity().getIntent().hasExtra("pokemonSprites")) {
            ImageView pokemonSprites = (ImageView) getActivity().findViewById(R.id.ioexample_backdrop);
            Picasso.get().load(getActivity().getIntent().getStringExtra("pokemonSprites")).into(pokemonSprites);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_io_detail, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
