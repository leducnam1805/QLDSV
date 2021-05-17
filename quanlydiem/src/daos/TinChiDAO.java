package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.tinchi;
import utils.DBConnectionUtils;

public class TinChiDAO extends AbstractDAO{

	public List<tinchi> findAll() {
		con = DBConnectionUtils.getConnection();
		List<tinchi> tinchiList = new ArrayList<tinchi>();
		String sql = "select * from tinchi";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				tinchi objTC = new tinchi(rs.getString("maTC"), rs.getInt("soTC"));
				tinchiList.add(objTC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tinchiList;
	}

	public int add(tinchi objTC) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO tinchi(maTC,soTC) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objTC.getMaTC());
			pst.setInt(2, objTC.getSoTC());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
