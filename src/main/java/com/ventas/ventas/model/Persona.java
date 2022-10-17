package com.ventas.ventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	@NotNull(message = "El nombre es un campo obligatorio")
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max=70, message = "El nombre debe ser mayor a tres caracteres")
	@Column(name="nombre", nullable = false, length = 70)
	private String nombre;
	@NotNull
	@NotBlank(message = "Los apellidos son obligatorio")
	@Size(min = 3, max=150, message = "Los apellidos deben ser mayores a tres caracteres")
	@Column(name="apellido", nullable = false, length = 150)
	private String apellido;
	@Size(max = 150, message = "La dirección no debe de superar los 150 caracteres")
	@Column(name="direccion", nullable = true, length = 150)
	private String direccion;
	@Size(min = 10, message = "El teléfono debe tener al menos 10 digitos")
	@Column(name="telefono", nullable = true, length = 12)
	private String telefono;
	 
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
