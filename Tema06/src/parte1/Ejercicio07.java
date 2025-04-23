package parte1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\agenda"));

			// Declaramos el escaner
			Scanner sc = new Scanner(System.in);

			// Mapa para guardar los contactos
			HashMap<String, Integer> agenda = new HashMap<>();

			// Array donde guardar cada línea
			String[] datos;

			// Variable para guardar una línea
			String linea;

			// Variable donde se va a guardar la opcion del usuario
			int opcion;

			// Variable donde se va a guardar el nombre
			String nombre;

			// Variable donde se va a guadar el teléfono
			int telf;

			linea = br.readLine();

			while (linea != null) {
				// Guardamos la línea en un array
				datos = linea.split(" ");

				// Guardamos el nombre
				nombre = datos[0];

				// Guardamos el telefono
				telf = Integer.parseInt(datos[1]);

				// Lo añadimos al mapa
				agenda.put(nombre, telf);

				// Leeemos la siguiente linea
				linea = br.readLine();
			}
			// Le mostramos el menu al usuario
			System.out.println("1. Nuevo contacto");
			System.out.println("2. Buscar por nombre");
			System.out.println("3. Mostrar todos");
			System.out.println("4. Salir");
			opcion = sc.nextInt();

			// Limpiamos el escaner
			sc.nextLine();

			while (opcion != 4) {

				switch (opcion) {
				case 1 -> {
					// Comprobamos que la agenda no esté llena
					if (agenda.size() < 20) {
						// Preguntamos el nombre y el teléfono
						System.out.println("Introduce el nombre");
						nombre = sc.nextLine();
						System.out.println("Introduce el teléfono");
						telf = sc.nextInt();
						sc.nextLine();
						agenda.put(nombre, telf);
					} else {
						System.out.println("La agenda ya tiene 20 contactos");
					}
				}
				case 2 -> {
					// Preguntamos el nombre
					System.out.println("Introduce el nombre que quiere buscar");
					nombre = sc.nextLine();

					if (agenda.get(nombre) != null) {
						System.out.println("El teléfono de " + nombre + " es: " + agenda.get(nombre));
					} else {
						System.out.println("No se ha encontrado ese nombre en la agenda");
					}
				}
				case 3 -> {
					// Imprimimos la agenda
					System.out.println(agenda);
				}
				case 4 -> {

					System.out.println("Saliendo...");

				}
				default -> System.out.println("Opción inválida");
				}

				// Le mostramos el menu al usuario
				System.out.println("1. Nuevo contacto");
				System.out.println("2. Buscar por nombre");
				System.out.println("3. Mostrar todos");
				System.out.println("4. Salir");
				opcion = sc.nextInt();
				sc.nextLine();
			}

			try {
				BufferedWriter bw = new BufferedWriter(
						new FileWriter("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\agenda"));

				for (String key : agenda.keySet()) {
					Integer value = agenda.get(key);
					bw.write(key + " " + value);
					bw.newLine();
				}

				// Hacemos el flush y cerramos el writer
				bw.flush();
				bw.close();

				System.out.println("Se han guardado los datos con exito");
			} catch (IOException e) {
				System.out.println("Error al abrir el archivo para escribir");
			}

			// Cerramos el escaner y el reader
			sc.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo para leer");
		} catch (IOException e1) {
			System.out.println("Error al leer el archivo");
		}
	}
}
