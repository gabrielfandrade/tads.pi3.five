<%-- 
    Document   : CadastrarVeiculo
    Created on : 17/10/2018, 00:46:11
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <title>ADICIONAR CARRO</title>
    </head>
    <body>
    <center>
        <h1>
            Adicionar Carro
        </h1>
    </center>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-2" style="background: write">
                <!-- Primeira lateral-->
            </div>
            <div class="col-8" style="background: write">
                <form id="form">
                    <div class="form-group">
                        <label for="inputModelo">Modelo de Veiculo</label>
                        <input type="text" class="form-control" id="modelo" placeholder="Modelo">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <label for="inputCategoria">Categoria</label>
                            <input type="text" class="form-control" id="categoria" placeholder="Categoria">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="ano">Ano</label>
                            <input type="date" class="form-control" id="ano" placeholder="2018">
                        </div>
                        <div class="form-group col-md-5">
                            <label for="caracteristicas">Características</label>
                            <input type="caracteristicas" class="form-control" id="caracteristicas" placeholder="caracteristicas">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="placa">Placa</label>
                            <input type="text" class="form-control" id="placa" placeholder="AAA-9999">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="marca">Marca</label>
                            <input type="text" class="form-control" id="marca" placeholder="marca">
                        </div>
                        <div class="form-group col-md-5">
                            <label for="ndocumento">Número de Documento</label>
                            <input type="text" class="form-control" id="ndocumento">
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="imagem">importar Imagem</label>
                        <input type="file" class="form-control" id="imagem">
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </form>
            </div>
            <div class="col-2" style="background: write">
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script src="jquery.mask.js"></script>
        <script src="javascript.js"></script>
    </body>
</html>
