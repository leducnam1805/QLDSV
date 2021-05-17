package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.roles;
import utils.DBConnectionUtils;

public class RolesDAO extends AbstractDAO{

	public List<roles> findAll() {
		con = DBConnectionUtils.getConnection();
		List<roles> rolesList = new ArrayList<roles>();
		String sql = "select r.id as rid, r.role as rRole  from roles as r";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				roles objR = new roles(rs.getInt("rid"), rs.getString("rRole"));
				rolesList.add(objR);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rolesList;
	}

	public int add(roles objR) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO roles(role) VALUE(?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objR.getRole());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
