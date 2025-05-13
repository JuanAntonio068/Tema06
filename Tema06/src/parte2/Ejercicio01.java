package parte2;

import java.io.*;

public class Ejercicio01 {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\carta");
			BufferedReader br = new BufferedReader(new FileReader(archivo));

			int caracteres = 0, palabras = 0, lineas = 0;
			String linea;

			while ((linea = br.readLine()) != null) {
				caracteres += linea.length();
				palabras += linea.split(" ").length;
				lineas++;
			}
			br.close();

			System.out.println("Caracteres: " + caracteres);
			System.out.println("Palabras: " + palabras);
			System.out.println("Líneas: " + lineas);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
