/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cupcake3;
import java.util.Random;
/*@author carlosce
 */
public class Cupcake3 {

    public static void main(String[] args) {
        System.out.println("INICIO");
        String[] preguntas = askgeo();
        
        System.out.println("PREGUNTAS");
        for (String pregunta : preguntas) {
            System.out.println(pregunta);
        }
        System.out.println("---");
        
        String[] respuestas = ansgeo();
        System.out.println("RESUESTAS");
        for (String respuesta : respuestas) {
            System.out.println(respuesta);
        }
        
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
}
