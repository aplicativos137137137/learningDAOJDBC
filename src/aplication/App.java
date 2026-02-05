package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;
import model.DAO.SellerDAO;
import model.DAO.DAOFactory;

public class App {

    public static void main(String[] args) {

        Department obj = new Department(1, "computer");
        System.out.println(obj);

        Seller seller = new Seller(10, "trem", "trem@gmail.com", new Date(), 3000.00, obj);
        System.out.print(seller);

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
    }
}