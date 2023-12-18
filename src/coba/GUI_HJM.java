/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coba;

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
     * Creates new form GUI_Mahasiswa
     */
    public GUI_HJM() {
        initComponents();
        tampil();
    }
    public Connection conn;

    public void clear() {
        txtmerk.setText("");
        txtmodel.setText("");
        txtstok.setText("");
        txtproduk.setText("");
        btnGroupJk.clearSelection();
    }

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_iventory_motor?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_HJM.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    String merk1, model1, stok1, produk1, tipe1;

    public void itempilih() {
        txtmerk.setText(merk1);
        txtmodel.setText(model1);
        txtstok.setText(stok1);
        txtproduk.setText(produk1);
        if (tipe1.equalsIgnoreCase("Metic")) {
            radiobtnmetic.setSelected(true);
        } else if (tipe1.equalsIgnoreCase("Manual")) {
            radiobtnmanual.setSelected(true);
        } else if (tipe1.equalsIgnoreCase("Kopling")) {
            radiobtnkopling.setSelected(true);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("MERK");
        tabelhead.addColumn("MODEL");
        tabelhead.addColumn("JUMLAH STOK");
        tabelhead.addColumn("TAHUN PRODUKSI");
        tabelhead.addColumn("TYPE");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_data_sepada_motor";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),});
            }
            table_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void update() {
        String Merk = txtmerk.getText();
        String Model = txtmodel.getText();
        String Tipe = null;
        if (Tipe.equalsIgnoreCase("Metic")) {
            radiobtnmetic.setSelected(true);
        } else if (Tipe.equalsIgnoreCase("Manual")) {
            radiobtnmanual.setSelected(true);
        } else if (Tipe.equalsIgnoreCase("Kopling")) {
            radiobtnkopling.setSelected(true);
        }
        String Stok = txtstok.getText();
        String Produk = txtproduk.getText();
        String Merklama = merk1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_data_sepada_motor SET merk='" + Merk + "'," + "model='" + Model + "',"
             + "type='" + Tipe + "'" + ",jumlah stok='" + Stok + "',tahun produksi='" + Produk + "' WHERE merk = '" + Merklama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Motor Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    public void refresh() {
        new GUI_HJM().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String Merk = txtmerk.getText();
        String Model = txtmodel.getText();
        String Tipe = null;
        if (Tipe.equalsIgnoreCase("Metic")) {
            radiobtnmetic.setSelected(true);
        } else if (Tipe.equalsIgnoreCase("Manual")) {
            radiobtnmanual.setSelected(true);
        } else if (Tipe.equalsIgnoreCase("Kopling")) {
            radiobtnkopling.setSelected(true);
        }
        String Stok = txtstok.getText();
        String Produk = txtproduk.getText();
        String Merklama = merk1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_data_sepada_motor SET merk='" + Merk + "'," + "model='" + Model + "',"
                    + "type='" + Tipe + "'" + ",jumlah stok='" + Stok + "',tahun produksi='" + Produk + "' WHERE nim = '" + Merklama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Motor!" + "\n" + Merk);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_data_sepada_motor WHERE merk='" + txtmerk.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }

    public void cari() {
        try {
            try (Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_data_sepeada_motor WHERE `merk`  LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtmerk.setText(rs.getString(2));
                    txtmodel.setText(rs.getString(3));
                    String jk = rs.getString(4);
                    if (jk.equalsIgnoreCase("L")) {
                        radiobtnmetic.setSelected(true);
                    } else {
                        radiobtnmanual.setSelected(true);
                    }
                    txtstok.setText(rs.getString(4));
                    txtproduk.setText(rs.getString(5));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupJk = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Prodi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmerk = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        txtproduk = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radiobtnmetic = new javax.swing.JRadioButton();
        radiobtnmanual = new javax.swing.JRadioButton();
        btnupdate = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        radiobtnkopling = new javax.swing.JRadioButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Prodi.setText("Jumlah Stok");

        jLabel3.setText("Model");

        jLabel2.setText("Tipe");

        jLabel5.setText("Merk");

        jLabel6.setText("Tahun Produksi");

        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });

        txtmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodelActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel1.setText("DATA MAHASISWA");

        btnGroupJk.add(radiobtnmetic);
        radiobtnmetic.setText("Metic");
        radiobtnmetic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnmeticActionPerformed(evt);
            }
        });

        btnGroupJk.add(radiobtnmanual);
        radiobtnmanual.setText("Manual");
        radiobtnmanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnmanualActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Merk", "Model", "Jumlah Stok", "Tahun Produksi", "Alamat"
            }
        ));
        table_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_data);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Close");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnGroupJk.add(radiobtnkopling);
        radiobtnkopling.setText("Kopling");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Prodi)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmerk, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radiobtnmetic)
                                    .addComponent(radiobtnmanual)
                                    .addComponent(radiobtnkopling))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(btnSimpan)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnupdate)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnHapus)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnBatal)
                                            .addGap(52, 52, 52))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnCari)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))))
                            .addComponent(jLabel1)))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtmerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Prodi))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radiobtnmetic)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radiobtnmanual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radiobtnkopling))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnupdate)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

    private void txtmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodelActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        //exit 
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
        // TODO add your handling code here:
        int tabel = table_data.getSelectedRow();
        merk1 = table_data.getValueAt(tabel, 0).toString();
        model1 = table_data.getValueAt(tabel, 1).toString();
        tipe1 = table_data.getValueAt(tabel, 2).toString();
        stok1 = table_data.getValueAt(tabel, 3).toString();
        produk1 = table_data.getValueAt(tabel, 4).toString();
        itempilih();

    }//GEN-LAST:event_table_dataMouseClicked

    private void radiobtnmeticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnmeticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnmeticActionPerformed

    private void radiobtnmanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnmanualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnmanualActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_HJM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_HJM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel Prodi;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.ButtonGroup btnGroupJk;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radiobtnkopling;
    private javax.swing.JRadioButton radiobtnmanual;
    private javax.swing.JRadioButton radiobtnmetic;
    private javax.swing.JTable table_data;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtmerk;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtproduk;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables

    private void batal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
