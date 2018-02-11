package dao;

import java.util.List;

import model.Person;

public interface PersonDAO {

	public void insertPerson(Person person);
	
	public Person getPerson(int id);
	
	public List<Person>getAllPersons();
	
	public void removePerson(int id);
	
	
	
	
}
