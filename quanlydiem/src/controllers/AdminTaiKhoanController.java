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
import daos.TaiKhoanDAO;
import models.roles;
import models.taikhoan;

public class AdminTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminTaiKhoanController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
		List<taikhoan> taiKhoanList = taiKhoanDAO.findAll();
		request.setAttribute("taiKhoanList", taiKhoanList);
		
		RolesDAO rolesDAO = new RolesDAO();
		List<roles> rolesList = rolesDAO.findAll();
		request.setAttribute("rolesList", rolesList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/taikhoan.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
		
		String username = request.getParameter("username");
		
		String matkhau = request.getParameter("matkhau");
		
		String email = request.getParameter("email");
		
		int role = 0;
		
		try {
			role = Integer.parseInt(request.getParameter("role"));
		} catch (NumberFormatException e) {
			System.out.println("Lỗi ... !");
		}
		
		taikhoan objTK = new taikhoan(0, username, matkhau, email, new roles(role, null));
		int add = taiKhoanDAO.add(objTK);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/taikhoan?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/taikhoan?msg=ERROR");
			return;
		}
		
	}


}
