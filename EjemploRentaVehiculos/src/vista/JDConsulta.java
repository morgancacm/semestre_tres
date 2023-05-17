/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author morga
 */
public class JDConsulta extends JDialog {
    private JLabel lbTitle;
    private JButton btnAceptar, btnSalir;
    private JPanel panelBotones,panelTabla;
    private Container contenedor;
    
    
    public JDConsulta(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.initComponentes();
    }
    
    private void initComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.panelTitulos();
        this.panelTabla();
        this.panelBotones();
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void panelTitulos() {
        this.lbTitle = new JLabel("Tabla de datos");
        JPanel panel = new JPanel();
        panel.add(this.lbTitle);
        
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 20));
        this.contenedor.add(panel, BorderLayout.WEST);
    }
    
    private void panelTabla() {
        String [] titles = {"Placa", "Tipo"};
        String [] [] data = {
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"},
            {"SVG-123", "Autobus"}, {"SSG-143", "Automovil"}, {"FVG-163", "Autobus"}, {"LOW-127", "Tractor"}
        };
        
        DefaultTableModel modeloTable = new DefaultTableModel(data, titles);
        JTable table = new JTable(modeloTable);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(3, 3, 3, 3);
        
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        
        JPanel panelAux = new JPanel();
        panelAux.add(panel);
        
        panelAux.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        this.contenedor.add(panelAux, BorderLayout.CENTER);
    }
    
    private void panelBotones() {
        this.btnAceptar = new JButton("Aceptar");
        this.btnSalir = new JButton("Salir");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 5, 5));
        panel.add(this.btnAceptar);
        panel.add(this.btnSalir);
        
        JPanel panelAux = new JPanel();
        panelAux.add(panel);
        
        panelAux.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        this.contenedor.add(panelAux, BorderLayout.SOUTH);
    }
//    private JTable table;
//    private JScrollPane scrollPane;
//    
//    private Container contenedor;
//
//    public JDConsulta(Frame owner, String title, boolean modal) {
//        super(owner, title, modal);
//        this.initTable();
//    }
//    
//    private void initTable() {
//        this.contenedor = this.getContentPane();
//        this.contenedor.setLayout(new BorderLayout());
//        this.pack();
//        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        this.setTitle("Consulta de alquileres");
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//        
//        {
//            scrollPane = new JScrollPane();
//            getContentPane().add(scrollPane);
//            scrollPane.setBounds(40, 20, 320, 120);
//            {
//                String [] [] datos = {{"ALX-234", "SVG-123"}};
//                String [] titles = new String [] {"Placa"};
//                TableModel modeloTable = new DefaultTableModel (datos, titles);
//                table = new JTable();
//                table.setModel(modeloTable);
//                table.setPreferredSize(new Dimension(350, datos.length*16));
//                scrollPane.setViewportView(table);
//                TableRowSorter ordenador = new TableRowSorter(modeloTable);
//                table.setRowSorter(ordenador);
//            }
//        }
//        this.setSize(400, 300);
//        JFrame panel = new JFrame();
//        panel.setLayout(null);
//        panel.setSize(500, 500);
//        panel.setLocationRelativeTo(null);
//        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        panel.add(scrollPane);
//        panel.setVisible(true);
//    }

}


