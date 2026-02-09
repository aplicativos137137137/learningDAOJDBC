package aplication;

import java.util.Date;
import java.util.List;

import model.entities.Department;
import model.entities.Seller;
import model.DAO.SellerDAO;
import model.DAO.DAOFactory;

public class App {

    public static void main(String[] args) {

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
            System.out.print(sellerFound);
        }
    }
}