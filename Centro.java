
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Centro {
	private String nombre;
	private String cuit;
	private int valorDiaInternacion;
	private HashMap<String, Integer> especialidades;
	private HashMap<Integer, Medico> medicos;
	private Privado pacientePrivado;
	private ObraSocial pacienteObraSocial;
	private double saldo;
	private Ambulatorio pacienteAmbulatorio;
	private int auxDia;
	private int auxMes;
	private int auxAño;

	public Centro(String nombre, String cuit, int valor) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.valorDiaInternacion = valor;
		this.especialidades = new HashMap<String, Integer>();
		this.medicos = new HashMap<Integer, Medico>();
		pacienteAmbulatorio = new Ambulatorio();
		pacientePrivado = new Privado();
		pacienteObraSocial = new ObraSocial(valor);

	}

	public void agregarEspecialidad(String es, int valor) {
		if (!this.especialidades.containsKey(es)) {
			this.especialidades.put(es, valor);
			pacientePrivado.agregarValorConsulta(es, valor);
		} else
			throw new RuntimeException("Esa especialidad ya exixte");

	}

	public void agregarMedico(String nombre, int matricula, String especialidad, int valorTratamiento) {
		Medico auxiliarMedico = new Medico(matricula, nombre, especialidad, valorTratamiento);
		if (!this.medicos.containsKey(matricula)) {
			this.medicos.put(matricula, auxiliarMedico);
			pacienteAmbulatorio.agregarValorTratamiento(nombre, matricula, especialidad, valorTratamiento);
			pacientePrivado.agregarMedico(nombre, matricula, especialidad, valorTratamiento);
			;
		} else
			throw new RuntimeException("Este medico ya existe");
	}

	public void agregarPacientePrivado(String nombre, int hC, Fecha f) {
		pacientePrivado.agregarPacientePrivado(nombre, hC, f);

	}

	public void agregarPacienteObraSocial(String nombre, int hC, Fecha f, String obra, double p) {
		pacienteObraSocial.agregarPacienteObraSocial(nombre, hC, f, obra, p);
	}

	public void agregarPacienteAmbulatorio(String nombre, int hC, Fecha nac) {
		pacienteAmbulatorio.agregarPaciente(nombre, hC, nac);

	}

	public void agregarTratamiento(int hC, int matricula, String atencion) {
		pacienteAmbulatorio.agregarTratamiento(hC, matricula, atencion);
	}

	public void agregarAtencion(int hC, LocalDate d, int matricula) {
		auxDia = d.getDayOfMonth();
		auxMes = d.getMonthValue();
		auxAño = d.getYear();
		pacientePrivado.agregarAtencion(hC, new Fecha(auxDia, auxMes, auxAño), matricula);

	}

	public void agregarAtencion(int hC, Fecha dia) {
		pacientePrivado.agregarAtencion(hC, dia);

	}

	public void agregarAtencion(int hC, Fecha dia, int matricula) {
		pacientePrivado.agregarAtencion(hC, dia, matricula);
	}

	public void agregarInternacion(int hC, String especialidad, Fecha ingreso) {
		pacienteObraSocial.agregarInternacion(hC, especialidad, ingreso);
	}

	public void altaInternacion(int hC, LocalDate d) {
		auxDia = d.getDayOfMonth();
		auxMes = d.getMonthValue();
		auxAño = d.getYear();
		pacienteObraSocial.altaInternacion(hC, new Fecha(auxDia, auxMes, auxAño));

	}

	public void altaInternacion(int hC, Fecha fechaAlta) {
		pacienteObraSocial.altaInternacion(hC, fechaAlta);
	}

	public ArrayList<Integer> listaInternacion() {
		return pacienteObraSocial.listaInternacion();
	}

	public double getSaldo(int hC) {
		if (pacienteAmbulatorio.contiene(hC)) {
			return pacienteAmbulatorio.getSaldo(hC);
		}
		if (pacienteObraSocial.contiene(hC)) {

			return pacienteObraSocial.getSaldo(hC);
		}
		if (pacientePrivado.contiene(hC)) {
			return pacientePrivado.getSaldo(hC);
		}
		return 0.0;
	}

	public void pagarSaldo(int hC) {
		pacienteAmbulatorio.pagarSaldo(hC);
		pacienteObraSocial.pagarSaldo(hC);
		pacientePrivado.pagarSaldo(hC);
	}

	public HashMap<Fecha, String> atencionesEnConsultorio(int hC) {
		return pacientePrivado.atencionesEnConsultorio(hC);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Medicos:");
		ret.append("\n");
		Iterator <Integer> it = medicos.keySet().iterator();
		while(it.hasNext()) {
			int aux = it.next();
			ret.append(aux);
			ret.append('\n');
			ret.append(medicos.get(aux).texto());
			ret.append('\n');
			ret.append('\n');
		}
		ret.append("Especialidades:");
		ret.append("\n");
		Iterator <String> e = especialidades.keySet().iterator();
			while(e.hasNext()) {
				String s = e.next();
				ret.append(s);
				ret.append('\n');
				ret.append(especialidades.get(s).toString());
				ret.append('\n');
				
		}
		ret.append('\n');
		ret.append("Pacientes Obra Social:");
		ret.append(pacienteObraSocial.pacientes());
		ret.append('\n');
		ret.append('\n');
		ret.append("Pacientes Privados:");
		ret.append(pacientePrivado.pacientes());
		ret.append('\n');
		ret.append('\n');
		ret.append("Pacientes Ambulatorios:");
		ret.append(pacienteAmbulatorio.pacientes());
		ret.append('\n');
		
		return ret.toString();
	}
}
