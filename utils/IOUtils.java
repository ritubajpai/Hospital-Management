package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.core.Doctor;

public class IOUtils {

	public static void storeDoctorDetails(String file,Map<String,Doctor> docMap) throws IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(docMap);
			System.out.println("Details stored....");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Doctor> restoreDoctorDetails(String file) {
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
			return (Map<String, Doctor>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
}
