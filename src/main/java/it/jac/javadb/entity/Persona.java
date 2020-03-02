package it.jac.javadb.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "vaccinato", joinColumns = {
			@JoinColumn(name = "idpersona", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idvaccinazione", referencedColumnName = "id") })
	private Set<Vaccinazione> vaccinazioni = new HashSet<Vaccinazione>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "somministrazione", joinColumns = {
			@JoinColumn(name = "idpersona", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idvaccinazione", referencedColumnName = "id") })
	private Set<Vaccinazione> vaccinations = new HashSet<Vaccinazione>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "somministrazione", joinColumns = {
			@JoinColumn(name = "idpersona", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idvaccino", referencedColumnName = "id") })
	private Set<Vaccino> vaccines = new HashSet<Vaccino>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ammalato", joinColumns = {
			@JoinColumn(name = "idpersona", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "idmalattia", referencedColumnName = "id") })
	private Set<Malattia> malattie = new HashSet<Malattia>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 15)
	private String nome;

	@Column(name = "cognome", length = 30)
	private String cognome;

	/*
	 * // 1Data da fpormattare bene
	 * 
	 * @Column(name = "data_nascita") private java.sql.Date data_nascita;
	 */
	@Column(name = "data_nascita")
	private Date data_nascita;

	@Column(name = "recapito_telefonico", length = 20)
	private String recapito_telefonico;

	@Column(name = "indirizzo_residenza", length = 50)
	private String indirizzo_residenza;

	/*
	 * @Column(name = "validTo") private Date validTo;
	 */
	@Column(name = "creation_time")
	private Date creation_time;

	@Column(name = "creation_user", length = 20)
	private String creation_user;

	@Column(name = "update_user", length = 20)
	private String update_user;

	@Column(name = "update_time")
	private Date update_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public java.sql.Date getDataNascita() {// prima era ->  public Date
		return (java.sql.Date) data_nascita;
	}

	public void setDataNascita(String date2) throws ParseException {
		this.data_nascita = java.sql.Date.valueOf(date2);
	}

	public String getRecapito_telefonico() {
		return recapito_telefonico;
	}

	public void setRecapito_telefonico(String recapitoTelefonico) {
		this.recapito_telefonico = recapitoTelefonico;
	}

	public String getIndirizzo_residenza() {
		return indirizzo_residenza;
	}

	public void setIndirizzo_residenza(String indirizzoResidenza) {
		this.indirizzo_residenza = indirizzoResidenza;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creationTime) {
		this.creation_time = creationTime;
	}

	public String getCreation_user() {
		return creation_user;
	}

	public void setCreation_user(String creationUser) {
		this.creation_user = creationUser;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String updateUser) {
		this.update_user = updateUser;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date updateTime) {
		this.update_time = updateTime;
	}
	/*
	 * public void setDataNascita(java.sql.Date data_nascita) { this.dataNascita =
	 * data_nascita; }
	 */

	/* Costruttore Set persona parameters */
	public Persona(int id, String nome, String cognome, String dataNascita, String recapitoTelefonico,
			String indirizzoResidenza) throws ParseException {

		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setDataNascita(dataNascita);// this.setDataNascita(data_nascita); 4 Data da fpormattare bene
		this.setRecapito_telefonico(recapitoTelefonico);
		this.setIndirizzo_residenza(indirizzoResidenza);

	}

	
	
	
//	public String getDataNascita() {// prima era ->  public Date
//		return data_nascita;
//	}
//
//	public String setDataNascita(String dataNascita) throws ParseException {
//		return dataNascita;
//	}
	
	
	
//	public Date getCreation_time() {
//		return creation_time;
//	}
//
//	public void setCreation_time(Date creationTime) {
//		this.creation_time = creationTime;
//	}
	

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * prova va bene ma ora prova cons tring builder
	 * 
	 * @Override //da rivedere, dovrebbe andare bene Ven 17/01 15:48 on IoT Lesson
	 * public String toString() { return "Item [id=" + id + ", nome=" + nome +
	 * ", cognome=" + cognome + ", data_nascita= " + data_nascita +
	 * ", recapito_telefonico=" + recapito_telefonico + ",  +  indirizzo_residenza="
	 * + indirizzo_residenza + ", creation_user=" + creation_user +
	 * ", creation_time=" + creation_time + ", update_user=" + update_user +
	 * ", update_time=" + update_time + "]"; }
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		/*
		 * builder.append("Persona [vaccinazioni="); builder.append(vaccinazioni);
		 * builder.append(", vaccinations="); builder.append(vaccinations);
		 * builder.append(", vaccines="); builder.append(vaccines);
		 * builder.append(", malattie="); builder.append(malattie);
		 */
		builder.append(" id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", data_nascita=");
		builder.append(data_nascita);
		builder.append(", recapito_telefonico=");
		builder.append(recapito_telefonico);
		builder.append(", indirizzo_residenza=");
		builder.append(indirizzo_residenza);
		builder.append(", creation_time=");
		builder.append(creation_time);
		builder.append(", creation_user=");
		builder.append(creation_user);
		builder.append(", update_user=");
		builder.append(update_user);
		builder.append(", update_time=");
		builder.append(update_time);
		builder.append("]");
		return builder.toString();
	}
	
	/*
	public Date setData_nascita(Date dataNascita) {
		// TODO Auto-generated method stub
		return dataNascita;
	}
	*/
	
	//Pattern Iterator Persona
	public static Iterator iterator() {

		Iterator<Persona> persone = Persona.iterator();
		return persone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((creation_time == null) ? 0 : creation_time.hashCode());
		result = prime * result + ((creation_user == null) ? 0 : creation_user.hashCode());
		result = prime * result + ((data_nascita == null) ? 0 : data_nascita.hashCode());
		result = prime * result + id;
		result = prime * result + ((indirizzo_residenza == null) ? 0 : indirizzo_residenza.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((recapito_telefonico == null) ? 0 : recapito_telefonico.hashCode());
		result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
		result = prime * result + ((update_user == null) ? 0 : update_user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (creation_time == null) {
			if (other.creation_time != null)
				return false;
		} else if (!creation_time.equals(other.creation_time))
			return false;
		if (creation_user == null) {
			if (other.creation_user != null)
				return false;
		} else if (!creation_user.equals(other.creation_user))
			return false;
		if (data_nascita == null) {
			if (other.data_nascita != null)
				return false;
		} else if (!data_nascita.equals(other.data_nascita))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo_residenza == null) {
			if (other.indirizzo_residenza != null)
				return false;
		} else if (!indirizzo_residenza.equals(other.indirizzo_residenza))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (recapito_telefonico == null) {
			if (other.recapito_telefonico != null)
				return false;
		} else if (!recapito_telefonico.equals(other.recapito_telefonico))
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		if (update_user == null) {
			if (other.update_user != null)
				return false;
		} else if (!update_user.equals(other.update_user))
			return false;
		return true;
	}
}
