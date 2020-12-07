import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Ambulatorio {

	 private HashMap<Integer,Paciente> paciente;
	 private LinkedList<Paciente>listaAmbulatorio; //lista de paciente en tratamiento
	 private HashMap<Integer,Integer>valorTratamiento; //lista de valor por especialidad
	 private ArrayList <Valor>saldo; //lista de saldo por paciente
	 private int valorT;
	 private double auxSaldo;
	
	public Ambulatorio() {
		this.paciente= new HashMap<Integer,Paciente>();
		this.listaAmbulatorio=new LinkedList<Paciente>();
		this.valorTratamiento = new HashMap <Integer,Integer>();
		this.saldo= new ArrayList<Valor>();
	}
	
	public void agregarPaciente (String nombre, int hC, Fecha nac) {
		if(!this.paciente.containsKey(hC)) {
			Paciente auxiliarPacienteAmbulatorio = new Paciente(nombre, hC, nac);
			this.paciente.put(hC, auxiliarPacienteAmbulatorio);
		} else
			throw new RuntimeException("Paciente ambulatorio ya exixte");
		}
	public void agregarValorTratamiento(String nombre, int matricula, String especialidad, int valorTratamiento) {
		
		if (!this.valorTratamiento.containsKey(matricula)) {
			this.valorTratamiento.put(matricula, valorTratamiento);
		}else
			throw new RuntimeException("Paciente ambulatorio no exixte");
	}
	
	public void agregarTratamiento(int hC, int matricula, String atencion) {
		if (this.paciente.containsKey(hC)) {
			listaAmbulatorio.add(new Paciente(hC,matricula,atencion));
			valorT = valorTrata(matricula);
			saldo.add(new Valor(valorT,hC, matricula));
		
		}else
			throw new RuntimeException("Paciente ambulatorio no exixte");
	}
	private int valorTrata(int auxMatricula) {
		if (valorTratamiento.containsKey(auxMatricula)) {
			valorT = valorTratamiento.get(auxMatricula);
		}
		return valorT;
	}
	public double getSaldo(int hC) {
		auxSaldo=0;
		if (paciente.containsKey(hC)) {
		Iterator <Valor> v = saldo.iterator();
			Valor auxV;
			while (v.hasNext()) {
				auxV = v.next();
				if (auxV.gethC() == hC) {
					auxSaldo= auxSaldo + auxV.getValor();				}
			}
		}		
	
		return auxSaldo;
	}
	
	
	public void pagarSaldo(int hC) {
		if (paciente.containsKey(hC)) {
			Iterator<Valor> va = saldo.iterator();
			Valor auxVa;
			while (va.hasNext()) {
				auxVa = va.next();
				if (auxVa.gethC() == hC) {
						va.remove();
					}
				
			}
		}

	}
	public boolean contiene (int hC) {
		if (paciente.containsKey(hC)) {
			return true;
		}
		return false;
	}
	public String pacientes(){
		StringBuilder ret = new StringBuilder();
		Iterator <Integer> at =paciente.keySet().iterator(); 
		while(at.hasNext()) {
			int aux = at.next();
			ret.append('\n');
			ret.append(paciente.get(aux).texto());
		}
		return ret.toString();
		}
}
	
			
		
	

		

