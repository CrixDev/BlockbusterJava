import javax.swing.SwingUtilities;

public class CatalogoApp {
    public static void main(String[] args) {
        //wasd
        SwingUtilities.invokeLater(() -> {
            CatalogoGUI gui = new CatalogoGUI();
            gui.setVisible(true);
        });
    }
} 