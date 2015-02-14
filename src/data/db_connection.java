/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.math.BigInteger;
import java.sql.*;
import window.*;

/**
 *
 * @author Bhadresh
 */
public class db_connection {
    
    // JDBC driver name and database URL
   public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/my_db";

   //  Database credentials
   public static final String USER = "root";
   public static final String PASS = "1234";
   public Connection conn = null;
   public Statement stmt = null;
   public ResultSet rs= null;
   
   purchase_home p;
  
   public String Pur_Date;
   public String Party_Name;
   public String Mat_Name;
   public float Rate;
   public int Expe;
   public float Weight;
   public float Tot_Amt;
   public String Pay_Date;
   public String Pro_Name;
   public float Mat_Weight;
   public int Pro_Piece;
   public float Piece_Weight;
   public float Tot_Weight;
   public float Sum;
   public float Waste;
   public float Grin;
   public String Item_Code;
   public int Piece;
   public String Sell_Date;
   public String RM_date;
   public String Pay_Type;
   public String Bank_Name;
   public int Check_no;
   public int pid;
   public float Fin_value;
   public float Amt_Due;
   public int sid;
   public String tra;
   public int sno;
   public String add;
   public String email;
   public String no;
    
    
   public void makeconnection(){
       try{
       Class.forName(JDBC_DRIVER);
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       }catch(Exception e)
       {
           
       }
   }

   public db_connection(){
       
   }
   
   public db_connection(add_purchase p)
   {
       Pur_Date = p.pur_date.getText();
       Party_Name = p.party_name.getSelectedItem().toString();
       Mat_Name = p.mat_name.getText();
       Rate = Float.parseFloat(p.rate.getText());
       Expe = Integer.parseInt(p.expe.getText());
       Weight = Float.parseFloat(p.weight.getText());
       Tot_Amt = (Rate * Weight)+Expe; 
       Amt_Due = Tot_Amt;
   }
   
   public db_connection(edit_purchase p)
   {
       sno = Integer.parseInt(p.s_no.getSelectedItem().toString());
       Pur_Date = p.pur_date.getText();
       Party_Name = p.party_name.getText();
       Mat_Name = p.mat_name.getText();
       Rate = Float.parseFloat(p.rate.getText());
       Expe = Integer.parseInt(p.expe.getText());
       Weight = Float.parseFloat(p.weight.getText());
       Tot_Amt = (Rate * Weight)+Expe; 
       Amt_Due = Tot_Amt;
   }
   
   public db_connection(add_production pr)
   {
       RM_date = pr.rm_date.getText();
       Party_Name = pr.party_name.getText();
       Mat_Name = pr.mat_name.getText();
       Pro_Name = pr.pro_name.getText();
       Mat_Weight = Float.parseFloat(pr.mat_weight.getText());
       Pro_Piece = Integer.parseInt(pr.pro_piece.getText());
       Piece_Weight = Float.parseFloat(pr.wop.getText());
       Tot_Weight = (Pro_Piece * Piece_Weight)/1000;
       Grin = Float.parseFloat(pr.grin.getText());
       Waste = Float.parseFloat(pr.waste.getText());
       Sum = Tot_Weight + Grin + Waste;
   }
   
   public db_connection(add_sale sh)
   {
       Sell_Date = sh.sell_date.getText();
       Party_Name = sh.party_name.getText();
       Pro_Name = sh.pro_name.getText();
       Item_Code = sh.item_code.getText();
       Piece = Integer.parseInt(sh.piece.getText());
       Rate = Float.parseFloat(sh.rate.getText());
       Tot_Amt = Piece * Rate; 
       Amt_Due = Tot_Amt;
   }
   
   public db_connection(add_vendor av)
   {
       Party_Name = av.party_name.getText();
       add = av.address.getText();
       no = av.mob_no.getText();
       email = av.email.getText();
   }
   
   public db_connection(edit_vendor v)
   {
       sno = Integer.parseInt(v.s_no.getSelectedItem().toString());
       Party_Name = v.party_name.getText();
       add = v.addr.getText();
       no = v.mob.getText();
       email = v.email.getText();
   }
   
