import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WalletGUI {
    public static void MainPage() {
        JFrame frame = new JFrame("LTCoin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        Border customBorder = BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
        );

        //Wallet stuff
        JPanel walletPanel = new JPanel();
        TitledBorder title1 = BorderFactory.createTitledBorder(customBorder, "Your wallet");
        walletPanel.setBorder(title1);
        walletPanel.setLayout(new GridLayout(3, 2));

        JLabel walletNumberLabel = new JLabel("Wallet Number:");
        JTextField walletNumberField = new JTextField(20);
        walletNumberField.setEditable(false);

        JLabel balanceLabel = new JLabel("Account Balance:");
        JTextField balanceField = new JTextField(10);
        balanceField.setEditable(false);


        JLabel marketRateLabel = new JLabel("Market Rate:");
        JTextField marketRateField = new JTextField(10);
        marketRateField.setEditable(false); // Make it read-only

        //placeholders TODO
        walletNumberField.setText("Wallet number");
        balanceField.setText("48,123 LTC");
        marketRateField.setText("0,0328 USD/1 LTC");

        walletPanel.add(walletNumberLabel);
        walletPanel.add(walletNumberField);
        walletPanel.add(balanceLabel);
        walletPanel.add(balanceField);
        walletPanel.add(marketRateLabel);
        walletPanel.add(marketRateField);

        // transfer stuff
        JPanel topic2Panel = new JPanel();
        TitledBorder title2 = BorderFactory.createTitledBorder(customBorder, "Transfer");
        topic2Panel.setBorder(title2);
        topic2Panel.setLayout(new GridLayout(3, 2));

        JLabel recipientLabel = new JLabel("Recipient Wallet:");
        JTextField recipientField = new JTextField(20);

        JLabel amountLabel = new JLabel("Amount to Send:");
        JTextField amountField = new JTextField(10);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (recipientField.getText().isBlank()||amountField.getText().isBlank()){
                    infoPopup("Error", "You need to fill all the fields first");
                } else {
                    try {
                        double d = Double.parseDouble(amountField.getText());
                        confirmationPopup(recipientField.getText(), d);
                    }
                    catch (NumberFormatException x){
                        infoPopup("Error", "Wrong amount format.");
                    }
                }
            }
        });
        JButton historyButton = new JButton("View Transfer History");
        historyButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                TransferHistory historyFrame = new TransferHistory();
                historyFrame.setVisible(true);
            });
        });

        topic2Panel.add(recipientLabel);
        topic2Panel.add(recipientField);
        topic2Panel.add(amountLabel);
        topic2Panel.add(amountField);
        topic2Panel.add(sendButton);
        topic2Panel.add(historyButton);

        //staking stuff
        JPanel topic3Panel = new JPanel();
        TitledBorder title3 = BorderFactory.createTitledBorder(customBorder, "Topic 3: Staking Functionality");
        topic3Panel.setBorder(title3);
        topic3Panel.setLayout(new GridLayout(3, 2));

        JLabel lockedBalanceLabel = new JLabel("Locked Balance:");
        JTextField lockedBalanceField = new JTextField(10);
        lockedBalanceField.setEditable(false);

        JLabel stakingAmountLabel = new JLabel("Staking Amount:");
        JTextField stakingAmountField = new JTextField(10);

        JButton stakeButton = new JButton("Stake");
        JButton unlockButton = new JButton("Unlock Stakes");

        //placeholders TODO
        lockedBalanceField.setText("22.321 LTC");

        topic3Panel.add(lockedBalanceLabel);
        topic3Panel.add(lockedBalanceField);
        topic3Panel.add(stakingAmountLabel);
        topic3Panel.add(stakingAmountField);
        topic3Panel.add(stakeButton);
        topic3Panel.add(unlockButton);

        mainPanel.add(walletPanel);
        mainPanel.add(topic2Panel);
        mainPanel.add(topic3Panel);

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    private static void infoPopup(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void confirmationPopup(String recipient, double amount) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel infoLabel = new JLabel("You are about to send " + amount + " to the following account:" + recipient);
        infoLabel.setVisible(true);

        int choice = JOptionPane.showConfirmDialog(null, panel, "Payment Confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (choice == JOptionPane.OK_OPTION) {
            //TODO payment
            JOptionPane.showMessageDialog(null, "Payment sent successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Payment canceled.");
        }
    }


}
