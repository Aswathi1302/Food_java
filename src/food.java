import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        System.out.println("2.Search Food");
        System.out.println("3.Delete Food");
        System.out.println("4.View all food");
        System.out.println("5.Exit");
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
                System.out.println("Search Food");
                break;
            case 3:
                System.out.println("Delete Food");
                break;
            case 4:
                System.out.println("View all Food");
                break;
            case 5:
                System.exit(0);
        }
    }

}


}