   public db_connection(pur_payment pup)
   {
       pid = Integer.parseInt(pup.s_no.getSelectedItem().toString());
       Pay_Date = pup.p_date.getText();
       Pay_Type = pup.p_type.getSelectedItem().toString();
       if(Pay_Type == "Check")
       {
           Check_no = Integer.parseInt(pup.check_no.getText());
           Bank_Name = pup.bank_name.getText();
       }
       else
       {
           Check_no = 0;
           Bank_Name = null;
       }
       Tot_Amt = Float.parseFloat(pup.amount.getText()); 
       
   }
   
   public db_connection(sales_payment pup)
   {
       sid = Integer.parseInt(pup.s_no.getSelectedItem().toString());
       Pay_Date = pup.p_date.getText();
       Pay_Type = pup.p_type.getSelectedItem().toString();
       if(Pay_Type == "Check")
       {
           Check_no = Integer.parseInt(pup.check_no.getText());
           Bank_Name = pup.bank_name.getText();
       }
       else
       {
           Check_no = 0;
           Bank_Name = null;
       }
       Tot_Amt = Float.parseFloat(pup.amount.getText()); 
   }
   
   
   public int insert_purchase_query()
   {
       String sql;
       makeconnection();
       
       try{
       
       sql = "INSERT INTO `purchase`\n" +
        "(`date`,\n" +
        "`party_name`,\n" +
        "`material_name`,\n" +
        "`rate`,\n" +
        "`weight`,\n" +
        "`expense`,\n" +
        "`amount`,\n" +
        "`amount_due`,\n" +
        "`status`)\n" +
        "VALUES ('" + Pur_Date + "','" + Party_Name + "','"  + Mat_Name + "',"  + Rate + "," + Weight + "," + Expe + "," + Tot_Amt + "," + Amt_Due + ",'" + "Pending" + "'" +");";
               
       
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
              
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   public int insert_epurchase_query()
   {
       String sql;
       makeconnection();
       
       try{
           
       sql = "UPDATE `my_db`.`purchase` \n" +
        "SET date = '" + Pur_Date + "',\n" +
        "party_name = '" + Party_Name + "',\n" +
        "material_name = '" + Mat_Name + "',\n" +
        "rate = '" + Rate + "',\n" +
        "weight = '" + Weight + "',\n" +
        "expense = '" + Expe + "',\n" +
        "amount = '" + Tot_Amt + "',\n" +
        "amount_due = '" + Amt_Due + "' WHERE p_id = '" + sno + "';";
      
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   public int insert_vendor_query()
   {
       String sql;
       makeconnection();
              
       try{
       
       sql = "INSERT INTO `vendor`\n" +
        "(`party_name`,\n" +
        "`address`,\n" +
        "`mobile_no`,\n" +
        "`email`)\n" +
        "VALUES ('" + Party_Name + "','"  + add + "','"  + no + "','"  + email + "');";   
       
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       }catch(Exception e)
       {
            e.printStackTrace();
       }
       return 1;
   }
   
   public int insert_evendor_query()
   {
       String sql;
       makeconnection();
       
       try{
           
       sql = "UPDATE `my_db`.`vendor` \n" +
        "SET party_name = '" + Party_Name + "',\n" +
        "address = '" + add + "',\n" +
        "mobile_no = '" + no + "',\n" +
        "email = '" + email + "' WHERE v_id = '" + sno + "';";
      
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   
   public int insert_production_query()
   {
       String sql;
       makeconnection();
       
       try{
       
       sql = "INSERT INTO `production`\n" +
        "(`rm_date`,\n" +
        "`party_name`,\n" +
        "`material_name`,\n" +
        "`product_name`,\n" +
        "`material_weight`,\n" +
        "`prod_piece`,\n" +
        "`piece_weight`,\n" +
        "`total_weight`,\n" +
        "`grinding`,\n" +
        "`waste`,\n" +
        "`sum`)\n" +
        "VALUES ('" + RM_date + "','" + Party_Name + "','" + Mat_Name + "','"  + Pro_Name + "',"  + Mat_Weight + "," + Pro_Piece + "," + Piece_Weight + "," + Tot_Weight + "," + Grin + "," + Waste + "," + Sum +");";
               
       
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   public int insert_selling_query()
   {
       String sql;
       makeconnection();
       
       try{
       
       sql = "INSERT INTO `sales`\n" +
        "(`date`,\n" +
        "`party_name`,\n" +
        "`product_name`,\n" +
        "`item_code`,\n" +
        "`piece`,\n" +
        "`rate`,\n" +
        "`amount`,\n" +
        "`amount_due`,\n" +
        "`status`)\n" +
        "VALUES ('" + Sell_Date + "','" + Party_Name + "','" + Pro_Name + "','"  + Item_Code + "',"  + Piece + "," + Rate + "," + Tot_Amt + "," + Amt_Due + ",'" + "Pending" + "'" +");";
       
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
 
   public int insert_ptransaction_query()
   {
       String sql;
       makeconnection();
       tra = "Debit";
       try{
       //sql = "SELECT purchase.party_name FROM purchase JOIN transaction ON transaction.p_id = purchase.p_id WHERE transaction.p_id = '" + pid + "' ;";
       sql = "SELECT purchase.party_name FROM purchase WHERE purchase.p_id = '" + pid + "' ;";
       stmt = conn.createStatement();
       rs = stmt.executeQuery(sql);

       while(rs.next())
       {
           Party_Name = rs.getString(1);
       }
       
       sql = "INSERT INTO `transaction`\n" +
        "(`p_id`,\n" +
        "`payment_date`,\n" +
        "`party_name`,\n" +
        "`transaction`,\n" +
        "`type`,\n" +
        "`check_no`,\n" +
        "`bank_name`,\n" +
        "`amount`)\n" +
        "VALUES ('" + pid + "','" + Pay_Date + "','" + Party_Name + "','" + tra + "','"  + Pay_Type + "',"  + Check_no + ",'" + Bank_Name + "'," + Tot_Amt +");";
               
       stmt.executeUpdate(sql);
       
       sql = "SELECT amount_due FROM purchase WHERE p_id='" + pid + "';";
       
       rs = stmt.executeQuery(sql);
       
       while(rs.next())
       {
           Fin_value = rs.getFloat(1) - Tot_Amt;
       }
       
       sql = "UPDATE `my_db`.`purchase` SET amount_due= '" + Fin_value + "' WHERE p_id = '" + pid + "' ;";
       stmt.executeUpdate(sql);
       
       if( Fin_value == 0.0 )
       {
           sql = "UPDATE `my_db`.`purchase` SET status= 'Clear' WHERE p_id = '" + pid + "' ;";
           stmt.executeUpdate(sql);
       }
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   public int insert_stransaction_query()
   {
       String sql;
       makeconnection();
       tra = "Credit";
       
       try{
       
       sql = "SELECT sales.party_name FROM sales WHERE sales.s_id = '" + sid + "' ;";
       stmt = conn.createStatement();
       rs = stmt.executeQuery(sql);

       while(rs.next())
       {
           Party_Name = rs.getString(1);
       }
       
       sql = "INSERT INTO `transaction`\n" +
        "(`s_id`,\n" +
        "`payment_date`,\n" +
        "`party_name`,\n" +
        "`transaction`,\n" +
        "`type`,\n" +
        "`check_no`,\n" +
        "`bank_name`,\n" +
        "`amount`)\n" +
        "VALUES ('" + sid + "','" + Pay_Date + "','" + Party_Name + "','" + tra + "','"  + Pay_Type + "',"  + Check_no + ",'" + Bank_Name + "'," + Tot_Amt +");";
               
       
       //stmt = conn.createStatement();
       stmt.executeUpdate(sql);
       
       sql = "SELECT amount_due FROM sales WHERE s_id='" + sid + "';";
       
       //stmt = conn.createStatement();
       rs = stmt.executeQuery(sql);
       
       while(rs.next())
       {
           Fin_value = rs.getFloat(1) - Tot_Amt;
       }
       
       sql = "UPDATE `my_db`.`sales` SET amount_due= '" + Fin_value + "' WHERE s_id = '" + sid + "' ;";
       stmt.executeUpdate(sql);
       
       if( Fin_value == 0.0 )
       {
           sql = "UPDATE `my_db`.`sales` SET status= 'Clear' WHERE s_id = '" + sid + "' ;";
           stmt.executeUpdate(sql);
       }
       
       }catch(Exception e)
       {
            e.printStackTrace();
       }
   return 1;
   }
   
   
}
