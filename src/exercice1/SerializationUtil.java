package exercice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

	public static void serializeEmployees(String path, List<Employee> data) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			oos.writeObject(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static List<Employee> deserializeEmployees(String path) {
		List<Employee> list = new ArrayList<Employee>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			list = (List<Employee>) ois.readObject();
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
