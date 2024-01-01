package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Menu {

    void init() {
        File file = new File("personas.txt");
        ArrayList<Persona> personas = leerPersonas(file);
        System.out.println(personas);
    }

    private ArrayList<Persona> leerPersonas(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<Persona> personas=new ArrayList<>();
            String linea=reader.readLine();
            while(linea!=null){
                personas.add(new Persona(linea.split(" ")[0], linea.split(" ")[1]+" "+linea.split(" ")[2]));
                linea=reader.readLine();
                System.out.println(linea);
            }
            return personas;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
