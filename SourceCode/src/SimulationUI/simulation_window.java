package SimulationUI;
import antgame.*;
/**
 *
 * @author Software Engineering Team 12
 */
public class simulation_window extends javax.swing.JFrame {

    SetUp setup;
    MainMenu menu;
    
    /**
     * Creates new form simulation_window
     * @param setup
     * @param menu
     */
    public simulation_window(SetUp setup,MainMenu menu){
        this.setup = setup;
        this.menu = menu;
        initComponents();
        try{
            this.setup.run2PGame();
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(this, "Simulation crashed horridly");
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Main_Menu_Bar = new javax.swing.JPanel();
        jLabel_Main_Menu_Title = new javax.swing.JLabel();
        jButton_Simulation_Return = new javax.swing.JButton();
        jButton_Simulation_Pause = new javax.swing.JButton();
        jPanel_Simulation_Status = new javax.swing.JPanel();
        jLabel_Simulation_Status_Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel_Simulation_Area = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        Main_Menu_Bar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Main_Menu_Bar.setName("jpanel_menuBar"); // NOI18N

        jLabel_Main_Menu_Title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Main_Menu_Title.setForeground(new java.awt.Color(0, 0, 153));
        jLabel_Main_Menu_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Main_Menu_Title.setText("Simulator");

        jButton_Simulation_Return.setForeground(new java.awt.Color(0, 0, 102));
        jButton_Simulation_Return.setText("Return to main menu");
        jButton_Simulation_Return.setMaximumSize(new java.awt.Dimension(240, 23));
        jButton_Simulation_Return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToMM(evt);
            }
        });

        jButton_Simulation_Pause.setForeground(new java.awt.Color(0, 0, 102));
        jButton_Simulation_Pause.setText("Pause simulation");
        jButton_Simulation_Pause.setToolTipText("");
        jButton_Simulation_Pause.setMaximumSize(new java.awt.Dimension(240, 23));

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
                .addComponent(jButton_Simulation_Return, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton_Simulation_Pause, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Main_Menu_BarLayout.setVerticalGroup(
            Main_Menu_BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_Menu_BarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Main_Menu_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Main_Menu_BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Simulation_Return, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton_Simulation_Pause, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_Simulation_Status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_Simulation_Status_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Simulation_Status_Title.setForeground(new java.awt.Color(0, 51, 204));
        jLabel_Simulation_Status_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Simulation_Status_Title.setText("Simulation Log");
        jLabel_Simulation_Status_Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel_Simulation_StatusLayout = new javax.swing.GroupLayout(jPanel_Simulation_Status);
        jPanel_Simulation_Status.setLayout(jPanel_Simulation_StatusLayout);
        jPanel_Simulation_StatusLayout.setHorizontalGroup(
            jPanel_Simulation_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Simulation_StatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Simulation_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Simulation_Status_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_Simulation_StatusLayout.setVerticalGroup(
            jPanel_Simulation_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Simulation_StatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Simulation_Status_Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_Simulation_Area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_Simulation_Area.setName("Simulation Area"); // NOI18N

        javax.swing.GroupLayout jPanel_Simulation_AreaLayout = new javax.swing.GroupLayout(jPanel_Simulation_Area);
        jPanel_Simulation_Area.setLayout(jPanel_Simulation_AreaLayout);
        jPanel_Simulation_AreaLayout.setHorizontalGroup(
            jPanel_Simulation_AreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_Simulation_AreaLayout.setVerticalGroup(
            jPanel_Simulation_AreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Main_Menu_Bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_Simulation_Area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_Simulation_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Main_Menu_Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_Simulation_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Simulation_Area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToMM(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToMM
       // TODO add your handling code here:
        this.menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMM

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main_Menu_Bar;
    private javax.swing.JButton jButton_Simulation_Pause;
    private javax.swing.JButton jButton_Simulation_Return;
    private javax.swing.JLabel jLabel_Main_Menu_Title;
    private javax.swing.JLabel jLabel_Simulation_Status_Title;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel_Simulation_Area;
    private javax.swing.JPanel jPanel_Simulation_Status;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
