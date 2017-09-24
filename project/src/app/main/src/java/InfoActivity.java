package com.example.simeon.najdiparking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView=(TextView) findViewById(R.id.txtinfo);
        textView.setText(getText());

    }


    String getText(){
        StringBuilder sb= new StringBuilder();
        sb.append("Најди Паркинг е апликација која е создадена со цел да овозможи приказ на сите паркинзи со зонско плаќање. " +
             "Оваа апликација дополнително нуди приказ на најблиските паркинзи од вашата локација.");
        sb.append("\n");
        sb.append("Најди паркинг дополнително овозможува преглед на сите паркинзи на мапата на Скопје, со соодветно означен маркер");
        sb.append("\n");
        sb.append("Оваа апликација со цел да го олесни плаќањето на паркинг ви нуди услуга да таа прати порака за старт и стоп на паркираето. " +
                "Се што вие треба да направите е да ја изберете зоната и да напишете која е вашата регистација");
        sb.append("\n");
        sb.append("Исто така ако сакате може да ја погледнете и галеријата со слики од паркинзите. Доколку ви се допаѓа апликацијата споделетеја со пријателите");
        return  sb.toString();
    }
}
