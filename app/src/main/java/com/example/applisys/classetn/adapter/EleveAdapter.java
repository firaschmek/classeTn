package com.example.applisys.classetn.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.interfas.EleveRecyclerListener;

import java.util.List;

/**
 * Created by applisys on 12/01/17.
 */

public class EleveAdapter extends RecyclerView.Adapter<EleveHolder> {
List<Eleve>   liste_eleve;
    EleveRecyclerListener eleveRecyclerListener;

    public EleveAdapter(List<Eleve> liste_eleve, EleveRecyclerListener eleveRecyclerListener) {
        this.liste_eleve = liste_eleve;
        this.eleveRecyclerListener = eleveRecyclerListener;
    }

    @Override
    public EleveHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eleve_item, parent, false);
        EleveHolder eleveHolder= new EleveHolder(v, eleveRecyclerListener);
        return eleveHolder;


    }

    @Override
    public void onBindViewHolder(EleveHolder holder, int position) {

        holder.updateText(liste_eleve.get(position));


    }

    @Override
    public int getItemCount() {
        Log.e("EleveAdapter",liste_eleve.size()+"");
        return liste_eleve.size();
    }
}
