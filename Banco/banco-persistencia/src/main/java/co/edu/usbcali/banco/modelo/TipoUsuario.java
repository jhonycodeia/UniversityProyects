package co.edu.usbcali.banco.modelo;
// Generated 25-jul-2017 23:40:32 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * TipoUsuario generated by hbm2java
 */
@Entity
@Table(name = "tipo_usuario", schema = "public")
public class TipoUsuario implements java.io.Serializable {

	@NotNull(message="no valido")
	private long tiusId;
	@NotNull(message="no valido")
	private String nombre;
	@NotNull(message="no valido")
	private char activo;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public TipoUsuario() {
	}

	public TipoUsuario(long tiusId, String nombre, char activo) {
		this.tiusId = tiusId;
		this.nombre = nombre;
		this.activo = activo;
	}

	public TipoUsuario(long tiusId, String nombre, char activo, Set<Usuario> usuarios) {
		this.tiusId = tiusId;
		this.nombre = nombre;
		this.activo = activo;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	  
	@Column(name = "tius_id", unique = true, nullable = false)
	public long getTiusId() {
		return this.tiusId;
	}

	public void setTiusId(long tiusId) {
		this.tiusId = tiusId;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "activo", nullable = false, length = 1)
	public char getActivo() {
		return this.activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String toString()
	{
		return tiusId+" "+nombre+" "+activo;
	}

}
