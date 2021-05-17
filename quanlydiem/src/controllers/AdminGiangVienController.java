package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.GiangVienDAO;
import models.giangvien;

public class AdminGiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminGiangVienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		GiangVienDAO giangvienDAO = new GiangVienDAO();
		List<giangvien> giangvienList = giangvienDAO.findAll();
		request.setAttribute("giangvienList", giangvienList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/giangvien.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		GiangVienDAO giangvienDAO = new GiangVienDAO();
		
		String magv = request.getParameter("magv");
		String tengv = request.getParameter("tengv");
		String diachi = request.getParameter("diachi");
		int sdt = 0;
		try {
			sdt = Integer.parseInt(request.getParameter("sdt"));
		} catch (NumberFormatException e) {
			System.out.println("Lỗi..!");
		}
		String email = request.getParameter("email");

		giangvien objGV = new giangvien(magv, tengv, diachi, sdt, email);
		int add = giangvienDAO.add(objGV);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/giangvien?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/giangvien?msg=ERROR");
			return;
		}
		
	}

}
