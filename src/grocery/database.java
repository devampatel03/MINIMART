package grocery;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class database implements database_interface {
    public void CustomerDetails() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from all_customer_details");

            System.out.println("Customer Id"+"   "+"Name"+"           "+"Address"+"                  "+"Pincode:" +"     " + "Phone No.:"+"    " + "Email Id:");

            while (rs.next()) {

                int id = rs.getInt("Cust_Id");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                int pincode = rs.getInt("Pincode");
                long ph_no = rs.getLong("Ph_No");
                String email = rs.getString("Email_Id");

                System.out.printf("| %-4d | %-20s | %-20s | %-4d | %-4d | %-20s |\n", id, name, address,pincode,ph_no,email);


            }


            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void CustomerDetails(String specific_name) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            PreparedStatement stmt = con.prepareStatement("select * from all_customer_details where name=?");
            stmt.setString(1, specific_name);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Customer Id"+"   "+"Name"+"           "+"Address"+"                 "+"Pincode:" +"     " + "Phone No.:"+"    " + "Email Id:");

            while (rs.next()) {

                int id = rs.getInt("Cust_Id");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                int pincode = rs.getInt("Pincode");
                long ph_no = rs.getLong("Ph_No");
                String email = rs.getString("Email_Id");

                System.out.printf("| %-4d | %-20s | %-20s | %-4d | %-4d | %-20s |\n", id, name, address,pincode,ph_no,email);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void CustomerDetails(int new_cust_id, String new_name, String new_address, int new_pincode, long new_number, String new_email) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            PreparedStatement stmt = con.prepareStatement("insert into all_customer_details (Cust_Id,Name,Address,Pincode,Ph_No,Email_Id)" + "values(?,?,?,?,?,?)");
            stmt.setInt(1, new_cust_id);
            stmt.setString(2, new_name);
            stmt.setString(3, new_address);
            stmt.setInt(4, new_pincode);
            stmt.setLong(5, new_number);
            stmt.setString(6, new_email);

            stmt.execute();
            System.out.println(" Customer registered successfully! ");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void Items_list() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Items_List");
            System.out.println("Item No " +" " + "Item Name " + "    " + "Price ");

            while (rs.next()) {

                int item_no = rs.getInt("Item_No");
                String item_name = rs.getString("Item_Name");
                int item_price = rs.getInt("Price");
                System.out.printf("| %-4d | %-30s | %-4d |\n", item_no, item_name, item_price);


            }


            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
    }

    public String name_list(int index) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Items_List");
            ArrayList<String> items_name_list = new ArrayList<>();

            while (rs.next()) {


                String item_name = rs.getString("Item_Name");

                items_name_list.add(item_name);

            }

            con.close();
            return items_name_list.get(index);
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
        return null;
    }

    public Integer price_list(int index) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Items_List");

            ArrayList<Integer> items_price_list = new ArrayList<>();
            while (rs.next()) {


                int item_price = rs.getInt("Price");

                items_price_list.add(item_price);

            }

            con.close();
            return items_price_list.get(index);
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
        return null;
    }

    public void get_bill_cust(int id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer_" + id);

            java.util.Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = dateFormat.format(currentDate);

            Random random = new Random();


            int randomInt = random.nextInt(10000);
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println("                              MINIMART                            ");
            System.out.println();
            System.out.println(formattedDateTime + "                           " + "Bill No.:" + randomInt);
            System.out.println();
            System.out.println("Item No." + "  " + "Item Name" + "                          " + "Quantity" + "  " + "Price");
            while (rs.next()) {

                int item_no = rs.getInt("Item_No");
                String item_name = rs.getString("Item_Name");
                int quantity = rs.getInt("Quantity");
                int item_price = rs.getInt("Price");
                System.out.printf("| %-4d | %-20s | %-4d | %-4d |\n", item_no, item_name, quantity, item_price);


            }


            ResultSet rrs = stmt.executeQuery("SELECT SUM(Price) AS TotalPrice FROM customer_" + id);
            if (rrs.next()) {
                int totalBill = rrs.getInt("TotalPrice");
                System.out.println();
                System.out.println("                Total Bill Amount: " + totalBill);
                System.out.println();
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------");

            }
            con.close();

        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void create_cust_table(int id) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table customer_"+id+" (Item_No integer not null unique primary key ," +
                    "Item_Name text(1000) not null," +
                    "Quantity integer," +
                    "Price integer," +
                    "foreign key(Item_No) references Items_List(Item_No));");


            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void add_item_into_cust_cart(int id,int choice,int quantity) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);

            GroceryStore add_object=new GroceryStore();

            PreparedStatement stmt = con.prepareStatement("insert into customer_"+id+" (Item_No,Item_Name,Quantity,Price)" + "values(?,?,?,?)");
            stmt.setInt(1, choice);
            stmt.setString(2, add_object.name_list(choice-1));
            stmt.setInt(3, quantity);
            stmt.setInt(4, (add_object.price_list(choice-1)*quantity));


            stmt.execute();

            con.close();
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }

    public void delete_cust(int id) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://127.0.0.1:3306/minimart";
            String db_username = "root";
            String db_password = "project@123";

            Connection con = DriverManager.getConnection(connectionString,
                    db_username,
                    db_password);


            String query1 = "delete from all_customer_details where Cust_Id = ?";
            String query2="delete from customer_"+id;
            PreparedStatement preparedStmt1 =
                    con.prepareStatement(query1);
            preparedStmt1.setInt(1, id);
            preparedStmt1.execute();

            PreparedStatement preparedStmt2 =
                    con.prepareStatement(query2);
            preparedStmt2.executeUpdate();
            con.close();

            System.out.println("Customer Deleted Successfully !");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }



}
