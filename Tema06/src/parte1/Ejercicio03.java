package parte1;

import java.io.*;

public class Ejercicio03 {
	public static void main(String[] args) {

		int sumaEdades = 0;
		double sumaEstaturas = 0;
		int cantidadAlumnos = 0;

		try {
			// Abrimos el archivo para leerlo
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\Alumnos"));

			// Variable para guardar una línea
			String linea;

			// Array para guardar los datos
			String[] datos;

			// Variable para guardar el nombre
			String nombre;

			// Variable para guardar la edad
			int edad;

			// Variable para guardar la estatura
			double estatura;

			linea = br.readLine();

			// Leer cada línea del archivo
			while (linea != null) {

				// Dividimos la línea en partes: nombre, edad y estatura
				datos = linea.split(" ");

				// Guardamos el nombre
				nombre = datos[0];

				// Convertimos la edad a número
				edad = Integer.parseInt(datos[1]);

				// Convertimos la estatura a número
				estatura = Double.parseDouble(datos[2]);

				// Mostramos el nombre del alumno
				System.out.println("Alumno: " + nombre);

				// Sumamos la edad para calcular la media
				sumaEdades += edad;

				// Sumamos la estatura para calcular la media
				sumaEstaturas += estatura;

				// Contamos cuántos alumnos hay
				cantidadAlumnos++;
			}

			// Calculamos y mostramos las medias
			double mediaEdad = (double) sumaEdades / cantidadAlumnos;
			double mediaEstatura = sumaEstaturas / cantidadAlumnos;

			System.out.println("Media de edad: " + mediaEdad);
			System.out.println("Media de estatura: " + mediaEstatura);

			// Cerramos el archivo
			br.close();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
	}
}
