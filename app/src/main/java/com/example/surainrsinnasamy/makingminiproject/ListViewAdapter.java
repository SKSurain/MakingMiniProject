package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    public Context mContext;
    LayoutInflater inflater;
    public List<PokeProfileStructure> allFoodItemlist;
    public ArrayList<PokeProfileStructure> arraylist;

    public ListViewAdapter(Context context, List<PokeProfileStructure> allFoodItemlist) {
        mContext = context;
        this.allFoodItemlist = allFoodItemlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<PokeProfileStructure>();
        this.arraylist.addAll(allFoodItemlist);
    }

    @Override
    public int getCount() {
        return allFoodItemlist.size();
    }

    @Override
    public PokeProfileStructure getItem(int position) {
        return allFoodItemlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView foodName, foodSpecies, calorie;
        ImageView pokemonImage1;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        Holder holder = new Holder();
        view = inflater.inflate(R.layout.pokemon_list, null);
        // Binding values to views
        holder.foodName = (TextView) view.findViewById(R.id.title);
        holder.foodSpecies = (TextView) view.findViewById(R.id.author);
        holder.pokemonImage1 = (ImageView) view.findViewById(R.id.profile_image);
        holder.foodName.setText(allFoodItemlist.get(position).getName().toString());
        holder.foodSpecies.setText(allFoodItemlist.get(position).getSpecies().toString());
        Picasso.get().load(this.allFoodItemlist.get(position).getSprites()).into(holder.pokemonImage1);

        //Setting up listItem behavour onClick
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send user and data to IOActivity
                Intent launchActivity1 = new Intent(view.getContext(), IOActivityExample.class);
                launchActivity1.putExtra("pokemonName", allFoodItemlist.get(position).getName());
                launchActivity1.putExtra("pokemonHeight", allFoodItemlist.get(position).getHeight());
                launchActivity1.putExtra("pokemonWeight", allFoodItemlist.get(position).getWeight());
                launchActivity1.putExtra("pokemonBaseExperience", allFoodItemlist.get(position).getBase_experience());
                launchActivity1.putExtra("pokemonSpecies", allFoodItemlist.get(position).getSpecies());
                launchActivity1.putExtra("pokemonSprites", allFoodItemlist.get(position).getSprites());

                view.getContext().startActivity(launchActivity1);
            }
        });
        return view;
    }

    // Declaration of Filter Class
    public void filter(String charText) {
        //Transform text into lowercase
        charText = charText.toLowerCase(Locale.getDefault());
        //Clear all existing data from allFoodItem object
        allFoodItemlist.clear();

        //Find pokemon names that matches user's search and display on listview
        if (charText.length() == 0) {
            allFoodItemlist.addAll(arraylist);
        } else {
            for (PokeProfileStructure wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    allFoodItemlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}