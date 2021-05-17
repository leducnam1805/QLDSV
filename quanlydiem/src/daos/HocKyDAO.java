package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.hocky;
import utils.DBConnectionUtils;

public class HocKyDAO extends AbstractDAO{

	public List<hocky> findAll() {
		con = DBConnectionUtils.getConnection();
		List<hocky> hockyList = new ArrayList<hocky>();
		String sql = "select hk.maHK as hkMa, hk.tenHK as hkTen  from hocky as hk";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				hocky objHK = new hocky(rs.getString("hkMa"), rs.getString("hkTen"));
				hockyList.add(objHK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hockyList;
	}

	public int add(hocky objHK) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO hocky(maHK,tenHK) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objHK.getMaHK());
			pst.setString(2, objHK.getTenHK());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
}
