package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.PersonDAO;
import dao.PersonDAOImp;
import model.Person;

public class TestJPA {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager=entityManagerFactory.createEntityManager();		
		Person person1=new Person("Suleyman", "Zengin",21);
		Person person2=new Person("Eren", "Zengin2", 16);
		Person person3=new Person("Bekir", "Zengin3", 21);
	
		PersonDAO personDAO=new PersonDAOImp(entityManager);
		
		System.out.println("**Veri taban�na kay�t ekleme**");
		personDAO.insertPerson(person1);
		personDAO.insertPerson(person2);
		personDAO.insertPerson(person3);
		
		System.out.println("**Veri Taban�ndan id ye g�re kay�t getiriyoruz**");
		Person person=personDAO.getPerson(1);
		System.out.println(person);
		
		System.out.println("**Veri taban�ndaki t�m kay�tlar� getirme**");
		List<Person>allPerson=personDAO.getAllPersons();
        for(Person printPerson:allPerson){
        	System.out.println(printPerson);
        }
        
        System.out.println("**Veri  taban�ndan kay�t silme**");
        
        personDAO.removePerson(1);
        
        System.out.println("**sildikten sonra tekrar b�t�n kay�tlar� getirelim**");
        List<Person>allPersonAfterDelete=personDAO.getAllPersons();
        for(Person printPerson:allPersonAfterDelete){
        	System.out.println(printPerson);
        }
        
	}

}
