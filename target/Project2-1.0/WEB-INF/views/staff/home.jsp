<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Danh sách</title>
</head>

<body>
<div class="main-content">
  <form action="#" id="formSubmit" method="get">
    <div class="main-content-inner">
      <div class="breadcrumbs ace-save-state" id="breadcrumbs">
        <ul class="breadcrumb">
          <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="<c:url value='/quan-tri/trang-chu'/>">Trang chủ</a>
          </li>
        </ul>
        <!-- /.breadcrumb -->
      </div>
      <div class="page-content">
        <div class="row">
          <div class="col-xs-12">
            <div class="widget-box table-filter">
              <div class="table-btn-controls">
                <div class="pull-right tableTools-container">

                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <div class="table-responsive">
                  <table class="table table-bordered" style="text-align:center; font-size:16px">
                    <thead>
                    <tr>
                      <th>Tên mặt hàng</th>
                      <th>Đơn vị</th>
                      <th>Số lượng</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${model.listResult}">
                      <tr>
                        <td>${item.displayName}</td>
                        <td>${item.unitName}</td>
                        <td>${item.count}</td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                  <ul class="pagination" id="pagination"></ul>
                  <input type="hidden" value="" id="page" name="page"/>
                  <input type="hidden" value="" id="limit" name="limit"/>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>
<!-- /.main-content -->
</body>
</html>