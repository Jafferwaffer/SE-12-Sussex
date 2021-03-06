/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulationUI;

/**
 *
 * @author ns350
 */
public class MainMenu extends javax.swing.JFrame {

    static void validateString(String playerName) throws Exception {
        if (playerName.length() > 24)
        {
            throw new Exception();
        }
        if (playerName.length() == 0)
        {
            throw new Exception();
        }
    }

    setting_window single;
    setting_window_tournament tourn;
    simulation_window sim;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main_Menu_Bar = new javax.swing.JPanel();
        jLabel_Main_Menu_Title = new javax.swing.JLabel();
        jButton_Main_Menu_Tournament = new javax.swing.JButton();
        jButton_Main_Menu_Single = new javax.swing.JButton();
        jPanel_Main_Menu_Logo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("main_menu"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        Main_Menu_Bar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Main_Menu_Bar.setName("jpanel_menuBar"); // NOI18N

        jLabel_Main_Menu_Title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Main_Menu_Title.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_Main_Menu_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Main_Menu_Title.setText("Software Engineering Team 12's Simulator");

        jButton_Main_Menu_Tournament.setForeground(new java.awt.Color(0, 0, 102));
        jButton_Main_Menu_Tournament.setText("Tournement Mode");
        jButton_Main_Menu_Tournament.setMaximumSize(new java.awt.Dimension(240, 23));
        jButton_Main_Menu_Tournament.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tournSetup(evt);
            }
        });

        jButton_Main_Menu_Single.setForeground(new java.awt.Color(0, 0, 102));
        jButton_Main_Menu_Single.setText("Single Match Mode");
        jButton_Main_Menu_Single.setMaximumSize(new java.awt.Dimension(240, 23));
        jButton_Main_Menu_Single.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoPlayerSetup(evt);
            }
        });

        javax.swing.GroupLayout Main_Menu_BarLayout = new javax.swing.GroupLayout(Main_Menu_Bar);
        Main_Menu_Bar.setLayout(Main_Menu_BarLayout);
        Main_Menu_BarLayout.setHorizontalGroup(
            Main_Menu_BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Menu_BarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Main_Menu_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Main_Menu_BarLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jButton_Main_Menu_Tournament, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton_Main_Menu_Single, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Main_Menu_BarLayout.setVerticalGroup(
            Main_Menu_BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Menu_BarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Main_Menu_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Main_Menu_BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Main_Menu_Tournament, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton_Main_Menu_Single, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_Main_Menu_Logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel_Main_Menu_LogoLayout = new javax.swing.GroupLayout(jPanel_Main_Menu_Logo);
        jPanel_Main_Menu_Logo.setLayout(jPanel_Main_Menu_LogoLayout);
        jPanel_Main_Menu_LogoLayout.setHorizontalGroup(
            jPanel_Main_Menu_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_Main_Menu_LogoLayout.setVerticalGroup(
            jPanel_Main_Menu_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Main_Menu_Bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Main_Menu_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Main_Menu_Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Main_Menu_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void twoPlayerSetup(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoPlayerSetup
        // TODO add your handling code here:
        this.setVisible(false);
        this.single = new setting_window(this);
        this.single.setVisible(true);
    }//GEN-LAST:event_twoPlayerSetup

    private void tournSetup(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tournSetup
        // TODO add your handling code here:
        this.setVisible(false);
        this.tourn = new setting_window_tournament();
    }//GEN-LAST:event_tournSetup

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main_Menu_Bar;
    private javax.swing.JButton jButton_Main_Menu_Single;
    private javax.swing.JButton jButton_Main_Menu_Tournament;
    private javax.swing.JLabel jLabel_Main_Menu_Title;
    private javax.swing.JPanel jPanel_Main_Menu_Logo;
    // End of variables declaration//GEN-END:variables
}
