package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Department;
import model.entities.Seller;
import model.DAO.SellerDAO;
import model.DAO.DAOFactory;

public class App {

    public static void main(String[] args) {

        Scanner dado = new Scanner(System.in);

        Department obj = new Department(1, "computer");
        System.out.println(obj);

        Seller seller = new Seller(10, "trem", "trem@gmail.com", new Date(), 3000.00, obj);
        System.out.println(seller);

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();

        Seller Anotherseller = sellerDAO.findById(3);
        System.out.println(Anotherseller);

        Department department = new Department(2, null);

        List<Seller> list = sellerDAO.findByDepartment(department);
        for(Seller sellerFound : list) {
            System.out.println(sellerFound);
        }

        List<Seller> listFindAll = sellerDAO.findAll();
        for(Seller sellerFindAll : listFindAll) {
            System.out.println(sellerFindAll);
        }

        Seller sellerTestandoOInsert = new Seller(null, "tremtestandooinsert", "tremtestandooinsert@gmail.com", new Date(), 3000.0, department);
        sellerDAO.insert(sellerTestandoOInsert);
        System.out.println("Inserted, new ID = " + sellerTestandoOInsert.getId());

        Seller SellerTestandoOUpdate = sellerDAO.findById(1);
        SellerTestandoOUpdate.setBaseSalary(1500.00);
        sellerDAO.update(SellerTestandoOUpdate);
        System.out.println("update completed");
 
        System.out.println("enter id for the delete test");
        int id = dado.nextInt();
        sellerDAO.deleteById(id);
        System.out.print("delete completed");

        dado.close();

    }
}