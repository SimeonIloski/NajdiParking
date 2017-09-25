package com.example.simeon.najdiparking;

import android.app.PendingIntent;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;
import android.widget.Spinner;
import android.widget.Toast;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PayActivity extends AppCompatActivity {
    public final int[] pos=new int[2];
    ArrayList<String> registrations=new ArrayList<>();
    Set<String> regs=new HashSet<>();
     EditText editMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnStart=(Button) findViewById(R.id.btnStart);
        Button btnStop=(Button) findViewById(R.id.btnStop);
        final ArrayList<String> zones=getIntent().getStringArrayListExtra("zones");
        final int ind=0;
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,zones);
        final Spinner spinner=(Spinner)  findViewById(R.id.spinner);
         editMsg=(EditText) findViewById(R.id.editTextMsg);
        Spinner spinner1=(Spinner) findViewById(R.id.spinner2);
        Button addBtn=(Button) findViewById(R.id.button2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                pos[0]=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pos[0]=-1;
            }
        });
        Preference preference=new Preference(getApplicationContext());
        Set<String> set=preference.get(Preference.my_pref);
        for(String s:set){
            registrations.add(s);
        }
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,registrations);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos[1]=i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                pos[1]=-1;
            }
        });
        String str="";
        CheckBox checkBoxExist=(CheckBox) findViewById(R.id.checkBox2);
        checkBoxExist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(compoundButton.isChecked()){
                            editMsg.setText(registrations.get(pos[1]));
                            compoundButton.setChecked(false);
                        }
                }
            });
        editMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editMsg.setText("");
            }
        });


        final String freg=str;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCorrect(editMsg.getText().toString())){
                    String msg="";
                    msg=String.format("%s %s %s","START",zones.get(pos[0]),editMsg.getText().toString());
                    SmsManager menager=SmsManager.getDefault();
                    String phone="070350915";
                    try {
                        menager.sendTextMessage(phone, null, msg, null, null);
                        Toast.makeText(getApplicationContext(), "Пораката е успешно испратена", Toast.LENGTH_SHORT).show();
                    }
                    catch (SecurityException e){
                        Toast.makeText(getApplicationContext(),"Пораката не е успешно испратена",Toast.LENGTH_SHORT).show();
                    }
                    }
                else{
                    Toast.makeText(getApplicationContext(),"Пораката е во невалиден формат",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCorrect(editMsg.getText().toString())){
                    String msg="";
                    msg=String.format("%s %s %s","STOP",zones.get(pos[0]),editMsg.getText().toString());
                    SmsManager menager=SmsManager.getDefault();
                    String phone="070350915";
                    try {
                        menager.sendTextMessage(phone, null, msg, null, null);
                        Toast.makeText(getApplicationContext(), "Пораката е успешно испратена", Toast.LENGTH_SHORT).show();
                    }
                    catch (SecurityException e){
                       Toast.makeText(getApplicationContext(),"Пораката не е успешно испратена",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),editMsg.getText().toString(),Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Пораката е во невалиден формат",Toast.LENGTH_SHORT).show();

                }
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preference preference=new Preference(getApplicationContext());
                Set<String> set=new HashSet<>();
                for(String s:registrations){
                    set.add(s);
                }
                set.add(editMsg.getText().toString());
                registrations.add(editMsg.getText().toString());
                preference.set(Preference.my_pref,set);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Вашата порака треба да биде во облик:регистрација без празни места"
                        , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    boolean checkCorrect(String str){
        boolean b=false;
        char l[]=str.toCharArray();
        if(str.trim().length()==7 || str.trim().length()==8) {
           b=true;
        }
        return  b;
    }
    String makereg(int i){
        String reg="";
        if(i!=-1){
            reg=registrations.get(i);
        }
        return reg;
    }
    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public  void onPause(){
        super.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
    }
}


