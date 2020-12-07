
public class Paciente {
	private int hC;
	private int matricula;
	private Fecha nac;
	private Fecha dia;
	private String nombre;
	private String ObraSocial;
	private double p;
	private String especialidad;
	private Fecha ingreso;

	private String atencion;;

	public Paciente(int hC, Fecha dia, int matricula) {
		this.hC = hC;
		this.matricula = matricula;
		this.dia = dia;
	}

	public Paciente(int hC, Fecha dia) {
		this.hC = hC;
		this.dia = dia;
	}

	public Paciente(String nombre, int hC, Fecha edad) {
		this.nombre = nombre;
		this.hC = hC;
		this.nac = edad;
	}

	public Paciente(String nombre, int hC, Fecha nac, String obraSocial, double p) {
		this.nombre = nombre;
		this.nac = nac;
		ObraSocial = obraSocial;
		this.p = p;
		this.hC = hC;
	}

	public Paciente(int hC, String especialidad, Fecha ingreso) {
		this.hC = hC;
		this.especialidad = especialidad;
		this.ingreso = ingreso;

	}

	public Paciente(int hC, int matricula, String atencion) {
		this.hC = hC;
		this.matricula = matricula;
		this.atencion = atencion;

	}

	public int gethC() {
		return hC;
	}

	public void sethC(int hC) {
		this.hC = hC;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Fecha getNac() {
		return nac;
	}

	public void setNac(Fecha nac) {
		this.nac = nac;
	}

	public Fecha getDia() {
		return dia;
	}

	public void setDia(Fecha dia) {
		this.dia = dia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObraSocial() {
		return ObraSocial;
	}

	public void setObraSocial(String obraSocial) {
		ObraSocial = obraSocial;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Fecha getIngreso() {
		return ingreso;
	}

	public void setIngreso(Fecha ingreso) {
		this.ingreso = ingreso;
	}

	public String getAtencion() {
		return atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public String texto() {
		StringBuilder ret = new StringBuilder();
		ret.append("Historia clinica: ");
		ret.append(hC);
		ret.append(' ');
		ret.append(' ');
		ret.append("Nombre: ");
		ret.append(nombre);
		ret.append(' ');
		ret.append(' ');
		ret.append("Fecha nacimiento: ");
		ret.append(nac);

		return ret.toString();
	}
}
