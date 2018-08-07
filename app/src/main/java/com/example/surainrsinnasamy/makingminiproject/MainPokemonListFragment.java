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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainPokemonListFragment extends Fragment {

    private List<PokeProfileStructure> PokemonList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PokemonAdapter mAdapter;
    private PokemonModelClass pokemonModelClassList;
    private ApiInterface apiInterface;
    private PokeProfileStructure book;
    private Integer testingConcept = 0;
    ProgressBar progressBar;

    //Testing shared preferences
    public static final String MyPREFERENCES = "MyPrefs";

    public MainPokemonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_pokemon_list, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Initialize components
        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        mAdapter = new PokemonAdapter(PokemonList) {
        };
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Using snaphelper to ensure proper view
        SnapHelper pokemonSnapHelper = new PokemonSnapHelper();
        pokemonSnapHelper.attachToRecyclerView(recyclerView);

        //Testing progressbar
        progressBar = getView().findViewById(R.id.progressBar);

        //Load data from poke API
        for (Integer i = 1; i <= 10; i++) {
            fetchData(i);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            //Use shared preference to receive user made pokemon
            SharedPreferences prefs = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            Integer pokemonAbilities = prefs.getInt("pokemonAbility", 0);
            Integer pokemonHeight = prefs.getInt("pokemonHeight", 0);
            Integer pokemonWeight = prefs.getInt("pokemonWeight", 0);
            String pokemonName = prefs.getString("pokemonName", null);
            String pokemonSpecies = prefs.getString("pokemonSpecies", null);
            String pokemonImage = prefs.getString("pokemonImage", null);

            //Clear all shared preference data
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.commit();

            if (pokemonName != null) {

                book = new PokeProfileStructure(pokemonAbilities, pokemonHeight, pokemonWeight, 23, pokemonName, pokemonSpecies, pokemonImage);
                PokemonList.add(book);
                mAdapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void fetchData(Integer id) {
        apiInterface = APIClient.getApiClient().create(ApiInterface.class);
        Call<PokemonModelClass> call = apiInterface.getPokemonProfilesList(id);
        call.enqueue(new Callback<PokemonModelClass>() {
            @Override
            public void onResponse(Call<PokemonModelClass> call, Response<PokemonModelClass> response) {
                //Save data from poke API using model class
                pokemonModelClassList = response.body();
                //Save data into pokeProfile [object] for simpler accessing
                book = new PokeProfileStructure(pokemonModelClassList.getBase_experience(), pokemonModelClassList.getHeight(), pokemonModelClassList.getWeight(), 23, "" + pokemonModelClassList.getName(), pokemonModelClassList.getSpecies().getName() + " species", "" + pokemonModelClassList.getSprites().getFront_default());
                PokemonList.add(book);

                //Keep on incrementing progressbar by 10 every time item loaded until 100
                if (testingConcept <= 90) {
                    //To make progressBar less chunkier looking, increment progress bar by 1 for 10 times
                    // every item loaded
                    int count = 1;

                    while (count <= 10) {
                        testingConcept++;
                        progressBar.setProgress(testingConcept);
                        count++;
                    }

                    if (testingConcept >= 91) {
                        Toast.makeText(getActivity(), "Loading complete!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                }

                mAdapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<PokemonModelClass> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to connect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
