package main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Inventario;

public class RegistroCutipa {
	EntityManagerFactory factory;
	EntityManager em;
	Inventario in;
	
	public void registrarInventario(Inventario data) throws Exception {
		factory = Persistence.createEntityManagerFactory("LPII_T1_CUTIPA_ANDERSON");
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		factory.close();

		System.out.println("Inventario registrado correctamente");
	}
	
	public static void main(String[] args) {
		RegistroCutipa r = new RegistroCutipa();
		try {
			Date fecha = new Date();
			Inventario inventario1 = new Inventario();
			inventario1.setNro_inventario(1);
			inventario1.setFecha(fecha);
			inventario1.setId_prod(2);
			inventario1.setCosto(70.0);
			r.registrarInventario(inventario1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
