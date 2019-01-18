/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
/**
 *
 * @author reroes
 */
public class OperacionData {//Creamos clase Operacion Data

    ArrayList<Profesor> informacion = new ArrayList<>(); //Declaramos un ArrayList de tipo Profesor vacia

    public void agregarInformacion(ArrayList<Profesor> info) {//Metodo para agregar informacion que recibe un Arraylist tipo Profesor
        //Asignamos a informacion el arraylist info recibio
        informacion = info;
    }

    public ArrayList<Profesor> obtenerInformacion() {//Metodo para obtener informacion del Arraylist
        return informacion;
    }
  
    public void ordenarPorCanton(){//Metodo con proceso de ordenar por canton, a través del uso de Collections
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();//Creamos un Arraylist vacio tipo Profesor
        dataPorCantones.addAll(informacion);//Se añade toda la informacion
        Collections.sort(dataPorCantones, 
                        (o1, o2) -> o1.canton.compareTo(o2.canton));//Compara para ordenar datos
        
        for (int i = 0; i < dataPorCantones.size(); i++) {//Utilizamos for para presentar los datos del Arraylist dataPorCantones
            System.out.println(dataPorCantones.get(i));
        }
    }
    
    public ArrayList<Profesor> ordenarPorNombres(){//Metodo para ordenar por Nombres
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();//Creamos un Arraylist vacio tipo Profesor 
        dataPorNombres.addAll(informacion);//Se añade toda la informacion
        Collections.sort(dataPorNombres, 
                        (o1, o2) -> o1.nombres.compareTo(o2.nombres));//Compara para ordenar datos
        return dataPorNombres;//retornamos el Arraylist
        
    }
    
    public String calcularPorPersonalidad (){//Metodo para calcular participantes catalogados por Personalidad: Adecuado y por Convocar
        Scanner teclado = new Scanner(System.in);     //Objeto scanner para leer de teclado
        int contPersonalidad = 0;                     //Creamos contador para sumar los participantes
        String cadena = " ";                          //Concatenamos cadena para acumular lo que vamos a presentar
        System.out.println("Contabilizar participantes catalogados como Adecuado->(1) o por Convocar->(2)");//Leemos una opcion
        int opc = teclado.nextInt();
        
        if (opc == 1) {//Si es 1 buscamos por Adecuador
            for (int i = 0; i<informacion.size();i++){//Creamos for para recorrer la lista
                if (informacion.get(i).getPersonalidad().equals("ADECUADO"))//Comparamos con cada posicion si es igual a ADECUADO
                    contPersonalidad += 1 ;                                 //Acumulamos las sumas en el contador
                cadena = String.format("Por ADECUADO existen: %d\n", contPersonalidad);//Asignamos a cadena lo que presentaremos
            }
        
        }
        if (opc == 2){//Si es 1 buscamos por Convocar
            for (int i = 0; i<informacion.size();i++){//Creamos for para recorrer la lista
                if (informacion.get(i).getPersonalidad().equals("POR CONVOCAR"))//Comparamos con cada posicion si es igual a POR CONVOCAR
                    contPersonalidad += 1 ;                                     //Acumulamos las sumas en el contador
            }
            cadena = String.format("Por CONVOCAR existen: %d\n", contPersonalidad);//Asignamos a cadena lo que presentaremos
        }  
        
        return cadena;//retornamos la cadena
    }
    
    
    public String calcularPorDictamen(){//Metodo para calcular participantes catalogados por Dictamen: Idoneo y no Idoneo
        Scanner teclado = new Scanner(System.in);       //Objeto scanner para leer de teclado
        int contDictamen = 0;                           //Creamos contador para sumar los participantes 
        String cadena = " ";                            //Concatenamos cadena para acumular lo que vamos a presentar
        System.out.println("Contabilizar participantes catalogados como Idoneo->(1) o por No Idoneo->(2)");//Leemos una opcion
        int opc = teclado.nextInt();
        
        if (opc == 1) {//Si es 1 buscamos por Idoneo
            for (int i = 0; i<informacion.size();i++){//Creamos for para recorrer la lista
                if (informacion.get(i).getDictamenI().equals("IDONEO"))//Comparamos con cada posicion si es igual a IDONEO
                    contDictamen += 1;                                 //Acumulamos las sumas en el contador
                cadena = String.format("Por IDONEO existen: %d\n", contDictamen);//Asignamos a cadena lo que presentaremos
            }
        
        }
        if (opc == 2){//Sie es 2 buscamos por No Idoneo
            for (int i = 0; i<informacion.size();i++){//Creamos for para recorrer la lista
                if (informacion.get(i).getDictamenI().equals("NO IDONEO"))//Comparamos con cada posicion si es igual a NO IDONEO
                    contDictamen += 1 ;                                   //Acumulamos las sumas en el contador
            }
            cadena = String.format("Por NO IDONEO existen: %d\n", contDictamen);//Asignamos a cadena lo que presentaremos
        } 
        
        return cadena;//retornamos la cadena 
    }
       
    public void lecturaData() {//Metodo para para presentar datos
        for (int i = 0; i<obtenerInformacion().size(); i++) {//Creamos un for para recorrer la lista y presentamos
            System.out.println(obtenerInformacion().get(i)); 
        }
    }

}
