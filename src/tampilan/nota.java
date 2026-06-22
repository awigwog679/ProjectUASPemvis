/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
/**
 *
 * @author ACER NITRO 5
 */
public class nota extends javax.swing.JFrame {

    Connection conn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;
    
    public String id, nama, jenis, telp, almt;
    public String kdbrg, nmbrg, jenisbrg, hb, hj;
    /**
     * Creates new form nota
     */
    public nota() {
        initComponents();
        String KD = UserID.getUserLogin();
        jLabel20.setText(KD);
        koneksi();
        aktif();
        aturTable();
        autonumber();
        kosong();
        
        txtnm.setEditable(false);
        txtalamat.setEditable(false);
        txtnmbrg.setEditable(false);
        txthb.setEditable(false);
        txthj.setEditable(false);
        txttotal.setEditable(false);
        txtttotal.setEditable(false);
    }
    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan", "root", "");
            st = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi Database Gagal: " + e.getMessage());
        }
    }
   protected void aktif() {
        txtqty.requestFocus(); 
        jtgl.setEditor(new javax.swing.JSpinner.DateEditor(jtgl, "yyyy/MM/dd")); 
        Object[] Baris = {"KD Barang", "Nama Barang", "Harga Beli", "Harga Jual", "QTY", "Sub Total"};
        model = new DefaultTableModel(null, Baris);
        tbltransaksi.setModel(model);
    }
    private void aturTable() {
        model = new DefaultTableModel();
        tbltransaksi.setModel(model);
        model.addColumn("KD Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("QTY");
        model.addColumn("Sub Total");
    }
    private void autonumber() {
        try {
            String sql = "SELECT idnota FROM nota ORDER BY idnota ASC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtidnota.setText("NOT001");
            while (rs.next()) {
                String id_nota = rs.getString("idnota").substring(3);
                int AN = Integer.parseInt(id_nota) + 1;
                String Nol = "";
                if (AN < 10) { Nol = "00"; } 
                else if (AN < 100) { Nol = "0"; } 
                else if (AN < 1000) { Nol = ""; }
                txtidnota.setText("NOT" + Nol + AN);
            }
            txtidnota.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Auto Number Gagal: " + e.getMessage());
        }
    }
    private void kosong() {
        txtid.setText("");
        txtnm.setText("");
        txtalamat.setText("");
        kosongBarang();
        txtttotal.setText("0");
    }

    private void kosongBarang() {
        txtkdbrg.setText("");
        txtnmbrg.setText("");
        txthb.setText("");
        txthj.setText("");
        txtqty.setText("");
        txttotal.setText("");
    }
    private void hitungTotal() {
        int total = 0;
        for (int i = 0; i < tbltransaksi.getRowCount(); i++) {
            int amount = Integer.valueOf(tbltransaksi.getValueAt(i, 5).toString());
            total += amount;
        }
        txtttotal.setText(Integer.toString(total));
    }
    public void itemTerpilihplg() {
        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        txtid.setText(id);
        txtnm.setText(nama);
        txtalamat.setText(almt);
    }
    public void itemTerpilihBrg() {
        popupbarang Pbrg = new popupbarang();
        Pbrg.brg = this;
        txtkdbrg.setText(kdbrg);
        txtnmbrg.setText(nmbrg);
        txthb.setText(hb);
        txthj.setText(hj);
        txtqty.requestFocus();
    }

    protected void nama_kasir() {
        try {
            String sql = "SELECT * FROM kasir WHERE id_kasir='" + jLabel20.getText() + "'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                jLabel19.setText(hasil.getString("nama_kasir"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Kasir Gagal Dipanggil: " + e);
        }
    }
    public void cetak() {
        try {
            String path = "./src/nota/report2.jasper"; 
            
            HashMap parameter = new HashMap();
            parameter.put("id_nota", txtidnota.getText()); 
            
            JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
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

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        bcarip = new javax.swing.JButton();
        txtnm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        txtkdbrg = new javax.swing.JTextField();
        bcaribrg = new javax.swing.JButton();
        txtnmbrg = new javax.swing.JTextField();
        txthb = new javax.swing.JTextField();
        txthj = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtidnota = new javax.swing.JTextField();
        jtgl = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        bhapus = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtttotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nota");

        jLabel2.setText("ID kasir");

        jLabel3.setText("ID nota");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Data Pelanggan");

        jLabel5.setText("ID pelanggan");

        jLabel6.setText("Nama");

        jLabel7.setText("Alamat");

        bcarip.setText("Cari");
        bcarip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripActionPerformed(evt);
            }
        });

        txtnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmActionPerformed(evt);
            }
        });

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnm)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bcarip)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel8.setText("Nama Kasir");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Data Barang");

        jLabel10.setText("KD Barang");

        jLabel11.setText("Nama");

        jLabel12.setText("Harga Beli");

        jLabel13.setText("Harga Jual");

        jLabel14.setText("QTY");

        jLabel15.setText("Total");

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bcaribrg.setText("Cari");
        bcaribrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribrgActionPerformed(evt);
            }
        });

        txthj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthjActionPerformed(evt);
            }
        });

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtqtyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txthb))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtkdbrg)
                                    .addComponent(txtnmbrg, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthj)
                                    .addComponent(txtqty)
                                    .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcaribrg)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaribrg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txthb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txthj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btambah))
        );

        jLabel16.setText("Tgl Nota");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Tabel");

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbltransaksi);

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bhapus)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bhapus)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        jLabel18.setText("Total Harga");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(29, 29, 29)
                                        .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(201, 201, 201)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bbatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bkeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16)
                    .addComponent(txtidnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bbatal)
                    .addComponent(bkeluar)
                    .addComponent(jLabel18)
                    .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmActionPerformed

    private void txthjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthjActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bcaripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripActionPerformed
        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaripActionPerformed

    private void bcaribrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribrgActionPerformed
        popupbarang Pbrg = new popupbarang();
        Pbrg.brg = this;
        Pbrg.setVisible(true);
        Pbrg.setResizable(false);
    }//GEN-LAST:event_bcaribrgActionPerformed

    private void txtqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyReleased
        try {
            if (!txtqty.getText().isEmpty()) {
                int hj = Integer.parseInt(txthj.getText());
                int qty = Integer.parseInt(txtqty.getText());
                int total = hj * qty;
                txttotal.setText(String.valueOf(total));
            } else {
                txttotal.setText("0");
            }
        } catch (NumberFormatException e) {
            txttotal.setText("0");
        }
    }//GEN-LAST:event_txtqtyKeyReleased

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
       try {
            String kode = txtkdbrg.getText();
            String nama = txtnmbrg.getText();
            int hargab = Integer.parseInt(txthb.getText());
            int hargaj = Integer.parseInt(txthj.getText());
            int qty = Integer.parseInt(txtqty.getText());
            int total = Integer.parseInt(txttotal.getText());

            model.addRow(new Object[]{kode, nama, hargab, hargaj, qty, total});
            tbltransaksi.setModel(model);
            
            hitungTotal();
            kosongBarang(); // Biar kolom barang bersih lagi
            txtkdbrg.requestFocus();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int index = tbltransaksi.getSelectedRow();
        if (index != -1) {
            model.removeRow(index);
            tbltransaksi.setModel(model);
            hitungTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris pada tabel terlebih dahulu!");
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(jtgl.getValue());
 
        String sql = "INSERT INTO nota VALUES (?,?,?,?)"; 
        String zsql = "INSERT INTO isi VALUES (?,?,?,?,?)"; 

        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtidnota.getText());
            stat.setString(2, fd);
            stat.setString(3, txtid.getText());
            stat.setString(4, jLabel20.getText()); 
            stat.executeUpdate();

            int t = tbltransaksi.getRowCount();
            for (int i = 0; i < t; i++) {
                String xkd = tbltransaksi.getValueAt(i, 0).toString();
                String xhb = tbltransaksi.getValueAt(i, 2).toString();
                String xhj = tbltransaksi.getValueAt(i, 3).toString();
                String xqty = tbltransaksi.getValueAt(i, 4).toString();

                PreparedStatement stat2 = conn.prepareStatement(zsql);
                stat2.setString(1, txtidnota.getText());
                stat2.setString(2, xkd);
                stat2.setString(3, xhb);
                stat2.setString(4, xhj);
                stat2.setString(5, xqty);
                stat2.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            cetak(); 
            kosong();
            aktif();
            autonumber();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        int xhrgj = Integer.parseInt(txthj.getText());
        int xqty = Integer.parseInt(txtqty.getText());
        int xjml = xhrgj * xqty;
        txttotal.setText(String.valueOf(xjml)); 
    }//GEN-LAST:event_txtqtyActionPerformed

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
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcaribrg;
    private javax.swing.JButton bcarip;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txthb;
    private javax.swing.JTextField txthj;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidnota;
    private javax.swing.JTextField txtkdbrg;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnmbrg;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtttotal;
    // End of variables declaration//GEN-END:variables
}
