package com.example.applisys.classetn;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.applisys.classetn.activities.BaseActivity;
import com.example.applisys.classetn.constant.Constant;
import com.example.applisys.classetn.fragment.AddEleveFragment;
import com.example.applisys.classetn.fragment.AuthFragment;
import com.example.applisys.classetn.fragment.EleveListFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

public class MainActivity extends BaseActivity {
public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* SharedPreferences sharedPref = this.getPreferences(this.MODE_PRIVATE);
        String identifiant_parent=null;
   identifiant_parent=     sharedPref.getString(getResources().getString(R.string.shared_key),identifiant_parent);
        if (identifiant_parent != null) {
            Constant.identifiant_parent=identifiant_parent;
            Log.e(TAG, identifiant_parent);
          Bundle       bundle_identifiant=new Bundle();
            bundle_identifiant.putString("identifiant_parent",identifiant_parent);

            EleveListFragment eleveListFragment=new EleveListFragment();
            eleveListFragment.setArguments(bundle_identifiant);

            replaceFragment(eleveListFragment,R.id.activity_main_FrameLayout);
        }
       else
        {replaceFragment(new AuthFragment(),R.id.activity_main_FrameLayout);}*/


        replaceFragment(new AuthFragment(),R.id.activity_main_FrameLayout);
    }
}
