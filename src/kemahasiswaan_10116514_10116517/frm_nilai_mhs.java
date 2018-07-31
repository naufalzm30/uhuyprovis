package kemahasiswaan_10116514_10116517;

import javax.swing.*;
//Fungsi import untuk SQL
import java.sql.*;
//Fungsi import untuk tanggal
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ACER PC
 */
public class frm_nilai_mhs extends javax.swing.JFrame {

    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;

    /**
     * Creates new form frm_nilai_mhs
     */
    public frm_nilai_mhs() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_nilai_mhs.setModel(table_model_nilai_mhs);
        settableload();
    }
    private javax.swing.table.DefaultTableModel table_model_nilai_mhs = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Nama",
                    "Nama M.K",
                    "Absensi",
                    "Tgs 1",
                    "Tgs 2",
                    "Tgs 2",
                    "UTS",
                    "UAS",
                    "Nilai Absen",
                    "Nilai tugas",
                    "Nilai UTS",
                    "Nilai UAS",
                    "Nilai Akhir",
                    "Index",
                    "Keterangan"
                }
        ) // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

    }
    double nilai_absen;
    String nilaiabsen;
    double nilai_tugas;
    String nilaitugas;
    double nilai_uts;
    String nilaiuts;
    double nilai_uas;
    String nilaiuas;
    double nilai_akhir;
    String nilaiakhir;
    String index;
    String ket;
    String data[] = new String[15];

    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            Statement stt = kon.createStatement();
            String SQL = "select * from nilai_ini";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next()) {
                nilai_absen = ((((res.getDouble(4) / 14) * 100) * 5) / 100);
                nilaiabsen = String.valueOf(nilai_absen);
                nilai_tugas = (((res.getInt(5) + res.getInt(6) + res.getInt(7)) / 3) * 25) / 100;
                nilaitugas = String.valueOf(nilai_tugas);
                nilai_uts = (res.getInt(8) * 30) / 100;
                nilaiuts = String.valueOf(nilai_uts);
                nilai_uas = (res.getInt(9) * 40) / 100;
                nilaiuas = String.valueOf(nilai_uas);
                nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;
                nilaiakhir = String.valueOf(nilai_akhir);
                
                    if ((nilai_akhir >= 80) && (nilai_akhir <= 100)) {
                        index = "A";
                        ket="Lulus";
                    } else if ((nilai_akhir >= 68) && (nilai_akhir <= 79)) {
                        index = "B";
                        ket="Lulus";
                    } else if ((nilai_akhir >= 56) && (nilai_akhir <= 67)) {
                        index = "C";
                        ket="Lulus";
                    } else if ((nilai_akhir >= 45) && (nilai_akhir <= 55)) {
                        index="D";
                        ket="Tidak Lulus";
                    } else if ((nilai_akhir >= 0) && (nilai_akhir <= 44)) {
                        index="E";
                        ket="Tidak lulus";
                    }
                    
                    if (res.getInt(4)<11) {
                    ket="Tidak Lulus";
                }
                

                data[0] = res.getString(2);
                data[1] = res.getString(3);
                data[2] = res.getString(4);
                data[3] = res.getString(5);
                data[4] = res.getString(6);
                data[5] = res.getString(7);
                data[6] = res.getString(8);
                data[7] = res.getString(9);
                data[8] = nilaiabsen;
                data[9] = nilaitugas;
                data[10] = nilaiuts;
                data[11] = nilaiuas;
                data[12] = nilaiakhir;
                data[13] = index;
                data[14] = ket;
                table_model_nilai_mhs.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tempat_cari = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tempat_nim = new javax.swing.JTextField();
        kombo_nama = new javax.swing.JComboBox<>();
        tempat_hadir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tempat_tugas1 = new javax.swing.JTextField();
        tempat_tugas2 = new javax.swing.JTextField();
        tempat_tugas3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        kombo_matkul = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tempat_kmk = new javax.swing.JTextField();
        tempat_uts = new javax.swing.JTextField();
        tempat_uas = new javax.swing.JTextField();
        tempat_ang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai_mhs = new javax.swing.JTable();
        add = new javax.swing.JButton();
        change = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        out = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Pencarian Data Mata Kuliah");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Masukkan Data");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setText("Nama");

        jLabel5.setText("NIM");

        jLabel6.setText("Kehadiran");

        jLabel7.setText("Tugas 1");

        jLabel8.setText("Tugas 2");

        jLabel9.setText("Tugas 3");

        tempat_hadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempat_hadirActionPerformed(evt);
            }
        });

        jLabel10.setText("Pertemuan");

        jLabel11.setText("Nama Mata Kuliah");

        jLabel12.setText("Kode M.K");

        jLabel13.setText("UTS");

        jLabel14.setText("UAS");

        jLabel15.setText("Angkatan");

        tempat_kmk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempat_kmkActionPerformed(evt);
            }
        });

        tempat_ang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempat_angActionPerformed(evt);
            }
        });

        tabel_nilai_mhs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_nilai_mhs);

        add.setText("TAMBAH");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        change.setText("UBAH");

        delete.setText("HAPUS");

        save.setText("SIMPAN");

        cancel.setText("BATAL");

        out.setText("KELUAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tempat_nim)
                                .addComponent(kombo_nama, 0, 198, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tempat_hadir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tempat_tugas3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(tempat_tugas2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tempat_tugas1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)
                                .addComponent(kombo_matkul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tempat_kmk, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tempat_uas, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tempat_uts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                    .addComponent(tempat_ang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 499, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(tempat_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tempat_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kombo_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(kombo_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tempat_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tempat_hadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tempat_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tempat_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tempat_kmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tempat_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tempat_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tempat_ang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tempat_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(out)
                    .addComponent(cancel)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(change)
                    .addComponent(add))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tempat_angActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempat_angActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempat_angActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void tempat_hadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempat_hadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempat_hadirActionPerformed

    private void tempat_kmkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempat_kmkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempat_kmkActionPerformed

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
            java.util.logging.Logger.getLogger(frm_nilai_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_nilai_mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton change;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> kombo_matkul;
    private javax.swing.JComboBox<String> kombo_nama;
    private javax.swing.JButton out;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel_nilai_mhs;
    private javax.swing.JTextField tempat_ang;
    private javax.swing.JTextField tempat_cari;
    private javax.swing.JTextField tempat_hadir;
    private javax.swing.JTextField tempat_kmk;
    private javax.swing.JTextField tempat_nim;
    private javax.swing.JTextField tempat_tugas1;
    private javax.swing.JTextField tempat_tugas2;
    private javax.swing.JTextField tempat_tugas3;
    private javax.swing.JTextField tempat_uas;
    private javax.swing.JTextField tempat_uts;
    // End of variables declaration//GEN-END:variables
}
