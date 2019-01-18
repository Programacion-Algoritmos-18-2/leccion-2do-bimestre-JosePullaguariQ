package lecturaArchivos2;

import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        //Creamos 2 objetos tipo LeerArchivoTexto para utilizar los metodos para leer un archivo
        LeerArchivoTexto aplicacion1 = new LeerArchivoTexto();
        LeerArchivoTexto aplicacion2 = new LeerArchivoTexto();
       
        //Creamos un objeto tipo OperacionData
        OperacionData operacion = new OperacionData();
        
        //Llamamos al metodo abrir archivo con la direccion del archivo a leer
        aplicacion1.abrirArchivo("data/data2.txt");
        aplicacion2.abrirArchivo("data/data1.csv");
        
        ArrayList<Profesor> lista1 = aplicacion1.leerRegistros1();//Creamos una lista1 con los datos del primer archivo
        ArrayList<Profesor> lista2 = aplicacion2.leerRegistros2();//Creamos una lista2 con los datos del segundo archivo
        
        //Creamos un for para agregar a la lista 1 los datos de la lista 2
        for (int i = 0; i <lista2.size(); i++) {
            lista1.add(lista2.get(i));
        }
        
        //Enviamos la información de la lista1 al metodo de agregarInformación de Operacion Data
        operacion.agregarInformacion(lista1);

        System.out.println("ORDENACIÓN POR CANTÓN\n");
        operacion.ordenarPorCanton();//Llamamos al metodo ordearPorCanton para que ordene por Cantones a la lista 1 enviada 
        
        //Creamos un Arraylist lista 3 apara guardar los datos ordenados por Nombres de los dos archivos unidos
        ArrayList<Profesor> lista3 = operacion.ordenarPorNombres();
        
        //Creamos un objeto apliccaion 3 tipo CrearArchivo
        CrearArchivo aplicacion3 = new CrearArchivo();
        aplicacion3.abrirArchivo();//LLamamos al metodo abrir archivo para crear el nuevo archivo data3
        aplicacion3.agregarRegistros(lista3);//Enviamos los datos de la lista 3 que estan rdenados por Nombres al metodo agregarRegistros
        
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(operacion.calcularPorPersonalidad());//Presentamos las cantidades catalogados por Personalidad
        System.out.println(operacion.calcularPorDictamen());//Presentamos las cantidades catalogados por Dictamen
                   
        // operacion.lecturaData();
        //Cerramos todos los archivos
        aplicacion1.cerrarArchivo();
        aplicacion2.cerrarArchivo();
        aplicacion3.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

