package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="categoria")
@NamedQuery(name= "Categoria.findAll", query="SELECT e FROM Categoria e")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cate;
	
	@Column(name="descripcion", nullable = false)
	private String descripcion;
	
	@Column(name="frecuencia_compra")
	@Enumerated(value = EnumType.STRING)
	private Frecuencia_Compra fre_comp;
	
	public Categoria() {
	}
	
}
