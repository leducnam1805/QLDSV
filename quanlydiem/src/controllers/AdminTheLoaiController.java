package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.TheLoaiDAO;
import models.theloai;

public class AdminTheLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminTheLoaiController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		List<theloai> theLoaiList = theLoaiDAO.findAll();
		request.setAttribute("theLoaiList", theLoaiList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/theloai.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		
		String maTL = request.getParameter("maTL");
		
		String tenTL = request.getParameter("tenTL");
		
		theloai objTL = new theloai(maTL, tenTL);
		int add = theLoaiDAO.add(objTL);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/theloai?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/theloai?msg=ERROR");
			return;
		}
		
	}

}
