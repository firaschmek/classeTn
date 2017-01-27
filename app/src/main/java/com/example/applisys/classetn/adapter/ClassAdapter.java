package com.example.applisys.classetn.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applisys.classetn.Bean.Classe;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.interfas.ClassRecyclerListener;

import java.util.List;

/**
 * Created by applisys on 24/01/17.
 */

public class ClassAdapter extends  RecyclerView.Adapter<ClassHolder>{

List<Classe >   liste_classe;
    ClassRecyclerListener classRecyclerListener;

    public ClassAdapter(List<Classe> liste_classe, ClassRecyclerListener classRecyclerListener) {
        this.liste_classe = liste_classe;
        this.classRecyclerListener = classRecyclerListener;
    }

    @Override
    public ClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        /*
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eleve_item, parent, false);
        EleveHolder eleveHolder= new EleveHolder(v, eleveRecyclerListener);
        return eleveHolder;
         */

        View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);
        ClassHolder classHolder=new ClassHolder(v,classRecyclerListener);
        return classHolder;


    }

    @Override
    public void onBindViewHolder(ClassHolder holder, int position) {
        holder.updateText(liste_classe.get(position));

    }

    @Override
    public int getItemCount() {

        /*
         Log.e("EleveAdapter",liste_eleve.size()+"");
        return liste_eleve.size();
         */
        Log.e("ClassAdapter",liste_classe.size()+"");
        return liste_classe.size();
    }
}
