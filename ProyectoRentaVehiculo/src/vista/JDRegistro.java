/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.LogicRenta;
import modelo.Autobus;
import modelo.Tractor;
import modelo.Vehiculo;

/**
 *
 * @author Jairo F
 */
public class JDRegistro extends JDialog implements ActionListener {

    private Container contenedor;

    private JLabel lbPlaca, lbTipo, lbPrecioKm, lbKmRenta, lbKmDev;
    private JLabel lbPrecioDia, lbFechaRenta, lbFechaDev;

    private JButton btnguardar, btnCancelar,btnBuscar, btnEliminar, btnEditar;

    private JTextField txtPlaca, txtPrecioKm, txtkmRenta, txtKmDev;
    private JFormattedTextField txtPrecioDia, txtFechaRenta, txtFechaDev;

    private JComboBox cmbTipo;

    private LogicRenta logica;

    public JDRegistro(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.logica = new LogicRenta();
        this.initComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponentes() {

        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crearPanelDatos();
        this.panelBotones();

    }

    public void panelBotones() {

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(5, 1, 5, 5));

        this.btnguardar = new JButton("   Guardar   ");
        this.btnguardar.addActionListener(this);
        this.btnCancelar = new JButton("  Cancelar  ");
        this.btnCancelar.addActionListener(this);
        
        this.btnBuscar = new JButton("  Buscar  ");
        this.btnEliminar = new JButton("  Eliminar  ");
        this.btnEliminar.setEnabled(false);
        this.btnEditar = new JButton("  Editar  ");
        this.btnEditar.setEnabled(false);
        
        panelGrid.add(this.btnguardar);
        panelGrid.add(this.btnCancelar);
        panelGrid.add(this.btnBuscar);
        panelGrid.add(this.btnEditar);
        panelGrid.add(this.btnEliminar);

        JPanel panel = new JPanel();
        panel.add(panelGrid);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panel, BorderLayout.EAST);

    }

    public void crearPanelDatos() {

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(8, 2, 5, 5));

        this.lbPlaca = new JLabel("Placa: ");
        this.lbTipo = new JLabel("Tipo vehiculo: ");
        this.lbPrecioKm = new JLabel("Precio Km: ");
        this.lbKmRenta = new JLabel("Km renta: ");
        this.lbKmDev = new JLabel("Km Devolucion: ");
        this.lbPrecioDia = new JLabel("Precio Dia: ");
        this.lbFechaRenta = new JLabel("Fecha renta: ");
        this.lbFechaDev = new JLabel("fecha devolucion: ");

        this.txtPlaca = new JTextField(20);

        this.txtPrecioKm = new JTextField();
        this.txtkmRenta = new JTextField();
        this.txtKmDev = new JTextField();;

        NumberFormat formato = NumberFormat.getCurrencyInstance();
        this.txtPrecioDia = new JFormattedTextField(formato);
        this.txtPrecioDia.setValue(0);
        this.txtFechaRenta = new JFormattedTextField();
        this.txtFechaRenta.setValue(new Date());
        this.txtFechaDev = new JFormattedTextField();
        this.txtFechaDev.setValue(new Date());

        this.cmbTipo = new JComboBox();
        this.cmbTipo.addActionListener(this);
        this.cmbTipo.addItem("Autobus");
        this.cmbTipo.addItem("Tractor");

        panelGrid.add(this.lbPlaca);
        panelGrid.add(this.txtPlaca);

        panelGrid.add(this.lbTipo);
        panelGrid.add(this.cmbTipo);

        panelGrid.add(this.lbPrecioKm);
        panelGrid.add(this.txtPrecioKm);

        panelGrid.add(this.lbKmRenta);
        panelGrid.add(this.txtkmRenta);

        panelGrid.add(this.lbKmDev);
        panelGrid.add(this.txtKmDev);

        panelGrid.add(this.lbPrecioDia);
        panelGrid.add(this.txtPrecioDia);

        panelGrid.add(this.lbFechaRenta);
        panelGrid.add(this.txtFechaRenta);

        panelGrid.add(this.lbFechaDev);
        panelGrid.add(this.txtFechaDev);

        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panelGrid, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.btnguardar) {
            try {
                Vehiculo v = this.leerDatosVehiculo();
                this.logica.rentarVehiculo(v);
                JOptionPane.showMessageDialog(this,"registro exitoso", "Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                this.cancelar();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,ex, "Error",JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == this.btnCancelar) {
            this.cancelar();
//            JOptionPane.showMessageDialog(this, "Click sobre cancelar");
        } else {
            //JOptionPane.showMessageDialog(this, "Click sobre combo");
            this.activarComponentes();
        }

    }

    private Vehiculo leerDatosVehiculo() {

        Vehiculo v = null;
        String placa = this.txtPlaca.getText();
        String tipo = this.cmbTipo.getSelectedItem().toString();
        switch (tipo) {
            case "Autobus":
                double precioKm = Double.parseDouble(this.txtPrecioKm.getText());
                double kmRenta = Double.parseDouble(this.txtkmRenta.getText());
                double kmDev = Double.parseDouble(this.txtKmDev.getText());
                v = new Autobus(precioKm, kmRenta, kmDev, placa, true);
                break;
            case "Tractor":
                double precioDia = ((Number)this.txtPrecioDia.getValue()).doubleValue();
                Date fecha = (Date)this.txtFechaRenta.getValue();
                LocalDate fechaRenta = LocalDate.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
                fecha = (Date)this.txtFechaDev.getValue();
                LocalDate fechaDev = LocalDate.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
                v = new Tractor(precioDia, fechaRenta, fechaDev, placa, true);

        }
        return v;
    }

    private void activarComponentes() {

        String select = this.cmbTipo.getSelectedItem().toString();
        boolean activado = select.equals("Tractor");

        this.txtPrecioKm.setEnabled(!activado);
        this.txtkmRenta.setEnabled(!activado);
        this.txtKmDev.setEnabled(!activado);

        this.txtPrecioDia.setEnabled(activado);
        this.txtFechaRenta.setEnabled(activado);
        this.txtFechaDev.setEnabled(activado);

    }
    
    private void cancelar(){
            this.txtPlaca.setText(null);
            this.txtPlaca.grabFocus();
            
            this.cmbTipo.setSelectedIndex(0);
            this.activarComponentes();
            
            this.txtPrecioKm.setText(null);
            this.txtkmRenta.setText(null);
            this.txtKmDev.setText(null);
            
            this.txtPrecioDia.setValue(0);
            this.txtFechaRenta.setValue(new Date());
            this.txtFechaDev.setValue(new Date());
    
    }

}
