/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tugas10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwar Arliman Gea
 */
public class GUI_HJM extends javax.swing.JFrame {

    /**
     * Creates new form GUI_HJM
     */
    public GUI_HJM() {
        initComponents();
        tampil();
    }
    public Connection conn;

  String Merk, Model, tipe, Jumlahstok, Tahunproduksi;

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_iventory_motor?user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Merk");
        tabelhead.addColumn("Model");
        tabelhead.addColumn("Jumlah Stok");
        tabelhead.addColumn("Tahun Produksi");
        tabelhead.addColumn("Type");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_data_sepeda_motor";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            table_HJM.setModel(tabelhead);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void refresh() {
        new GUI_HJM().setVisible(true);
        this.setVisible(false);
    }

   public void insert() {
    Merk = txtmerk.getText();
    Model = txtmodel.getText();
    int selectedIndex = Cmb_Tipe.getSelectedIndex();
    switch (selectedIndex) {
        case 0:
            tipe = "Metic";
            break;
        case 1:
            tipe = "Manual";
            break;
        case 2:
            tipe = "Kopling";
            break;
        default:
            tipe = "Pilihan Tidak Valid";
            break;
    }
    try {
        koneksi();
        int Jumlahstok = Integer.parseInt(txtproduksi.getText());
        int Tahunproduksi = Integer.parseInt(txtstok.getText());
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO tb_data_sepeda_motor (Merk, Model, `Jumlah Stok`, `Tahun Produksi`, Type) " +
                        "VALUES('" + Merk + "','" + Model + "','" + Jumlahstok + "','" + Tahunproduksi + "','" + tipe + "')");
        statement.close();
        JOptionPane.showMessageDialog(null, "Berhasil Memasukkan Data Sepeda Motor!\n" + Model);
    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
    }
    refresh();
}

    public void update() {
        Merk = txtmerk.getText();
        Model = txtmodel.getText();
        int selectedIndex = Cmb_Tipe.getSelectedIndex();
        switch (selectedIndex) {
            case 0:
                tipe = "Metic";
                break;
            case 1:
                tipe = "Manual";
                break;
            case 2:
                tipe = "Kopling";
                break;
            default:
                tipe = "Pilihan Tidak Valid";
                break;
        }
        try {
            koneksi();
            int Jumlahstok = Integer.parseInt(txtproduksi.getText());
            int Tahunproduksi = Integer.parseInt(txtstok.getText());
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_data_sepeda_motor SET Merk = '" + Merk + "', Model = '" + Model + "', JumlahStok = '" + Jumlahstok + "', TahunProduksi = '" + Tahunproduksi + "', Type = '" + tipe + "' WHERE some_condition");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Sepeda Motor Berhasil!");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                koneksi();
                String sql = "DELETE FROM tb_data_sepeda_motor WHERE some_condition";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
            }
        }
        refresh();
    }
    
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_data_sepada_motor WHERE `merk`  LIKE '%" + txtmerk.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtmodel.setText(rs.getString(2));
                    txtproduksi.setText(rs.getString(3));
                    txtstok.setText(rs.getString(4));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

    public void itempilih() {
        txtmerk.setText(Merk);
        txtmodel.setText(Model);
        txtproduksi.setText(Tahunproduksi);
        txtstok.setText(Jumlahstok);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmerk = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txtproduksi = new javax.swing.JTextField();
        Cmb_Tipe = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnTampil = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_HJM = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Merk");

        jLabel2.setText("Model");

        jLabel3.setText("Jumlah Stok");

        jLabel4.setText("Tahun Produksi");

        Cmb_Tipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Skuter (Scooter)", "Sport Bike", "Naked Bike" }));
        Cmb_Tipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_TipeActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Sepada Motor");

        btnTampil.setText("Tampilkan");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });

        table_HJM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Merk", "Model", "Jumlah Stok", "Tahun Produksi", "Type"
            }
        ));
        table_HJM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HJMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_HJM);

        btnHapus.setText("Update");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Delate");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cmb_Tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtmerk, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addComponent(txtmodel)
                                .addComponent(txtstok)
                                .addComponent(txtproduksi)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTampil)
                                .addGap(73, 73, 73)
                                .addComponent(btnHapus)
                                .addGap(59, 59, 59)
                                .addComponent(btnBatal)
                                .addGap(62, 62, 62)
                                .addComponent(btnClose))
                            .addComponent(jScrollPane2))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtproduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Cmb_Tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTampil)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnClose))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:                                        
        refresh();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void Cmb_TipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_TipeActionPerformed
        // TODO add your handling code here:
        int selectedIndex = Cmb_Tipe.getSelectedIndex();
        String tipe = "";
        switch (selectedIndex) {
            case 0:
                tipe = "Metic";
                break;
            case 1:
                tipe = "Manual";
                break;
            case 2:
                tipe = "Kopling";
                break;
            default:
        }
    }//GEN-LAST:event_Cmb_TipeActionPerformed

    private void table_HJMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HJMMouseClicked
        // TODO add your handling code here:
        int tabel = table_HJM.getSelectedRow();
        Merk = table_HJM.getValueAt(tabel, 0).toString();
        Model = table_HJM.getValueAt(tabel, 1).toString();
        Jumlahstok = table_HJM.getValueAt(tabel, 2).toString();
        Tahunproduksi = table_HJM.getValueAt(tabel, 3).toString();
        tipe = table_HJM.getValueAt(tabel, 4).toString();
        itempilih();

    }//GEN-LAST:event_table_HJMMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_HJM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cmb_Tipe;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTampil;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_HJM;
    private javax.swing.JTextField txtmerk;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtproduksi;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
