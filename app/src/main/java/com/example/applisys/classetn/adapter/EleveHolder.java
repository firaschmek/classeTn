package com.example.applisys.classetn.adapter;

import android.view.View;

/**
 * Created by applisys on 12/01/17.
 */
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.interfas.EleveRecyclerListener;

public class EleveHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView eleve_name_txtv,class_txtv,etablissement_item_txtv;
    EleveRecyclerListener eleveRecyclerListener;
    public EleveHolder(View itemView,EleveRecyclerListener eleveRecyclerListener) {
        super(itemView);
        this.eleveRecyclerListener=eleveRecyclerListener;
        eleve_name_txtv= (TextView) itemView.findViewById(R.id.nom_eleve_txtv);
        class_txtv= (TextView) itemView.findViewById(R.id.class_txtv);
        etablissement_item_txtv= (TextView) itemView.findViewById(R.id.etablissement_item_txtv);
    itemView.setOnClickListener(this);}



    public void updateText(Eleve eleve) {
       eleve_name_txtv.setText(eleve.getNomEleve());
        /*
        * TextView textView = (TextView) findViewById(R.id.myTxtView);
textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon, 0, 0, 0);
        * */

        class_txtv.setText(eleve.getClasseTitre());
        etablissement_item_txtv.setText(eleve.getEtabNomAR());
    }
    @Override
    public void onClick(View v) {
        if (eleveRecyclerListener != null)
            eleveRecyclerListener.onItemClicked(v, getAdapterPosition());

    }
}
