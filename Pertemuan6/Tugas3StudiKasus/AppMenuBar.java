import javax.swing.*;

public class AppMenuBar extends JMenuBar {
    private static Runnable formMenuListener;

    public AppMenuBar(JFrame frame) {
        // Menu Navigasi
        JMenu menu = new JMenu("Navigasi");
        JMenuItem formMenuItem = new JMenuItem("Form Input");

        // Listener untuk membuka form
        formMenuItem.addActionListener(e -> {
            if (formMenuListener != null) formMenuListener.run();
        });

        // Menambahkan item ke menu
        menu.add(formMenuItem);
        add(menu);
    }

    public static void addFormMenuListener(Runnable listener) {
        formMenuListener = listener;
    }
}
