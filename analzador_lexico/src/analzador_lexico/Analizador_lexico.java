/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analzador_lexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FELIPE
 */
public class Analizador_lexico {

    /**
     * @param args the command line arguments
     */
    private final ArrayList<String> keyword=new ArrayList<>(Arrays.asList(
                                "false","true","none","and","as","assert","async",
                                "await","break","class","continue","def","del",
                                "elif","else","except","finally","for","from",
                                "global","import","if","in","is","lambda",
                                "nonlocal","pass","raise","return","try",
                                "with","while","yield"));
    private final ArrayList<String> constante=new ArrayList<>(Arrays.asList(
                                "None","notImplemented","Ellipsis","NaN","Inf",
                                "_debug_"));
    private final ArrayList<String> apertura=new ArrayList<>(Arrays.asList("(",
                                               "[","{"));
    private final ArrayList<String> cierre=new ArrayList<>(Arrays.asList(")","]"
                                                                ,"}"));
    private final ArrayList<String> simbolosEspeciales=new ArrayList<>(
                                    Arrays.asList("#","@",":",";","\""));
    private final ArrayList<String> aritmetico=new ArrayList<>(Arrays.asList("+",
                                                    "-","*","/","//","%","**"));
    private final ArrayList<String> relacional=new ArrayList<>(Arrays.asList("<",
                                                "<=",">",">=","!=","=="));
    private final ArrayList<String> logico=new ArrayList<>(Arrays.asList("or",
                                                "not","and"));
    private final ArrayList<String> asignacion=new ArrayList<>(Arrays.asList("=",
                                                "+=","-=","*=","/=","%=","**="));
    private final ArrayList<String> Bit_a_Bit=new ArrayList<>(Arrays.asList("&",
                                                "|","~","^","<<",">>"));
    
    
    public String Tokenize(String frase){
        String[] chain=frase.split(" ");
        return this.identify(chain);
        
    }
    
    public String identify(String[] chain){
        String mensaje="";
        
        for(int i=0;i<chain.length;i++){
            if(this.constante.contains(chain[i])){
                mensaje+=(chain[i]+" es una constante \n");
                
            }
            
            chain[i]=chain[i].toLowerCase();
            if(this.keyword.contains(chain[i])){
                mensaje+=(chain[i]+" es una keyword \n");
                
            }else if(this.apertura.contains(chain[i])){
                mensaje+=(chain[i]+" es un parentesis de apertura \n");
                
            }else if(this.cierre.contains(chain[i])){
                mensaje+=(chain[i]+" es un parentesis de cierre \n");
                
            }else if(this.simbolosEspeciales.contains(chain[i])){
                mensaje+=(chain[i]+" es un simbolo especial \n");
                
            }else if(this.aritmetico.contains(chain[i])){
                mensaje+=(chain[i]+" es un operador aritmetico \n");
                
            }else if(this.relacional.contains(chain[i])){
                mensaje+=(chain[i]+" es un operador relacional \n");
                
            }else if(this.asignacion.contains(chain[i])){
                mensaje+=(chain[i]+" es un operador de asignacion \n");
                
            }else if(this.logico.contains(chain[i])){
                mensaje+=(chain[i]+" es un operador logico \n");
                
            }else if(this.Bit_a_Bit.contains(chain[i])){
                mensaje+=(chain[i]+" es un operador bit a bit \n");
                
            }else if(chain[i].charAt(0)=="\"".charAt(0)&&
                    chain[i].charAt(chain[i].length()-1)=="\"".charAt(0) ){
                mensaje+=(chain[i]+" es una constante String \n");    
                
            }else if(chain[i].matches("[+-]?\\d*(\\.\\d+)?")){
                mensaje+=(chain[i]+" es un valor numerico \n");
            }else if(!this.simbolosEspeciales.contains(String.valueOf(
                    chain[i].charAt(0))) && !Character.isDigit(chain[i].charAt(0))){
                mensaje+=(chain[i]+" es un identificador de variable \n");
            }else{
                mensaje+=(chain[i]+" no se encuentra dentro del lenguaje \n");
            }
        
        }
        return mensaje;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Analizador_lexico an=new Analizador_lexico();
        Ingreso in=new Ingreso(an);
    }
    
}
