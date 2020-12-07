
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class Privado {
	
	private HashMap<Integer,Paciente> pacientePrivado;
	private HashMap<String,Integer>valorConsulta; //lista especialidad valor
	private LinkedList <Medico>medico; //lista de medicos matricula
	private ArrayList<Valor>saldo;
	private HashMap<Fecha,String>atencion; //lista de fechas de consulta
	private String auxE;
	private String guardia;
	private int valorC;
	private double deudor;;
	
	
	public Privado() {
		this.pacientePrivado = new HashMap<Integer,Paciente>();
		this.valorConsulta = new HashMap<String,Integer>();
		this.atencion= new HashMap<Fecha,String>();
		this.saldo= new ArrayList<Valor>();
		this.medico = new LinkedList <Medico>();
		this.guardia= "Guardia";
		this.deudor=0;
	}
	
	public void agregarPacientePrivado(String nombre, int hC, Fecha f) {
		if(!this.pacientePrivado.containsKey(hC)) {
			Paciente auxiliarPaciente = new Paciente(nombre, hC, f);
			this.pacientePrivado.put(hC, auxiliarPaciente);
		} else
			throw new RuntimeException("Paciente privado ya exixte");
		
	}
	
	public void agregarValorConsulta (String especialidad,Integer valor) {
		if (!this.valorConsulta.containsKey(especialidad)) {
			this.valorConsulta.put(especialidad, valor);
		} else
			throw new RuntimeException("Esta especialidad ya exixte");
	}
	public void agregarMedico (String nombre, int matricula, String especialidad, double valorTratamiento) {
		Medico auxMedico = new Medico (matricula,nombre,especialidad,valorTratamiento);
		if (this.valorConsulta.containsKey(especialidad)) {
			medico.add(auxMedico);
		} else
			throw new RuntimeException("Esta especialidad ya exixte");
	}
	
	
	
	public void agregarAtencion (int hC, Fecha dia, int matricula) {
		if (pacientePrivado.containsKey(hC)) {
			for (Medico m : medico) {
				if (m.getMatricula()==matricula) {
					auxE= m.getNomEspecialidad();
				}
			}
			if (valorConsulta.containsKey(auxE)){
				valorC= valorConsulta.get(auxE);
			}
			saldo.add(new Valor (auxE,valorC,hC));
			atencion.put(dia, auxE);
		}else	
			throw new RuntimeException("paciente no existe");
	}
	public void agregarAtencion (int hC, Fecha dia) {
		if (pacientePrivado.containsKey(hC)) {
			atencion.put(dia,guardia );
		}else	
			
			throw new RuntimeException("paciente no existe");
	}
	public boolean contiene (int hC) {
		if (pacientePrivado.containsKey(hC)) {
			return true;
		}
		return false;
	}
	public double getSaldo(int hC) {
		deudor =0;
			for (Valor v: saldo) {
				if (v.gethC()==hC && v.getEspecialidad().equals(v.getEspecialidad())) {
					deudor = deudor + 1 * v.getValor();
				}
			}
		
		return deudor;
	}
	public void pagarSaldo(int hC) {
		if (pacientePrivado.containsKey(hC)) {
			Iterator <Valor> v = saldo.iterator();
			Valor aux;
			while( v.hasNext()) {
				aux= v.next();
				if (aux.gethC()==hC) {
					v.remove();
				}
			}
		}
	}
	public HashMap <Fecha,String>atencionesEnConsultorio(int hC){
		return atencion;
	}
	public String pacientes(){
		StringBuilder ret = new StringBuilder();
		Iterator <Integer> at =pacientePrivado.keySet().iterator(); 
		while(at.hasNext()) {
			int aux = at.next();
			ret.append('\n');
			ret.append(pacientePrivado.get(aux).texto());
		}
		return ret.toString();
		}
}
