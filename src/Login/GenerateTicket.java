package Login;import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class GenerateTicket extends JFrame {
     ArrayList<String> list;
     JLabel headingLabel;
     JLabel detailsLabel;
     JLabel dateLabel;
     JLabel reservationIdLabel;
     JLabel congratulationsLabel;

    private String reservationId;

    public GenerateTicket(ArrayList<String> list, String source, String destination) {
        this.list = list;

        setTitle("Train Ticket");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        generateReservationId();

        initUI(source, destination);

        setLocationRelativeTo(null);
        setVisible(true);

        cancelReservationForm();

        closeJFrame();
    }

    private void generateReservationId() {

        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000);
        reservationId = String.valueOf(randomNumber);
    }

    private void initUI(String source, String destination) {
        setLayout(new GridLayout(0, 1));

        headingLabel = new JLabel("Train Ticket");
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        detailsLabel = new JLabel("Source: " + source + "   |   Destination: " + destination);
        detailsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(detailsLabel);

        dateLabel = new JLabel("Date and Time: " + getCurrentDateTime());
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dateLabel);

        reservationIdLabel = new JLabel("Reservation ID: " + reservationId);
        reservationIdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        reservationIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(reservationIdLabel);

        int count = 1;
        for (String element : list) {
            JLabel label = new JLabel(count + ". " + element);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            add(label);
            count++;
        }

        congratulationsLabel = new JLabel("Congratulations on booking your train ticket!");
        congratulationsLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(congratulationsLabel);

        pack();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private void cancelReservationForm() {

        System.out.println("\n=== Cancellation Form ===");
        System.out.print("Enter your reservation ID to cancel: ");

        Scanner scanner = new Scanner(System.in);
        String userEnteredReservationId = scanner.nextLine();

        if (userEnteredReservationId.equals(reservationId)) {
            System.out.println("Reservation ID " + userEnteredReservationId + " has been canceled.");
        } else {
            System.out.println("Invalid reservation ID. Cancellation failed.");
        }
    }

    private void closeJFrame() {

        SwingUtilities.invokeLater(() -> {
            this.dispose();
        });
    }
}