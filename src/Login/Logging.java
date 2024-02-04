package Login;

import java.util.Scanner;

public class Logging {
    String uname;
    String pass;
    public boolean login(String DBName, String DBPass) {
        Scanner sc = new Scanner(System.in);
        int i = 3;
        while (i >= 0) {
            if (uname == null || pass == null) {
                System.out.print("Enter the UserName : ");
                uname = sc.next();
                System.out.print("Enter the password : ");
                pass = sc.next();
                continue;
            }
            if (uname.equals(DBName) && pass.equals(DBPass)) {
                System.out.println("Successful");

                return true;
            } else {
                System.out.println("Incorrect ");
                uname = null;
                pass = null;
            }
            i--;
        }
        sc.close();
    return false;
    }
}
