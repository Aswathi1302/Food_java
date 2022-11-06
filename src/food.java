import  java.util.Scanner;
public class food {
    public static void main(String[] args) {
    int choice;
    while(true)
    {
        System.out.println("Select the option");
        System.out.println("1.Add Food");
        System.out.println("2.Search Food");
        System.out.println("3.Delete Food");
        System.out.println("4.View all food");
        System.out.println("5.Exit");
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Add Food");
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
