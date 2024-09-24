/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.desktop.widgets.clima;

import br.edu.util.FuncoesUteis;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Kaua Sousa
 */
public class WidgetClima extends javax.swing.JPanel {
    Clima clima = null;
    
    /**
     * Creates new form WidgetClima
     */
    public WidgetClima() {
        initComponents();
        
        putClientProperty(FlatClientProperties.STYLE, "arc: 35");
        
        Font sf = FuncoesUteis.carregarFonte("/br/edu/desktop/fonts/SF-Pro-Text-Medium.otf");
        Font sf12 = sf.deriveFont(Font.PLAIN, 12);
        Font sf14 = sf.deriveFont(Font.PLAIN, 14);
        Font sf34 = sf.deriveFont(Font.PLAIN, 34);
        
        jlCidade.setFont(sf14);
        jlTemp.setFont(sf34);
        jlMaxMin.setFont(sf12);
        jlWeatherCode.setFont(sf12);
        
        try {
            clima = APIClima.carregarClima();
        } catch (MalformedURLException ex) {
            jlCidade.setText("Sem conexão.");
            jlTemp.setText("");
            jlMaxMin.setText("");
            jlWeatherCode.setText("");
            jlWeatherIcon.setIcon(null);
        } catch (IOException ex) {
            jlCidade.setText("Sem conexão.");
            jlTemp.setText("");
            jlMaxMin.setText("");
            jlWeatherCode.setText("");
            jlWeatherIcon.setIcon(null);
        }
        
        if (clima != null) {
            jlTemp.setText("" + Math.round(clima.getCurrent().getTemperature2m()) + "º");
            jlMaxMin.setText("Máx.: " + Math.round(clima.getDaily().getApparentTemperatureMax()[0]) + "º  Mín.: " + Math.round(clima.getDaily().getTemperature2mMin()[0]) + "º");
            
            int isDay = clima.getCurrent().getIsDay();
            int wc = clima.getCurrent().getWeatherCode();
            
            if (isDay == 0) {
                setBackground(new Color(41, 48, 61));
            }
            
            String wcConvertido = APIClima.getNomeClimaCorrespondente(wc, isDay);
            ImageIcon icone = APIClima.getIconeClimaCorrespondente(wc, isDay);
            
            jlWeatherCode.setText("" + wcConvertido);
            jlWeatherIcon.setIcon(icone);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jlCidade = new javax.swing.JLabel();
        jlTemp = new javax.swing.JLabel();
        jlMaxMin = new javax.swing.JLabel();
        jlWeatherCode = new javax.swing.JLabel();
        jlWeatherIcon = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(56, 117, 179));
        setMinimumSize(new java.awt.Dimension(222, 80));
        setPreferredSize(new java.awt.Dimension(222, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlCidade.setForeground(new java.awt.Color(255, 255, 255));
        jlCidade.setText("Fortaleza");
        jlCidade.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jlCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));

        jlTemp.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        jlTemp.setForeground(new java.awt.Color(255, 255, 255));
        jlTemp.setText("27º");
        jlTemp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jlTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 40));

        jlMaxMin.setForeground(new java.awt.Color(255, 255, 255));
        jlMaxMin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlMaxMin.setText("Máx.: 28º  Mín.: 25º");
        add(jlMaxMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, 20));

        jlWeatherCode.setForeground(new java.awt.Color(255, 255, 255));
        jlWeatherCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlWeatherCode.setText("Nublado");
        jlWeatherCode.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jlWeatherCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 38, 130, 20));

        jlWeatherIcon.setForeground(new java.awt.Color(255, 255, 255));
        jlWeatherIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/desktop/widgets/clima/img/limpo.png"))); // NOI18N
        jlWeatherIcon.setMaximumSize(new java.awt.Dimension(20, 20));
        jlWeatherIcon.setMinimumSize(new java.awt.Dimension(20, 20));
        jlWeatherIcon.setPreferredSize(new java.awt.Dimension(20, 20));
        add(jlWeatherIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 10, 30, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlMaxMin;
    private javax.swing.JLabel jlTemp;
    private javax.swing.JLabel jlWeatherCode;
    private javax.swing.JLabel jlWeatherIcon;
    // End of variables declaration//GEN-END:variables
}