import java.time.LocalDate;

public class Fecha {
	private int dia;
	private int mes;
	private int año;
	private LocalDate d;

	public Fecha(int dia, int mes, int año) {
		setDia(dia);
		setMes(mes);
		this.año = año;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {

		if (dia < 1 || dia > this.diasDelMes(this.mes, this.año)) {
			throw new RuntimeException("Dia invalido ");
		}

		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mm) {
		if (mm < 1 || mm > 12) {
			throw new RuntimeException("Mes invalido ");
		}
		this.mes = mm;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public LocalDate getD() {
		return d;
	}

	public void setD(LocalDate d) {
		this.d = d;
	}

	public static LocalDate hoy() {
		LocalDate ahora = LocalDate.now();
		return ahora;
	}

	static boolean esBisiesto(int anio) {
		if (anio % 4 == 0 && anio % 100 != 00)
			return true;
		if (anio % 400 == 0)
			return true;
		return false;
	}

	static int diasDelMes(int mes, int anio) {
		if (mes == 2) {
			if (esBisiesto(anio)) {
				return 29;
			} else {
				return 28;
			}
		}
		if ((mes < 7 && mes % 2 == 0) || (mes > 6 && mes % 2 != 0)) {
			return 30;
		} else {
			return 31;
		}
	}

	public int resta(Fecha fechaAlta, Fecha ingreso) {
		dia = fechaAlta.getDia() - ingreso.getDia();
		if (dia < 0) {
			dia = dia + 31;
			mes = fechaAlta.getMes() - ingreso.getMes();
			if (mes >= 1) {
				dia = dia + dia * (mes - 1) * 31;
			}
		}
		return dia;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + año;
	}
}
