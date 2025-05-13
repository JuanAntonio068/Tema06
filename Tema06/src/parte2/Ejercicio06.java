package parte2;

import java.io.*;

public class Ejercicio06 {

	public static void main(String[] args) {
		try {
			File archivo = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\deportista");
			BufferedReader br = new BufferedReader(new FileReader(archivo));

			String linea;
			String mayorEdad = "", mayorPeso = "", mayorEstatura = "";
			int edadMax = 0, pesoMax = 0;
			double alturaMax = 0;

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");

				String nombre = datos[0];
				int edad = Integer.parseInt(datos[1]);
				int peso = Integer.parseInt(datos[2]);
				double altura = Double.parseDouble(datos[3]);

				if (edad > edadMax) {
					edadMax = edad;
					mayorEdad = nombre;
				}
				if (peso > pesoMax) {
					pesoMax = peso;
					mayorPeso = nombre;
				}
				if (altura > alturaMax) {
					alturaMax = altura;
					mayorEstatura = nombre;
				}
			}
			br.close();

			System.out.println("Mayor edad: " + mayorEdad + " (" + edadMax + " años)");
			System.out.println("Mayor peso: " + mayorPeso + " (" + pesoMax + " kg)");
			System.out.println("Mayor estatura: " + mayorEstatura + " (" + alturaMax + " m)");
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
