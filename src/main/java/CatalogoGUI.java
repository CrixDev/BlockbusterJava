import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CatalogoGUI extends JFrame {
    private List<Producto> productos;
    private JTable tablaProductos;
    private DefaultTableModel modelo;
    private JTextField txtNombre, txtDescripcion, txtPrecio, txtStock;
    private int idActual = 1;

    public CatalogoGUI() {
        productos = new ArrayList<>();
        inicializarGUI();
    }

    private void inicializarGUI() {
        setTitle("Gestor de Catálogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEntrada.add(txtNombre);

        panelEntrada.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelEntrada.add(txtDescripcion);

        panelEntrada.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelEntrada.add(txtPrecio);

        panelEntrada.add(new JLabel("Stock:"));
        txtStock = new JTextField();
        panelEntrada.add(txtStock);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // Tabla de productos
        String[] columnas = {"ID", "Nombre", "Descripción", "Precio", "Stock"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaProductos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);

        // Agregar componentes al panel principal
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarProducto());
        btnModificar.addActionListener(e -> modificarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        tablaProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarProductoSeleccionado();
            }
        });

        add(panelPrincipal);
    }

    private void agregarProducto() {
        try {
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());

            Producto producto = new Producto(idActual++, nombre, descripcion, precio, stock);
            productos.add(producto);
            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos");
        }
    }

    private void modificarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            try {
                int id = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());

                for (Producto p : productos) {
                    if (p.getId() == id) {
                        p.setNombre(nombre);
                        p.setDescripcion(descripcion);
                        p.setPrecio(precio);
                        p.setStock(stock);
                        break;
                    }
                }
                actualizarTabla();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Producto modificado exitosamente");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para modificar");
        }
    }

    private void eliminarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
            productos.removeIf(p -> p.getId() == id);
            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para eliminar");
        }
    }

    private void cargarProductoSeleccionado() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            txtNombre.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
            txtDescripcion.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
            txtPrecio.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
            txtStock.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (Producto p : productos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getStock()
            });
        }
    }
} 