package fciencias.edatos.colas;

public class Proceso{
	
	private String nombre;

	private int tiempo;

	private boolean estado;

	public Proceso(String nombre, int tiempo){
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	public String obtenerNombre(){
		return nombre;
	}

	public int obtenerTiempo(){
		return tiempo;
	}

	public void asignarTiempo(int tiempo){
		this.tiempo = tiempo;
	}

	public void asignarEstado(boolean estado){
		this.estado = estado;
	}

	public boolean isEstado(){
		return estado;
	}
}