package parte1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio06 {

	public static void main(String[] args) {

		// Lista donde se van a guardar los números
		ArrayList<String> numeros = new ArrayList<>();

		try {
			// El archivo que se va a leer
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\NumerosDesordenados"));

			// Variable para guardar una linea
			String linea;

			linea = br.readLine();

			while (linea != null) {

				// Pasamos de string a int y lo guardamos en la lista
				numeros.add(linea);

				// Leemos la siguiente línea
				linea = br.readLine();
			}

			// Ordenamos la lista
			Collections.sort(numeros);

			// Cerramos el reader
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo para leer");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}

		try {
			// El archivo que se va a editar
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\NumerosOrdenados"));

			for (int i = 0; i < numeros.size(); i++) {
				// Escribrimos el numero
				bw.write(numeros.get(i));
				// Salto de linea
				bw.newLine();
			}

			// Hacemos el flush y cerramos el writer
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo para escribirlo");
		}
	}

}
