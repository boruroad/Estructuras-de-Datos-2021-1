package fciencias.edatos.practica03;

/**
 * Práctica 3: Listas //  Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public class Empleado{


	/** Nombre completo del empleado */
	private final String nombreCompleto;

	/** Fecha de nacimiento del empleado */
	private final String fechaNacimiento;

	/** RFC del empleado */
	private String rfc;

	/** Sueldo mensual del empleado */
	private double sueldoMensual;

	/** Puesto donde está el empleado */
	private String puesto;

	/** Numero de empleado */
	private int numEmpleado;

	/**
	 * CONSTRUCTOR. Construye un nuevo Empleado.
	 * @param nombreCompleto el nombre completo del empleado.
	 * @param fechaNacimiento la fecha de nacimiento del empleado.
	 * @param rfc el RFC del empleado.
	 * @param sueldoMensual el sueldo mensual del empleado.
	 * @param puesto el puesto que ocupa el empleado
	 */
	 public Empleado(String nombreCompleto, String fechaNacimiento/*, String rfc*/, double sueldoMensual, String puesto){
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;		
		/* comentamos el rfc porque primero necesitas obtenerlo
		this.rfc = rfc;*/
		this.sueldoMensual = sueldoMensual;
		this.puesto = puesto;
	}

	public void ensenia(){
		System.out.println("  EMPLEADO: "+this.numEmpleado);
		System.out.println("  Nombre: " + nombreCompleto);
		System.out.println("  Fecha de nacimiento: " + fechaNacimiento);
		System.out.println("  RFC: "+calculaRFC(this.nombreCompleto,this.fechaNacimiento));
		System.out.println("  Sueldo Mensual: $" + sueldoMensual);
		System.out.println("  Puesto: " + puesto+"\n");
	}	


	/** MÉTODOS DE ACCESO */
	public  int getNumEmpleado(){
		return this.numEmpleado;
	}

	/** Permite acceder al nombre completo del empleado.
	 * @return el nombre del empleado.
	 */
	public String getNombreCompleto(){
		return this.nombreCompleto;
	}

	/** Permite acceder a la fecha de nacimiento del empleado.
	 * @return la fecha de nacimiento del empleado.
	 */
	public String getFechaNacimiento(){
		return this.fechaNacimiento;
	}


	/** Permite acceder al sueldo mensual del empleado.
	 * @return el sueldo mensual del empleado.
	 */
	public double getSueldoMensual(){
		return this.sueldoMensual;
	}

	/** Permite acceder al puesto de un empleado.
	 * @return el puesto que ocupa uel empleado.
	 */
	public String getPuesto(){
		return this.puesto;
	}

	/** MÉTODOS MUTANTES */

	/**
	 * Permite modificar el sueldo mensual de un empleado.
	 * @param sueldoMensual el nuevo sueldo a percibir.
	 */
	public void setSueldoMensual(double sueldoMensual){
		this.sueldoMensual = sueldoMensual;
	}

	/**
	 * Permite modificar el numero de un empleado en el catálogo.
	 * @param numEmpleado el nuevo numero de empleado.
	 */
	public void setNumEmpleado(int numEmpleado){
		this.numEmpleado=numEmpleado;
	}

	/**
	 * Permite calcular el RFC de un empleado en el catálogo.
	 * @param nombreCompleto el nombre de nuestro empleado.
	 * @param fechaNacimiento la fecha de nacimiento del empleado
	 * @return el RFC del empleado
	 */
	public static String calculaRFC(String nombreCompleto, String fechaNacimiento){
		if(nombreCompleto.equals("SIN NOMBRE")){
			return "NO DISPONIBLE";
		}else{

		String aPaterno, aMaterno, nombre,dia, mes, año,total;
		int posicion;
		nombreCompleto = nombreCompleto.trim().replaceAll(",","").replaceAll("Á","A").replaceAll("É","E").replaceAll("Í","I").replaceAll("Ó","O").replaceAll("Ú","U").replaceAll("á","A").replaceAll("é","E").replaceAll("í","I").replaceAll("ó","O").replaceAll("ú","U").replaceAll("[^ñ,a-z Ñ,A-Z]+","").toUpperCase();;

		posicion = nombreCompleto.indexOf(" ");
		aPaterno = nombreCompleto.substring(posicion+1, posicion+3);
		aPaterno = aPaterno.toUpperCase(); 

		posicion = nombreCompleto.lastIndexOf(" ");
		aMaterno = nombreCompleto.substring(posicion+1, posicion+2);
		aMaterno = aMaterno.toUpperCase();

		posicion = 0;
		nombre = nombreCompleto.substring(posicion, posicion+1);
		nombre = nombre.toUpperCase();

		posicion = 0;
		dia = fechaNacimiento.substring(posicion, posicion+2);

		posicion = fechaNacimiento.indexOf("/");
		mes = fechaNacimiento.substring(posicion+1, posicion+3);

		posicion = fechaNacimiento.lastIndexOf("/");
		año = fechaNacimiento.substring(posicion+3, posicion + 5);

		total = aPaterno+aMaterno+nombre+año+mes+dia;
		return total;
		}
	}

	/** Método toString para mostrar un empleado */
	@Override
	public String toString() {
		return "\nNombre: " + this.nombreCompleto + "\nFecha de nacimiento: " + this.fechaNacimiento+ "\nRFC: " +calculaRFC(this.nombreCompleto,this.fechaNacimiento) + "\nSueldo mensual: $ " + this.sueldoMensual+"\nPuesto: "+this.puesto+"\n******************\n";
	}

}