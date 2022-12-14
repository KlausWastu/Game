package com.ui;

import com.socket.History;
import com.socket.Message;
import com.socket.SocketClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.IconUIResource;
import oracle.jrockit.jfr.JFR;
import javax.swing.Timer;

public class ChatFrame extends javax.swing.JFrame {

    public SocketClient client;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    public DefaultListModel model;
    public File file;
    public int[][] map;
    public int[][] mapijo;
    public int posO;
    public int posX;
    public Random ran;
    public int acak, pbiru, phijau;
    public Timer timer;
    public int detik;
    public int menit;
    
    public void hitungmundur(){
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // set detik
                if(detik<10)
                    jLabel11.setText("0"+detik);
                else
                    jLabel11.setText(""+detik);
                if(menit<10)
                    jLabel10.setText("0"+menit);
                else
                    jLabel10.setText(""+menit);
                if(detik==0){
                    menit--;
                    if(menit<0){
                        JOptionPane.showMessageDialog(null,"KALIAN CUPU COBA GAME LAIN AJA"); 
                        timer.stop();
                        System.exit(0);
                    }
                    detik = 60;
                }
                detik --; 
            }   
        });
        timer.start();
    }
    public ChatFrame() {
        initComponents();
        hitungmundur();
        detik = 60;
        menit = 2;
        this.setTitle("jMessenger");
        model.addElement("All");
        jList1.setSelectedIndex(0);
        posO=0;posX=0;acak=0;
        ran = new Random();

        mapijo = new int[57][2];
        mapijo[0][0]=214; mapijo[0][1]=35;
        mapijo[1][0]=214;mapijo[1][1]=62;
        mapijo[2][0]=214;mapijo[2][1]=89;
        mapijo[3][0]=214;mapijo[3][1]=114;
        mapijo[4][0]=214;mapijo[4][1]=141;
        
        mapijo[5][0]=243;mapijo[5][1] =169;
        mapijo[6][0] =268;mapijo[6][1] =169;
        mapijo[7][0] =295;mapijo[7][1] =169;
        mapijo[8][0] =322;mapijo[8][1] =169;
        mapijo[9][0] =346;mapijo[9][1] =169;
        mapijo[10][0]=375;mapijo[10][1]=169;
        
        mapijo[11][0]=375; mapijo[11][1]=195;
        mapijo[12][0]=375; mapijo[12][1]=219;
        
        mapijo[13][0]=348;mapijo[13][1]=219;
        mapijo[14][0]=320;mapijo[14][1]=219;
        mapijo[15][0]=294;mapijo[15][1]=219;
        mapijo[16][0]=267;mapijo[16][1]=219;
        mapijo[17][0]=241;mapijo[17][1]=219;
        
        mapijo[18][0] =214;mapijo[18][1] =246;       
        mapijo[19][0] =214;mapijo[19][1] =274;
        mapijo[20][0] =214;mapijo[20][1] =301;
        mapijo[21][0] =214;mapijo[21][1] =326;
        mapijo[22][0] =214;mapijo[22][1] =353;
        mapijo[23][0] =214; mapijo[23][1] =381; 
        
        mapijo[24][0]=188; mapijo[24][1]=381;
        mapijo[25][0]=162;mapijo[25][1]=381;
        
        mapijo[26][0]=162;mapijo[26][1]=352;
        mapijo[27][0]=162;mapijo[27][1]=327;
        mapijo[28][0]=162;mapijo[28][1]=300;
        mapijo[29][0]=162;mapijo[29][1]=274;
        mapijo[30][0]=162;mapijo[30][1]=248;
        
        mapijo[31][0]=133;mapijo[31][1]=219;
        mapijo[32][0] =108;mapijo[32][1] =219;
        mapijo[33][0] =80;mapijo[33][1] =219;
        mapijo[34][0] =56;mapijo[34][1] =219;
        mapijo[35][0] =28; mapijo[35][1] =219;
        mapijo[36][0] =2;mapijo[36][1] =219;
        
        mapijo[37][0] =2;mapijo[37][1] =194;
        mapijo[38][0] =2;mapijo[38][1] =169;
        
        mapijo[39][0] =27;mapijo[39][1] =169;
        mapijo[40][0] =54;mapijo[40][1] =169;
        mapijo[41][0] =82; mapijo[41][1] =169;
        mapijo[42][0] =106;mapijo[42][1] =169;
        mapijo[43][0] =135;mapijo[43][1] =169;
        
        mapijo[44][0] =162;mapijo[44][1] =140;
        mapijo[45][0] =162;mapijo[45][1] =115;
        mapijo[46][0] =162;mapijo[46][1] =88;
        mapijo[47][0] =162; mapijo[47][1] =60;
        mapijo[48][0] =162;mapijo[48][1] =36;
        mapijo[49][0] =162;mapijo[49][1] =10;
        
        mapijo[50][0] =189;mapijo[50][1] =10;
        mapijo[51][0] =189;mapijo[51][1] =31;
        mapijo[52][0] =189;mapijo[52][1] =60;
        mapijo[53][0] =189; mapijo[53][1] =87;
        mapijo[54][0] =189;mapijo[54][1] =112;
        mapijo[55][0] =189;mapijo[55][1] =139;
        mapijo[56][0] =189;mapijo[56][1] =174;
        
        
        map = new int[57][2];
        map[0][0]=162;map[0][1]=352;
        map[1][0]=162;map[1][1]=327;
        map[2][0]=162;map[2][1]=300;
        map[3][0]=162;map[3][1]=274;
        map[4][0]=162;map[4][1]=248;
        
        map[5][0]=133;map[5][1] =219;
        map[6][0] =108;map[6][1] =219;
        map[7][0] =80;map[7][1] =219;
        map[8][0] =56;map[8][1] =219;
        map[9][0] =28;map[9][1] =219;
        map[10][0]=2;map[10][1]=219;
        
        map[11][0]=2; map[11][1]=194;
        map[12][0]=2; map[12][1]=169;
        
        map[13][0]=27;map[13][1]=169;
        map[14][0]=54;map[14][1]=169;
        map[15][0]=82;map[15][1]=169;
        map[16][0]=106;map[16][1]=169;
        map[17][0] =135;map[17][1] =169;
        
        map[18][0] =162;map[18][1] =140;
        map[19][0] =162;map[19][1] =115;
        map[20][0] =162;map[20][1] =88;
        map[21][0] =162;map[21][1] =60;
        map[22][0] =162;map[22][1] =36;        
        map[23][0]=162;map[23][1]=10;
        
        map[24][0]=189;map[24][1]=10;
        map[25][0]=214;map[25][1]=10;

        map[26][0]=214;map[26][1]=35;
        map[27][0]=214;map[27][1]=62;
        map[28][0]=214;map[28][1]=89;
        map[29][0]=214;map[29][1]=114;
        map[30][0]=214;map[30][1]=141;
        
        map[31][0] =243;map[31][1] =169;
        map[32][0] =268;map[32][1] =169;
        map[33][0] =295;map[33][1] =169;
        map[34][0] =322; map[45][1] =169;
        map[35][0] =346;map[35][1] =169;
        map[36][0] =375;map[36][1] =169;
        
        map[37][0] =375;map[37][1] =195;
        map[38][0] =375;map[38][1] =219;
        
        map[39][0] =348;map[39][1] =219;
        map[40][0] =320;map[40][1] =219;
        map[41][0] =294;map[41][1] =219;
        map[42][0] =267;map[42][1] =219;
        map[43][0] =241;map[43][1] =219;
        
        map[44][0] =214;map[44][1] =246;
        map[45][0] =214;map[45][1] =274;
        map[46][0] =214;map[46][1] =301;
        map[47][0] =214;map[47][1] =326;
        map[48][0] =214;map[48][1] =353;
        map[49][0] =214;map[49][1] =381;
        
        map[50][0] =189;map[50][1] =381;
        map[51][0] =189;map[51][1] =351;
        map[52][0] =189; map[23][1] =329;
        map[53][0] =189;map[53][1] =298;
        map[54][0] =189;map[54][1] =275;
        map[55][0] =189;map[55][1] =248;
        map[56][0] =189;map[56][1] =215;
/*
        map[58][0] =100;map[58][1] =25;
        map[59][0] =38; map[59][1] =25;
        
        map[60][0] =354;map[60][1] =25;
        map[61][0] =292;map[61][1] =25;
        map[62][0] =228;map[62][1] =25;
        map[63][0] =164;map[63][1] =25;
        map[64][0] =100;map[64][1] =25;
        map[65][0] =38; map[65][1] =25;
        
        map[66][0] =354;map[66][1] =25;
        map[67][0] =292;map[67][1] =25;
        map[68][0] =228;map[68][1] =25;
        map[69][0] =164;map[69][1] =25;
        map[70][0] =100;map[70][1] =25;
        map[71][0] =38; map[71][1] =25;
        
        map[72][0] =354;map[72][1] =25;
        map[73][0] =292;map[73][1] =25;
        map[74][0] =228;map[74][1] =25;
        map[75][0] =164;map[75][1] =25;
        map[76][0] =100;map[76][1] =25;
        */                     
        this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { try{ client.send(new Message("message", username, ".bye", "SERVER")); clientThread.stop();  }catch(Exception ex){} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        
        
        
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TALI = new javax.swing.JButton();
        TALI_O = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Host : ");

        jTextField1.setText("localhost");

        jLabel2.setText("Port : ");

        jTextField2.setText("13000");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setEnabled(false);

        jLabel4.setText("Name :");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setModel((model = new DefaultListModel()));
        jScrollPane2.setViewportView(jList1);

        jLabel5.setText("Message : ");

        jButton4.setText("Send");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Login");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("...");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Send");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("File :");

        jButton3.setText("API");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TALI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icon ijo.jpg"))); // NOI18N
        TALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TALIActionPerformed(evt);
            }
        });
        jPanel1.add(TALI, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 30, 30));

        TALI_O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/icon biru.jpg"))); // NOI18N
        TALI_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TALI_OActionPerformed(evt);
            }
        });
        jPanel1.add(TALI_O, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/ludo.jpg"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 410));

        jButton8.setText("HIJAU");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("BIRU");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("ACAK");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ui/dice1.png"))); // NOI18N

        jTextField6.setText("jTextField6");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setText("jTextField7");
        jTextField7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField7MouseMoved(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel8.setText(":");
        jLabel8.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setText("jLabel8");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel11.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jButton9))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(47, 47, 47)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverAddr = jTextField1.getText(); port = Integer.parseInt(jTextField2.getText());
        
        if(!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()){
            try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
            }
            catch(Exception ex){
                jTextArea1.append("[Application > Me] : Server not found\n");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        username = jTextField3.getText();
        
        if(!username.isEmpty()){
            client.send(new Message("login", username, "", "SERVER"));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String msg = jTextField4.getText();
        String target = jList1.getSelectedValue().toString();
        
        if(!msg.isEmpty() && !target.isEmpty()){
            jTextField4.setText("");
            client.send(new Message("message", username, msg, target));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            long size = file.length();
            if(size < 120 * 1024 * 1024){
                client.send(new Message("upload_req", username, file.getName(), jList1.getSelectedValue().toString()));
            }
            else{
                jTextArea1.append("[Application > Me] : File is size too large\n");
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        client.send(new Message("api", username, "", "SERVER"));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed


        posO=posO+acak;
        //if(posO>56){posO=56-(posO-56);}
        //TALI_O.setBounds(map[posO][0], map[posO][1], 20, 20);
        
        /*
        if(posO==5){posO=7;}
        if(posO==10){posO=24;}
        if(posO==15){posO=20;}^
        if(posO==19){posO=32;}
        
        if(posO==8){posO=2;}
        if(posO==16){posO=6;}
        if(posO==13){posO=9;}
        if(posO==27){posO=14;}
        if(posO==34){posO=26;}
        if(posO==31){posO=29;}
        */
        TALI_O.setBounds(map[posO][0], map[posO][1], 20, 20);
        client.send(new Message("message", username, "POSO "+Integer.toString(posO), "All"));
        
//        jButton9.setEnabled(true);
        if(username.equalsIgnoreCase("X")){jButton8.setEnabled(false);}
         else {jButton7.setEnabled(false);}
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        
        posX=posX+acak;
        //if(posX>56){posX=56-(posX-56);}
        //if acak = 6 posX dipindah ke posisi awal
        //if(mapijo==map){mapijo==0;map==0;}
        /*
        if(posX==5){posX=7;}
        if(posX==10){posX=24;}
        if(posX==15){posX=20;}
        if(posX==19){posX=32;}
        
        if(posX==8){posX=2;}
        if(posX==16){posX=6;}
        if(posX==13){posX=9;}
        if(posX==27){posX=14;}
        if(posX==34){posX=26;}
        if(posX==31){posX=29;}*/
        client.send(new Message("message", username, "POSX "+Integer.toString(posX), "All"));
        
//        jButton9.setEnabled(true);
        if(username.equalsIgnoreCase("X")){jButton8.setEnabled(false);}
         else {jButton7.setEnabled(false);}
    }//GEN-LAST:event_jButton8ActionPerformed
    //
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         acak = dadu();
//         acak = 6;
         ImageIcon image = new ImageIcon(getClass().getResource("dice"+Integer.toString(acak)+".png"));
         jLabel9.setIcon(image);
         
         if(username.equalsIgnoreCase("X")){
             jButton8.setEnabled(true);
         }
         else {
             jButton7.setEnabled(false);
         }
         if(username.equalsIgnoreCase("O")){
             jButton7.setEnabled(true);
         }
         else {
             jButton8.setEnabled(false);
         }
         jButton9.setEnabled(true);
         if(username.equalsIgnoreCase("X")){client.send(new Message("message", username, "POKH", "All"));}
         if(username.equalsIgnoreCase("O")){client.send(new Message("message", username, "POKB", "All"));}
//         client.send(new Message("message", "xxx", "KH", "All"));
//         client.send(new Message("message", "yyy", "KB", "All"));
         //if(username.equalsIgnoreCase("X")){client.send(new Message("message", "xxx", "KH", "All"));}
         //if(username.equalsIgnoreCase("O")){client.send(new Message("message", "yyy", "KB", "All"));}
         
    }//GEN-LAST:event_jButton9ActionPerformed

    private void TALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TALIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TALIActionPerformed

    private void TALI_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TALI_OActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TALI_OActionPerformed

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
             // TODO add your handling code here:
             jTextField6.setText(Integer.toString(evt.getX()));
             jTextField7.setText(Integer.toString(evt.getY()));
        
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
            // TODO add your handling code here:
            
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField7MouseMoved

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed
    
    public void tunda(){try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}}
    
    public int dadu(){
        int x = ran.nextInt(6) + 1;
        return x;     
    }
   
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton TALI;
    public javax.swing.JButton TALI_O;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
