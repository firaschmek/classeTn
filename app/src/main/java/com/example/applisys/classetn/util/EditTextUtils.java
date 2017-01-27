package com.example.applisys.classetn.util;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by applisys on 26/01/17.
 */

public class EditTextUtils {
    public static boolean isTextFieldEmpty(EditText editText)
    {

    String text   = editText.getText().toString();
        if (text.matches("")) {

            return true;
        }
        return  false;

    }
    /*
    * method forwarding to next editText
    *
    * */

    public  static final void forwardTonext(TextView textView_first, final View textView_next)
    {

        textView_first.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                textView_next.requestFocus();
                return true;
            }
        });
    }
}
