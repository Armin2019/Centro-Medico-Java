
public class Valor {
	private String especialidad;
	private int valor;
	private int hC;
	private int matricula;
	private double v;
	private Fecha ingreso;
	private Fecha alta;

	public Valor(String especialidad, int valor, int hC) {
		super();
		this.especialidad = especialidad;
		this.valor = valor;
		this.hC = hC;
	}

	public Valor(int valor, int hC, int matricula) {
		super();
		this.valor = valor;
		this.hC = hC;
		this.matricula = matricula;
	}

	public Valor(int hC, double v, Fecha ingreso, Fecha alta) {
		super();
		this.hC = hC;
		this.v = v;
		this.ingreso = ingreso;
		this.alta = alta;
	}

	public Fecha getIngreso() {
		return ingreso;
	}

	public Fecha getAlta() {
		return alta;
	}

	public double getV() {
		return v;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getValor() {
		return valor;
	}

	public int gethC() {
		return hC;
	}

}
