package parte1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {

		// Declaramos el escaner
		Scanner sc = new Scanner(System.in);

		// Variable para guardar la fecha
		String fecha;

		// Variable para guardar la temperatura mínima
		int tempMin;

		// Variable para guardar la temperatura máxima
		int tempMax;

		// Variable para guardar la opcion del usuario
		int opcion;

		// Le mostramos el menú al usuario
		System.out.println("1. Registra nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("3. Salir");
		opcion = sc.nextInt();

		while (opcion != 3) {

			switch (opcion) {
			case 1 -> {

				// Preguntamos por la temperatura mínima y máxima y la fecha
				System.out.println("Introduce la temperatura máxima");
				tempMax = sc.nextInt();
				System.out.println("Introduce la temperatura mínima");
				tempMin = sc.nextInt();
				sc.nextLine();
				System.out.println("Introduce la fecha");
				fecha = sc.nextLine();

				try {
					BufferedWriter bw = new BufferedWriter(
							new FileWriter("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\Temperatura", true));

					// Escribimos y añadimos una nueva línea
					bw.write(fecha + ", " + tempMax + ", " + tempMin);
					bw.newLine();

					// Hacemos flush y cerramos el writer
					bw.flush();
					bw.close();
				} catch (IOException e) {
					System.out.println("Error al abrir el archivo para escribir");
				}
			}
			case 2 -> {
				try {
					BufferedReader br = new BufferedReader(
							new FileReader("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\Temperatura"));

					// Variable para guardar una linea
					String linea;

					// Leemos la linea
					linea = br.readLine();

					while (linea != null) {
						System.out.println(linea);

						linea = br.readLine();
					}

					// Cerramos el reader
					br.close();
				} catch (FileNotFoundException e) {
					System.out.println("Error al abrir el archivo para leer");
				} catch (IOException e) {
					System.out.println("Error al leer el archivo");
				}
			}
			case 3 -> {
				System.out.println("Saliendo...");
			}
			default -> System.out.println("Opcion incorrecta");
			}
			// Le mostramos el menú al usuario
			System.out.println("1. Registra nueva temperatura");
			System.out.println("2. Mostrar historial de registros");
			System.out.println("3. Salir");
			opcion = sc.nextInt();
		}
		// Cerramos el escaner
		sc.close();
	}

}
