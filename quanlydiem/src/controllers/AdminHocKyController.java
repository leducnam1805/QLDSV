package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.HocKyDAO;
import models.hocky;

public class AdminHocKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHocKyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		HocKyDAO hoKyDAO = new HocKyDAO();
		List<hocky> hockyList = hoKyDAO.findAll();
		request.setAttribute("hockyList", hockyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/hocky.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HocKyDAO hocKyDAO = new HocKyDAO();
		
		String mahk = request.getParameter("mahk");
		
		String tenhk = request.getParameter("tenhk");
		
		hocky objHK = new hocky(mahk, tenhk);
		int add = hocKyDAO.add(objHK);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/hocky?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/hocky?msg=ERROR");
			return;
		}
		
	}


}
