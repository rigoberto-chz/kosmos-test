<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>@Rigoberto Mercado</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/icon/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/doctores/crear-doctores.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="container">
      <h2 class="text-center">Registrar doctor</h2>
      <c:if test="${not empty error}">
        <div class="col-lg-12 mb-4">
          <div class="card bg-danger text-white shadow">
            <div class="card-body text-center">
              ${error}
            </div>
          </div>
        </div>
      </c:if>
      <c:if test="${not empty message}">
        <div class="col-lg-12 mb-4">
          <div class="card bg-success text-white shadow">
            <div class="card-body text-center">
              ${message}
            </div>
          </div>
        </div>
      </c:if>
      <form action="${pageContext.request.contextPath}/agregarDoctor" method="post" class="needs-validation" novalidate>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="inputText1" class="form-label">Nombre : </label> 
            <input id="inputText1" type="text" class="form-control" name="nombre" placeholder="Nombre del doctor" required>
          </div>
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="inputText2" class="form-label">Apellido paterno : </label> 
            <input id="inputText2" type="text" class="form-control" name="apellidoPaterno" placeholder="Apellido paterno" required>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="inputText3" class="form-label">Apellido materno : </label> 
            <input id="inputText3" type="text" class="form-control" name="apellidoMaterno" placeholder="Apellido materno" required>
          </div>
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="select1" class="form-label">Especialidad : </label>             
            <select id="select1" class="form-select" name="especialidad" required>
              <option selected disabled value="">Seleccionar...</option>
              <option value="MEDICINA INTERNA">MEDICINA INTERNA</option>
              <option value="PEDIATR&Iacute;A">PEDIATR&Iacute;A</option>
              <option value="GINECOLOG&Iacute;A Y OBSTETRICIA">GINECOLOG&Iacute;A Y OBSTETRICIA</option>
              <option value="CIRUG&Iacute;A">CIRUG&Iacute;A</option>
              <option value="PSIQUIATR&Iacute;A">PSIQUIATR&Iacute;A</option>
              <option value="CARDI&Oacute;LOGIA">CARDI&Oacute;LOGIA</option>
              <option value="DERMATOLOG&Iacute;A">DERMATOLOG&Iacute;A</option>
              <option value="GASTROENTEROLOG&Iacute;A">GASTROENTEROLOG&Iacute;A</option>
              <option value="NEUROLOG&Iacute;A">NEUROLOG&Iacute;A</option>
              <option value="ONCOLOG&Iacute;A">ONCOLOG&Iacute;A</option>
              <option value="OFTALMOLOG&Iacute;A">OFTALMOLOG&Iacute;A</option>
              <option value="OTORRINOLARINGOLOG&Iacute;A">OTORRINOLARINGOLOG&Iacute;A</option>
              <option value="TRAUMATOLOG&Iacute;A Y ORTOPEDIA">TRAUMATOLOG&Iacute;A Y ORTOPEDIA</option>
              <option value="UROLOG&Iacute;A">UROLOG&Iacute;A</option>
              <option value="ANESTESIOLOG&Iacute;A">ANESTESIOLOG&Iacute;A</option>
              <option value="RADIOLOG&Iacute;A">RADIOLOG&Iacute;A</option>
            </select>
          </div>
        </div>
        <hr/>
        <button type="submit" class="btn btn-primary">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-add" viewBox="0 0 16 16">
            <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4"/>
            <path d="M8.256 14a4.5 4.5 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10q.39 0 .74.025c.226-.341.496-.65.804-.918Q8.844 9.002 8 9c-5 0-6 3-6 4s1 1 1 1z"/>
          </svg>
          Registrar doctor
        </button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/doctores">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
          </svg>
          Doctores
        </a>
      </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/doctores/crear-doctores.js"></script>
  </body>
</html>