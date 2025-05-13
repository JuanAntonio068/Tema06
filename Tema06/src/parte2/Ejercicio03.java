package parte2;

import java.io.*;

public class Ejercicio03 {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\Texto");
			BufferedReader br = new BufferedReader(new FileReader(archivo));

			String linea;
			int contador = 0;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				contador++;
				if (contador == 24) {
					System.out.println("\nPresiona Enter para continuar...");
					System.in.read();
					contador = 0;
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
