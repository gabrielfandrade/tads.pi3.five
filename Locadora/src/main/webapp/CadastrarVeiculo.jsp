<%-- 
    Document   : CadastrarVeiculo
    Created on : 17/10/2018, 00:46:11
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Veiculo</title>
    </head>
    <body>
        <center><br><br><br><br>
        <form action="main" method="post">
            Modelo do Carro: <input type="text" name="modelo"><br><br>
            Categoria: <input type="text" name="categoria">
            Ano: <input type="date" name="ano"><br><br>
            Características: <input type="text" name="caracter"><br><br>
            Placa: <input type="text" name="placa"><br><br>
            Marca: <input type="text" name="marca"><br><br>
            Número de Documento: <input type="number" name="ndocumento"><br><br>
            Importar Imagem: <input type="file" name="imagem"><br><br>
            <button value="Salvar" type="submit"> Salvar </button>
        </form>
    </center>
    </body>
</html>
