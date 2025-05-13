package parte2;

public class Ejercicio07clientes {

	String dni, nombre, fechaNacimiento;
	double saldo;

	public Ejercicio07clientes(String dni, String nombre, String fechaNacimiento, double saldo) {
	        this.dni = dni;
	        this.nombre = nombre;
	        this.fechaNacimiento = fechaNacimiento;
	        this.saldo = saldo;
	    }

	@Override
	public String toString() {
		return dni + "; " + nombre + "; " + fechaNacimiento + "; " + saldo;
	}
}
