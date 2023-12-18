/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tugas4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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
    String merk1, model1, jumlah1, produksi1, type1;

    public Connection conn;

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_iventory_motor?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void itempilih() {
        txtmerk.setText(merk1);
        txtmodel.setText(model1);
        txtproduksi.setText(produksi1);
        txtstok.setText(jumlah1);
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("MERK");
        tabelhead.addColumn("MODEL");
        tabelhead.addColumn("TANGGAL");
        tabelhead.addColumn("BULAN");
        tabelhead.addColumn("TAHUN");
        tabelhead.addColumn("TYPE");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_data_sepeda_motor";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),});
            }
            tabeldata.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void refresh() {
        new GUI_HJM().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String Merk = txtmerk.getText();
        String Model = txtmodel.getText();
        String type = "";
        Object selectedItem = Cmb_Tipe.getSelectedItem();
        if (selectedItem == null) {
            type = "Pilihan Tidak Valid";
        } else {
            int selectedIndex = Cmb_Tipe.getSelectedIndex();
            switch (selectedIndex) {
                case 0:
                    type = "Metic";
                    break;
                case 1:
                    type = "Manual";
                    break;
                case 2:
                    type = "Kopling";
                    break;
                default:
                    type = "Pilihan Tidak Valid";
                    break;
            }
        }
        System.out.println("Tipe yang dipilih: " + type);
        String Produk = txtproduksi.getText();
        String stok = txtstok.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_data_sepada_motor (merk, model,stok, tahun, type)" + "VALUES('" + Merk + "','" + Model + "','" + stok + "','" + Produk + "','" + type + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Sepeda Motor!" + "\n" + Model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    public void update() {
        String Merk = txtmerk.getText();
        String Model = txtmodel.getText();
        String type = "";
        Object selectedItem = Cmb_Tipe.getSelectedItem();
        if (selectedItem == null) {
            type = "Pilihan Tidak Valid";
        } else {
            int selectedIndex = Cmb_Tipe.getSelectedIndex();
            switch (selectedIndex) {
                case 0:
                    type = "Metic";
                    break;
                case 1:
                    type = "Manual";
                    break;
                case 2:
                    type = "Kopling";
                    break;
                default:
                    type = "Pilihan Tidak Valid";
                    break;
            }
        }
        System.out.println("Tipe yang dipilih: " + type);
        String Produk = txtproduksi.getText();
        String stok = txtstok.getText();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_data_sepada_motor (merk, model,stok, tahun, type)" + "VALUES('" + Merk + "','" + Model + "','" + stok + "','" + Produk + "','" + type + "')");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Mahasiswa Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_data_sepada_motor WHERE model='" + txtmodel.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                delete();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
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
        Btn_tampil = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeldata = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        Btn_tampil.setText("TAMPILKAN");
        Btn_tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_tampilActionPerformed(evt);
            }
        });

        tabeldata.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabeldata);

        jButton1.setText("DELATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CLOSE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_tampil)
                                .addGap(83, 83, 83)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(69, 69, 69)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel5)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                        .addComponent(Cmb_Tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(Btn_tampil)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_tampilActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_Btn_tampilActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Cmb_TipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_TipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_TipeActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_HJM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_tampil;
    private javax.swing.JComboBox<String> Cmb_Tipe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabeldata;
    private javax.swing.JTextField txtmerk;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtproduksi;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
