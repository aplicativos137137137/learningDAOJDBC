package model.DAO;

import model.DAO.impl.SellerDAOJDBC;
import db.DB;
import model.DAO.impl.DepartmentDAOJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDAOJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDAOJDBC(DB.getConnection());
    }
}