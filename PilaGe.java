/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila_generica;

/**
 *
 * @author Dell
 */
public class PilaGe <Tipo> {
    int maxsize = 5;
    Tipo pila[];
    int tope;
    
    public PilaGe(){      
        tope=-1;
        pila = (Tipo[]) new Object[maxsize];
    }
 void push(Tipo dato) throws Exception {
        if (!pilallena()) {
            pila[++tope] = dato;
        } else {
            System.out.println("Pila llena");
        }
    }
     
     void pop() throws Exception{
         if(!pilaVacía()){
             pila[tope] = pila[tope--];
         }
         System.out.println("Pila vacia");;
     }

    private boolean pilallena() {
       return tope == maxsize-1;
    }

    private boolean pilaVacía() {
       return tope == -1;
    }
    
    void peek(){
        if (pilaVacía()) {
            System.out.println("La pila esta vacia. No hay elementos para ver.");
           
        } else {
            System.out.println(pila[tope]);
        }
    }
    
    
    
}
