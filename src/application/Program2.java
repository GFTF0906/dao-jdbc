package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("============================");
		System.out.println("=== TEST 1: findById =======");
		System.out.println("============================");
		
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n============================");
		System.out.println("=== TEST 2: findAll =======");
		System.out.println("============================");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n============================");
		System.out.println("=== TEST 3: insert =======");
		System.out.println("============================");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n============================");
		System.out.println("=== TEST 4: update =======");
		System.out.println("============================");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n============================");
		System.out.println("=== TEST 5: delete =======");
		System.out.println("============================");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
}