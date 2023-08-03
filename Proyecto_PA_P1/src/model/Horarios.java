package model;

import patron_generico.generica;

public class Horarios {
	private generica <String, String, String> dt_horario;
	private generica <String, String, String> dt_horario2;

	public Horarios(String empleado, String horario1, String horario2, String horario3, String horario4, String horario5) {
		this.dt_horario = new generica <String, String, String> (empleado, horario1, horario2);
		this.dt_horario2 = new generica <String, String, String> (horario3, horario4, horario5);

	}

	public String getEmpleado() {
		return this.dt_horario.getAtributoT1();
	}

	public void setEmpleado(String empleado) {
		this.dt_horario.setAtributoT1(empleado); 
	}

	public String getHorario1() {
		return this.dt_horario.getAtributoS1();
	}

	public void setHorario1(String horario1) {
		this.dt_horario.setAtributoS1(horario1);
	}

	public String getHorario2() {
		return this.dt_horario.getAtributoU1();
	}

	public void setHorario2(String horario2) {
		this.dt_horario.setAtributoU1(horario2);
	}
	
	public String getHorario3() {
		return this.dt_horario2.getAtributoT1();
	}

	public void setHorario3(String horario1) {
		this.dt_horario2.setAtributoT1(horario1);
	}
	
	public String getHorario4() {
		return this.dt_horario2.getAtributoS1();
	}

	public void setHorario4(String horario1) {
		this.dt_horario2.setAtributoS1(horario1);
	}
	
	public String getHorario5() {
		return this.dt_horario2.getAtributoU1();
	}

	public void setHorario5(String horario1) {
		this.dt_horario2.setAtributoU1(horario1);
	}
}
