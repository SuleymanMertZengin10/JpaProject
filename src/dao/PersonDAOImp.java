package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Person;

public class PersonDAOImp implements PersonDAO{
    
	EntityManager entityManager;
	
	
	public PersonDAOImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public void insertPerson(Person person) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(person);
		transaction.commit();
		
	}

	@Override
	public Person getPerson(int id) {
		
		Person person=entityManager.find(Person.class,id);
		
		return person;
	
		
	}

	@Override
	public List<Person> getAllPersons() {
		TypedQuery<Person> query= entityManager.createQuery("Select e from Person e",Person.class);
		return query.getResultList();
		
	}

	@Override
	public void removePerson(int id) {
		Person  person = getPerson(id);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(person);
		transaction.commit();
		
	}
	
	

}
