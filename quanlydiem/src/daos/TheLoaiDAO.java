package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.theloai;
import utils.DBConnectionUtils;

public class TheLoaiDAO extends AbstractDAO{

	public List<theloai> findAll() {
		con = DBConnectionUtils.getConnection();
		List<theloai> theloaiList = new ArrayList<theloai>();
		String sql = "select * from theloai";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				theloai objTL = new theloai(rs.getString("maTL"), rs.getString("tenTL"));
				theloaiList.add(objTL);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theloaiList;
	}

	public int add(theloai objTL) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO theloai(maTL,tenTL) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objTL.getMaTL());
			pst.setString(2, objTL.getTenTL());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
