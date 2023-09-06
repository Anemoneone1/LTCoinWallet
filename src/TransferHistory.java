import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TransferHistory extends JFrame {
    private JList<TransferInstance> transferList;
    private DefaultListModel<TransferInstance> listModel;

    public TransferHistory() {
        setTitle("Transfer History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);

        listModel = new DefaultListModel<>();
        transferList = new JList<>(listModel);
        transferList.setCellRenderer(new TransferListRenderer());

        JScrollPane scrollPane = new JScrollPane(transferList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateTransferList());
        getContentPane().add(updateButton, BorderLayout.SOUTH);

        updateTransferList();
    }

    private void updateTransferList() {
        List<TransferInstance> updatedList = generateTransferList();

        listModel.clear();

        for (TransferInstance transfer : updatedList) {
            listModel.addElement(transfer);
        }
    }

    private List<TransferInstance> generateTransferList() {
        List<TransferInstance> transfers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String sender = getRandomSender();
            String receiver = getRandomReceiver();
            double amount = random.nextDouble() * 1000;
            Date date = new Date();

            TransferInstance transfer = new TransferInstance(amount, sender, receiver, date);
            transfers.add(transfer);
        }

        return transfers;
    }

    private String getRandomSender() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "userWallet";
        } else {
            return "OtherParty";
        }
    }

    private String getRandomReceiver() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "userWallet";
        } else {
            return "OtherParty";
        }
    }

}
