package login.cliente.model;

import java.io.Serializable;

public class ClienteEntity implements Serializable{
	private Integer idCliente;
	private String emailCliente;
	private String passCliente;
	private String nombreCliente;
	private Integer telCliente;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getPassCliente() {
		return passCliente;
	}
	public void setPassCliente(String passCliente) {
		this.passCliente = passCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Integer getTelCliente() {
		return telCliente;
	}
	public void setTelCliente(Integer telCliente) {
		this.telCliente = telCliente;
	}
}


