package com.example.simeon.najdiparking;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simeon on 03.9.2017.
 */

class Preference{
    public  static  final  String my_pref= "registrations";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public  Preference(Context context){
        this.preferences=context.getSharedPreferences(my_pref,0);
        this.editor=this.preferences.edit();
    }
    public void set(String key, Set<String> set){
        this.editor.putStringSet(key,set);
        editor.commit();
    }
    public  Set<String> get(String key){
        HashSet<String> set=new HashSet<>();
        set.add("");
        return preferences.getStringSet(key,set);
    }
    public void clear(String key) {
        this.editor.remove(key);
        this.editor.commit();
    }

    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }
}
