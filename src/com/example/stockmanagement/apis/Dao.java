package com.example.stockmanagement.apis;

import com.example.stockmanagement.utils.AppConfig;
import com.mrasif.jdbms.JDbms;
import com.mrasif.jdbms.JDbmsHelper;

public class Dao implements JDbmsHelper {
    private static JDbms dbms=null;
    @Override
    public JDbms getJDbms() {
        if(dbms==null){
            dbms=new JDbms(AppConfig.getDatabasePath());
        }
        return dbms;
    }

    public static JDbms getDatabase(){
        return new Dao().getJDbms();
    }
}
