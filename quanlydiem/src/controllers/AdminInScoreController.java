package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constans.GlobalConstans;
import daos.DiemDAO;
import daos.GiangVienDAO;
import daos.HocKyDAO;
import daos.MonHocDAO;
import daos.NamHocDAO;
import daos.TheLoaiDAO;
import daos.TinChiDAO;
import models.Khoa;
import models.Lop;
import models.diem;
import models.giangvien;
import models.hocky;
import models.monhoc;
import models.namhoc;
import models.sinhvien;
import models.theloai;
import models.tinchi;

@MultipartConfig
public class AdminInScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int COLUMN_INDEX_MASV = 0;
	 public static final int COLUMN_INDEX_HOTEN = 1;
	 public static final int COLUMN_INDEX_HS1 = 2;
	 public static final int COLUMN_INDEX_HS3 = 3;
	 public static final int COLUMN_INDEX_DIEMTHI = 4;
	 public static final int COLUMN_INDEX_DIEMHP = 5;
	 public static final int COLUMN_INDEX_LOP = 6;
	
	public AdminInScoreController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		MonHocDAO monHocDAO = new MonHocDAO();
		List<monhoc> monhocList = monHocDAO.findAll();
		request.setAttribute("monhocList", monhocList);
		
		HocKyDAO hockyDAO = new HocKyDAO();
		List<hocky> hockyList = hockyDAO.findAll();
		request.setAttribute("hockyList", hockyList);
		
		NamHocDAO namhocDAO = new NamHocDAO();
		List<namhoc> namhocList = namhocDAO.findAll();
		request.setAttribute("namhocList", namhocList);
		
		GiangVienDAO giangvienDAO = new GiangVienDAO();
		List<giangvien> giangvienList = giangvienDAO.findAll();
		request.setAttribute("giangvienList", giangvienList);
		
		TinChiDAO tinchiDAO = new TinChiDAO();
		List<tinchi> tinchiList = tinchiDAO.findAll();
		request.setAttribute("tinchiList", tinchiList);
		
		TheLoaiDAO theloaiDAO = new TheLoaiDAO();
		List<theloai> theloaiList = theloaiDAO.findAll();
		request.setAttribute("theloaiList", theloaiList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/inScore.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		DiemDAO diemDAO = new DiemDAO();
		
		String maMonHoc = request.getParameter("maMonHoc");
		String maHocKy = request.getParameter("maHocKy");
		String maNamhoc = request.getParameter("maNamhoc");
		String maGiangVien = request.getParameter("maGiangVien");
		String maTinChi = request.getParameter("maTinChi");
		String maTheLoai = request.getParameter("maTheLoai");
		
		String filePath = null;
		Part part = request.getPart("fileExcel");
		String fileName = part.getSubmittedFileName();
		if(!"".equals(fileName)) {
			// lấy đường dẫn thực của dự án
			String dirPath = request.getServletContext().getRealPath("")+ GlobalConstans.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if(!saveDir.exists()) {
				saveDir.mkdirs();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		List<diem> filexExx = readExcel(filePath);
		for(diem diem : filexExx) {
			if(diem.getSinhvien() == null) {
				System.out.println(" lôiz null");
				break;
			}
			diem.setGiangvien(new giangvien(maGiangVien, null, null, 0, null));
			diem.setMonhoc(new monhoc(maMonHoc, null, 
					new tinchi(null, 0), new theloai(null, null)));
			diem.setTinchi(new tinchi(maTinChi, 0));
			diem.setTheloai(new theloai(maTheLoai, null));
			diem.setHocky(new hocky(maHocKy, null));
			diem.setNamhoc(new namhoc(maNamhoc, null));
			diem objDiem = new diem(0, diem.getHeso1(), diem.getHeso3(), diem.getHeso6(), diem.getTongDiem(),
					new giangvien(maGiangVien, null, null, 0, null),
					new sinhvien(diem.getSinhvien().getMaSV(), null, null, 0, null,
							new Lop(0, null, new Khoa(null, null, null))),
					new monhoc(maMonHoc, null, new tinchi(null, 0),
							new theloai(null, null)),
					new tinchi(maTinChi, 0),
					new theloai(maTheLoai, null),
					new hocky(maHocKy, null),
					new namhoc(maNamhoc, null),
					new Lop(0, null, new Khoa(null, null, null)));
			int add = diemDAO.nhapdiem(objDiem);
			if(add > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/inScore?msg=OK");
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/inScore?msg=ERROR");
			}
		}
		
		
	}
	public static List<diem> readExcel(String excelFilePath) throws IOException {
		List<diem> diemList = new ArrayList<diem>();
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
       //FormulaEvaluator formula = workbook.getCreationHelper().createFormulaEvaluator();
        
        for(Row row : sheet) {
        	int nextRow = row.getRowNum();
        	if (nextRow == 0) {
                continue;
            }
        	diem diem = new diem();
        	for(Cell cell : row) {
        		//org.apache.poi.ss.usermodel.CellType cellType = cell.getCellTypeEnum();
        		Object cellValue = getCellValue(cell);
        		if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
        		int columnIndex = cell.getColumnIndex();
        		switch (columnIndex) {
				case COLUMN_INDEX_MASV:
					int msv = new BigDecimal((double) cellValue).intValue();
					diem.setSinhvien(new sinhvien(msv, null, null, 0, null,
							new Lop(0, null,
									new Khoa(null, null, null))));
					System.out.println("msv: "+msv);
					break;
				case COLUMN_INDEX_HOTEN:
					String hoTen = getCellValue(cell).toString();
//					diem.setSinhvien(new sinhvien(1, hoTen, null, 0, null,
//							new Lop(0, null,
//									new Khoa(null, null, null))));
					System.out.print("hoten: "+hoTen);
					break;
				case COLUMN_INDEX_HS1:
					String hs1 = getCellValue(cell).toString();
					diem.setHeso1(Float.parseFloat(hs1));
					System.out.print(hs1);
					break;
				case COLUMN_INDEX_HS3:
					String hs3 = getCellValue(cell).toString();
					diem.setHeso3(Float.parseFloat(hs3));
					System.out.print(hs3);
					break;
				case COLUMN_INDEX_DIEMTHI:
					String diemThi = getCellValue(cell).toString();
					diem.setHeso6(Float.parseFloat(diemThi));
					System.out.print(diemThi);
					break;
				case COLUMN_INDEX_DIEMHP:
					String diemHP =getCellValue(cell).toString();
					diem.setTongDiem(Float.parseFloat(diemHP));
					System.out.print(diemHP);
					break;
				case COLUMN_INDEX_LOP:
					diem.setLop(new Lop(0, getCellValue(cell).toString(), new Khoa(null, null, null)));
					String lop =getCellValue(cell).toString();
					System.out.print(lop);
					break;
				default:
					break;
				}
        	}
        	System.out.println();
        	diemList.add(diem);
        }
        workbook.close();
        inputStream.close();
 
        return diemList;
    }
 
    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
        	cellValue = cell.getBooleanCellValue();
        	break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
 
}
