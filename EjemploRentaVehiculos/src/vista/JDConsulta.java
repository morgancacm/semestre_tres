/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jairo F
 */
public class JDConsulta extends JDialog implements ActionListener {
    
    private JLabel lbTipo;
    private JComboBox cmbTipo;
    private JTable tabla;
    
    private JButton boton;
    
    private String[] titulo = {"Placa", "Tipo", "Precio Km", "Km renta", "Km Devolucion",
                               "Precio Dia", "Fecha renta", "Fecha Devolucion", "Importe"};
    private String[][] datos={{null},{null},{null}};
    private DefaultTableModel modeloTabla ;
    
    private Container contenedor;

    public JDConsulta(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.initComponents();
        
    }
    
    public void initComponents(){
        
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.crearPanelFiltro();
        this.crearPanelTabla();
        this.pack();
        //this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    
    }
    
    public void crearPanelFiltro(){
        
        JPanel panel= new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lbTipo= new JLabel("Tipo Vehiculo: ");
        panel.add(this.lbTipo);
        
        String[] listItem = {"Automovil","Tractor"};
        this.cmbTipo = new JComboBox(listItem);
        this.cmbTipo.addActionListener(this);
        panel.add(this.cmbTipo);
        
        this.boton = new JButton("Buscar");
        this.boton.addActionListener(this);
        panel.add(this.boton);
        
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.NORTH);
    
    }
    
    public void crearPanelTabla(){
        
        JPanel panel = new JPanel();
        this.tabla = new JTable();
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.titulo);
        this.tabla.setModel(this.modeloTabla);
        this.tabla.setPreferredSize(new Dimension(950, 400));
        JScrollPane sPanel = new JScrollPane(this.tabla);
        sPanel.setPreferredSize(new Dimension(950, 400));
        panel.add(sPanel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.contenedor.add(panel, BorderLayout.CENTER);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.cmbTipo){
            String selected = this.cmbTipo.getSelectedItem().toString();
            JOptionPane.showMessageDialog(this, selected);
        }
        else{
                JOptionPane.showMessageDialog(this, "Click sobre boton");
        }
        
    }
    
    
}
