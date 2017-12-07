package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@Table(name="PERSONA" , schema="HR")
public class Persona  extends AuditingEntity implements  BaseEntity,  Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONA_ID_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_PERSONA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_ID_GENERATOR" )
	@Column(name="ID_PERSONA")
	private Long id;

	@Column(name="APE_MATERNO")
	private String apeMaterno;

	@Column(name="APE_PATERNO")
	private String apePaterno;

	@Column(name="NOMBRES")
	private String nombres;
	
	
	@Column(name="CORREO")
	private String correo;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="ID_EMPRESA")
	private Integer idEmpresa;

	

	@Column(name="NUM_DOC")
	private String numDoc;


	@Column(name="TELEFONO")
	private String telefono;

	@Column(name="TIPO_DOC")
	private String tipoDoc;

	@Column(name="TIPO_PER")
	private Integer tipoPer;

	@ManyToOne
	@JoinColumn(name="USER_NAME")
	private User user;
	
	

	public Persona() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Integer getTipoPer() {
		return tipoPer;
	}

	public void setTipoPer(Integer tipoPer) {
		this.tipoPer = tipoPer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}