package com.example.stockmanagement.apis;

import com.example.stockmanagement.models.*;
import com.example.stockmanagement.utils.AppConfig;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiDatabase {
    public static boolean Migrate(){
        return Dao.getDatabase().createDatabase(AppConfig.getMigration());
    }

    public static boolean addUser(User user){
        return Dao.getDatabase().executeNonQuery("INSERT INTO users(name,email,password,address,created_at,updated_at) " +
                "VALUES('"+user.getName()+"','"+user.getEmail()+"','"+ user.getPassword()+"','"+user.getAddress()+"','"+user.getCreated_at()+"','"+user.getUpdated_at()+"')");
    }

    public static boolean updateUser(User user){
        return Dao.getDatabase().executeNonQuery("UPDATE users SET name='"+user.getName()+"', address='"+user.getAddress()+"', updated_at='"+ AppConfig.dateToString(new Date())+"' WHERE email='"+user.getEmail()+"'");
    }

    public static boolean deleteUser(User user){
        return Dao.getDatabase().executeNonQuery("DELETE FROM users WHERE email='"+user.getEmail()+"'");
    }

    public static boolean changePassword(String email, String old_password, String new_password){
        return Dao.getDatabase().executeNonQuery("UPDATE users SET password='"+new_password+"' WHERE email='"+email+"' AND password='"+old_password+"'");
    }

    public static boolean login(String email, String password){
        boolean flag=false;
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT email FROM users WHERE email='"+email+"' AND password='"+password+"'");
        try {
            if(rs.next()){
                if(rs.getString("email").equals(email)){
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static User getUser(int id){
        User user=new User();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM users WHERE id="+id+"");
        try {
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setCreated_at(rs.getString("created_at"));
                user.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(String email){
        User user=new User();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM users WHERE email='"+email+"'");
        try {
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setCreated_at(rs.getString("created_at"));
                user.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean addCustomer(Customer customer){
        return Dao.getDatabase().executeNonQuery("INSERT INTO customers(name,mobile,address,created_at,updated_at) " +
                "VALUES('"+customer.getName()+"','"+customer.getMobile()+"','"+ customer.getAddress()+"','"+customer.getCreated_at()+"','"+customer.getUpdated_at()+"')");
    }

    public static boolean updateCustomer(Customer customer){
        return Dao.getDatabase().executeNonQuery("UPDATE customers SET name='"+customer.getName()+"', address='"+customer.getAddress()+"', updated_at='"+ AppConfig.dateToString(new Date())+"' WHERE id="+customer.getId());
    }

    public static boolean deleteCusomer(Customer customer){
        return Dao.getDatabase().executeNonQuery("DELETE FROM customers WHERE id="+customer.getId());
    }

    public static Customer getCustomer(int id){
        Customer customer=new Customer();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM customers WHERE id="+id+"");
        try {
            if(rs.next()){
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setAddress(rs.getString("address"));
                customer.setCreated_at(rs.getString("created_at"));
                customer.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static Customer getCustomer(String mobile){
        Customer customer=new Customer();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM customers WHERE mobile='"+mobile+"'");
        try {
            if(rs.next()){
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setAddress(rs.getString("address"));
                customer.setCreated_at(rs.getString("created_at"));
                customer.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static List<Customer> findCustomers(String name){
        List<Customer> customers=new ArrayList<>();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM customers WHERE name like '"+name+"%'");
        try {
            while (rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setAddress(rs.getString("address"));
                customer.setCreated_at(rs.getString("created_at"));
                customer.setUpdated_at(rs.getString("updated_at"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static boolean addProductType(Product product){
        return Dao.getDatabase().executeNonQuery("INSERT INTO products(title,description,quantity,rate,created_at,updated_at) " +
                "VALUES('"+product.getTitle()+"','"+product.getDescription()+"',"+ product.getQuantity()+",'"+ product.getRate()+"','"+product.getCreated_at()+"','"+product.getUpdated_at()+"')");
    }

    public static boolean addProduct(Product product){
        return Dao.getDatabase().executeNonQuery("UPDATE products SET quantity=(quantity+"+product.getQuantity()+"), updated_at='"+ AppConfig.dateToString(new Date())+"' WHERE id="+product.getId());
    }

    public static boolean deleteProduct(Product product) {
        if (getProduct(product.getId()).getQuantity() > product.getQuantity()) {
            return Dao.getDatabase().executeNonQuery("UPDATE products SET quantity=(quantity-" + product.getQuantity() + "), updated_at='" + AppConfig.dateToString(new Date()) + "' WHERE id=" + product.getId());
        } else {
            return false;
        }
    }

    public static boolean updateProductType(Product product){
        return Dao.getDatabase().executeNonQuery("UPDATE products SET title='"+product.getTitle()+"', " +
                "description='"+product.getDescription()+"', " +
                "rate='"+product.getRate()+"', updated_at='"+ AppConfig.dateToString(new Date())+"' WHERE id="+product.getId());
    }

    /*
    public static boolean deleteProductType(Product product) {
        if (getProduct(product.getId()).getQuantity() <= 0) {
            return Dao.getDatabase().executeNonQuery("DELETE FROM products WHERE id=" + product.getId());
        } else {
            return false;
        }
    }
    */

    public static Product getProduct(int id){
        Product product=new Product();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM products WHERE id="+id+"");
        try {
            if(rs.next()){
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setRate(rs.getString("rate"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static List<Product> getAllProducts(){
        List<Product> products=new ArrayList<>();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM products");
        try {
            while (rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setRate(rs.getString("rate"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Product> findProducts(String title){
        List<Product> products=new ArrayList<>();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM products WHERE title='"+title+"%'");
        try {
            while (rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setRate(rs.getString("rate"));
                product.setCreated_at(rs.getString("created_at"));
                product.setUpdated_at(rs.getString("updated_at"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static boolean addBill(Bill bill){
        return Dao.getDatabase().executeNonQuery("INSERT INTO bills(title,description,amount,paid,customer_id,created_at,updated_at) " +
                "VALUES('"+bill.getTitle()+"','"+bill.getDescription()+"','"+ bill.getAmount()+"','"+bill.getPaid()+"',"+ bill.getCustomer_id()+",'"+bill.getCreated_at()+"','"+bill.getUpdated_at()+"')");
    }

    public static boolean addInvoice(Invoice invoice){
        return Dao.getDatabase().executeNonQuery("INSERT INTO invoices(product_id,bill_id,quantity,created_at,updated_at) " +
                "VALUES("+invoice.getProduct_id()+","+invoice.getBill_id()+","+ invoice.getQuantity()+",'"+invoice.getCreated_at()+"','"+invoice.getUpdated_at()+"')");
    }

}
