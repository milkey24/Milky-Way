package dairyproject.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dairyproject.dto.Dairy;
import dairyproject.dto.Products;

public class DairyDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public int saveDairy(Dairy dairy) {
		try {
			transaction.begin();
			manager.persist(dairy);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int loginDairy(int id, String password) {
		Dairy dairy = manager.find(Dairy.class, id);
		if (dairy == null) {
			return 0;
		} else {
			if (dairy.getPassword().equals(password)) {
				return 1;
			} else {
				return 2;
			}
		}
	}
	
	public Dairy findDairy(int id) {
	    return manager.find(Dairy.class, id);
	}
	
	public int saveProductToDairy(Dairy dairy, Products products) {
		try {
			transaction.begin();
			manager.persist(products);
			List<Products> list=dairy.getProductList();
			list.add(products);
			dairy.setProductList(list);
			manager.merge(dairy);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int deleteProduct(int id,Dairy dairy) {
		Products products=manager.find(Products.class, id);
		if (products!=null) {
			List<Products> list=dairy.getProductList();
			list.remove(products);
			dairy.setProductList(list);
			transaction.begin();
			manager.remove(products);
			manager.merge(dairy);
			transaction.commit();
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<Products> getAllProduct(Dairy dairy) {
		return dairy.getProductList();
	}

	public int updateProduct(int id,Products products, Dairy dairy) {
		Products dbProducts=manager.find(Products.class, id);
		if (dbProducts!=null) {
			products.setProductId(id);
			List<Products> list=dairy.getProductList();
			Collections.replaceAll(list, dbProducts, products);
			dairy.setProductList(list);
			transaction.begin();
			manager.merge(dairy);
			manager.merge(products);
			transaction.commit();
			return 1;
		}
		else {
			return 0;
		}
	}
}
