package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("===============================================");
		System.out.println("===        TEST 1: Seller findById          ===");
		System.out.println("===============================================");
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);

		System.out.println("\n===============================================");
		System.out.println("===      TEST 2: Seller findByDepartment    ===");
		System.out.println("===============================================");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===============================================");
		System.out.println("===         TEST 3: Seller findAll          ===");
		System.out.println("===============================================");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===============================================");
		System.out.println("===         TEST 4: Seller insert           ===");
		System.out.println("===============================================");
		Seller newSeller = new Seller(null, "Saul", "saul@gmail.com", new Date(), 3000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n===============================================");
		System.out.println("===         TEST 5: Seller update           ===");
		System.out.println("===============================================");
		seller = sellerDao.findById(1);
		seller.setName("Ozzy Osbourne");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println("\n===============================================");
		System.out.println("===       TEST 6: Seller deleteById         ===");
		System.out.println("===============================================");
		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Complete!");

		sc.close();
	}

}
