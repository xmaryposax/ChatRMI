package chatrmi.ui;

import chatrmi.impl.ClientRMI;
import chatrmi.remote.Message;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *  @author Mary Carmen Ríos Ramírez
 *  @author Laura Lizeth Heredia Manzano 
 *  @author Carlos Iván Castillo Sepúlveda
 *  @since 2015
 * 
 */
    public class ClientChat extends javax.swing.JFrame implements Runnable {
    
    /**
     * Creates new form Chat
     */
    public ClientChat() throws  Exception{
        this("default",new ClientRMI("localhost"));
        
    }
    public ClientChat(String user, ClientRMI client) {
        userName=user;
        initComponents();
        this.setLocationRelativeTo(null);
        getColors();
        tpn_ListUsers.setContentType("text/html");
        tpn_Messages.setContentType("text/html");
        
        try {
            this.clientRMI = client;
          
            tMessages=new Thread(this,"HiloMensajes");
            tMessages.start();
            
            tUsers=new Thread(() -> {
                List<String> listUsers = new ArrayList<>();
                Message userjoined=new Message(userName,"se ha unido a la platica   <<<","Login");
                try {
                    clientRMI.sendMessage(userjoined);
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    while(true){
                        listUsers = clientRMI.getUsers();
                        if(listUsers != null && listUsers.size()>0){
                            tpn_ListUsers.setText(formatList(listUsers).toString());
                            /*
                            StyledDocument doc = jTextPane1.getStyledDocument();
                            addStylesToDocument(doc);
                            doc.insertString(doc.getLength(),message.getUser() + ": " +
                            message.getMessage() + "\n",null);
                            */
                        }
                        Thread.sleep(10000);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }); 
            tUsers.start();
            
        }
        catch(Exception e){
            System.out.println("ERROR: Iniciar clase ClienteRMI");
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCurrentMsg = new javax.swing.JTextArea();
        btn_Send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_User = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_Message = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpn_ListUsers = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tpn_Messages = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mit_CloseSession = new javax.swing.JMenuItem();
        mit_Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtCurrentMsg.setColumns(20);
        txtCurrentMsg.setRows(5);
        txtCurrentMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCurrentMsgKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtCurrentMsg);

        btn_Send.setText("Enviar");
        btn_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendActionPerformed(evt);
            }
        });

        jLabel1.setText("Bienvenid@");

        lbl_User.setText("Usuario");

        jLabel2.setText("Usuarios:");

        lbl_Message.setText("Mensaje");

        jSplitPane1.setDividerLocation(320);
        jSplitPane1.setDividerSize(10);

        tpn_ListUsers.setEditable(false);
        tpn_ListUsers.setMaximumSize(new java.awt.Dimension(100, 1000));
        jScrollPane1.setViewportView(tpn_ListUsers);

        jSplitPane1.setRightComponent(jScrollPane1);

        tpn_Messages.setEditable(false);
        tpn_Messages.setMinimumSize(new java.awt.Dimension(40, 40));
        tpn_Messages.setPreferredSize(new java.awt.Dimension(40, 40));
        jScrollPane3.setViewportView(tpn_Messages);

        jSplitPane1.setLeftComponent(jScrollPane3);

        jMenu1.setText("File");

        mit_CloseSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mit_CloseSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatrmi/ui/p_acesso.png"))); // NOI18N
        mit_CloseSession.setText("Cerrar Sesion");
        mit_CloseSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mit_CloseSessionActionPerformed(evt);
            }
        });
        jMenu1.add(mit_CloseSession);

        mit_Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mit_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatrmi/ui/logout.png"))); // NOI18N
        mit_Exit.setText("Salir");
        mit_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mit_ExitActionPerformed(evt);
            }
        });
        jMenu1.add(mit_Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");

        jMenuItem2.setText("about");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSplitPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Message)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Send, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_User)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_User)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Message)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mit_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mit_ExitActionPerformed
        // TODO add your handling code here:
        //cerrar sesion
        closeSession();
        System.exit(0);
        
    }//GEN-LAST:event_mit_ExitActionPerformed

    private void mit_CloseSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mit_CloseSessionActionPerformed
        // TODO add your handling code here:
        //cerrar sesion
        closeSession();
        LoginChat login=new LoginChat();
        login.setVisible(true);
    }//GEN-LAST:event_mit_CloseSessionActionPerformed

    private void btn_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendActionPerformed
        // TODO add your handling code here:
        try {
            Message msg = new Message(lbl_User.getText(), txtCurrentMsg.getText(),"");
            clientRMI.sendMessage(msg);
            txtCurrentMsg.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger("ERROR_SENT_MESSAGE: " + ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SendActionPerformed
    public void closeSession(){
        try {
            clientRMI.logOut(lbl_User.getText());
            Message userleaved=new Message(userName, "se ha retirado a la platica","Login");
                try {
                    clientRMI.sendMessage(userleaved);
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (Exception ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeSession();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        closeSession();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Conected to: "+clientRMI.getHost()+":"+clientRMI.getPort(), "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtCurrentMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurrentMsgKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("hey");
            btn_Send.doClick();
        }
    }//GEN-LAST:event_txtCurrentMsgKeyPressed

    public javax.swing.JLabel getLabel() {
        return lbl_User;
    }
    
    public void setLabel(javax.swing.JLabel label) {
        this.lbl_User = label;
    }
    
    static void threadMessage(String message) {
        String threadName =
            Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                          threadName,
                          message);
    }
    
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
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ClientChat().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbl_Message;
    private javax.swing.JLabel lbl_User;
    private javax.swing.JMenuItem mit_CloseSession;
    private javax.swing.JMenuItem mit_Exit;
    private javax.swing.JTextPane tpn_ListUsers;
    private javax.swing.JTextPane tpn_Messages;
    private javax.swing.JTextArea txtCurrentMsg;
    // End of variables declaration//GEN-END:variables
    Thread tMessages;
    Thread tUsers;
    Thread tSendMessage;
    ClientRMI clientRMI;
    private final String  userName;
    List<String> listColors =  new ArrayList<>();
    StringBuilder conversation = new StringBuilder();
   
    public void run() {
        List <Message> listMessages;
        try {
            while (true){
              listMessages = clientRMI.getMesssages(userName);
              
                if(listMessages != null && listMessages.size()>0){
                    for (Message message : listMessages) {
                        if(message.getType().equals("")){
                            conversation.append("<p style=\"margin-top: 0;color:blue\">").append(message.getTime()).append(" - ").append(message.getUser()).append(":</p>");
                            conversation.append("<p style=\"margin-top: 0;color:black\">").append(message.getMessage()).append("</p>");
                        }
                        else
                            conversation.append("<p style=\"margin-top: 0;color:red\">").append(message.getUser()).append(" ").append(message.getMessage()).append("</p>");
                    }
                    tpn_Messages.setText(conversation.toString());
                    tpn_Messages.setCaretPosition(tpn_Messages.getDocument().getLength());
                    
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            threadMessage("I wasn't done!");
            
        } catch (Exception ex) {
            Logger.getLogger("Error: list msgs, " + ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getColors() {
        listColors.add("Purple");
        listColors.add("Pink");
        listColors.add("Red");
        listColors.add("Black");
        listColors.add("Gray");
        listColors.add("Green");
        listColors.add("Blue");
        listColors.add("Yellow");
        listColors.add("Brown");   
    }
    
    public StringBuilder formatList(List<String> list){
        StringBuilder listofUsers = new StringBuilder();
        int i=0;
        for(String user: list){
            
            if(!user.equals(userName))
                listofUsers.append("<p style=\"margin-top: 0;color=").append(listColors.get(i)).append("\">").append(user).append("</p>");
            i++;
            if(i==listColors.size())
                i=0;
        }
        return listofUsers;
    }
}

