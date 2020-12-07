
public class Medico {
	private int matricula;
	private String nombre;
	private String nomEspecialidad;
	private double valorTratamiento;

	public Medico(int matricula, String nombre, String nomEspecialidad, double valorTratamiento) {

		this.nombre = nombre;
		this.nomEspecialidad = nomEspecialidad;
		this.valorTratamiento = valorTratamiento;
		this.matricula = matricula;
	}

	public Medico(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNomEspecialidad() {
		return nomEspecialidad;
	}

	public double getValorTratamiento() {
		return valorTratamiento;
	}
	public String texto() {
		StringBuilder ret= new StringBuilder();
		ret.append("Medico: ");
		ret.append(nombre);
		ret.append(' ');
		ret.append("Matricula: ");
		ret.append(matricula);
		ret.append(' ');
		ret.append("Especialidad: ");
		ret.append(nomEspecialidad);
		ret.append(' ');
		ret.append("Valor de tratamiento: ");
		ret.append(valorTratamiento);
		return ret.toString();
	}
}
