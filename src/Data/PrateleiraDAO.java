package Data;

import Business.Armazem.Palete;
import Business.Armazem.Prateleira;
import Business.Gestor.Gestor;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PrateleiraDAO {

    public Prateleira get(Object key) {
        Prateleira p = null;
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM Prateleira WHERE prateleiraID='"+key+"'")) {
            if (rs.next()) {
                p = new Prateleira(rs.getInt("prateleiraID"),
                        rs.getInt("capacidade"),
                        rs.getInt("ocupacao"));
            } else {
                p = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    public void updatePrateleira(Prateleira p) {
        Gestor res = null;
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
             Statement stm = conn.createStatement()) {

            stm.executeUpdate("INSERT INTO Prateleira VALUES ("+p.getPrateleiraID()+","+p.getCapacidade()+","+
                    p.getOcupacao()+")" +
                    "ON DUPLICATE KEY UPDATE Capacidade=Values(Capacidade),Ocupacao=Values(Ocupacao)");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public int escolhePrateleira() {
        int p = 0;
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL+DAOconfig.CREDENTIALS);
             Statement stm = conn.createStatement()) {

            ResultSet rs = stm.executeQuery("SELECT * FROM Prateleira WHERE Ocupacao < 5");

            if(rs.next())
                p = rs.getInt("prateleiraID");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }
}