<%@page import="models.Lop"%>
<%@page import="models.sinhvien"%>
<%@page import="models.theloai"%>
<%@page import="models.tinchi"%>
<%@page import="models.giangvien"%>
<%@page import="models.namhoc"%>
<%@page import="models.hocky"%>
<%@page import="models.monhoc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/templates/admin/inc/header.jsp" %>

  <!-- Main Sidebar Container -->
  <%@include file="/templates/admin/inc/menu.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Môn Học</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
              <li class="breadcrumb-item active">Môn Học</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      <%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("OK".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thành công..!
					</div>
				<%
			}
		}
	%>
	<%
		if(!"".equals(request.getParameter("msg"))){
			String msg = request.getParameter("msg");
			if("ERROR".equals(msg)){
				%>
					<div class="alert alert-success" role="alert">
						 Xử lý thất bại..!
					</div>
				<%
			}
		}
	%>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalThem">Thêm</button>
	<table class="table table-bordered" id="datatable">
	  <thead class="thead-CCFFFF">
	    <tr class="list-header">
	      <th scope="col">#</th>
	      <th scope="col">Mã Môn học</th>
	      <th scope="col">Môn Học</th>
	      <th scope="col">Số Tín Chỉ</th>
	      <th scope="col">Thể Loại</th>
	      <th scope="col">Chức năng</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  if(request.getAttribute("monHocList") != null){
		  List<monhoc> monHocList = (List<monhoc>) request.getAttribute("monHocList");
		  if(monHocList.size() > 0){
			  for(monhoc objMH : monHocList){
				  %>
		<tr class="tr-hover">
	      <th scope="row"><input type="checkbox" name="vehicle1" value="Bike"></th>
	      <td><%=objMH.getMaMH() %></td>
	      <td><%=objMH.getTenMH() %></td>
	      <td><%=objMH.getTinchi().getSoTC() %></td>
	      <td><%=objMH.getTheloai().getTenTL() %></td>
	     <td>
	    	<%-- <button type="button" class="btn btn-warning suaMenu" data-toggle="modal" data-target="#exampleModalSua">
				<a href="<%=request.getContextPath()%>/admin/menu/edit?id=">Cập nhật</a>
			</button>
	     	<button xoaMenu="" type="button" class="btn btn-danger">Xóa</button> --%>
	     </td>
	    </tr>
				  <%
			  }
		  }
	  }
	  %>
	  </tbody>
	</table>
	
			      	
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    <!-- Modal -->
<div class="modal fade" id="modalThem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm Môn Học</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action ="<%=request.getContextPath()%>/admin/monhoc" method="post">
        	<div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Mã Môn Học</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="maMH">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Môn Học</label>
			    <input type="text" class="form-control-file col-sm-8" id="exampleFormControlFile1" name="tenMH">
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Số Tín Chỉ</label>
			    <%
			    	if(request.getAttribute("tinchiList") != null){
			    		List<tinchi> tinchiList = (List<tinchi>) request.getAttribute("tinchiList");
			    		if(tinchiList.size() > 0){
			    			%>
			    <select class="form-control" id="exampleFormControlSelect1" name="maTC">
			    <%
			    	for(tinchi objTC : tinchiList){
			    		%>
			    	<option value="<%=objTC.getMaTC()%>"><%=objTC.getSoTC()%></option>
			    		<%
			    	}
			    %>
			    </select>
			    			<%
			    		}
			    	}
			    %>
			  </div>
			  <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-3">Thể Loại</label>
			    <%
			    	if(request.getAttribute("theloaiList") != null){
			    		List<theloai> theloaiList = (List<theloai>) request.getAttribute("theloaiList");
			    		if(theloaiList.size() > 0){
			    			%>
			    <select class="form-control" id="exampleFormControlSelect1" name="maTL">
			    <%
			    	for(theloai objTL : theloaiList){
			    		%>
			    	<option value="<%=objTL.getMaTL()%>"><%=objTL.getTenTL()%></option>
			    		<%
			    	}
			    %>
			    </select>
			    			<%
			    		}
			    	}
			    %>
			  </div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Thoát</button>
		        <button type="submit" class="btn btn-primary">Thêm</button>
		      </div>        
        </form>
      </div>
    </div>
  </div>
</div>
  </div>
 <script type="text/javascript">
  $(document).ready(function(){
	  $("form").submit(function(event){
		  event.preventDefault();
		  var formData = new FormData(this);
		  $.ajax({
			  url:"input",
			  type: "post",
			  data: formData,
			  success: function(data){
				  var row = data;
				  for(i = 0;i < row.length;i++){
					  var column = row[i];
					  var eachrow = "<tr>";
					  for(j = 0; j < column.lenght;j++){
						  eachrow = eachrow+"<td>" + column[j]+ "</td>";
					  }
					  eachrow = eachrow + "</td>";
					  $('#tbody').append(eachrow);
				  }
			  },
			  cache:false,
			  contentType: false,
			  processData: false
		  })
	  })
  }
</script>
  <!-- /.content-wrapper -->
  <%@include file="/templates/admin/inc/footer.jsp" %>

    