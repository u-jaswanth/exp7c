import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App {

    public static double calculateDiscount(
            double price, String category) {

        switch (category) {

            case "electronics":
                return price * 0.9;

            case "clothing":
                return price * 0.8;

            default:
                return price;
        }
    }

    public static void main(String[] args) {

        JFrame frame =
            new JFrame("Front End Grid - Data Driven Test");

        String[] columns = {
            "Price", "Category", "Result"
        };

        DefaultTableModel model =
            new DefaultTableModel(columns, 0);

        Object[][] gridData = {
            {500.0, "electronics"},
            {300.0, "clothing"},
            {150.0, "grocery"}
        };

        for (Object[] row : gridData) {

            double price = (double) row[0];

            String category = (String) row[1];

            double result =
                calculateDiscount(price, category);

            model.addRow(new Object[] {
                price,
                category,
                String.format("%.2f", result)
            });
        }

        JTable table = new JTable(model);

        frame.add(new JScrollPane(table));

        frame.setSize(400, 200);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);
    }
}
