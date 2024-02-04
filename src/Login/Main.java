package Login;

import Reservation.SystemReservation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ProjectDB db = new ProjectDB();
        db.DB();
        String DBname = db.name;
        String DBpass = db.password;
        String source;
        String destiny;
        int seat;
        Logging lg = new Logging();
        boolean login = lg.login(DBname, DBpass);

        if(login) {
            SystemReservation sr = new SystemReservation();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the source : ");
            source = sc.next();

            System.out.print("Enter the destination : ");
            destiny = sc.next();

            seat = sr.seats;
            sr.setSource(source);
            sr.setDestination(destiny);

            sr.searchTrains();
            db.saveData(DBname,source, destiny, seat);
            sr.ticket();
        }
    }
}