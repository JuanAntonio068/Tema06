package parte2;

import java.io.*;
import java.util.*;

public class Ejercicio02 {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\Firmas");
			Set<String> firmas = new HashSet<>();

			if (archivo.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String firma;
				while ((firma = br.readLine()) != null) {
					firmas.add(firma);
				}
				br.close();
			}

			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce tu nombre:");
			String nombre = sc.nextLine();

			if (firmas.add(nombre)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
				bw.write(nombre);
				bw.newLine();
				bw.close();
				System.out.println("Firma registrada.");
			} else {
				System.out.println("El nombre ya está registrado.");
			}

			sc.close();
		} catch (IOException e) {
			System.out.println("Error al manipular el archivo: " + e.getMessage());
		}
	}
}
