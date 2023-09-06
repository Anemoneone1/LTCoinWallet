import javax.swing.*;
import java.awt.*;

public class TransferListRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        TransferInstance transfer = (TransferInstance) value;

        if (transfer.getReceiver().equals("userWallet")) {
            setForeground(Color.GREEN);
            setText("Amount: +" + transfer.getAmount() + "LTC | Date: " + transfer.getDate() + " | Sender: " + transfer.getSender());
        } else {
            setForeground(Color.RED);
            setText("Amount: -" + transfer.getAmount() + "LTC | Date: " + transfer.getDate() + " | Receiver: " + transfer.getReceiver());
        }


        return this;
    }
}