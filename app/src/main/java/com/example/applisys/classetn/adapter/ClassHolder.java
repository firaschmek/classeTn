package com.example.applisys.classetn.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.applisys.classetn.Bean.Classe;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.interfas.ClassRecyclerListener;

/**
 * Created by applisys on 24/01/17.
 */

public class ClassHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView class_item_txtv;
    ClassRecyclerListener classRecyclerListener;
    CheckBox class_item_txtv_checkBox;

    public ClassHolder(View itemView,ClassRecyclerListener classRecyclerListener) {
        super(itemView);
        this.classRecyclerListener=classRecyclerListener;
        this.classRecyclerListener=classRecyclerListener;
        class_item_txtv= (TextView) itemView.findViewById(R.id.class_item_txtv);
        class_item_txtv_checkBox= (CheckBox) itemView.findViewById(R.id.class_item_txtv_checkBox);
        itemView.setOnClickListener(this);
    }




public void updateText(Classe classe)
{class_item_txtv.setText(classe.getTitre());}

    @Override
    public void onClick(View v) {
if(class_item_txtv_checkBox.isChecked())
{class_item_txtv_checkBox.setChecked(false);
}
        else
{class_item_txtv_checkBox.setChecked(true);}
        if(classRecyclerListener!=null)
        {classRecyclerListener.onItemClicked(v,getAdapterPosition());}

    }

}
