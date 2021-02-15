package fciencias.edatos.recursion;

public class Hanoi{

	/**
	* Resuelve las torres de Hanoi con n discos.
	* @param n la cantidad de discos.
	* @param origen la torre de origen.
	* @param auxiliar la torre auxiliar.
	* @param destino la torre destino.
	*/
	public static void hanoi(int n, int origen,  int auxiliar, int destino){
		if(n==1)
			System.out.println("Mover disco de " + origen + " a " + destino);
		else{
			hanoi(n-1, origen, destino, auxiliar);
			System.out.println("Mover disco de "+ origen + " a " + destino);
			hanoi(n-1, auxiliar, origen, destino);
		}
	}

	public static void main(String[] args) {
		hanoi(15,1,2,3);
	}
}