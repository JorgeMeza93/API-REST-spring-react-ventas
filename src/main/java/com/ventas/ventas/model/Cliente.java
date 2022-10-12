package com.ventas.ventas.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@NotNull(message = "E email es un campo obligatorio")
	@NotBlank(message = "El email es obligatorio")
	@Size(min = 10, max=70, message = "El email debe ser de al menos 10 caracteres")
	@Email(message = "El email enviado no es una formato válido")
	@Column(name="email", nullable = false, length = 150)
	private String email;
	@Column(length = 20)
	private String nit;
	@Column(length = 100)
	private String razonSocial;
	@OneToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona idPersona;
	
	public Persona getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
}
