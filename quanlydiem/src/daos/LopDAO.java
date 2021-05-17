package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Khoa;
import models.Lop;
import utils.DBConnectionUtils;

public class LopDAO extends AbstractDAO{

	public List<Lop> findAll() {
		con = DBConnectionUtils.getConnection();
		List<Lop> lopList = new ArrayList<Lop>();
		String sql = "SELECT"
				+ " l.maLop as lMa,"
				+ " l.tenLop as lTen,"
				+ " l.maKH as lMaKH,"
				+ " k.tenKH as kTen,"
				+ " k.lienheKH as kLH"
				+ " FROM lop as l"
				+ " INNER JOIN khoa as k ON k.maKH = l.maKH";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Lop objLop = new Lop(rs.getInt("lMa"), rs.getString("lTen"),
						new Khoa(rs.getString("lMaKH"),
								rs.getString("kTen"),
								rs.getString("kLH")));
				lopList.add(objLop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lopList;
	}

	public int add(Lop objL) {
		con = DBConnectionUtils.getConnection();
		int result = 0;
		String sql = "INSERT INTO lop(tenLop,maKH) VALUE(?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objL.getTenLop());
			pst.setString(2, objL.getKhoa().getMaKH());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
}
