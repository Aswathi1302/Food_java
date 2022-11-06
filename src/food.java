import java.sql.*;
import  java.util.Scanner;
public class food {
    public static void main(String[] args) {
        int foodcode;
        String name,description,preparedby,incrediance;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodrecipe","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
    int choice;
    while(true)
    {
        System.out.println("Select the option");
        System.out.println("1.Add Food");
        System.out.println("2.View all Food");
        System.out.println("3.Search Food");
        System.out.println("4.update food");
        System.out.println("5.Delete dood ");
        System.out.println("6.Exit ");
        System.out.println("*****************");
        System.out.println("ENTER YOUR CHOICE:--");
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter the Food code:--");
                foodcode=sc.nextInt();
                System.out.println("Enter the Name:--");
                name=sc.next();
                System.out.println("Enter Description:--");
                description=sc.next();
                System.out.println("Enter  name of cook: --");
                preparedby=sc.next();
                System.out.println("Enter incrediance:--");
                incrediance=sc.next();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodrecipe","root","");
                    String sql="INSERT INTO `recipe`(`foodcode`, `name`, `description`, `preparedby`, `incrediance`) VALUES (?,?,?,?,?)";
                    PreparedStatement stmt=con.prepareStatement((sql));
                    stmt.setInt(1,foodcode);
                    stmt.setString(2,name);
                    stmt.setString(3,description);
                    stmt.setString(4,preparedby);
                    stmt.setString(5,incrediance);
                    stmt.executeUpdate();
                    System.out.println("value inserted successfully.........!");
                }
                catch (Exception e){
                    System.out.println((e));
                }
                break;
            case 2:
                System.out.println("View all Food");
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodrecipe","root","");
                    String sql="SELECT `foodcode`, `name`, `description`, `preparedby`, `incrediance` FROM `recipe` ";
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(sql);
                    while ((rs.next())) {
                        String getfoodcode = rs.getString(("foodcode"));
                        String getname = rs.getString(("name"));
                        String getdescription = rs.getString(("description"));
                        String getpreparedby = rs.getString(("preparedby"));
                        String getincrediance = rs.getString(("incrediance"));
                        System.out.println("Food code=" + getfoodcode);
                        System.out.println("Name=" + getname);
                        System.out.println("Description=" + getdescription);
                        System.out.println("Prepared by=" + getpreparedby);
                        System.out.println("Compney name=" + getincrediance);
                        System.out.println("\n");
                    }
                }
                catch (Exception e){
                    System.out.println((e));
                }
                break;
            case 3:
                System.out.println("Search Food");
                System.out.println("Enter the Food code:");
                foodcode=sc.nextInt();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodrecipe","root","");
                    String sql = "SELECT `name`, `description`, `preparedby`, `incrediance` FROM `recipe` WHERE `foodcode`="+String.valueOf(foodcode);
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(sql);
                    while ((rs.next())) {
                        String getname = rs.getString(("name"));
                        String getdescription = rs.getString(("description"));
                        String getpreparedby = rs.getString(("preparedby"));
                        String getincrediance = rs.getString(("incrediance"));
                        System.out.println("Name=" + getname);
                        System.out.println("Description=" + getdescription);
                        System.out.println("Prepared by=" + getpreparedby);
                        System.out.println("Compney name=" + getincrediance);
                        System.out.println("\n");
                    }
                }
                catch (Exception e){
                    System.out.println((e));
                }
                break;
            case 4:
                System.out.println("Update Food");
                System.out.println("Enter the food code");
                foodcode=sc.nextInt();
                System.out.println("Enter the Name of food to be updated:");
                name=sc.next();
                System.out.println("Enter the Description to be updated--");
                description=sc.next();
                System.out.println("Enter cook name to be updated--");
                preparedby=sc.next();
                System.out.println("Enter incrediance to be updated:--");
                incrediance=sc.next();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodrecipe","root","");
                    String sql="UPDATE `recipe` SET `name`='"+name+"',`description`='"+description+"',`preparedby`='"+preparedby+"',`incrediance`='"+incrediance+"' WHERE `foodcode`="+String.valueOf(foodcode);
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate(sql);
                }
                catch (Exception e){
                    System.out.println((e));
                }

                break;
            case 5:
                System.out.println("Delete Food");
                break;
            case 6:
                System.exit(0);
        }
    }

}


}
