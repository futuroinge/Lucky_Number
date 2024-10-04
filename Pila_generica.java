/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila_generica;

/**
 *
 * @author Dell
 */
public class Pila_generica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    PilaGe<Integer> pilaInt = new PilaGe<>();
  
    pilaInt.pop();
    pilaInt.push(2);
    pilaInt.push(2);
    pilaInt.push(67);
    pilaInt.push(25);
    pilaInt.push(23);
    pilaInt.push(26);
    
    pilaInt.peek();
   pilaInt.pop();
   pilaInt.peek();
    
    } 
}
