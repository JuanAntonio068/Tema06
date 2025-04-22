package parte1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		// Variable para guardar un número
		int num;

		// Variable para guardar la suma
		int suma = 0;

		// Variable para contar cuantos números hay en el fichero
		int cont = 0;

		// Variable para calcular la media
		double media;
		
		try {
			Scanner sc = new Scanner(new FileReader("C:\\Users\\ja.montano\\git\\Tema06\\Tema06\\Enteros"));

			// Se repite hasta que no hayan más numeros enteros
			while (sc.hasNextInt()) {
				num = sc.nextInt();
				suma += num;
				cont++;
			}

			media = (double) suma / cont;

			// Imprimimos el resultado
			System.out.println("La suma de todos los números es: " + suma);
			System.out.println("La media de todos los números es: " + media);

			// Cerramos el escaner
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al buscar el archivo");
		}
	}
}
