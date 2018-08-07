package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class PokemonListViewFragment extends Fragment {

    private ListViewAdapter listViewAdapter;
    private List<PokeProfileStructure> pokeProfileStructure;
    private ListView listView;
    private SearchView searchView;


    public PokemonListViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_new_pokemon_list_view_filter, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pokeProfileStructure = new ArrayList<>();

        //Injecting fake data
        PokeProfileStructure pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Name", "DemiGod", "no image for you");
        pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Pokemon Mimikyu", "DemiGod", "https://upload.wikimedia.org/wikipedia/en/2/23/Pokémon_Mimikyu_art.png");
        pokeProfileStructure.add(pokeObject);
        pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Litten", "Water", "https://cdn.bulbagarden.net/upload/0/0e/725Litten.png");
        pokeProfileStructure.add(pokeObject);
        pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Latias", "Thunder", "https://cdn.bulbagarden.net/upload/2/24/380Latias.png");
        pokeProfileStructure.add(pokeObject);
        pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Pikachu", "Earth", "https://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/600px-025Pikachu.png");
        pokeProfileStructure.add(pokeObject);
        pokeObject = new PokeProfileStructure(12, 12, 12, 23, "Squirtle", "Hybrid", "https://static.giantbomb.com/uploads/scale_small/13/135472/1891764-007squirtle.png");
        pokeProfileStructure.add(pokeObject);

        //Setting up the listview and adapter
        this.listView = (ListView) getActivity().findViewById(R.id.list_view);
        this.listViewAdapter = new ListViewAdapter(getActivity(), pokeProfileStructure);
        this.listView.setAdapter(this.listViewAdapter);

        //Setting up searchview to perform filter on listview based on user's input
        searchView = (SearchView) getActivity().findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listViewAdapter.filter(newText);
                return true;
            }
        });

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
