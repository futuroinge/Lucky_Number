/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cupcake;

import java.util.Scanner;

/*@author carlosce
 */
public class Cupcake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cupcake project");
        System.out.println("Bienvenido al tutorial");
        
        
        boolean tut = true;
        String[] question = {"Colombia", "USA", "Mexico", "India", "Chihuahua"};
        String[] answer = {"Bogota", "Washington", "CDMX", "Nueva Dheli", "Chihuahua"};
        
        do { 
            int life = 3;
            for (int i = 0; i < question.length && life > 0 ; i++) {
            System.out.println("La capital de: " + question[i]);
            String resp = input.nextLine();
            if (resp.equalsIgnoreCase(answer[i])) {
                System.out.println("Respuesta correcta");
            }else{
                System.out.println("Respuesta equivocada");
                life--;
            }
            
        }
        
        if (life==0) {
            System.out.println("game over");
        } else {
            System.out.println("tutorial completado");
        }
        
            System.out.println("Se reinciara el tutorial, quieres volverlo a juegar?");
            System.out.println("Y/n");
            String resp = input.nextLine();
            switch (resp.toUpperCase()) {
                case "Y":
                    break;
                case "N":
                    tut= false;
                    break;
            }
      
        } while (tut);
        
        System.out.println("Nivel 1");
        
    }
}


