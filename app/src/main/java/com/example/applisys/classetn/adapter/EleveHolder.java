package com.example.applisys.classetn.adapter;

import android.view.View;

/**
 * Created by applisys on 12/01/17.
 */
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.interfas.EleveRecyclerListener;

public class EleveHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView eleve_name_txtv;
    EleveRecyclerListener eleveRecyclerListener;
    public EleveHolder(View itemView,EleveRecyclerListener eleveRecyclerListener) {
        super(itemView);
        this.eleveRecyclerListener=eleveRecyclerListener;
        eleve_name_txtv= (TextView) itemView.findViewById(R.id.eleve_name_txtv);
    itemView.setOnClickListener(this);}



    public void updateText(Eleve eleve) {
       eleve_name_txtv.setText(eleve.getNomEleve());
    }
    @Override
    public void onClick(View v) {
        if (eleveRecyclerListener != null)
            eleveRecyclerListener.onItemClicked(v, getAdapterPosition());

    }
}
