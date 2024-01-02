package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    void init() {
        File file = new File("personas.txt");
        ArrayList<Persona> personas = leerPersonas(file);
        String nombre, apellidos;
        Persona persona;
        System.out.println(personas);
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    sc.nextLine();
                    System.out.println("Introduce el nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Introduce el apellido:");
                    apellidos = sc.nextLine();
                    personas.add(new Persona(nombre, apellidos));
                    escribirPersonas(personas, file);
                    break;
                case 2:
                    personas.sort((Persona o1, Persona o2) -> (o1.getNombre() + " " + o1.getApellidos()).compareTo(o2.getNombre() + " " + o2.getApellidos()));
                    escribirPersonas(personas, new File("personaObjeto.txt"));
                    break;
                case 3:
                    if(new File("personaObjeto.txt").exists()){
                        mostrarDatos(new File("personaObjeto.txt"));
                    }else{
                        System.out.println("No exite el fichero.");
                    }
            }
        } while (opcion != 0);
    }

    private ArrayList<Persona> leerPersonas(File file) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(file));) {
            ArrayList<Persona> personas = new ArrayList<>();
            String linea = reader.readLine();
            while (linea != null) {
                personas.add(new Persona(linea.split(" ")[0], linea.split(" ")[1] + " " + linea.split(" ")[2]));
                linea = reader.readLine();
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

    private void mostrarMenu() {
        System.out.println("1. Introducir nuevos valores\n"
                + "  2. Guardar lista\n"
                + "  3. Mostrar contenido del fichero");
    }

    private void escribirPersonas(ArrayList<Persona> personas, File file) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(file));) {
            for (Persona persona : personas) {
                writer.write(persona.toString());
                writer.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarDatos(File file) {
        System.out.println(leerPersonas(file));
    }

}
