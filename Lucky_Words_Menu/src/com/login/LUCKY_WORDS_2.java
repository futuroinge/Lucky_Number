package com.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LUCKY_WORDS_2 extends javax.swing.JFrame {

    //base de datos de preguntas
    String[] pregunta = {
        "¿Cuál es la capital de Australia?",
        "¿Cuál es la capital de Canadá?",
        "¿Cuál es la capital de Nueva Zelanda?",
        "¿Cuál es la capital de Sudáfrica?",
        "¿Cuál es la capital de Chile?",
        "¿Cuál es la capital de Finlandia?",
        "¿Cuál es la capital de Hungría?",
        "¿Cuál es la capital de Bulgaria?",
        "¿Cuál es la capital de Polonia?",
        "¿Cuál es la capital de Suiza?",
        "¿Cuál es la capital de Dinamarca?",
        "¿Dónde se encuentra el Valle de la Muerte?",
        "¿En qué continente se encuentra el desierto del Sahara?",
        "¿En qué continente se encuentra la Gran Barrera de Coral?",
        "¿Cuál es la frontera terrestre más larga del mundo?",
        "¿Cuál es la ciudad más alta sobre el nivel del mar?",
        "¿En qué país se encuentra la isla de Java?",
        "¿En qué país se encuentra el Everest?",
        "¿Dónde se encuentra la cordillera de los Andes?",
        "¿Qué océano se encuentra entre América y Europa?",
        "¿Cuál es el país más grande por área terrestre?",
        "¿Cuál es el país más pequeño del mundo?",
        "¿Cuál es la capital de Japon?",
        "¿Cuál es el país con la mayor cantidad de islas en el mundo?",
        "¿Cuál es el país más pequeño de América del Sur?",
        "¿Cuál es el país más grande de África?",
        "¿Cuál es el país más pequeño de Asia?",
        "¿Cuál es el país más grande de Centroamérica?",
        "¿Cuál es el país más grande de América del Sur?",
        "¿Cuales son los puntos principales",
        "¿Cual es el punto mas bajo de la Tierra?",
        "¿Estrecho que separa Asia de Africa?",
        "¿En que continente se encuentra el Polo sur?",
        "¿Cual es el rio mas largo de Europa?",
        "¿Cual es la Capital de Argentina?",
        "¿¿Cual es la cuidad mas poblada del Mundo?",
        "¿Cual es la Capital de Ecuador?",
        "¿Cual es la Capital de Paraguay?",
        "¿Cual es la Capital de España?"
    };

    //base de datos de las respuestas
    String[] respuesta = {
        "Canberra",
        "Ottawa",
        "Wellington",
        "Pretoria",
        "Santiago",
        "Helsinki",
        "Budapest",
        "Sofía",
        "Varsovia",
        "Berna",
        "Copenhague",
        "Estados Unidos",
        "África",
        "Oceanía",
        "Frontera entre Estados Unidos y México",
        "La Rinconada, Perú",
        "Indonesia",
        "Nepal",
        "América del Sur",
        "Océano Atlántico",
        "Rusia",
        "Nauru",
        "Tokio",
        "Suecia",
        "Surinam",
        "Argelia",
        "Maldivas",
        "Nicaragua",
        "Brasil",
        "Norte, Sur, Este y Oeste",
        "Fosa de las Marianas",
        "Gilbraltar",
        "Antartida",
        "Volga",
        "Buenos Aires",
        "Shangai",
        "Quito",
        "Asuncion",
        "Madrid"
    };


    //variables clave
    int life = 3;//averiguar esta en que parte poner la vida
    int correctas = 0;
    int resultado;
    int total_preguntas = pregunta.length;
    int segundos = 10;
    int numpregunta = 1;
    int j = 0;

    //num = random array
    private int[] num = new int[pregunta.length];

    //Cronometro NO TOCAR 
    Timer timer = new Timer(1000, new ActionListener() {
        @Override // corta la herencia de la superclase
        public void actionPerformed(ActionEvent e) {
            segundos--;
            labelSegundos.setText(String.valueOf(segundos));
            labelSegundos.setForeground(Color.RED);
            if (segundos <= 0) {
                verRespuesta();
            }
        }
    });
    //Aqui termina el cronometro

    //codigo base generado al usar jframe, adaptado al programa
    public LUCKY_WORDS_2() {
        initComponents();
        this.setLocationRelativeTo(null);
        siguientePregunta();
    }

    //god bless mr fisher && mr yates
    public void mezclarInd(String[] preguntas, String[] respuestas) {
        int[] indice = new int[preguntas.length];
        for (int i = 0; i < indice.length; i++) {
            indice[i] = i;
        }

        Random random = new Random();
        for (int i = indice.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temporal = indice[index];
            indice[index] = indice[i];
            indice[i] = temporal;

            String asktemporal = preguntas[index];
            preguntas[index] = preguntas[i];
            preguntas[i] = asktemporal;

            String resptemporal = respuestas[index];
            respuestas[index] = respuestas[i];
            respuestas[i] = resptemporal;
        }
    }

    //arreglar problema de respuesta tiene que ser diferente la cond del if
    private void verRespuesta() {
        timer.stop();
        botonA.setEnabled(false);
        botonB.setEnabled(false);
        botonC.setEnabled(false);
        botonD.setEnabled(false);

        if (!(num[j] >= 1 && num[j] <= 2)) {
            respuestaA.setForeground(Color.RED);
        }
        if (!(num[j] >= 3 && num[j] <= 5)) {
            respuestaB.setForeground(Color.RED);
        }
        if (!(num[j] >= 6 && num[j] <= 7)) {
            respuestaC.setForeground(Color.RED);
        }
        if (!(num[j] >= 8 && num[j] <= 10)) {
            respuestaD.setForeground(Color.RED);
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuestaA.setForeground(Color.BLACK);
                respuestaB.setForeground(Color.BLACK);
                respuestaC.setForeground(Color.BLACK);
                respuestaD.setForeground(Color.BLACK);
                String respuesta = " ";
                segundos = 10;
                labelSegundos.setText(String.valueOf(segundos));
                botonA.setEnabled(true);
                botonB.setEnabled(true);
                botonC.setEnabled(true);
                botonD.setEnabled(true);

                siguientePregunta();
            }
        });
        j++;
        pause.setRepeats(false);
        pause.start();
    }

    private void resultadoFinal() {
        botonA.setEnabled(false);
        respuestaB.setEnabled(false);
        respuestaC.setEnabled(false);
        botonD.setEnabled(false);
        
        almacenarPreguntas.setText("");
        respuestaA.setText("");
        respuestaB.setText("");
        respuestaC.setText("");
        respuestaD.setText("");

        labelSegundos.setVisible(false);

        // Configurar un temporizador para esperar 10 segundos
        Timer temporizador = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se ejecutará después de 10 segundos
                //cerrar ventana actual
                LUCKY_WORDS_2 ventanaActual = (LUCKY_WORDS_2) SwingUtilities.getWindowAncestor(botonA);
                ventanaActual.dispose();
                //abrir nueva ventana
                Modos_de_juego newframe = new Modos_de_juego();
                newframe.setVisible(true);

                this.dispose();
                // Detener el temporizador después de mostrar la nueva ventana
                ((Timer) e.getSource()).stop();
            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        // Iniciar el temporizador
        temporizador.start();

        JOptionPane.showMessageDialog(this, "GAME OVER", "", JOptionPane.INFORMATION_MESSAGE);

    }

    //la magia 
    private void siguientePregunta() {
        mezclarInd(pregunta, respuesta);
        Random random = new Random();
        for (int i = 0; i < pregunta.length; i++) {
            num[i] = random.nextInt(10) + 1;
        }

        if (numpregunta > 12) { // opcion de modificar en num de preguntas
            resultadoFinal();

        } else {
            contarPreguntas.setText("Pregunta:" + (numpregunta++));
            almacenarPreguntas.setText(pregunta[j]);
            timer.start();

            int randomIndex = num[j];

            if (randomIndex >= 1 && randomIndex <= 2) {
                mostrarRespuestas(
                        respuesta[j],
                        respuesta[(j + 1)],
                        respuesta[(j + 2)],
                        respuesta[(j + 3)]);
            } else if (randomIndex >= 3 && randomIndex <= 5) {
                mostrarRespuestas(
                        respuesta[(j + 1)],
                        respuesta[j],
                        respuesta[(j + 2)],
                        respuesta[(j + 3)]);
            } else if (randomIndex >= 6 && randomIndex <= 7) {
                mostrarRespuestas(
                        respuesta[(j + 2)],
                        respuesta[(j + 3)],
                        respuesta[j],
                        respuesta[(j + 1)]);
            } else if (randomIndex >= 8 && randomIndex <= 10) {
                mostrarRespuestas(
                        respuesta[(j + 3)],
                        respuesta[(j + 2)],
                        respuesta[(j + 1)],
                        respuesta[j]);
            }

        }

    }

    private void mostrarRespuestas(String resp1, String resp2, String resp3, String resp4) {
        respuestaA.setText(resp1);
        respuestaB.setText(resp2);
        respuestaC.setText(resp3);
        respuestaD.setText(resp4);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contarPreguntas = new javax.swing.JTextField();
        almacenarPreguntas = new javax.swing.JTextField();
        botonA = new javax.swing.JButton();
        botonB = new javax.swing.JButton();
        botonC = new javax.swing.JButton();
        botonD = new javax.swing.JButton();
        respuestaA = new javax.swing.JTextField();
        respuestaB = new javax.swing.JTextField();
        respuestaC = new javax.swing.JTextField();
        respuestaD = new javax.swing.JTextField();
        labelSegundos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelFondo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contarPreguntas.setEditable(false);
        contarPreguntas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contarPreguntas.setText("contarPreguntas");
        contarPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarPreguntasActionPerformed(evt);
            }
        });
        getContentPane().add(contarPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 147, -1));

        almacenarPreguntas.setEditable(false);
        almacenarPreguntas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        almacenarPreguntas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        almacenarPreguntas.setText("almacenarPreguntas");
        almacenarPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenarPreguntasActionPerformed(evt);
            }
        });
        getContentPane().add(almacenarPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 36, 530, 40));

        botonA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonA.setText("A");
        botonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAActionPerformed(evt);
            }
        });
        getContentPane().add(botonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 59, 39));

        botonB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonB.setText("B");
        botonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBActionPerformed(evt);
            }
        });
        getContentPane().add(botonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 59, 40));

        botonC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonC.setText("C");
        botonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCActionPerformed(evt);
            }
        });
        getContentPane().add(botonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 59, 40));

        botonD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonD.setText("D");
        botonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDActionPerformed(evt);
            }
        });
        getContentPane().add(botonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 59, 40));

        respuestaA.setEditable(false);
        respuestaA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        respuestaA.setText("jTextField2");
        respuestaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestaAActionPerformed(evt);
            }
        });
        getContentPane().add(respuestaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 92, 400, 40));

        respuestaB.setEditable(false);
        respuestaB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        respuestaB.setText("jTextField2");
        getContentPane().add(respuestaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 142, 400, 40));

        respuestaC.setEditable(false);
        respuestaC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        respuestaC.setText("jTextField2");
        respuestaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestaCActionPerformed(evt);
            }
        });
        getContentPane().add(respuestaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 190, 400, 40));

        respuestaD.setEditable(false);
        respuestaD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        respuestaD.setText("jTextField2");
        getContentPane().add(respuestaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 398, 40));

        labelSegundos.setEditable(false);
        labelSegundos.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        labelSegundos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelSegundos.setText("timer");
        labelSegundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelSegundosActionPerformed(evt);
            }
        });
        getContentPane().add(labelSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 80, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reloj.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 250, 170));

        jLabelFondo2.setBackground(new java.awt.Color(204, 255, 204));
        jLabelFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondito.png"))); // NOI18N
        getContentPane().add(jLabelFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondito.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 110, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAActionPerformed
        botonA.setEnabled(false);
        botonB.setEnabled(false);
        botonC.setEnabled(false);
        botonD.setEnabled(false);

        if (evt.getSource() == botonA) {
            String resp = "A";
            if (num[j] >= 1 && num[j] <= 2) {
                correctas++;
            }
        }
        verRespuesta();        // TODO add your handling code here:
    }//GEN-LAST:event_botonAActionPerformed

    private void botonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBActionPerformed
        botonA.setEnabled(false);
        botonB.setEnabled(false);
        botonC.setEnabled(false);
        botonD.setEnabled(false);

        if (evt.getSource() == botonB) {
            String resp = "B";
            if (num[j] >= 3 && num[j] <= 5) {
                correctas++;
            }
        }
        verRespuesta();   // TODO add your handling code here:
    }//GEN-LAST:event_botonBActionPerformed

    private void botonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCActionPerformed
        botonA.setEnabled(false);
        botonB.setEnabled(false);
        botonC.setEnabled(false);
        botonD.setEnabled(false);

        if (evt.getSource() == botonC) {
            String resp = "C";
            if (num[j] >= 6 && num[j] <= 7) {
                correctas++;
            }
        }
        verRespuesta();         // TODO add your handling code here:
    }//GEN-LAST:event_botonCActionPerformed

    private void botonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDActionPerformed
        botonA.setEnabled(false);
        botonB.setEnabled(false);
        botonC.setEnabled(false);
        botonD.setEnabled(false);

        if (evt.getSource() == botonD) {
            String resp = "D";
            if (num[j] >= 8 && num[j] <= 10) {
                correctas++;
            }
        }
        verRespuesta();   // TODO add your handling code here:
    }//GEN-LAST:event_botonDActionPerformed

    private void labelSegundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelSegundosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSegundosActionPerformed

    private void contarPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contarPreguntasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contarPreguntasActionPerformed

    private void respuestaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respuestaAActionPerformed

    private void almacenarPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenarPreguntasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_almacenarPreguntasActionPerformed

    private void respuestaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respuestaCActionPerformed

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
            java.util.logging.Logger.getLogger(LUCKY_WORDS_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LUCKY_WORDS_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LUCKY_WORDS_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LUCKY_WORDS_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LUCKY_WORDS_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField almacenarPreguntas;
    private javax.swing.JButton botonA;
    private javax.swing.JButton botonB;
    private javax.swing.JButton botonC;
    private javax.swing.JButton botonD;
    private javax.swing.JTextField contarPreguntas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo2;
    private javax.swing.JTextField labelSegundos;
    private javax.swing.JTextField respuestaA;
    private javax.swing.JTextField respuestaB;
    private javax.swing.JTextField respuestaC;
    private javax.swing.JTextField respuestaD;
    // End of variables declaration//GEN-END:variables
}
