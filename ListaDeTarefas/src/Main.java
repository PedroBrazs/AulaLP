import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaDeTarefasGUI app = new ListaDeTarefasGUI();
            app.setVisible(true);
        });
    }
}