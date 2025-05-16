<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>@Rigoberto Mercado</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/icon/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/citas/buscar-citas.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="container">
      <h2 class="text-center">Buscador de citas</h2>
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
      <form action="${pageContext.request.contextPath}/buscar/citas" method="post">
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <label class="input-group-text" for="select1">Doctores</label>
              </div>
              <select id="select1" class="form-select" name="doctor.idDoctor">
                <option value="0">Seleccionar</option>
                <c:forEach items="${lstDoctores}" var="doctor">
                  <option value="${doctor.idDoctor}" ${vo.doctor.idDoctor == doctor.idDoctor ? 'selected' :''}>${doctor.nombre} ${doctor.apellidoPaterno} ${doctor.apellidoMaterno} - ${doctor.especialidad}</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="col-sm-6 mb-3 mb-sm-0">
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <label class="input-group-text" for="select2">Consultorios</label>
              </div>
              <select id="select2" class="form-select" name="consultorio.idConsultorio">
                <option value="0">Seleccionar</option>
                <c:forEach items="${lstConsultorios}" var="consultorio">
                  <option value="${consultorio.idConsultorio}" ${vo.consultorio.idConsultorio == consultorio.idConsultorio ? 'selected' :''}>${consultorio.numeroConsultorio} - ${consultorio.piso}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="exampleInputName1" class="form-label">Nombre del paciente : </label> 
            <input type="text" class="form-control"	id="exampleInputName1" name="nombrePaciente" value="${vo.nombrePaciente}">
          </div>
          <div class="col-sm-6 mb-3 mb-sm-0">
            <label for="datePicker" class="form-label">Fecha : </label>                
            <div class="input-group">
              <span class="input-group-text" id="span-calendar">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-plus" viewBox="0 0 16 16">
                  <path d="M8 7a.5.5 0 0 1 .5.5V9H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V10H6a.5.5 0 0 1 0-1h1.5V7.5A.5.5 0 0 1 8 7"/>
                  <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4z"/>
                </svg>
              </span>
              <input type="text" id="idCalendario" name="horarioConsulta" class="form-control input-sm text-center" aria-describedby="span-calendar" value="${vo.horarioConsulta}" readonly>
            </div>
          </div>
        </div>
        <c:if test="${not empty lstCitas}">
          <hr/>
          <table class="table">
            <thead>
              <tr>
                <th scope="col" class="text-center">Doctor</th>
                <th scope="col" class="text-center">Especialidad</th>
                <th scope="col" class="text-center">Horario consulta</th>
                <th scope="col" class="text-center">Consultorio</th>
                <th scope="col" class="text-center">Piso</th>
                <th scope="col" class="text-center">Paciente</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${lstCitas}" var="cita">
                <tr>
                  <th scope="row" class="text-center">${cita.doctor.nombre} ${cita.doctor.apellidoPaterno} ${cita.doctor.apellidoMaterno}</th>
              	  <td class="text-center">${cita.doctor.especialidad}</td>
              	  <td class="text-center">${cita.horarioConsulta}</td>
              	  <td class="text-center">${cita.consultorio.numeroConsultorio}</td>
              	  <td class="text-center">${cita.consultorio.piso}</td>
              	  <td class="text-center">${cita.nombrePaciente}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:if>
        <hr/>
        <button type="submit" class="btn btn-primary">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
          </svg>
          Buscar citas
        </button>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/citas">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"/>
          </svg>
          Citas
        </a>
      </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/citas/buscar-citas.js"></script>
  </body>
</html>