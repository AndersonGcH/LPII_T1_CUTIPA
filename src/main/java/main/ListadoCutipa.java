package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Inventario;

public class ListadoCutipa {
	EntityManagerFactory factory;
	EntityManager em;
	Inventario in;
	
	public void buscarTodos() {
		factory = Persistence.createEntityManagerFactory("LPII_T1_CUTIPA_ANDERSON");
		em = factory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventario> q = em.createQuery("select e from Inventario e", Inventario.class);

		List<Inventario> res = q.getResultList();

		for (Inventario item : res) {
			System.out.println("Nro inventario: " + String.valueOf(item.getNro_inventario()) + " , fecha: " + item.getFecha() + 
					" , Nombre del producto: " + item.getId_prod() + ", Costo ingreso: " + item.getCosto());
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public static void main(String[] args) {

		ListadoCutipa p = new ListadoCutipa();
		try {				
			p.buscarTodos();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
