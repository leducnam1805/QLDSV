package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.NienKhoaDAO;
import models.NienKhoa;

public class AdminNienKhoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminNienKhoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		NienKhoaDAO nienKhoaDAO = new NienKhoaDAO();
		List<NienKhoa> nienKhoaList = nienKhoaDAO.findAll();
		request.setAttribute("nienKhoaList", nienKhoaList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nienkhoa.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		NienKhoaDAO nienKhoaDAO = new NienKhoaDAO();
		
		String maNK = request.getParameter("maNK");
		String tenNK = request.getParameter("tenNK");
		
		NienKhoa objNK = new NienKhoa(maNK, tenNK);
		int add = nienKhoaDAO.add(objNK);
		if(add > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/nienkhoa?msg=OK");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/nienkhoa?msg=ERROR");
			return;
		}
		
	}


}
