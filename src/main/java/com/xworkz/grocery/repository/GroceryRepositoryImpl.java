package com.xworkz.grocery.repository;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.xworkz.grocery.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.xworkz.grocery.entity.GroceryEntity;

@Component
public class GroceryRepositoryImpl implements GroceryRepository {

	@Autowired
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public GroceryRepositoryImpl() {
		System.out.println("invoked groceryrepo");
	}

	@Override
	public void save(GroceryEntity groceryEntity) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(groceryEntity);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	public GroceryEntity findByNameAndBrand(String name, String brand) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		GroceryEntity groceryEntity = null;
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createNamedQuery("findByNameAndBrand");
			query.setParameter("name", name);
			query.setParameter("brand", brand);
			try {
				groceryEntity = (GroceryEntity) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("No grocery entity found with name: " + name + " and brand: " + brand);
			}
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return groceryEntity;
	}

	@Override
	public GroceryEntity findByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		GroceryEntity groceryEntity = null;
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createNamedQuery("findByName");
			query.setParameter("name", name);
			try {
				groceryEntity = (GroceryEntity) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("No grocery entity found with name: " + name);
			}
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return groceryEntity;
	}


	@Override
	public GroceryEntity updateByName(GroceryEntity groceryEntity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createNamedQuery("updateByName");
			query.setParameter("name", groceryEntity.getName());
			query.setParameter("quantity", groceryEntity.getQuantity());
			query.setParameter("price", groceryEntity.getPrice());
			query.setParameter("type", groceryEntity.getType());
			query.setParameter("brand", groceryEntity.getBrand());

			int updateCount = query.executeUpdate();
			entityManager.getTransaction().commit();

			if (updateCount > 0) {
				System.out.println("Grocery entity updated successfully.");
			} else {
				System.out.println("No grocery entity found to update.");
			}
		} catch (PersistenceException e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

		return groceryEntity;
	}

	@Override
	public List<GroceryEntity> getAllGrocery() {
		System.out.println("invoked get all grocery");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("getAllGrocery");
			List<GroceryEntity> obj = query.getResultList();

			return obj;

		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			;
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

		return GroceryRepository.super.getAllGrocery();
	}

	@Override
	public boolean deleteGroceryByName(String name) {
		System.out.println("Invoked deleteGroceryByName");

		if (name == null || name.trim().isEmpty()) {
			System.out.println("Invalid grocery name provided");
			return false;
		}

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Assuming a named query "deleteGroceryByName" for deletion
			Query query = entityManager.createNamedQuery("deleteGrocery");
			query.setParameter("name", name);

			int rowsAffected = query.executeUpdate();
			entityManager.getTransaction().commit();

			if (rowsAffected > 0) {
				System.out.println("Deleted grocery with name: " + name);
				return true;
			} else {
				System.out.println("No grocery found with name: " + name);
				return false;
			}
		} catch (PersistenceException e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			entityManager.close();
		}
	}
	@Override
	public void saveDataUsers(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public User findUsername(String username) {
		try {
			return entityManager.createNamedQuery("User.findByUsername", User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User findUserByEmail(String email) {
		try {
			return entityManager.createNamedQuery("User.findByEmail", User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
