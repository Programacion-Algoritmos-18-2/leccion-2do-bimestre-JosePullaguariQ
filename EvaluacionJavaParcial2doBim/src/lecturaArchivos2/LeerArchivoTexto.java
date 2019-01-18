package lecturaArchivos2;

// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo(String direccionA) {//Metodo para abrir archivo que recibe un parametro con la direccion del archivo a leer
        try {
            entrada = new Scanner(new File(direccionA));//agregamos la variable con direccion del archivo
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo
    
    
    //Metodo que lee registros del archivo tipo Json
    public ArrayList<Profesor> leerRegistros1() {
        OperacionData operacion = new OperacionData();//Creamos un objeto tipo OperacionData
        ArrayList<Profesor> lista = new ArrayList<>();//Creamos un Arraylist lista tipo Profesor

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                // Se crea el objeto para leer un Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // Se hace el proceso de transformación del archivo tipo Json  
                Profesor p = g.fromJson(linea, Profesor.class);
                //agregamos a la lista el objeto p
                lista.add(p);
            } // fin de while
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n
       
    //Metodo que lee registros de archivos tipo csv
    public ArrayList<Profesor> leerRegistros2() {
        ArrayList<Profesor> lista = new ArrayList<>();//Creamos un Arraylist lista tipo Profesor
 
        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
  
                Profesor p = new Profesor();//Creamos un objeto tipo Profesor
                String linea = entrada.nextLine();//Usamos el nextLine para leer una linea hasta que encuentre un salto de linea
                ArrayList<String> lineasP = new ArrayList<String>(Arrays.asList(linea.split(",")));//Separamos la cadena con un split con el caracter de ","
                p.setCedula(lineasP.get(0));//Enviamos los datos a los atributos del objeto con las posiciones del Arraylist
                p.setNombres(lineasP.get(1));
                p.setZona(lineasP.get(2));
                p.setProvincia(lineasP.get(3));
                p.setCanton(lineasP.get(4));
                p.setPersonalidad(lineasP.get(5));
                p.setRazonamiento(lineasP.get(6));
                p.setDictamenI(lineasP.get(7));
                lista.add(p);//agregamos el objeto a la lista 
            } // fin de while
        } // fin de try 
        
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } // fin del m�todo leerRegistros

    
    // Metodo que cierra el archivo y termina la aplicacion
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto
