/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tugas5;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwar Arliman Gea
 */
public class GUI_HJM extends javax.swing.JFrame {

    private DefaultTableModel dataModel;

    /**
     * Creates new form GUI_HJM
     */
    public GUI_HJM() {
        initComponents();
        dataModel = new DefaultTableModel();
        table_HJM.setModel(dataModel);

        // Menambahkan kolom ke model tabel
        dataModel.addColumn("Merk");
        dataModel.addColumn("Model");
        dataModel.addColumn("Jumlah Stok");
        dataModel.addColumn("Tahun Produksi");
        dataModel.addColumn("Type");
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

        btnTampil.setText("TAMPILKAN");
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
        jScrollPane2.setViewportView(table_HJM);

        btnHapus.setText("UPDATE");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("DELATE");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("CLOSE");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String merk = txtmerk.getText();
        String model = txtmodel.getText();
        int jumlahStok = Integer.parseInt(txtstok.getText());
        int tahunProduksi = Integer.parseInt(txtproduksi.getText());
        String selectedType = Cmb_Tipe.getSelectedItem().toString();

        // Membuat objek Harapan_Jaya_Motor
        Harapan_Jaya_Motor HJM = new Harapan_Jaya_Motor();
        HJM.setMerk(merk);
        HJM.setModel(model);
        HJM.setJumlahStok(jumlahStok);
        HJM.setTahunProduksi(tahunProduksi);

        // Menentukan tipe berdasarkan pilihan combo box
        String type;
        switch (selectedType) {
            case "Skuter (Scooter)":
                type = new Tipe().getTipe1();
                break;
            case "Sport Bike":
                type = new Tipe().getTipe2();
                break;
            case "Naked Bike":
                type = new Tipe().getTipe3();
                break;
            default:
                type = "";
        }

        // Menambahkan data ke dalam model tabel
        dataModel.addRow(new Object[]{HJM.getMerk(), HJM.getModel(), HJM.getJumlahStok(), HJM.getTahunProduksi(), type});

    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //exit
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dataModel = (DefaultTableModel) table_HJM.getModel();
        int rowCount = dataModel.getRowCount();
        while (rowCount > 0) {
            dataModel.removeRow(rowCount - 1);
            rowCount = dataModel.getRowCount();//untuk Update data
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

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
