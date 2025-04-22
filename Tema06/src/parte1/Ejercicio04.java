package parte1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		// Declaramos el escaner
		Scanner sc = new Scanner(System.in);

		try {
			// Abrimos el archivo
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\Editable"));

			// Variable donde se va a guardar lo que quiera escribir el usuario
			String escritura;

			// Preguntamos al usuario por la cadena que quiere escribir
			System.out.println("Introduce la cadena a escribir");
			escritura = sc.nextLine();

			while (!escritura.equalsIgnoreCase("fin")) {

				bw.write(escritura);
				bw.newLine();

				// Preguntamos al usuario por la cadena que quiere escribir
				System.out.println("Introduce la cadena a escribir");
				escritura = sc.nextLine();
			}

			// Hacemos el flush
			bw.flush();

			// Cerramos el writer
			bw.close();

			// Cerramos el escaner
			sc.close();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
	}

}
