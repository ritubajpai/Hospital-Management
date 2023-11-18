package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static utils.DoctorUtils.populateDoctor;
import static utils.HospitalValidations.*;
import static utils.IOUtils.*;
import com.core.Department;
import com.core.Doctor;

public class DoctorManagement {
	public static Map<String, Doctor> docMap = new HashMap<>();

	public static void main(String[] args) {
		docMap = populateDoctor();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			System.out.println("Enter file name: ");
			String file = sc.next();
			while (!exit) {
				try {
					System.out.println("-----------------------------DEPT--------------------------------");
					for (Department d : Department.values()) {
						System.out.println(d);
					}
					System.out.println("---------------------------MENU----------------------------------------");
					System.out.println(
							"1.SignIN\n2.Add Doctor\n3.Display doctor with highest salary\n4.Sort by experiece\n5.Search doctor who are orthopedics\n6.Seriealization\n7.Deserialization\n0.exit");
					System.out.println("-------------------------------------------------------------------");
					System.out.println("Enter your choice: ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the email and name: ");
						validateDoctor(sc.next(), sc.next(), docMap);
						break;

					case 2:
						System.out.println(
								"Enter details: dname, validateEmail, degree, validateDate, department, salary, experience");
						Doctor doctor = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.nextInt(), docMap);
						docMap.putIfAbsent(doctor.getDname(), doctor);
						break;

					case 3:
						Doctor doctor2 = docMap.values().stream()
								.max((d1, d2) -> ((Double) d1.getSalary()).compareTo(d2.getSalary())).orElseThrow();
						System.out.println("Name: " + doctor2.getDname());
						;
						break;

					case 4:
						docMap.values().stream()
								.sorted((d1, d2) -> ((Integer) d1.getExperience()).compareTo(d2.getExperience()))
								.forEach(System.out::println);
						break;

					case 5:
						Department dept = Department.ORTHO;
						docMap.values().stream().filter(d -> d.getDept().equals(dept)).forEach(System.out::println);
						break;

					case 6:
						storeDoctorDetails(file, docMap);
						break;

					case 7:
						System.out.println("Doctor details: ");
						System.out.println(restoreDoctorDetails(file));
						break;

					default:
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}

}
