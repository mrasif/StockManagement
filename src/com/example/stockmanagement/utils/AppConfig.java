package com.example.stockmanagement.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppConfig {

    public static String getDatabasePath(){
        /*String dbPath = System.getProperty("user.home") + File.separator + "supernotes" + File.separator+ "data" + File.separator;
        File file=new File(dbPath);
        if(!file.exists()){
            file.mkdirs();
        }*/
        String dbPath="data.jdb";
        return dbPath;
    }

    public static List<String> getMigration(){
        List<String> sqls=new ArrayList<>();
        sqls.add("CREATE TABLE IF NOT EXISTS `users` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`name` TEXT," +
                "`email` TEXT UNIQUE," +
                "`password` TEXT," +
                "`address` TEXT," +
                "`created_at` Date," +
                "`updated_at` Date" +
                ");");

        sqls.add("CREATE TABLE IF NOT EXISTS `customers` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`name` TEXT," +
                "`mobile` TEXT UNIQUE," +
                "`address` TEXT," +
                "`created_at` Date," +
                "`updated_at` Date" +
                ");");

        sqls.add("CREATE TABLE IF NOT EXISTS `products` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`title` TEXT UNIQUE," +
                "`description` TEXT," +
                "`quantity` INTEGER," +
                "`rate` TEXT," +
                "`created_at` Date," +
                "`updated_at` Date" +
                ");");

        sqls.add("CREATE TABLE IF NOT EXISTS `bills` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`title` TEXT," +
                "`description` TEXT," +
                "`amount` TEXT," +
                "`paid` TEXT," +
                "`customer_id` INTEGER," +
                "`created_at` Date," +
                "`updated_at` Date," +
                "CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE" +
                ");");

        sqls.add("CREATE TABLE IF NOT EXISTS `invoices` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`product_id` INTEGER," +
                "`bill_id` INTEGER," +
                "`quantity` INTEGER," +
                "`created_at` Date," +
                "`updated_at` Date," +
                "CONSTRAINT fk_products FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE," +
                "CONSTRAINT fk_bills FOREIGN KEY (bill_id) REFERENCES bills(id) ON DELETE CASCADE" +
                ");");

        return sqls;
    }

    public static Date stringToDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

}
