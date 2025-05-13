package parte2;

import java.io.*;
import java.util.*;

public class Ejercicio04 {

	public static void main(String[] args) {
		try {
			Map<Character, Character> codigo = cargarCodificacion("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\codec");
			codificarTexto("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\mensaje",
					"C:\\Users\\Usuario\\git\\Tema06\\Tema06\\mensaje_cifrado", codigo);
		} catch (IOException e) {
			System.out.println("Error al procesar los archivos: " + e.getMessage());
		}
	}

	public static Map<Character, Character> cargarCodificacion(String archivo) throws IOException {
		Map<Character, Character> mapa = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String[] letras = br.readLine().split(" ");
			String[] cifrado = br.readLine().split(" ");

			for (int i = 0; i < letras.length; i++) {
				mapa.put(letras[i].charAt(0), cifrado[i].charAt(0));
			}
		}
		return mapa;
	}

	public static void codificarTexto(String entrada, String salida, Map<Character, Character> codigo)
			throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(entrada));
				BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

			int c;
			while ((c = br.read()) != -1) {
				bw.write(codigo.getOrDefault((char) c, (char) c));
			}

			System.out.println("Mensaje cifrado guardado en " + salida);
		}
	}
}
