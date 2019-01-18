/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

/**
 *
 * @author reroes
 */
/*
{"cedula":"1803742806","nombres":"MULLO ROMERO ESTHER DEL CARMEN", 
"zona":"ZONA 3","provincia":"TUNGURAHUA", 
"canton":"AMBATO", "personalidad": "POR CONVOCAR", 
"razonamiento":"POR CONVOCAR", 
"dictamenIdoniedad":"NO IDONEO"}
*/

public class Profesor {//Creamos la clase Profesor con sus atributos
    String cedula;
    String nombres;
    String zona;
    String provincia;
    String canton;
    String personalidad;
    String razonamiento;
    String dictamenIdoniedad;
    
    // Creamos un constructor sin argumentos que llama a otro constructor con valores predeterminados
    public Profesor() {
      this( " ", " ", " ", " ", " ", " ", " ", " "); 
    }
    
    //Constructor de la clase Profesor para recibir parametros
    public Profesor(String cedu, String nomb, String zon, String prov, String cant, String perso, String razon, String dictI) {//Constructor de la clase Profesor para recibir parametros
        setCedula(cedu);
        setNombres(nomb);
        setZona(zon);
        setProvincia(prov);
        setCanton(cant);
        setPersonalidad(perso);
        setRazonamiento(razon);
        setDictamenI(dictI);
    }
    
    //Metodos de agregar y obtener para los atributos    
    public void setCedula(String cedu) {
        cedula = cedu;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombres(String nomb) {
        nombres = nomb;
    }

    public String getNombres() {
        return nombres;
    }
    
    public void setZona(String zon) {
        zona = zon;
    }

    public String getZona() {
        return zona;
    }
    
    public void setProvincia(String prov) {
        provincia = prov;
    }

    public String getProvincia() {
        return provincia;
    }
    
    public void setCanton(String cant) {
        canton = cant;
    }

    public String getCanton() {
        return canton;
    }
    
    public void setPersonalidad(String perso) {
        personalidad = perso;
    }

    public String getPersonalidad() {
        return personalidad;
    }
        
    public void setRazonamiento(String razo) {
        razonamiento = razo;
    }

    public String getRazonamiento() {
        return razonamiento;
    }
    
    public void setDictamenI(String dictI) {
        dictamenIdoniedad = dictI;
    }

    public String getDictamenI() {
        return dictamenIdoniedad;
    }
    
    //Metodo toString para presentar Datos
    public String toString(){
        return String.format("Cedula: %s - Nombres: %s - Zona: %s - Provincia: %s - Canton: %s - Personalidad: %s - Razonamiento %s - Dictamen Idoniedad: %s\n", getCedula(), getNombres(), getZona(), getProvincia(), getCanton(),
                                                                                                                                                            getPersonalidad(), getRazonamiento(), getDictamenI());
    }
}







