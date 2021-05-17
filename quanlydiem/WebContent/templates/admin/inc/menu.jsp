<%@page import="models.taikhoan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
   <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="<%=request.getContextPath() %>/templates/admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Quản lý điểm sinh viên</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<%=request.getContextPath() %>/templates/admin/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <%
			if(session.getAttribute("userInfor") != null){
				taikhoan objTK = (taikhoan) session.getAttribute("userInfor");
				%>
				<div class="info">
		          <a href="#" class="d-block"><%=objTK.getUsername() %></a>
		        </div>
				<%
			}
        %>
      </div>

      <!-- SidebarSearch Form -->
      <!-- <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div> -->

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="<%=request.getContextPath()%>/admin/inScore" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Nhập điểm
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<%=request.getContextPath()%>/admin/sinhvien" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Sinh Viên
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<%=request.getContextPath()%>/admin/giangvien" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Giảng Viên
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Thông tin chung
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right">2</span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/hocky" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Học Kỳ</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/namhoc" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Năm học</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/nienkhoa" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Niên Khóa</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>
                Thông Tin Môn Học
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/monhoc" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Môn Học</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/theloai" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Thể Loại</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/tinchi" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Tín Chỉ</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-tree"></i>
              <p>
                Khoa Chuyên Môn
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/khoa" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Khoa</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/lop" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Lớp</p>
                </a>
              </li>
            </ul>
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Người dùng
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/taikhoan" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Tài khoản</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="<%=request.getContextPath()%>/admin/role" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Loại tài khoản</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>