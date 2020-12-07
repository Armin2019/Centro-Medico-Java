
public class Especialidad extends Medico {

	private int valor;

	public Especialidad(int matricula, String nombre, String nomEspecialidad, double valorTratamiento) {

		super(matricula, nombre, nomEspecialidad, valorTratamiento);
	}

	public Especialidad(String especialidad, int valor) {
		super(especialidad);
		this.valor = valor;
	}
	
	

	public int getValor() {
		return valor;
	}
	
	
	
}
