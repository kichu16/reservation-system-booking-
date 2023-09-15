import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationSystem {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public ReservationSystem() {
        frame = new JFrame("Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                openCancellationForm();
            }
        });

        frame.setVisible(true);
    }

    private void openCancellationForm() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        JLabel cancellationLabel = new JLabel("Cancellation Form");
        JButton cancelButton = new JButton("Cancel Reservation");

        frame.add(cancellationLabel);
        frame.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Reservation cancelled!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReservationSystem();
            }
        });
    }
}
