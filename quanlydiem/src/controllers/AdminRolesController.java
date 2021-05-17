package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.RolesDAO;
import models.roles;

public class AdminRolesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRolesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		RolesDAO rolesDAO = new RolesDAO();
		List<roles> rolesList = rolesDAO.findAll();
		request.setAttribute("rolesList", rolesList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/roles.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		RolesDAO rolesDAO = new RolesDAO();
		
		String role = request.getParameter("role");
		
		roles objR = new roles(0, role);
		int add = rolesDAO.add(objR);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/role?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/role?msg=ERROR");
			return;
		}
		
	}


}
