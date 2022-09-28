package com.ventas.ventas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@NotNull
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max=70, message = "El nombre debe ser mayor a tres caracteres")
	@Column(name="nombre", nullable = false, length = 70)
	private String nombre;
	@NotNull
	@NotBlank(message = "Los apellidos son obligatorio")
	@Size(min = 3, max=150, message = "Los apellidos deben ser mayores a tres caracteres")
	@Column(name="apellidos", nullable = false, length = 150)
	private String apellido;
	@Size(max = 150, message = "La dirección no debe de superar los 150 caracteres")
	@Column(name="direccion", nullable = true, length = 150)
	private String direccion;
	@Size(min = 10, message = "El teléfono debe tener al menos 10 digitos")
	@Column(name="telefono", nullable = true, length = 12)
	private String telefono;
	@NotNull
	@NotBlank(message = "El email es obligatorio")
	@Size(min = 10, message = "El email debe ser de al menos 10 caracteres")
	@Email(message = "Esto no parece un email")
	@Column(name="email", nullable = false, length = 70)
	private String email;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
