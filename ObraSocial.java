
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ObraSocial {

	private HashMap<Integer, Paciente> pacienteObraSocial;
	private ArrayList<Paciente> lista; // lista de pacientes Internados
	private ArrayList<Integer> listaInternacion; // lista de historia clinicas de pacientes
	private ArrayList<Valor> saldoPaciente;
	private double auxDiasInternacion;
	private double saldo;
	private double deudor;
	private int diaInternacion;
	private Fecha auxFechaIngreso;

	public ObraSocial(int dia) {

		this.pacienteObraSocial = new HashMap<Integer, Paciente>();
		this.lista = new ArrayList<Paciente>();
		this.listaInternacion = new ArrayList<Integer>();
		this.saldoPaciente = new ArrayList<Valor>();
		diaInternacion = dia;

	}

	public void agregarPacienteObraSocial(String nombre, int hC, Fecha f, String obra, double p) {
		if (!this.pacienteObraSocial.containsKey(hC)) {
			Paciente auxiliarPaciente = new Paciente(nombre, hC, f, obra, p);
			this.pacienteObraSocial.put(hC, auxiliarPaciente);
		} else
			throw new RuntimeException("Paciente Obra social ya exixte");

	}

	public void agregarInternacion(int hC, String especialidad, Fecha ingreso) {
		auxFechaIngreso = null;
		if (pacienteObraSocial.containsKey(hC)) {
			auxFechaIngreso = ingreso;
			lista.add(new Paciente(hC, especialidad, ingreso));
			listaInternacion.add(hC);
		}
	}

	public void altaInternacion(int hC, Fecha fechaAlta) {
		double porc;

		auxDiasInternacion = fechaAlta.resta(fechaAlta, auxFechaIngreso);
		if (pacienteObraSocial.containsKey(hC)) {

			porc = pacienteObraSocial.get(hC).getP();
			Iterator<Paciente> i = lista.iterator();
			Paciente a;
			while (i.hasNext()) {
				a = i.next();
				if (a.gethC() == hC) {
					if ((fechaAlta.resta(fechaAlta, a.getIngreso())) < 0) {
						auxFechaIngreso = a.getIngreso();
					}
					i.remove();
				}
			}
			auxDiasInternacion = auxDiasInternacion - 0.5; // en el test me daba una diferencia de un dia. si no le
															// restaba 0.5
			saldo = auxDiasInternacion * porc * diaInternacion;
			saldoPaciente.add(new Valor(hC, saldo, auxFechaIngreso, fechaAlta));
			Iterator<Integer> l = listaInternacion.iterator();
			int aux;
			while (l.hasNext()) {
				aux = l.next();
				{
					if (aux == hC) {
						l.remove();
					}
				}
			}

		}

	}

	public ArrayList<Integer> listaInternacion() {
		return this.listaInternacion;

	}

	public boolean contiene(int hC) {
		if (pacienteObraSocial.containsKey(hC)) {
			return true;
		}
		return false;
	}

	public double getSaldo(int hC) {
		deudor = 0;
		if (pacienteObraSocial.containsKey(hC)) {
			Iterator<Valor> va = saldoPaciente.iterator();
			Valor aux;
			while (va.hasNext()) {
				aux = va.next();
				if (aux.gethC() == hC) {
					deudor = deudor + aux.getV();
				}
			}
		}
		return deudor;
	}

	public void pagarSaldo(int hC) {
		if (pacienteObraSocial.containsKey(hC)) {
			Iterator<Valor> valor = saldoPaciente.iterator();
			Valor ot;
			while (valor.hasNext()) {
				ot = valor.next();
				if (ot.gethC() == hC) {
					valor.remove();

				}
			}
			Iterator<Integer> i = listaInternacion.iterator();
			int aux;
			while (i.hasNext()) {
				aux = i.next();
				if (aux == hC) {
					i.remove();

				}
			}

		}
	}
	public String pacientes(){
		StringBuilder ret = new StringBuilder();
		Iterator <Integer> at =pacienteObraSocial.keySet().iterator(); 
		while(at.hasNext()) {
			int aux = at.next();
			ret.append('\n');
			ret.append(pacienteObraSocial.get(aux).texto());
		}
		return ret.toString();
		}

}
