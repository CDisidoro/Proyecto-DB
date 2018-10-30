/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;



/**
 *
 * @author Camilo D'isidoro
 */
public class Validador {
    public static int numeros(String campo){
        int correcto = 0;
        boolean letra = false;
        for(int i=0;i<campo.length();i++){
            if(Character.isDigit(campo.charAt(i))){
            }else{
                letra = true;
                break;
            }
        }
        if(letra!=true){
            correcto=1;
        }
        return correcto;
    }
    
}