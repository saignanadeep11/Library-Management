/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LibraryManagement;
import java.sql.*;
import javax.swing.JTable;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author saign
 */
public class myinfo extends javax.swing.JFrame {

    /**
     * Creates new form myinfo
     * 
     */
    static String sid;
    public void getid(String s){
    sid=s;
    //return s;
}
    String[] title={"Student Id","Student Name","Gmail","Semister","password","Book Id","Book Name"};
    String[][] output=new String[20][20];
    int i=0,j=0;
    JTable t;
    JButton bt;
    Font f;
    public myinfo() {
        super("MY DETAILS");
        setLocation(1,1);
        setSize(1000,500);
        f=new Font("Arial",Font.BOLD,16);
       // initComponents();
        try{
            ConnectionClass connect=new ConnectionClass();
            String s="select * from student where StudentId='"+sid+"'";
            ResultSet rs=connect.st.executeQuery(s);
            while(rs.next()){
                output[i][j++]=rs.getString("StudentId");
                output[i][j++]=rs.getString("StudentName");
                output[i][j++]=rs.getString("Gmail");
                output[i][j++]=rs.getString("Semister");
                output[i][j++]=rs.getString("password");
            }
            s="select * from issuedbook where studentId='"+sid+"'";
            rs=connect.st.executeQuery(s);
            while(rs.next()){
                output[i][j++]=rs.getString("bookId");
                output[i++][j++]=rs.getString("bookName");
            }
            t=new JTable(output,title);
            t.setFont(f);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(myinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
