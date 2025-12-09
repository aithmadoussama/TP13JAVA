package exercice1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		final String filePath = "employees.ser";

		List<Employee> staff = new ArrayList<>();
		staff.add(new Employee(1, "Youssef", 3000.0, "pwdYoussef"));
		staff.add(new Employee(2, "Fatima", 3500.5, "pwdFatima"));
		staff.add(new Employee(3, "Omar", 2800.75, "pwdOmar"));

		try {
			SerializationUtil.serializeEmployees(filePath, staff);
			System.out.println("→ Sérialisation réussie dans " + filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Employee> loaded = new ArrayList<Employee>();

		try {
			loaded = SerializationUtil.deserializeEmployees(filePath);
			System.out.println("→ Désérialisation réussie, objets restaurés :");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(Employee e : loaded) {
			System.out.println(e);
		}
	}
}
