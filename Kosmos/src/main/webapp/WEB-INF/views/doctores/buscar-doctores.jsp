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
    <link href="${pageContext.request.contextPath}/resources/css/doctores/buscar-doctores.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="container">
      <h2 class="text-center">Buscador de doctores</h2>
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
      <form action="${pageContext.request.contextPath}/buscarDoctores" method="post">
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
            <select id="select1" class="form-select" name="especialidad">
              <option value="MEDICINA INTERNA">MEDICINA INTERNA</option>
              <option value="PEDIATRIA">PEDIATR&Iacute;A</option>
              <option value="GINECOLOGIA Y OBSTETRICIA">GINECOLOG&Iacute;A Y OBSTETRICIA</option>
              <option value="CIRUGIA">CIRUG&Iacute;A</option>
              <option value="PSIQUIATRIA">PSIQUIATR&Iacute;A</option>
              <option value="CARDIOLOGIA">CARDI&Oacute;LOGIA</option>
              <option value="DERMATOLOGIA">DERMATOLOG&Iacute;A</option>
              <option value="GASTROENTEROLOGIA">GASTROENTEROLOG&Iacute;A</option>
              <option value="NEUROLOGIA">NEUROLOG&Iacute;A</option>
              <option value="ONCOLOGIA">ONCOLOG&Iacute;A</option>
              <option value="OFTALMOLOGIA">OFTALMOLOG&Iacute;A</option>
              <option value="OTORRINOLARINGOLOGIA">OTORRINOLARINGOLOG&Iacute;A</option>
              <option value="TRAUMATOLOGIA Y ORTOPEDIA">TRAUMATOLOG&Iacute;A Y ORTOPEDIA</option>
              <option value="UROLOGIA">UROLOG&Iacute;A</option>
              <option value="ANESTESIOLOGIA">ANESTESIOLOG&Iacute;A</option>
              <option value="RADIOLOGIA">RADIOLOG&Iacute;A</option>
            </select>
          </div>
        </div>
        <hr/>
        <button type="submit" class="btn btn-primary">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
          </svg>
          Buscar doctor
        </button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/doctores">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
          </svg>
          Doctores
        </a>
      </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
  </body>
</html>