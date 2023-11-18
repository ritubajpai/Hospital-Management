package utils;

import java.time.LocalDate;
import java.util.Map;
import static tester.DoctorManagement.*;

import com.core.Department;
import com.core.Doctor;

public class DoctorUtils {
	
	public static Map<String,Doctor> populateDoctor(){
		docMap.put("doctor1@abc.com", new Doctor("doctor1", "doctor1@abc.com", "MBBS", LocalDate.parse("2009-08-20"), Department.ORTHO, 32000,8));
		docMap.put("doctor2@abc.com", new Doctor("doctor2", "doctor2@abc.com", "MS", LocalDate.parse("2010-08-09"), Department.GASTROLOGY, 10000,6));
		docMap.put("doctor3@abc.com", new Doctor("doctor3", "doctor3@abc.com", "MBBS", LocalDate.parse("2015-11-20"), Department.ORTHO, 32000,8));
		docMap.put("doctor4@abc.com", new Doctor("doctor4", "doctor4@abc.com", "MBBS", LocalDate.parse("2006-08-22"), Department.PHYSIIOTHEROPY, 25000,5));
		docMap.put("doctor5@abc.com", new Doctor("doctor5", "doctor5@abc.com", "MS", LocalDate.parse("2009-03-20"), Department.PEDIATRICS, 12000,10));
		docMap.put("doctor6@abc.com", new Doctor("doctor6", "doctor6@abc.com", "MBBS", LocalDate.parse("2009-12-23"), Department.ORTHO, 22000,5));
		return docMap;
	}
}
