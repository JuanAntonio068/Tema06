package parte1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		// Declaramos el escaner
		Scanner sc = new Scanner(System.in);

		try {
			// Declaramos el writer
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\datos", true));

			// Variable para guardar el nombre
			String nombre;

			// Variable para guardar la edad
			int edad;

			// Preguntamos la edad y el nombre al usuario
			System.out.println("Intoduce tu nombre y edad");
			nombre = sc.nextLine();
			edad = sc.nextInt();

			// Escribimos los datos
			bw.write(nombre + " " + edad);

			// Hacemos flush
			bw.flush();

			// Cerramos el writer y el escaner
			bw.close();
			sc.close();
			
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
	}

}
