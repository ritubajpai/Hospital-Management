package utils;

import java.time.LocalDate;
import java.util.Map;
import com.core.*;
import com.core.Department;
import com.core.Doctor;

import custom_exceptions.InvalidInputException;

public class HospitalValidations {

	public static LocalDate validateDate(LocalDate joinDate) throws InvalidInputException {
		LocalDate date = LocalDate.of(2001, 10, 01);
		if (joinDate.isBefore(date)) {
			throw new InvalidInputException("Invalid date......");
		} else {
			return joinDate;
		}
	}

	public static String validateEmail(String email) throws InvalidInputException {
		String reg = "[a-zA-z0-9]+@[a-zA-Z]*\\.(com|org|net)";
		if (!(email.matches(reg))) {
			throw new InvalidInputException("Invalid emial formate.....");
		} else {
			return email;
		}
	}

	public static void validateDoctor(String email, String name, Map<String, Doctor> docMap)
			throws InvalidInputException {
		Doctor doctor = docMap.get(email);
		if (doctor != null) {
			if (doctor.getDname().equals(name)) {
				System.out.println("Login successful.....");
			} else {
				throw new InvalidInputException("Name is incorrect.....");
			}
		} else {
			throw new InvalidInputException("Email is not registered....");
		}
	}

	public static Doctor validateAllInputs(String dname, String email, String degree, String joiningDate, String dept,
			double salary, int experience, Map<String, Doctor> docMap) throws InvalidInputException {
		LocalDate validateDate = validateDate(LocalDate.parse(joiningDate));
		String validateEmail = validateEmail(email);
		Department department = Department.valueOf(dept);
		return new Doctor(dname, validateEmail, degree, validateDate, department, salary, experience);

	}
}
