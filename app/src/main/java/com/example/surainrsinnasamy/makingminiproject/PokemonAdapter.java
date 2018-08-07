package com.example.surainrsinnasamy.makingminiproject;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<PokeProfileStructure> PokeList;

    public PokemonAdapter(List<PokeProfileStructure> pokeList) {
        this.PokeList = pokeList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_list, parent, false);

        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, final int position) {
        //Bind values with resources

        String stringTransform = PokeList.get(position).getName();
        String capitalWord = stringTransform.substring(0,1).toUpperCase() + stringTransform.substring(1);
        holder.title.setText(capitalWord);
        holder.author.setText(PokeList.get(position).getSpecies());
        String imageUrl = PokeList.get(position).getSprites();
        Picasso.get().load((imageUrl)).into(holder.pokemonImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send user and data to DetailActivity
                Intent launchActivity1 = new Intent(view.getContext(), DetailActivity.class);
                launchActivity1.putExtra("pokemonName", PokeList.get(position).getName());
                launchActivity1.putExtra("pokemonHeight", PokeList.get(position).getHeight());
                launchActivity1.putExtra("pokemonWeight", PokeList.get(position).getWeight());
                launchActivity1.putExtra("pokemonAbility", PokeList.get(position).getBase_experience());
                launchActivity1.putExtra("pokemonSpecies", PokeList.get(position).getSpecies());
                launchActivity1.putExtra("pokemonSprites", PokeList.get(position).getSprites());

                view.getContext().startActivity(launchActivity1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return PokeList.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;
        public ImageView pokemonImage;
        View mView;

        public PokemonViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            pokemonImage = (ImageView) view.findViewById(R.id.profile_image);
        }
    }
}