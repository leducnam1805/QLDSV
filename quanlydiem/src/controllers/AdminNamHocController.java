package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.NamHocDAO;
import models.namhoc;

public class AdminNamHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminNamHocController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		NamHocDAO namHocDAO = new NamHocDAO();
		List<namhoc> namHocList = namHocDAO.findAll();
		request.setAttribute("namHocList", namHocList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/namhoc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		NamHocDAO namHocDAO = new NamHocDAO();
		
		String maNH = request.getParameter("maNH");
		
		String tenNH = request.getParameter("tenNH");
		
		namhoc objNH = new namhoc(maNH, tenNH);
		int add = namHocDAO.add(objNH);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/namhoc?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/namhoc?msg=ERROR");
			return;
		}
		
	}

}
