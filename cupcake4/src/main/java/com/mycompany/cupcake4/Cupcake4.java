/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cupcake4;

import java.util.Scanner;
import java.util.Random;

/* @author carlosce
 */
public class Cupcake4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int life = 3;
        String resp;

        String[] preguntas = askgeo();
        String[] respuestas = ansgeo();
        int[] indice = indice();

        mezclar(indice, preguntas, respuestas);

        /*for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + i + " " + preguntas[i]);
            System.out.println("Respuesta " + i + " " + respuestas[i]);
            System.out.println("["+indice[i]+"]");
        }*/
        System.out.println("vidas: " + life);
        do {
            for (int i = 0; i < preguntas.length; i++) {
                int num = random.nextInt(10) + 1;
                System.out.println(preguntas[i]);
                System.out.println(ordenar(num, life, respuestas, i));
                System.out.print("RESPUESTA: ");
                resp = input.nextLine();
                if (resp.equalsIgnoreCase(respuestas[i])) {
                    System.out.println("correcto" + "\n");
                } else {
                    life--;
                    System.out.println("Incorrecto" + "Checaste los acentos?" +"\n");
                }
                if (life > 0) {
                  System.out.println("vidas: " + life);  
                }else if (life == 0) System.out.println("Ultima vida");
                    
                
                if (life < 0) {
                    System.out.println("GAME OVER");
                    break;
                }
            }
        } while (life >= 0);
    }

    public static String[] askgeo() {
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
        return pregunta;
    }

    public static String[] ansgeo() {
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
        return respuesta;
    }

    public static int[] indice() {
        Random random = new Random();
        int[] indice = new int[30]; //modificar numero si se agregan preguntas o respuestas
        for (int i = 0; i < indice.length; i++) {
            indice[i] = i;
        }
        return indice;
    }

    public static void mezclar(int[] indice, String[] preguntas, String[] respuestas) {
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

    public static String ordenar(int num, int life, String[] respuestas, int i) {
        Random random = new Random();
        int aleatorio = random.nextInt(respuestas.length);
        int aleatorio2 = random.nextInt(respuestas.length);
        int aleatorio3 = random.nextInt(respuestas.length);

        if (num >= 1 && num <= 2) {
            System.out.println(respuestas[i]);
            System.out.println(respuestas[aleatorio]);
            System.out.println(respuestas[aleatorio2]);
            System.out.println(respuestas[aleatorio3]);
        } else if (num >= 3 && num <= 5) {
            System.out.println(respuestas[aleatorio]);
            System.out.println(respuestas[i]);
            System.out.println(respuestas[aleatorio2]);
            System.out.println(respuestas[aleatorio3]);
        } else if (num >= 6 && num <= 7) {
            System.out.println(respuestas[aleatorio2]);
            System.out.println(respuestas[aleatorio3]);
            System.out.println(respuestas[i]);
            System.out.println(respuestas[aleatorio]);
        } else if (num >= 8 && num <= 10) {
            System.out.println(respuestas[aleatorio3]);
            System.out.println(respuestas[aleatorio2]);
            System.out.println(respuestas[aleatorio]);
            System.out.println(respuestas[i]);
        }
        return "";
    }

}
