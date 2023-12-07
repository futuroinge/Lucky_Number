package com.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Random;

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
        "¿Cuál es el país más grande de Asia?",
        "¿Cuál es el país con la mayor cantidad de islas en el mundo?",
        "¿Cuál es el país más pequeño de América del Sur?",
        "¿Cuál es el país con mayor cantidad de volcanes activos?",
        "¿Cuál es el país más grande de África?",
        "¿Cuál es el país más pequeño de Asia?",
        "¿Cuál es el país más grande de Centroamérica?",
        "¿Cuál es el país más grande de América del Sur?"
    };

    //base de datos de las pregutuntas
    String[] respuesta = {
        "Australia",
        "Canadá",
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
        "Rusia",
        "Suecia",
        "Surinam",
        "Indonesia",
        "Argelia",
        "Maldivas",
        "Nicaragua",
        "Brasil"
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
        @Override
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
            life--;
        }
        if (!(num[j] >= 3 && num[j] <= 5)) {
            respuestaB.setForeground(Color.RED);
            life--;
        }
        if (!(num[j] >= 6 && num[j] <= 7)) {
            respuestaC.setForeground(Color.RED);
            life--;
        }
        if (!(num[j] >= 8 && num[j] <= 10)) {
            respuestaD.setForeground(Color.RED);
            life--;
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
        resultado = (int) ((correctas / (double) total_preguntas) * 100);
        contarPreguntas.setText("Resultado");
        almacenarPreguntas.setText("");
        respuestaA.setText("");
        respuestaB.setText("");
        respuestaC.setText("");
        respuestaD.setText("");

        
        labelSegundos.setVisible(false);

    }

    //la magia 
    private void siguientePregunta() {
        mezclarInd(pregunta, respuesta);
        Random random = new Random();
        for (int i = 0; i < pregunta.length; i++) {
            num[i] = random.nextInt(10) + 1;
        }

        if (numpregunta > 30) {
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
        // Aquí puedes manejar cómo muestras las respuestas
        // Por ejemplo, podrías asignar las respuestas a tus componentes UI
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contarPreguntas.setEditable(false);
        contarPreguntas.setText("contarPreguntas");
        contarPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarPreguntasActionPerformed(evt);
            }
        });

        almacenarPreguntas.setEditable(false);
        almacenarPreguntas.setText("almacenarPreguntas");
        almacenarPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenarPreguntasActionPerformed(evt);
            }
        });

        botonA.setText("A");
        botonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAActionPerformed(evt);
            }
        });

        botonB.setText("B");
        botonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBActionPerformed(evt);
            }
        });

        botonC.setText("C");
        botonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCActionPerformed(evt);
            }
        });

        botonD.setText("D");
        botonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDActionPerformed(evt);
            }
        });

        respuestaA.setEditable(false);
        respuestaA.setText("jTextField2");
        respuestaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestaAActionPerformed(evt);
            }
        });

        respuestaB.setEditable(false);
        respuestaB.setText("jTextField2");

        respuestaC.setEditable(false);
        respuestaC.setText("jTextField2");

        respuestaD.setEditable(false);
        respuestaD.setText("jTextField2");

        labelSegundos.setEditable(false);
        labelSegundos.setText("timer");
        labelSegundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelSegundosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonA, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(botonB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(respuestaA, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addComponent(respuestaB)
                            .addComponent(respuestaC)
                            .addComponent(respuestaD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 159, Short.MAX_VALUE)
                        .addComponent(almacenarPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contarPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contarPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(almacenarPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(respuestaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(respuestaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(respuestaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(respuestaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

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
    private javax.swing.JTextField labelSegundos;
    private javax.swing.JTextField respuestaA;
    private javax.swing.JTextField respuestaB;
    private javax.swing.JTextField respuestaC;
    private javax.swing.JTextField respuestaD;
    // End of variables declaration//GEN-END:variables
}
