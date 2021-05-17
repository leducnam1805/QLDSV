package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.namhoc;
import utils.DBConnectionUtils;

public class NamHocDAO extends AbstractDAO {

	public List<namhoc> findAll() {
		con = DBConnectionUtils.getConnection();
		List<namhoc> namhocList = new ArrayList<namhoc>();
		String sql = "select nh.maNh as nhMa, nh.tenNh as nhTen  from namhoc as nh";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				namhoc objNH = new namhoc(rs.getString("nhMa"), rs.getString("nhTen"));
				namhocList.add(objNH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return namhocList;
	}

	public int add(namhoc objNH) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO namhoc(maNH,tenNH) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objNH.getMaNH());
			pst.setString(2, objNH.getTenNH());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
}
