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
            <div class="row">
                <div class="col col-md-9">
                    <h1 id="titulo">Registrar Estadisticas de Nuevo Partido </h1>
                    <h3 id="detalle_EL"></h3>
                </div>
                <div style="" class="col col-md-3">
                    <div style="text-align: center" class="col-md-2">
                        <button class="mi-button" onclick="registrarDatoEquipoLocal()">
                            <div class="agregar">
                                <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                                <h2 style="font-size: 15px">Registrar Datos(L)</h2>
                            </div>
                        </button>
                    </div>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col col-md-12">
                    <h2>DATOS DEL EQUIPO LOCAL</h2>
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
                                <th></th>
                                <th>REB</th>
                                <th></th>
                                <th></th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>FP</th>
                                <th>+/-</th>
                                <th>PTS</th>
                            </tr>
                            <tr>
                                
                                <th input</th>
                                
                                <th></th>
                                <th></th>
                                <th>A / R%</th>
                                <th>A / R%</th>
                                <th>A / R%</th>
                                <th>A / R%</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>RT</th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th>C / D</th>
                                <th></th>
                            </tr>

                        </thead>
                        <tbody id="tblDatos"></tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal datos EV -->

        <div class="container">
            <div class="row">
                <div style="" class="col col-md-3">
                    <div style="float: right">
                        <button class="mi-button" onclick="registrarDatoEquipoVisitante()" style="float: right;">
                            <div class="agregar">
                                <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                                <h2 style="font-size: 15px">Registrar Datos(L)</h2>
                            </div>
                        </button>
                    </div>
                </div>
            </div>
            <div class="table-container table-outline">
                <div class="row mt-4">
                    <div class="col col-md-12">
                        <h2>DATOS DEL EQUIPO RIVAL</h2>
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
                                    <th></th>
                                    <th>REB</th>
                                    <th></th>
                                    <th></th>
                                    <th>AS</th>
                                    <th>TO</th>
                                    <th>RB</th>
                                    <th>TP</th>
                                    <th>FP</th>
                                    <th>+/-</th>
                                    <th>PTS</th>
                                </tr>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th>A / R%</th>
                                    <th>A / R%</th>
                                    <th>A / R%</th>
                                    <th>A / R%</th>
                                    <th>RO</th>
                                    <th>RD</th>
                                    <th>RT</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th>C / D</th>
                                    <th></th>


                                </tr>

                            </thead>
                            <tbody>
                                <!-- Tus datos van aquí -->
                            </tbody>
                        </table>


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
    <script src="js/equiposRivales.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
