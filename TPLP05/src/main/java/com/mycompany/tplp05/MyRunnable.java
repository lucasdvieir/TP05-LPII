/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tplp05;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author konsa
 */
public class MyRunnable implements Runnable {
    private final JTextArea textArea;
    private final JLabel lblFinal;
    private final int maximo;

    public MyRunnable(JTextArea textArea, JLabel lblFinal, int maximo) {
        this.textArea = textArea;
        this.lblFinal = lblFinal;
        this.maximo = maximo;
    }

    @Override
    public void run() {
        for (int i = 0; i <= maximo; i++) {
            final int value = i;
            SwingUtilities.invokeLater(() -> {
                synchronized (textArea) {
                    textArea.append(value + "\n");
                    if (value == maximo) {
                        lblFinal.setVisible(true);
                    }
                }
            });

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    

