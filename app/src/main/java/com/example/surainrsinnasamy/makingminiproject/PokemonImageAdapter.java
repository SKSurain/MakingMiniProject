package com.example.surainrsinnasamy.makingminiproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class PokemonImageAdapter extends RecyclerView.Adapter<PokemonImageAdapter.PokemonImageViewHolder> {

    private List<String> PokeList;
    private OnItemClick mCallback;
    private View tmpViewHolder;
    private Integer counter = 0;

    public PokemonImageAdapter(List<String> pokeList,OnItemClick listener) {
        this.PokeList = pokeList;
        this.mCallback = listener;
    }

    @Override
    public PokemonImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_images_list, parent, false);
        return new PokemonImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonImageViewHolder holder, final int position) {
//        holder.pokemonImage1.setImageResource(R.drawable.bilbasaur);
        Picasso.get().load(this.PokeList.get(position)).into(holder.pokemonImage1);
        holder.pokemonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                if(counter > 0){
                    tmpViewHolder.setSelected(false);
                }
                tmpViewHolder = view;
                mCallback.onClick(PokeList.get(position).toString());
                counter++;
            }
        });
    }

    @Override
    public int getItemCount() {
        return PokeList.size();
    }

    public class PokemonImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView pokemonImage1;

        View mView;

        public PokemonImageViewHolder(View view) {
            super(view);
            mView = view;
            pokemonImage1 = (ImageView) view.findViewById(R.id.pokemonImage1);
        }

    }
}

