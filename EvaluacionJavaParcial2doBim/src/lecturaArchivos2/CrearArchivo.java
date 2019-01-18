/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

// Uso de la clase Formatter para escribir datos en un archivo de texto.
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CrearArchivo {//Clase CrearArchivoTexto
    private Formatter salida;//Creamos globalmente una salida tipo formatter usado para enviar texto al archivo
    // Metodo que permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            salida = new Formatter("data/data3.txt");//direccion y nombre del archivo a crear
        } // fin de try
        catch (SecurityException securityException) {//creacion de excepcion
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // Metodo que agrega registros al archivo, recibe una lista tipo arraylist
    public void agregarRegistros(ArrayList<Profesor> lista_ordenada) {
            try // envia valores al archivo
            {
                for (int i = 0; i <lista_ordenada.size(); i++) {//Creamos un for para recorrer la lista
                    //Escribimos con el format un nuevo registro con los datos obtenidos de la lista_ordenada recibida
                    salida.format("%s - %s - %s - %s - %s - %s - %s - %s\n",
                                lista_ordenada.get(i).getCedula(), lista_ordenada.get(i).getNombres(), lista_ordenada.get(i).getZona(), lista_ordenada.get(i).getProvincia(), 
                                lista_ordenada.get(i).getCanton(), lista_ordenada.get(i).getPersonalidad(), lista_ordenada.get(i).getRazonamiento(), lista_ordenada.get(i).getDictamenI());
                }
            } // fin de try
            catch (FormatterClosedException formatterClosedException) {         
                System.err.println("Error al escribir en el archivo.");
                return;
            } // fin de catch
    } // fin del metodo agregarRegistros

    // Metodo que cierra el archivo
    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase CrearArchivoTexto