/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.*;

/**
 *
 * @author Jairo F
 */
public class JDRegistro extends JDialog {

    private JLabel lbPlaca, lbPrecioKm, lbKmRenta, lbKmDev, lbTipoVehiculo;
    private JLabel lbPrecioDia, lbFechaRenta, lbFechaDev;
    
    private JTextField txtPlaca, txtPrecioKm, txtKmRenta, txtKmDevolucion;
    private JFormattedTextField txtPrecioDia, txtFechaRenta, txtFechaDevolucion;
    
    private JComboBox cmbTipoVehiculo;
    
    private JButton btnGuardar, btnCancelar;
    
    private JPanel panelDatos, panelBotones;
    
    private Container contenedor;

    public JDRegistro(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.initComponentes();
    }

    private void initComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.panelDatos();
        this.panelBotones();
        //this.setSize(400, 200);
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void panelBotones() {

        this.btnGuardar = new JButton("Guardar");
        this.btnGuardar.addActionListener(new clickBotonGuardar());
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.addActionListener(new clickBotonCancelar());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        panel.add(this.btnGuardar);
        panel.add(this.btnCancelar);

        JPanel panelAux = new JPanel();
        panelAux.add(panel);
        
        panelAux.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
        this.contenedor.add(panelAux, BorderLayout.EAST);

    }

    private void panelDatos() {

        this.lbPlaca = new JLabel("Placa: ");
        this.lbTipoVehiculo = new JLabel("Tipo vehiculo: ");
        this.lbPrecioKm = new JLabel("precio x Km: ");
        this.lbKmRenta = new JLabel("Km de renta: ");
        this.lbKmDev = new JLabel("Km de devolucion: ");
        this.lbPrecioDia = new JLabel("Precio x Dia: ");
        this.lbFechaRenta = new JLabel("Fecha de renta: ");
        this.lbFechaDev = new JLabel("Fecha de devolucion: ");

        this.txtPlaca = new JTextField();
        this.txtPrecioKm= new JTextField();
        this.txtKmRenta= new JTextField();
        this.txtKmDevolucion= new JTextField();
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        this.txtPrecioDia = new JFormattedTextField(currencyFormat);
        this.txtPrecioDia.setValue(0);
        this.txtFechaRenta= new JFormattedTextField();
        this.txtFechaRenta.setValue(new Date());
        this.txtFechaDevolucion= new JFormattedTextField();
        this.txtFechaDevolucion.setValue(new Date());
        
        this.cmbTipoVehiculo = new JComboBox();
        this.cmbTipoVehiculo.addActionListener(new clickComboTipo());
        this.cmbTipoVehiculo.addItem("Autobus");
        this.cmbTipoVehiculo.addItem("Tractor");
        


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 5));
        panel.add(this.lbPlaca);
        panel.add(this.txtPlaca);

        panel.add(this.lbTipoVehiculo);
        panel.add(this.cmbTipoVehiculo);
        
        panel.add(this.lbPrecioKm);
        panel.add(this.txtPrecioKm);
        
        panel.add(this.lbKmRenta);
        panel.add(this.txtKmRenta);
        
        panel.add(this.lbKmDev);
        panel.add(this.txtKmDevolucion);
        
        panel.add(this.lbPrecioDia);
        panel.add(this.txtPrecioDia);
        
        panel.add(this.lbFechaRenta);
        panel.add(this.txtFechaRenta);
        
        panel.add(this.lbFechaDev);
        panel.add(this.txtFechaDevolucion);
        
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.contenedor.add(panel, BorderLayout.CENTER);

    }
    
    class clickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    class clickBotonCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    class clickComboTipo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            activarComponentes();
        }
    
    }
    
    public void activarComponentes(){
        String selected = this.cmbTipoVehiculo.getSelectedItem().toString();
        boolean tipo = selected.equals("Autobus");
        
        this.txtPrecioKm.setEnabled(!tipo);
        this.txtKmRenta.setEnabled(!tipo);
        this.txtKmDevolucion.setEnabled(!tipo);
        
        this.txtPrecioDia.setEnabled(tipo);
        this.txtFechaRenta.setEnabled(tipo);
        this.txtFechaDevolucion.setEnabled(tipo);
    
    }
}
