package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Khoa;
import utils.DBConnectionUtils;

public class KhoaDAO extends AbstractDAO{

	public List<Khoa> findAll() {
		con = DBConnectionUtils.getConnection();
		List<Khoa> khoaList = new ArrayList<Khoa>();
		String sql = "SELECT k.maKH as kMa, k.tenKH as kTen, lienheKH as kLH FROM khoa as k";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Khoa objK = new Khoa(rs.getString("kMa"), rs.getString("kTen"), rs.getString("kLH"));
				khoaList.add(objK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return khoaList;
	}

	public int add(Khoa objK) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO khoa(maKH,tenKH,lienheKH) VALUE(?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objK.getMaKH());
			pst.setString(2, objK.getTenKH());
			pst.setString(3, objK.getLienheKH());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
