<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/mat-hang/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/mat-hang/chinh-sua"/>
<c:url var="newAPI" value="/api/object"/>
<html>
<head>
    <title>Chỉnh sửa</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
                </li>

                <li><a href="${newURL}?page=1&limit=20">Danh sách</a></li>
                <li class="active">Thêm/sửa</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label for="displayName" class="col-sm-3 control-label no-padding-right">Tên mặt hàng</label>
                            <div class="col-sm-9">
                                <form:input path="displayName" cssClass="col-xs-10 col-sm-5" id="displayName" name="displayName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="unitId" class="col-sm-3 control-label no-padding-right">Tên đơn vị</label>
                            <div class="col-sm-9">
                                <form:select path="unitId" id="unitId">
                                    <form:option value="" label="-- Chọn đơn vị --"/>
                                    <form:options items="${unit}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="suplierId" class="col-sm-3 control-label no-padding-right">Nhà cung cấp</label>
                            <div class="col-sm-9">
                                <form:select path="suplierId" id="suplierId">
                                    <form:option value="" label="-- Chọn đơn vị --"/>
                                    <form:options items="${suplier}"/>
                                </form:select>
                            </div>
                        </div>
                        <form:hidden path="id" id="newId"/>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Thêm
                                    </button>
                                </c:if>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                                <button class="btn" style="background-color: #6fb3e0!important;border-color: #6fb3e0!important ;margin-left:20px ">
                                    <a style="color: #FFFFFF "href="<c:url value='/quan-tri/mat-hang/danh-sach?page=1&limit=20'/>">
                                        Danh sách
                                    </a>
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        console.log(formData);
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#newId').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });

    function addNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${newURL}?page=1&limit=20&message=error_system";
            }
        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>
