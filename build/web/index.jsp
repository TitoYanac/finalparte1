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
        <h1 class="center">PARTE 1 EXAMEN FINAL</h1>
<!-- inicio pregunta 1 -->
        <article class="contenido">
            <p class="pregunta">1.¿Muestre el nombre y el apellido de los productores de una región determinada que han tenido una producción superior a una cantidad determinada de botellas?</p>		
            <form id="form1" class="row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" id="region1" name="region1" placeholder="Ingrese Región">
                </div>
                <div class="form-group col-md-2">
                    <input type="text" class="form-control" id="cantidad1" name="cantidad1" placeholder="Cant">
                </div>
                <div class="form-group col-md-4">
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
        </article>
<!-- inicio pregunta 2 -->
        <article class="contenido">
            <p class="pregunta">2.Cuál esel número de identificación de los vinos que tienen un grado superior a uno determinadoo que han sido producidos por el productor determinado</p>
            <form  id="form2" class="row">
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control" id="grado2" name="grado2" placeholder="Grado">
                    </div>
                    <div class="form-group col-md-5">
                        <input type="text" class="form-control" id="productor2" name="productor2" placeholder="Id Productor">
                    </div>
                    <div class="form-group col-md-4">
                        <input type='submit' id='accion2' name='Respuesta2' value='Respuesta2' class="btn btn-primary"/>
                    </div>
            </form>
            <div class="respuesta" id="respuesta2">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">n°identificacion</th>
                                <th scope="col">Nombre</th>
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
        </article>

<!-- inicio pregunta 3 -->
    <article class="contenido">
              <p class="pregunta">3.Hallar el número, nombre y apellido de los productores que no han producido vinos.</p>
            <form id="form3"  class="row">
              <div class="form-group col-md-4">
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
        </article>

<!-- inicio pregunta 4 -->
    <article class="contenido">

        <form id="form4"  class="row">
            <p class="pregunta">4.Hallar el número de identificación del vino que se ha producido en mayor cantidad.</p>
            <div class="col-md-4">
                <input type='submit' id='accion4' name='Respuesta4' value='Respuesta4' class="btn btn-primary"/>
            </div>
        </form>
        <div class="respuesta" id="respuesta4"></div>
    </article>

<!-- inicio pregunta 5 -->
    <article class="contenido">
        <p class="pregunta">5.¿Cuáles es el nombre y su apellido de los productores que producen por lo menos N vinos diferentes</p>
        <form  id="form5" class="row">
          <div class="form-group col-md-5">
              <input type="text" class="form-control" id="cantidad5" name="cantidad5" placeholder="Cantidad de Vinos">
          </div>
          <div class="form-group col-md-4">
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
                <th scope="col">Cantidad</th>
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
    </article>


<!-- inicio pregunta 6 -->
    <article class="contenido">
        <p class="pregunta">6. Un vino  es  significativo  si  en  una  misma producción  la cantidad es superior  a N botellas producidas.</p>
        <p class="pregunta"> Muestre para cada productor el número de vinos significativos.</p>
        
        <form  id="form6" class="row">
            <div class="form-group col-md-5">
                <input type="text" class="form-control" id="cantidad6"  name="cantidad6" placeholder="Cantidad de Botellas">
            </div>
            <div class="form-group col-md-4">
                <input type='submit' id='accion6' name='Respuesta6' value='Respuesta6' class="btn btn-primary"/>
            </div>
        </form>
        
        <div class="respuesta" id="respuesta6">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">N° Identificacion</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Num.vinos.Signif.</th>
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
    </article>

<!-- inicio pregunta 7 -->
    <article class="contenido">
      <p class="pregunta">7.¿Qué productores producen al menos todos los vinos que son producidos por el productor determinado?</p>
        <form  id="form7" class="row">
          <div class="form-group col-md-5">
              <input type="text" class="form-control" id="productor7"  name="productor7" placeholder="IdProductor">
          </div>
          <div class="form-group col-md-4">
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
                <td>---</td>
                <td>---</td>
              </tr>
            </tbody>
          </table>
        </div> 
    </article>


   
<!-- inicio pregunta 8 -->
    <article class="contenido">
      <p class="pregunta">8.¿Cuáles son productores que no tienen nombre y que no tengan producción alguna?</p>
        <form  id="form8" class="row">
          <div class="form-group col-md-4">
                <input type='submit' id='accion8' name='Respuesta8' value='Respuesta8' class="btn btn-primary"/>
          </div>
        </form>
        <div class="respuesta" id="respuesta8">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">N° Identificacion</th>
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
    </article>

    </section>

    <footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                $.ajax({
                    url: "ServletRespuestas",
                    data:{
                        accion: $('#accion1').val(),
                        region: $('#region1').val(),
                        cantidad: $('#cantidad1').val()
                    },
                    success: function(response){
                        $("#respuesta1").html(response);
                    }
                });
                
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion2').val(),
                            grado: $('#grado2').val(),
                            productor: $('#productor2').val()
                        },
                    success: function (response) {
                        $('#respuesta2').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion3').val()
                        },
                    success: function (response) {
                        $('#respuesta3').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion4').val()
                        },
                    success: function (response) {
                        $('#respuesta4').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion5').val(),
                            cantidad: $('#cantidad5').val()
                        },
                    success: function (response) {
                        $('#respuesta5').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion6').val(),
                            cantidad: $('#cantidad6').val()
                        },
                    success: function (response) {
                        $('#respuesta6').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion7').val(),
                            productor: $('#productor7').val()
                        },
                    success: function (response) {
                        $('#respuesta7').html(response);
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
                    url: 'ServletRespuestas',
                    data:
                        {
                            accion: $('#accion8').val()
                        },
                    success: function (response) {
                        $('#respuesta8').html(response);
                    }
                });
            }
        });
        
    });
</script>
        </footer>
</body>
</html>