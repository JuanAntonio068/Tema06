package parte2;

import java.io.*;

public class Ejercicio05 {

	public static void main(String[] args) {
		try {
			File archivo1 = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\archivo1");
			File archivo2 = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\archivo2");

			try (BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
					BufferedReader br2 = new BufferedReader(new FileReader(archivo2))) {
				String linea1, linea2;
				int numLinea = 1;

				while ((linea1 = br1.readLine()) != null && (linea2 = br2.readLine()) != null) {
					if (!linea1.equals(linea2)) {
						for (int i = 0; i < Math.min(linea1.length(), linea2.length()); i++) {
							if (linea1.charAt(i) != linea2.charAt(i)) {
								System.out.println("Diferencia en línea " + numLinea + ", carácter " + (i + 1) + ": '"
										+ linea1.charAt(i) + "' vs '" + linea2.charAt(i) + "'");
								return;
							}
						}
					}
					numLinea++;
				}

				br1.close();
				br2.close();
			}
		} catch (IOException e) {
			System.out.println("Error al comparar archivos: " + e.getMessage());
		}
	}
}
