<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Categorias</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/agregarCategoria.css"/>
    </head>
    <body>
        
        <div class="container"> 
            <div class="row mt-4">
                <div style="text-align: center" class="col-md-10">
                    <h1 >Categorias</h1>
                </div>
                
                <div style="text-align: center" class="col-md-2">
                    <button class="mi-button" onclick="agregar()">
                        <div class="agregar">
                            <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                            <h2 style="font-size: 15px">Agregar Categoria</h2>
                        </div>
                    </button>
                </div>
                
            </div>

            <div class="row mt-4">
                 <div class="container" id="mainContainer">

                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <div id="modal-creacion" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;color: white ">REGISTRAR NUEVA CATEGORIA</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="crearCategoria" method="post">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                      <label for="NOMBRE_CATEGORIA" style="color: white">Nombre de Categoria</label>
                                    <input id="NOMBRE_CATEGORIA" name="NOMBRE_CATEGORIA" type="text" class="form-control" placeholder="Nombre de Categoria" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="ABREVIATURA" style="color: white">Abreviacion de Categoria</label>
                                    <input id="ABREVIATURA" name="ABREVIATURA" type="text" placeholder="Abreviatura" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="DESC_CATEGORIA" style="color: white">Descripcion de Categoria</label>
                                    <input id="DESC_CATEGORIA" name="DESC_CATEGORIA" type="text" placeholder="Descripcion de Categoria " class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="IMAGEN" style="color: white">Imagen</label>
                                    <input id="IMAGEN" name="IMAGEN" type="text" placeholder="Imagen" class="form-control"  required/>
                                </div>
                            </div>


                            <div class="modal-footer ">
                                <button type="submit" value="registrar" class="btn btn-primary" data-dismiss="modal">Registrar <i class="bi bi-plus-circle"></i></button>
                            </div>

                    </div>
                    </form>    
                </div>


            </div>
        </div>
    </div>
    <!-- Fin Modal -->
    <!-- Modal Detalles-->
    <div id="modal-detalles" class="modal fade" role="dialog">
        <div class="modal-dialog  modal-dialog-centered modal-sm ">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header-color modalEliminarHeader">
                    <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white" >EDITAR CATEGORIA</center>

                </div>
                <div class="modal-body">

                    <form action = "action" id="agregarCategoria">
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="NOMBRE_CATEGORIAe" style="color: white">Nombre de Categoria</label>
                                <input id="NOMBRE_CATEGORIAe" name="NOMBRE_CATEGORIA"  placeholder="NOMBRE_CATEGORIA" type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="ABREVIATURAe" style="color: white">Abreviatura</label>
                                <input id="ABREVIATURAe" name="ABREVIATURA" type="text" placeholder="Abreviatura" class="form-control"  required/>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="DESC_CATEGORIAe" style="color: white">Descripcion</label>
                                <input id="DESC_CATEGORIAe" name=" DESC_CATEGORIA" type="text" placeholder="Descripcion de Categoria" class="form-control"  required/>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="modal-footer btnEditar">
                                <button  id="btnEditarCategoria" type="submit" data-dismiss="modal" class="btn btn-primary"><i class="bi bi-pencil-square"></i>Editar</button>
                                </form>     

                            </div>

                        </div>

                </div>


            </div>
        </div>
    </div>
    <%@ include file="components/includes/footer.jspf" %>
    <script src="js/agregarCategoria.js"></script>
</body>
</html>