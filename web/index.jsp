<%-- 
    Document   : index.jsp
    Created on : 27-ago-2020, 17:51:57
    Author     : Tito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<style type="text/css">
            #examen{
                    position: relative;
                    top: 0;
                    bottom: 0;
                    left:0;
                    right:0;
                    margin: auto;
                    width: 800px;
                    min-height: 700px;
                    border-radius: 2rem;
                    background-color: #ececec;
                    padding: 50px;
            }
            .center{
                    text-align: center;
            }
            .w100{
                    width: 100%;
                    display:inline-block;
                    float:left;
            }
            .respuesta{
                    background-color: white;
                    margin: 15px 0;

            }

	</style>
</head>
<body>
    <%
        HttpSession sesion = request.getSession();
    %>
    
	<section id="examen">
            <form action="ServletPrueba" method="POST">
                <input type="hidden" value="tito" name="nombre"/>
            <input type="submit" value="entrar">
        </form>
            <a href="/ServletPrueba">asfawsdasfasd</a>
		<h1 class="center">PARTE 1 EXAMEN FINAL</h1>
<!-- inicio pregunta 1 -->
                <form id="form1" class="row" action="ServletPreguntas" method="POST">
			<p class="pregunta">1.¿Muestre el nombre y el apellido de los productores de una región determinada que han tenido una producción superior a una cantidad determinada de botellas?</p>		
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" class="form-control" id="region1" name="region1" placeholder="Ingrese Región">
				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<input type="text" class="form-control" id="cantidad1" name="cantidad1" placeholder="Cant">
				</div>
			</div>
			<div class="col-md-4">
                            <input type='submit' id="accion1" name='Respuesta1' value='Respuesta1' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta1">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Región</th>
						<th scope="col">Cantidad</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>---</td>
						<td>---</td>
						<td>---</td>
						<td>---</td>
					</tr>
				</tbody>
			</table>
		</div>
<!-- inicio pregunta 2 -->
		<form  id="form2" class="row">
			<p class="pregunta">2.Cuál esel número de identificación de los vinos que tienen un grado superior a uno determinadoo que han sido producidos por el productor determinado</p>
			<div class="col-md-3">
				<div class="form-group">
					<input type="text" class="form-control" id="grado2" name="grado2" placeholder="Grado">
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<input type="text" class="form-control" id="productor2" name="productor2" placeholder="Productor">
				</div>
			</div>
			<div class="col-md-4">
                            <input type='submit' id='accion2' name='Respuesta2' value='Respuesta2' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta2">
			<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">n°identificacion</th>
                                    <th scope="col">Productor</th>
                                </tr>	
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>---</td>
                                    <td>---</td>
                                </tr>
                            </tbody>
			</table>
		</div>
<!-- inicio pregunta 3 -->
		<form id="form3"  class="row">
			<p class="pregunta">3.Hallar el número, nombre y apellido de los productores que no han producido vinos.</p>
			<div class="col-md-4">
                            <input type='submit' id='accion3' name='Respuesta3' value='Respuesta3' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta3">

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Numero</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>---</td>
						<td>---</td>
						<td>---</td>
					</tr>
				</tbody>
			</table>

		</div>
<!-- inicio pregunta 4 -->
		<form id="form4"  class="row">
			<p class="pregunta">4.Hallar el número de identificación del vino que se ha producido en mayor cantidad.</p>
			<div class="col-md-4">
                            <input type='submit' id='accion4' name='Respuesta4' value='Respuesta4' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta4"></div>
<!-- inicio pregunta 5 -->
		<form  id="form5" class="row">
			<p class="pregunta">5.¿Cuáles es el nombre y su apellido de los productores que producen por lo menos N vinos diferentes</p>
			<div class="col-md-5">
				<div class="form-group">
					<input type="text" class="form-control" id="cantidad5" name="cantidad5" placeholder="Cantidad">
				</div>
			</div>
			<div class="col-md-4">
                            <input type='submit' id='accion5' name='Respuesta5' value='Respuesta5' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>---</td>
						<td>---</td>
					</tr>
				</tbody>
			</table>
		</div>
<!-- inicio pregunta 6 -->
		<form  id="form6" class="row">
			<p class="pregunta">6. Un vino  es  significativo  si  en  una  misma producción  la cantidad es superior  a N botellas producidas.</p>
			<p class="pregunta"> Muestre para cada productor el número de vinos significativos.</p>
			<div class="col-md-5">
				<div class="form-group">
					<input type="text" class="form-control" id="cantidad6"  name="cantidad6" placeholder="Cantidad">
				</div>
			</div>
			<div class="col-md-4">
                            <input type='submit' id='accion6' name='Respuesta6' value='Respuesta6' class="btn btn-primary"/>
			</div>
		</form>
		<div  id="form6" class="respuesta" id="respuesta6">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Num.vinos.Signif.</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>10</td>
					</tr>
				</tbody>
			</table>
		</div>
