package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class CreatePokemonFragment extends Fragment implements OnItemClick {

    private List<String> PokemonList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PokemonImageAdapter mAdapter;
    RadioGroup radioGroup;
    Button btnDisplay;
    RadioButton radioButton;
    EditText pokemonName;
    EditText pokemonHeight;
    EditText pokemonWeight;
    Spinner spinner;
    Spinner species_spinner;
    String pokemonImage;
    //Testing shared preferences
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    private MainPokemonListFragment mainPokemonListFragment;

    public CreatePokemonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(String value) {
        // value this data you receive when increment() / decrement() called
        pokemonImage = value;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_pokemon, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //Initialize components
        btnDisplay = (Button) getActivity().findViewById(R.id.button_send);
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.gender);
        pokemonName = (EditText) getActivity().findViewById(R.id.pokemonName);
        pokemonHeight = (EditText) getActivity().findViewById(R.id.pokemonHeight);
        pokemonWeight = (EditText) getActivity().findViewById(R.id.pokemonWeight);
        mainPokemonListFragment = new MainPokemonListFragment();
        //Testing shared preference
        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        //Setup RadioGroup behaviour
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) getActivity().findViewById(selectedId);


                //Send data to another fragment to be included in recyclerview list
                if (!pokemonHeight.getText().toString().matches("") && !pokemonWeight.getText().toString().matches("") && !pokemonName.getText().toString().matches("") && !pokemonImage.toString().matches("")) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("pokemonName", pokemonName.getText().toString());
                    editor.putString("pokemonImage", pokemonImage);
                    editor.putInt("pokemonHeight", Integer.parseInt(pokemonHeight.getText().toString()));
                    editor.putInt("pokemonWeight", Integer.parseInt(pokemonWeight.getText().toString()));
                    editor.putInt("pokemonAbility", Integer.parseInt(spinner.getSelectedItem().toString()));
                    editor.putString("pokemonSpecies", species_spinner.getSelectedItem().toString());
                    editor.commit();

                    //Clear all data entered by user to prevent redundancy
                    pokemonName.setText("");
                    pokemonImage = "";
                    pokemonHeight.setText("");
                    pokemonWeight.setText("");
                    spinner.setSelected(false);
                    species_spinner.setSelected(false);

                }
            }

        });

        //Populating spinners

        //Ability spinner
        spinner = (Spinner) getView().findViewById(R.id.ability_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.ability_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //Species spinner
        species_spinner = (Spinner) getView().findViewById(R.id.species_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> species_adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.species_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        species_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        species_spinner.setAdapter(species_adapter);

        //Implementing recyclerview and recyclerview adapter
        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);

        mAdapter = new PokemonImageAdapter(PokemonList, this) {
        };
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Using snaphelper to ensure proper view
        SnapHelper pokemonSnapHelper = new PokemonSnapHelper();
        pokemonSnapHelper.attachToRecyclerView(recyclerView);

        //Load fake data for pokemon images
        PokemonList.add("https://upload.wikimedia.org/wikipedia/en/2/23/Pokémon_Mimikyu_art.png");
        PokemonList.add("https://cdn.bulbagarden.net/upload/0/0e/725Litten.png");
        PokemonList.add("https://cdn.bulbagarden.net/upload/2/24/380Latias.png");
        PokemonList.add("https://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/600px-025Pikachu.png");
        PokemonList.add("https://static.giantbomb.com/uploads/scale_small/13/135472/1891764-007squirtle.png");

    }
}
