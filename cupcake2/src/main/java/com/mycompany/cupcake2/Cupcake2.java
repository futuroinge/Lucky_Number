/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cupcake2;

import java.util.Scanner;

/*@author carlosce
 */
public class Cupcake2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PREGUNTA");
        int number = (int) (Math.random() * 10);
        System.out.println(number);
        String ans = input.nextLine();
        int life = 3;

        if (number == 0 || number == 1 || number == 2) {
            switch (ans.toLowerCase()) {
                case "q":
                    System.out.println("CORRECTO");
                    break;

                case "w":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "r":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "t":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;
                default:
                    System.out.println("ALGO SALIO MAL");
            }
        } else if (number == 3 || number == 4 || number == 5) {
            switch (ans.toLowerCase()) {
                case "q":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "w":
                    System.out.println("CORRECTO");
                    break;

                case "r":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "t":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;
                default:
                    System.out.println("ALGO SALIO MAL");
            }
        } else if (number == 6 || number == 7) {
            switch (ans.toLowerCase()) {
                case "q":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "w":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "r":
                    System.out.println("CORRECTO");
                    break;

                case "t":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;
                default:
                    System.out.println("ALGO SALIO MAL");
            }
        } else if (number == 8 || number == 9 || number == 10) {
            switch (ans.toLowerCase()) {
                case "q":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "w":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "r":
                    life--;
                    System.out.println("RESP ERRONEA");
                    break;

                case "t":
                    System.out.println("CORRECTO");
                    break;
                default:
                    System.out.println("ALGO SALIO MAL");
            }
        }
    }

}
