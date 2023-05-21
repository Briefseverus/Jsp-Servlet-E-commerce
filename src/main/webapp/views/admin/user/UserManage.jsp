<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quan Tri</title>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
    <!-- header -->
    <%@ include file="/common/admin/header.jsp"%>
    <!-- header -->

    <div class="main-container" id="main-container">
        <script type="text/javascript">
            try {
                ace.settings.check('main-container', 'fixed')
            } catch (e) {}
        </script>
        <!-- header -->
        <%@ include file="/common/admin/menu.jsp"%>
        <!-- header -->

        <div class="container mt-5">
            <h1>User List</h1>

            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>User ID</th>
                        <th>Name</th>
                        <th>Full name</th>
                        <th>email</th>
                        <th>Phones</th>
                        <th>activated</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pro" items="${pros}">
                        <c:url var="upload" value="UserManage">
                            <c:param name="action" value="load"></c:param>
                            <c:param name="user_id" value="${pro.getUser_id()}"></c:param>
                        </c:url>
                        <tr>
                            <td>${pro.getUser_id()}</td>
                            <td>${pro.getUsername()}</td>
                            <td>${pro.getFull_name()}</td>
                            <td>${pro.getEmail()}</td>
                            <td>${pro.getPhone_number()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${pro.isActivated()}">
                                        <input type="checkbox" checked="checked" onclick="updateActivationStatus(${pro.getUser_id()}, false)">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" onclick="updateActivationStatus(${pro.getUser_id()}, true)">
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a type="button" class="btn btn-primary btn-sm" href="${upload}">upload</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

<script>
    function updateActivationStatus(userId, activated) {
        $.ajax({
            url: 'UserManage',
            type: 'POST',
            data: {
                action: 'deactivate',
                user_id: userId,
                activated: activated.toString() // Chuyển đổi giá trị thành chuỗi
            },
            success: function(data) {
                alert('Activation status updated successfully');
                location.reload(); // Tải lại trang để cập nhật danh sách người dùng
            },
            error: function() {
                alert('Failed to update activation status');
            }
        });
    }
</script>

    <!-- footer -->
    <%@ include file="/common/admin/footer.jsp"%>
    <!-- footer -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>

    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

    <!-- page specific plugin scripts -->
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>
