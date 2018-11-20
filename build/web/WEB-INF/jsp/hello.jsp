<%@ include file="/WEB-INF/jsp/include.jsp" %> 

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
      <div style="float:left">
    <h1><fmt:message key="heading"/></h1>
    <h3>Notes</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.name}"/> <i><c:out value="${prod.description}"/></i><br><br>
    </c:forEach>
      </div>
    <div style="float: right">
        <form action="" method="post">
        <input type="text" name="Name" value="" maxlength="255">
        <input type="hidden" name="Command" value="search">
        <input type="submit" value="Search">
        </form>
        <form action="" method="post">
        <input type="text" name="Name" value="name" maxlength="255">
        <input type="hidden" name="Command" value="delete">
        <input type="submit" value="Delete">
        </form>
        <form action="" method="post">
        <input type="text" name="Name" value="name" maxlength="255">
        <input type="text" name="Description" value="note" maxlength="255">
        <input type="hidden" name="Command" value="add">
        <input type="submit" value="Add">
        </form>
        <form action="" method="post">
        <input type="hidden" name="Command" value="show">
        <input type="submit" value="Show">
        </form>
    </div>
  </body>
</html>