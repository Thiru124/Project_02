package Reservation;

import Login.GenerateTicket;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemReservation {
    String source;
    String destination;
    public int seats = 0;
    Scanner sc = new Scanner(System.in);
    public ArrayList<String> travellers = new ArrayList<>();

    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void searchTrains(){
        ArrayList<String> sources = new ArrayList<>();
                sources.add("chennai");
                sources.add("mumbai");
                sources.add("delhi");

                ArrayList<String> destiny = new ArrayList<>();
                destiny.add("hydrabad");
                destiny.add("ooty");
                destiny.add("shimla");

        for(String i : sources)
            if(i.equals(source))
                for(String j : destiny)
                    if(j.equals(destination)){
                        System.out.print("Enter the number of seats : ");
                        int seat = sc.nextInt();
                        seats = seat;
                        if(seat > 1){
                            System.out.println("Enter the travellers name :->");
                            for (int k = 0; k < seat; k++) {
                                String names = sc.next();
                                travellers.add(names);
                            }
                        }
                    }
    }
    public void ticket() {
       new GenerateTicket(travellers, source, destination);
    }
}

