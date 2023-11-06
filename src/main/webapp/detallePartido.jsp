<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/detallePartido.css"/>
    </head>
    <body>


        <!-- Modal Datos EL -->
        <div class="container">
            
                <div class="col col-md-9">
                    <h1 id="titulo">Estadisticas de Partido </h1>
                    <h3 id="detalle_EL"></h3>
                </div>
                <br>
            
           <h2 id="equipoLocal"></h2>
         <div class="row mt-4">
                <div class="col col-md-12">
                      <table id="tblEquipoLocal" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="3"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="3">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="2"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Min</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>Tot</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoLocal">

                        </tbody>
                        
                    </table>
                    
                  
                </div>
            </div>
        <br>

        <!-- Modal datos EV -->

        <div class="container">
        
               <h2 id="equipoRival"></h2>
         <div class="row mt-4">
                <div class="col col-md-12">
                      <table id="tblEquipoRival" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="3"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="3">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="2"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Min</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>Tot</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoRival">

                        </tbody>
                        
                    </table>
                    
                  
                </div>
            </div>
        


                        <tbody id="tblDatos"></tbody>

                    </div>
                </div>
            </div>
        </div>


















        <!-- Modal registrar datos para Equipo Local -->
        <div id="modal-registrar" class="modal fade" role="dialog">
            <div class="modal-dialog modal-dialog-centered modal-xl">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%; font-size: 20px; margin-top: 10px; color: white">REGISTRAR NUEVO PARTIDO</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black; font-size: 15px; color: white">Ingrese el Partido a Registrar.</p>

                        <form action="action" id="registrarPartido">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>NOMBRE</th>
                                        <th>MIN</th>
                                        <th>TC</th>
                                        <th>2P TC</th>
                                        <th>3P TC</th>
                                        <th>TL</th>
                                        <th>REB</th>
                                        <th>AS</th>
                                        <th>TO</th>
                                        <th>RB</th>
                                        <th>TP</th>
                                        <th>FP</th>
                                        <th>+/-</th>
                                        <th>PTS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input id="min" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="tc" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="tc2p" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="tc3p" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="tl" class="form-control" required>
                                        </td>
                                        <td></td>
                                        <td>
                                            <input id="reb" class="form-control" required>
                                        </td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input id="as" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="to" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="rb" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="tp" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="fp" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="plusminus" class="form-control" required>
                                        </td>
                                        <td>
                                            <input id="pts" class="form-control" required>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%; font-size: 15px; color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Registrar Partido</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!---- Modal Editar Partido--->
        <div id="modal-editar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;">Editar Colaborador</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="editarPartido"  method="post">
                            <div class="row mt-4">
                                <div class="col col-md-4">
                                    <label for="resultadoE" style="color: white"><strong>Resultado:</strong></label>
                                    <select id="resultadoE" class="form-control" required>
                                        <option value="Pendiente">Pendiente</option>
                                        <option value="Ganado">Ganado</option>
                                        <option value="Perdido">Perdido</option>
                                        <option value="Empate">Empate</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="detalleResultadoE">Detalle Resultado:</label>
                                    <input id="detalleResultadoE" name="detalleResultadoE" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="lugarE">Lugar:</label>
                                    <input id="lugarE" name="lugarE" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div>

                                <div class="modal-footer ">
                                    <button type="submit" class="btnEditarPartido" id="confirmarEditarPartido" data-dismiss="modal">Editar<i class="bi bi-plus-circle"></i></button>
                                </div>

                            </div>
                        </form>    
                    </div>


                </div>
            </div>
        </div>


        <!-- Fin Modal -->

        <!---- Modal Eliminar Partido --->
        <div id="modal-eliminar-Partido" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;" >ELIMINAR PARTIDO</center>
                    </div>
                    <div class="modal-body">
                        <p>¿Estás seguro de que deseas eliminar este Partido?</p>
                    </div>
                    <div class="modal-footer ">
                        <button value="SI" class="btn btn-danger" id="confirmar-eliminar" data-dismiss="modal">SI</button>
                        <button value="NO" class="btn btn-primary" id="cancelar-eliminar" data-dismiss="modal">NO</button>
                    </div>



                </div>


            </div>
        </div>
    </div>

    <%@include file="components/includes/footer.jspf"%>
    <script src="js/detallePartido.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
