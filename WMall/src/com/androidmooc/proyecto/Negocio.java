package com.androidmooc.proyecto;

class Negocio {
	//Constantes
	public static final int NOMBRE = 0;
	public static final int DIRECCION = 1;
	public static final int TELEFONO = 2;
	public static final int HORARIO = 3;
	public static final int WEBSITE = 4;
	public static final int EMAIL = 5;
	
	//Campos o atributos
	int id;
	String nombre;
	String direccion;
	String telefono;
	String horario;
	String website;
	String email;
	
	//Constructores
	public Negocio(){
		super();
	}
	
	public Negocio(
		int id,
		String nombre,
		String direccion,
		String telefono,
		String horario,
		String website,
		String email
	){
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.website = website;
		this.email = email;
	}
	
	//Métodos
	@Override
	public String toString(){
		return this.id + ". " + this.nombre;
	}
}
