package parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio07 {

	static List<Ejercicio07clientes> clientes = new ArrayList<>();

	public static void main(String[] args) {
		cargarClientes();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\nMenú:");
			System.out.println("1. Alta cliente");
			System.out.println("2. Baja cliente");
			System.out.println("3. Listar clientes");
			System.out.println("4. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				altaCliente(sc);
				break;
			case 2:
				bajaCliente(sc);
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				guardarClientes();
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 4);
	}

	static void cargarClientes() {
		try {
			File archivo = new File("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\clientes");
			BufferedReader br = new BufferedReader(new FileReader(archivo));

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				clientes.add(new Ejercicio07clientes(datos[0], datos[1], datos[2], Double.parseDouble(datos[3])));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de clientes: " + e.getMessage());
		}
	}

	static void altaCliente(Scanner sc) {
		System.out.print("DNI: ");
		String dni = sc.nextLine();
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
		String fechaNacimiento = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		sc.nextLine();

		clientes.add(new Ejercicio07clientes(dni, nombre, fechaNacimiento, saldo));
		System.out.println("Cliente agregado.");
	}

	static void bajaCliente(Scanner sc) {
		System.out.print("Introduce el DNI del cliente a eliminar: ");
		String dni = sc.nextLine();

		clientes.removeIf(cliente -> cliente.dni.equals(dni));
		System.out.println("Cliente eliminado.");
	}

	static void listarClientes() {
		System.out.println("\nLista de clientes:");
		double saldoMax = 0, saldoMin = Double.MAX_VALUE, saldoTotal = 0;

		for (Ejercicio07clientes c : clientes) {
			System.out.println(c);
			saldoMax = Math.max(saldoMax, c.saldo);
			saldoMin = Math.min(saldoMin, c.saldo);
			saldoTotal += c.saldo;
		}

		System.out.println("Saldo máximo: " + saldoMax);
		System.out.println("Saldo mínimo: " + saldoMin);
		System.out.println("Saldo promedio: " + (saldoTotal / clientes.size()));
	}

	static void guardarClientes() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\git\\Tema06\\Tema06\\clientes"));
			for (Ejercicio07clientes c : clientes) {
				bw.write(c.dni + ";" + c.nombre + ";" + c.fechaNacimiento + ";" + c.saldo + "\n");
			}
			bw.close();
			System.out.println("Clientes guardados en el archivo.");
		} catch (IOException e) {
			System.out.println("Error al guardar los clientes: " + e.getMessage());
		}
	}
}
