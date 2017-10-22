/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import static org.apache.commons.lang.StringUtils.startsWithIgnoreCase;

/**
 *
 * @author Unlimited
 */
public class JFrame extends javax.swing.JFrame
{

    DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    String driver = "jdbc:ucanaccess://";
    Connection connection = null;
    String databasePath = "c:\\java\\MCS\\Database1.mdb";
    String name;

    public JFrame()
    {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(defaultTableModel);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0)
        {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jComboBox1.setEditable(true);
        jComboBox1.setModel(defaultComboBoxModel);
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jComboBox1KeyPressed(evt);
            }
        });

        jButton1.setText("Найти");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Обновить");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Заполнить");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        conncetToDb("SELECT Элементы_1.IDЭлементов, РодителиНаследники.Позиция, Элементы_1.Обозначение, РодителиНаследники.Количество\n"
                + "FROM (Элементы LEFT JOIN РодителиНаследники ON Элементы.IDЭлементов = РодителиНаследники.Родитель) LEFT JOIN Элементы AS Элементы_1 ON РодителиНаследники.Наследник = Элементы_1.IDЭлементов\n"
                + "GROUP BY Элементы_1.IDЭлементов, РодителиНаследники.Позиция, Элементы_1.Обозначение, РодителиНаследники.Количество, Элементы.Обозначение, РодителиНаследники.Родитель\n"
                + "HAVING (((Элементы.Обозначение)=\"" + jComboBox1.getSelectedItem() + "\"))\n"
                + "ORDER BY РодителиНаследники.Позиция;");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed

        updateBd("UPDATE Элементы SET Элементы.Обозначение = \"ЛУИФ.ПНК1-11.63.152-012\"\n"
                + "WHERE (((Элементы.Обозначение)=\"ЛУИФ.ПНК1-11.63.152\"))");


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        loadElementsFromBd("SELECT Элементы.Обозначение\n"
                + "FROM Элементы\n"
                + "ORDER BY Элементы.Обозначение;");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jComboBox1KeyPressed
    {//GEN-HEADEREND:event_jComboBox1KeyPressed
        defaultComboBoxModel.
    }//GEN-LAST:event_jComboBox1KeyPressed
    private void conncetToDb(String sql)
    {
        Vector columnNames = new Vector();
        Vector data = new Vector();
        try
        {
            connection = DriverManager.getConnection(driver + databasePath);
            if (connection == null)
            {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement(resultSetMetaData.getColumnName(i));
            }
            while (resultSet.next())
            {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++)
                {

                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
                System.out.println(row);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        defaultTableModel = new DefaultTableModel(data, columnNames)
        {
            @Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        jTable1.setModel(defaultTableModel);
    }

    private void updateBd(String sql)
    {
        try
        {
            connection = DriverManager.getConnection(driver + databasePath);
            if (connection == null)
            {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Обновлено");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void loadElementsFromBd(String sql)
    {
        try
        {
            connection = DriverManager.getConnection(driver + databasePath);

            if (connection == null)
            {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                defaultComboBoxModel.addElement(resultSet.getString("Обозначение"));
            }

            statement.close();
            connection.close();
        }
        catch (SQLException ex)
        {

        }

        jComboBox1.setModel(defaultComboBoxModel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
