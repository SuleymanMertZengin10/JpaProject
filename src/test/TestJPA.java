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
		
		System.out.println("**Veri tabanýna kayýt ekleme**");
		personDAO.insertPerson(person1);
		personDAO.insertPerson(person2);
		personDAO.insertPerson(person3);
		
		System.out.println("**Veri Tabanýndan id ye göre kayýt getiriyoruz**");
		Person person=personDAO.getPerson(1);
		System.out.println(person);
		
		System.out.println("**Veri tabanýndaki tüm kayýtlarý getirme**");
		List<Person>allPerson=personDAO.getAllPersons();
        for(Person printPerson:allPerson){
        	System.out.println(printPerson);
        }
        
        System.out.println("**Veri  tabanýndan kayýt silme**");
        
        personDAO.removePerson(1);
        
        System.out.println("**sildikten sonra tekrar bütün kayýtlarý getirelim**");
        List<Person>allPersonAfterDelete=personDAO.getAllPersons();
        for(Person printPerson:allPersonAfterDelete){
        	System.out.println(printPerson);
        }
        
	}

}
