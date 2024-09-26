package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="inventario")
@NamedQuery(name= "Inventario.findAll", query="SELECT e FROM Inventario e")
public class Inventario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nro_inventario;
	
	@Column(name = "fecha", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private int id_prod;
	
	@Column(name="costo_ingreso")
	private double costo;
	
	public Inventario() {
	}
}
