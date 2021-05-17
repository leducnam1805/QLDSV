package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.monhoc;
import models.theloai;
import models.tinchi;
import utils.DBConnectionUtils;

public class MonHocDAO extends AbstractDAO{

	public List<monhoc> findAll() {
		con = DBConnectionUtils.getConnection();
		List<monhoc> monhocList = new ArrayList<monhoc>();
		String sql = "SELECT m.maMH as mMH,m.tenMH as mtMH,m.maTC as mTC,m.maTL as mTL,"
				+ " soTC,tenTL FROM monhoc m"
				+ " INNER JOIN tinchi t ON m.maTC = t.maTC"
				+ " INNER JOIN theloai tl ON m.maTL = tl.maTL";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				monhoc objMH = new monhoc(rs.getString("mMH"),
						rs.getString("mtMH"),
						new tinchi(rs.getString("mTC"),
								rs.getInt("soTC")),
						new theloai(rs.getString("mTL"),
								rs.getString("tenTL")));
				monhocList.add(objMH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return monhocList;
	}

	public int add(monhoc objMH) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO monhoc(maMH,tenMH,maTC,maTL) VALUE(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objMH.getMaMH());
			pst.setString(2, objMH.getTenMH());
			pst.setString(3, objMH.getTinchi().getMaTC());
			pst.setString(4, objMH.getTheloai().getMaTL());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
