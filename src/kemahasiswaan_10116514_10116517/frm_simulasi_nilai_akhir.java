/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_10116514_10116517;
import javax.swing.*;
//Fungsi import untuk SQL
import java.sql.*;
//Fungsi import untuk tanggal
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Naufal Zayn M
 */
public class frm_simulasi_nilai_akhir extends javax.swing.JFrame {
koneksi dbsetting;
String driver,database,user,pass;
Object tabel;
    /**
     * Creates new form frm_simulasi_nilai_akhir
     */
    public frm_simulasi_nilai_akhir() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_simulasi.setModel(table_model_simulasi_nilai_mhs);
        
        tampilkombomatkul();
        nonaktif();
    }
     private javax.swing.table.DefaultTableModel table_model_simulasi_nilai_mhs=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel()
    {
     //membuat judul header
     return new javax.swing.table.DefaultTableModel
     (
          new Object [] [] {},
          new String [] {"Nama M.K",
                         "Presentasi Absen",
                         "Presentasi Tugas",
                         "Presentasi UTS",
                         "Presentasi UAS",                         
                         "Absensi",
                         "Tgs 1",
                         "Tgs 2",
                         "Tgs 3",
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
     )
     // disable perubahan pada grid
     {
         boolean[] canEdit = new boolean[]
         {
             false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
         };
         
         public boolean isCellEditable(int rowIndex, int columnIndex)
         {
             return canEdit[columnIndex];
         }
     };
        
    }
    String data[] = new String[15];
    private void tampilkombomatkul() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            Statement stt = kon.createStatement();
            String SQL = "select nama_mk from mata_kuliah order by nomor_mk asc";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next()) {
                data[0] = res.getString(1);
                kombo_matkul.addItem(data[0]);
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
    
    private void setkombomatkul() {
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            Statement stt = kon.createStatement();
            String SQL = "select nomor_mk from mata_kuliah where nama_mk='"+kombo_matkul.getSelectedItem()+"' order by nomor_mk asc";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next()) {
                data[0] = res.getString(1);
                tempat_kmk.setText(data[0]);
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
     public void aktif_teks()
    {
        kombo_matkul.setEnabled(true);
        persenAbsen.setEnabled(true);
        persenTugas.setEnabled(true);
        persenUTS.setEnabled(true);
        persenUAS.setEnabled(true);
        hadir.setEnabled(true);
        tugas1.setEnabled(true);
        tugas2.setEnabled(true);
        tugas3.setEnabled(true);
        uts.setEnabled(true);
        uas.setEnabled(true);
    }
      public void membersihkan_teks()
    {
        persenAbsen.setText("");
        persenTugas.setText("");
        persenUTS.setText("");
        persenUAS.setText("");
        hadir.setText("");
        tugas1.setText("");
        tugas2.setText("");
        tugas3.setText("");
        uts.setText("");
        uas.setText("");
    }
     
     public void nonaktif(){
         kombo_matkul.setEnabled(false);
        persenAbsen.setEnabled(false);
        persenTugas.setEnabled(false);
        persenUTS.setEnabled(false);
        persenUAS.setEnabled(false);
        hadir.setEnabled(false);
        tugas1.setEnabled(false);
        tugas2.setEnabled(false);
        tugas3.setEnabled(false);
        uts.setEnabled(false);
        uas.setEnabled(false);
     }

     int row = 0;
    public void tampilkeun(){
        row = tabel_simulasi.getSelectedRow();       
        kombo_matkul.setSelectedItem(table_model_simulasi_nilai_mhs.getValueAt(row, 0).toString());
        persenAbsen.setText( table_model_simulasi_nilai_mhs.getValueAt(row, 1).toString());
        persenTugas.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 2).toString());
        persenUTS.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 3).toString());
        persenUAS.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 4).toString());        
        hadir.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 5).toString());
        tugas1.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 6).toString());
        tugas2.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 7).toString());
        tugas3.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 8).toString());
        uts.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 9).toString());
        uas.setText(table_model_simulasi_nilai_mhs.getValueAt(row, 10).toString());
        
       save.setEnabled(false);
        change.setEnabled(true);
        erase.setEnabled(true);
        cancel.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        tempat_kmk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        persenAbsen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        persenTugas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        persenUTS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        persenUAS = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        hadir = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tugas1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        uts = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        uas = new javax.swing.JTextField();
        tugas2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tugas3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_simulasi = new javax.swing.JTable();
        plus = new javax.swing.JButton();
        change = new javax.swing.JButton();
        save = new javax.swing.JButton();
        erase = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        out = new javax.swing.JButton();
        kombo_matkul = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setText("Nama Mata Kuliah");

        jLabel3.setText("Kode MK");

        tempat_kmk.setEditable(false);

        jLabel4.setText("Presentase Absen");

        persenAbsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persenAbsenActionPerformed(evt);
            }
        });

        jLabel5.setText("Presentase Tugas");

        jLabel6.setText("Presentase UTS");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("%");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("%");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("%");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("%");

        jLabel11.setText("Presentase UAS");

        jLabel12.setText("Kehadiran");

        jLabel13.setText("Tugas 1");

        jLabel14.setText("UTS");

        jLabel15.setText("UAS");

        jLabel16.setText("Tugas 2");

        jLabel17.setText("Tugas 3");

        tabel_simulasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_simulasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_simulasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_simulasi);

        plus.setText("Tambah");
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });

        change.setText("Ubah");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        save.setText("Simpan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        erase.setText("Hapus");
        erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseActionPerformed(evt);
            }
        });

        cancel.setText("Batal");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        out.setText("Keluar");
        out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outActionPerformed(evt);
            }
        });

        kombo_matkul.setEditable(true);
        kombo_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Nama Matkul --" }));
        kombo_matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kombo_matkulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(persenUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(persenTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(persenAbsen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(27, 27, 27)
                                        .addComponent(persenUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(kombo_matkul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(62, 62, 62)
                                            .addComponent(tempat_kmk, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(hadir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(28, 28, 28)
                                .addComponent(tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(uas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27)
                                .addComponent(uts, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 661, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(erase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kombo_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tempat_kmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(persenAbsen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(persenTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(persenUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11))
                            .addComponent(persenUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(112, 112, 112)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(hadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel15))
                            .addComponent(uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plus)
                    .addComponent(change)
                    .addComponent(erase)
                    .addComponent(save)
                    .addComponent(cancel)
                    .addComponent(out))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kombo_matkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kombo_matkulActionPerformed
        // TODO add your handling code here:
        setkombomatkul();
    }//GEN-LAST:event_kombo_matkulActionPerformed

    private void persenAbsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persenAbsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_persenAbsenActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
        // TODO add your handling code here:
        aktif_teks();
        plus.setEnabled(false);
        change.setEnabled(false);
        erase.setEnabled(false);
        membersihkan_teks();
        
    }//GEN-LAST:event_plusActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String data[]=new String[18];
        Double nilaiabsen = (((Double.parseDouble(hadir.getText())/14)*100)*(Double.parseDouble(persenAbsen.getText())/100));
        Double nilaitugas = (((Double.parseDouble(tugas1.getText())+Double.parseDouble(tugas2.getText())+Double.parseDouble(tugas3.getText()))/3)*(Double.parseDouble(persenTugas.getText())/100));
        Double nilaiuts = (Double.parseDouble(uts.getText())*(Double.parseDouble(persenUTS.getText())/100));
        Double nilaiuas = (Double.parseDouble(uas.getText())*(Double.parseDouble(persenUAS.getText())/100));
        Double nilai_akhir = nilaiabsen + nilaitugas + nilaiuts + nilaiuas;
        String index = "";
        String ket = "";
       
                    
        if ((tempat_kmk.getText().isEmpty()) || (hadir.getText().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong,silahkan dilengkapi");
            tempat_kmk.requestFocus();
        }
        else if((hadir.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong,silahkan dilengkapi");
            hadir.requestFocus();
        }
        else if(Integer.valueOf(hadir.getText())>14){
            JOptionPane.showMessageDialog(null, "Maksimal 14 Pertemuan!");
            hadir.setText("");
            hadir.requestFocus();
        }
        else
        {
            try
            {
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
                    
                    if (Integer.parseInt(hadir.getText())<11) {
                    ket="Tidak Lulus";
                }
                data[0] = (String)kombo_matkul.getSelectedItem();
                data[1] = persenAbsen.getText();
                data[2] = persenTugas.getText();
                data[3] = persenUTS.getText();
                data[4] = persenUAS.getText();
                data[5] = hadir.getText();
                data[6] = tugas1.getText();
                data[7] = tugas2.getText();
                data[8] = tugas3.getText();
                data[9] = uts.getText();
                data[10] = uas.getText();
                data[11] = String.valueOf(nilaiabsen);
                data[12] = String.valueOf(nilaitugas);
                data[13] = String.valueOf(nilaiuts);
                data[14] = String.valueOf(nilaiuas);
                data[15] = String.valueOf(nilai_akhir);
                data[16] = index;
                data[17] = ket;
                table_model_simulasi_nilai_mhs.insertRow(0, data);
                
               
              
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, 
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
            }
        }
        plus.setEnabled(true);
    }//GEN-LAST:event_saveActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        
        table_model_simulasi_nilai_mhs.removeRow(row);
        String data[]=new String[18];
        Double nilaiabsen = (((Double.parseDouble(hadir.getText())/14)*100)*(Double.parseDouble(persenAbsen.getText())/100));
        Double nilaitugas = (((Double.parseDouble(tugas1.getText())+Double.parseDouble(tugas2.getText())+Double.parseDouble(tugas3.getText()))/3)*(Double.parseDouble(persenTugas.getText())/100));
        Double nilaiuts = (Double.parseDouble(uts.getText())*(Double.parseDouble(persenUTS.getText())/100));
        Double nilaiuas = (Double.parseDouble(uas.getText())*(Double.parseDouble(persenUAS.getText())/100));
        Double nilai_akhir = nilaiabsen + nilaitugas + nilaiuts + nilaiuas;
        String index = "";
        String ket = "";
       
                    
        if ((tempat_kmk.getText().isEmpty()) || (hadir.getText().isEmpty()) || (uts.getText().isEmpty()) || (uas.getText().isEmpty())
           || (uts.getText().isEmpty()) || (tugas1.getText().isEmpty()) || (tugas2.getText().isEmpty()) || (tugas3.getText().isEmpty())
           || (persenAbsen.getText().isEmpty()) || (persenTugas.getText().isEmpty()) || (persenUAS.getText().isEmpty()) || (persenUTS.getText().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong,silahkan dilengkapi");
            tempat_kmk.requestFocus();
        }
        else if((hadir.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong,silahkan dilengkapi");
            hadir.requestFocus();
        }
        else if(Integer.valueOf(hadir.getText())>14){
            JOptionPane.showMessageDialog(null, "Maksimal 14 Pertemuan!");
            hadir.setText("");
            hadir.requestFocus();
        }
        else
        {
            try
            {
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
                    
                    if (Integer.parseInt(hadir.getText())<11) {
                    ket="Tidak Lulus";
                }
                data[0] = (String)kombo_matkul.getSelectedItem();
                data[1] = persenAbsen.getText();
                data[2] = persenTugas.getText();
                data[3] = persenUTS.getText();
                data[4] = persenUAS.getText();
                data[5] = hadir.getText();
                data[6] = tugas1.getText();
                data[7] = tugas2.getText();
                data[8] = tugas3.getText();
                data[9] = uts.getText();
                data[10] = uas.getText();
                data[11] = String.valueOf(nilaiabsen);
                data[12] = String.valueOf(nilaitugas);
                data[13] = String.valueOf(nilaiuts);
                data[14] = String.valueOf(nilaiuas);
                data[15] = String.valueOf(nilai_akhir);
                data[16] = index;
                data[17] = ket;
                table_model_simulasi_nilai_mhs.insertRow(0, data);
                
               
              
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, 
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
            }
        }
        plus.setEnabled(true);
    }//GEN-LAST:event_changeActionPerformed

    private void tabel_simulasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_simulasiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            tampilkeun();
        }
    }//GEN-LAST:event_tabel_simulasiMouseClicked

    private void eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseActionPerformed
        // TODO add your handling code here:
        table_model_simulasi_nilai_mhs.removeRow(row);
    }//GEN-LAST:event_eraseActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        plus.setEnabled(true);
        change.setEnabled(true);
        erase.setEnabled(true);
        save.setEnabled(true);
        cancel.setEnabled(true);
        out.setEnabled(true);
        membersihkan_teks();
    }//GEN-LAST:event_cancelActionPerformed

    private void outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_outActionPerformed

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
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_simulasi_nilai_akhir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton change;
    private javax.swing.JButton erase;
    private javax.swing.JTextField hadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JComboBox<String> kombo_matkul;
    private javax.swing.JButton out;
    private javax.swing.JTextField persenAbsen;
    private javax.swing.JTextField persenTugas;
    private javax.swing.JTextField persenUAS;
    private javax.swing.JTextField persenUTS;
    private javax.swing.JButton plus;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel_simulasi;
    private javax.swing.JTextField tempat_kmk;
    private javax.swing.JTextField tugas1;
    private javax.swing.JTextField tugas2;
    private javax.swing.JTextField tugas3;
    private javax.swing.JTextField uas;
    private javax.swing.JTextField uts;
    // End of variables declaration//GEN-END:variables
}