<!-- inicio pregunta 7 -->
		<form  id="form7" class="row">
			<p class="pregunta">7.¿Qué productores producen al menos todos los vinos que son producidos por el productor determinado?</p>
			<div class="col-md-5">
				<div class="form-group">
					<input type="text" class="form-control" id="productor7"  name="productor7" placeholder="Productor">
				</div>
			</div>
			<div class="col-md-4">
                            <input type='submit' id='accion7' name='Respuesta7' value='Respuesta7' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta7">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
					</tr>
				</tbody>
			</table>
		</div>		
<!-- inicio pregunta 8 -->
		<form  id="form8" class="row">
			<p class="pregunta">8.¿Cuáles son productores que no tienen nombre y que no tengan producción alguna?</p>
			<div class="col-md-4">
                            <input type='submit' id='accion8' name='Respuesta8' value='Respuesta8' class="btn btn-primary"/>
			</div>
		</form>
		<div class="respuesta" id="respuesta8">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
					</tr>
				</tbody>
			</table>
		</div>	
	</section>

    <footer>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script type='text/javascript'>
    
    $(document).ready(function () {
        //pregunta1
        $('#form1').validate({
            rules: {
                region1: {required: true},
                cantidad1: {required: true, number: true}
            },
            messages: {
                region1: 'Este Campo es Obligatorio',
                cantidad1: {required:'Este Campo es Obligatorio',number:'Solo Numeros'}
            },
            submitHandler: function (form) {
                 
                if(confirm('Are you sure?')) { 
                    var accion1 = $('#accion1').val();
                    var region1 =  $('#region1').val();
                    var cantidad1 = $('#cantidad1').val();
                    
                    alert(accion1+" - "+region1+" + "+cantidad1);
                 //form.submit(); 
                    $.ajax({
                       type: 'POST',
                       url: 'ServletPreguntas',
                       dataType: 'json',
                       data:
                           {
                               accion: accion1,
                               region: region1,
                               cantidad: cantidad1
                           },
                       success: function (response) {
                           if(response.mensaje!==""){
                               $('#respuesta1').load(response.mensaje);
                           }else{
                               alert("no carga la respuesta1");
                           }
                       }
                   });
                } 
                
            }
        });
        //pregunta2
        
        $('#form2').validate({
            rules: {
                productor2: {required: true},
                grado2: {required: true, number: true}
            },
            messages: {
                productor2: 'Este Campo es Obligatorio',
                grado2: {required:'Este Campo es Obligatorio',number:'Solo Numeros'}
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion2').val(),
                            grado: $('#grado2').val(),
                            productor: $('#productor2').val()
                        },
                    success: function (response) {
                        $('#respuesta2').load(response.mensaje);
                    }
                });
            }
        });
        //pregunta3
        
        $('#form3').validate({
            rules: {
            },
            messages: {
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion3').val()
                        },
                    success: function (response) {
                        if(response.mensaje){
                            $('#respuesta3').load(response.mensaje);
                        }else{
                            alert("no carga el servlet");
                        }
                    }
                });
            }
        });
        //pregunta4
        
        $('#form4').validate({
            rules: {
            },
            messages: {
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion4').val()
                        },
                    success: function (response) {
                        $('#respuesta4').load(response.mensaje);
                    }
                });
            }
        });
        //pregunta 5
        
        $('#form5').validate({
            rules: {
                cantidad5: {required: true, number: true}
            },
            messages: {
                cantidad5: {required:'Este Campo es Obligatorio',number:'Solo Numeros'}
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion5').val(),
                            cantidad: $('#cantidad5').val()
                        },
                    success: function (response) {
                        $('#respuesta5').load(response.mensaje);
                    }
                });
            }
        });
        //pregunta 6
        
        $('#form6').validate({
            rules: {
                cantidad6: {required: true, number: true}
            },
            messages: {
                cantidad6: {required:'Este Campo es Obligatorio',number:'Solo Numeros'}
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion6').val(),
                            cantidad: $('#cantidad6').val()
                        },
                    success: function (response) {
                        $('#respuesta6').load(response.mensaje);
                    }
                });
            }
        });
        //pregunta 7
        
        $('#form7').validate({
            rules: {
                productor7: {required: true}
            },
            messages: {
                productor7: 'Este Campo es Obligatorio'
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion').val(),
                            productor7: $('#productor7').val()
                        },
                    success: function (response) {
                        $('#respuesta7').load(response.mensaje);
                    }
                });
            }
        });
        //pregunta 8
        
        $('#form8').validate({
            rules: {
            },
            messages: {
            },
            submitHandler: function (form) {
                $.ajax({
                    type: 'POST',
                    url: 'ServletPreguntas',
                    dataType: 'json',
                    data:
                        {
                            accion: $('#accion8').val()
                        },
                    success: function (response) {
                        $('#respuesta8').load(response.mensaje);
                    }
                });
            }
        });
    });
</script>
        </footer>
</body>
</html>