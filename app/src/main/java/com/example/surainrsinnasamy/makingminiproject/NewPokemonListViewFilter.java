package com.example.surainrsinnasamy.makingminiproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class NewPokemonListViewFilter extends Activity {

    private ListViewAdapter listViewAdapter;
    private List<PokeProfileStructure> pokeProfileStructure;
    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pokemon_list_view_filter);

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
        listView = (ListView) findViewById(R.id.list_view);
        listViewAdapter = new ListViewAdapter(this, pokeProfileStructure);
        listView.setAdapter(listViewAdapter);

        //Setting up searchview to perform filter on listview based on user's input
        searchView = (SearchView) findViewById(R.id.search_view);
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
}
