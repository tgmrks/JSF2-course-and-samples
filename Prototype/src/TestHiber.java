import java.util.List;
import org.hibernate.Session;
import com.example.model.Person;
import com.example.util.HibernateUtil;

public class TestHiber {

	public static void main(String[] args) {
		
		System.out.println(" TEST ");
		
		Session session = HibernateUtil.getSession();
		
		List<Person> people = session.createCriteria(Person.class).list();
		
		for (Person p : people) {
			System.out.println(p.getCod() + " - " + p.getName());
		}
		
		System.out.println(" TEST ");
		
		session.close();

	}

}
