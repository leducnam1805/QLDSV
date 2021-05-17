package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.TinChiDAO;
import models.tinchi;

public class AdminTinChiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminTinChiController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		TinChiDAO tinChiDAO = new TinChiDAO();
		List<tinchi> tinchiList = tinChiDAO.findAll();
		request.setAttribute("tinchiList", tinchiList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/tinchi.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		TinChiDAO tinChiDAO = new TinChiDAO();
		
		String maTC = request.getParameter("maTC");
		
		int soTC = 0;
		try {
			soTC = Integer.parseInt(request.getParameter("soTC"));
		} catch (NumberFormatException e) {
			System.out.println("Lỗi ..!");
		}
		
		tinchi objTC = new tinchi(maTC, soTC);
		int add = tinChiDAO.add(objTC);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/tinchi?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/tinchi?msg=ERROR");
			return;
		}
		
	}

}
