import java.util.List;

import org.hibernate.Session;

import com.example.model.Person;
import com.example.util.HibernateUtil;

public class TestHiber {

	public static void main(String[] args) {
		
		System.out.println(" TEST ");
		
		Session session = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<Person> people = session.createCriteria(Person.class).list();
		
		if(people.isEmpty()){
			System.out.println("VAZIO");
		}
		else{
			for (Person p : people) {
				System.out.println("TEST: " + p.getCod() + " - " + p.getName());
			}
		}
						
		session.close();

	}

}
