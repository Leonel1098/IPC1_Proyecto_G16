package Grupo1.com;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;

public class Error {
    public static  void vericador(){
        File archivo = new File("error.log");
        if (archivo.exists()) {
            Registro("");
        }
        else {
            createFileError();
            Registro("Creacion de Archivo error.log");
        }
    }
    public static void createFileError() {
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("error.log");
            System.out.println("Archivo de errores");

        } catch (IOException e) {
            e.printStackTrace();
            Registro("Falla en la creacion del archivo Error"+"\n");
        }
    }
    public static void Registro(String falla) {
        FileWriter flwriter = null;

        try {
            flwriter = new FileWriter("error.log", true); // True indica que se va a agregar datos al final
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            // Escribe los datos en el archivo
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            bfwriter.write(dtf.format(LocalDateTime.now()));
            bfwriter.write(falla);
            bfwriter.close();

        } catch (IOException e) {

        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
