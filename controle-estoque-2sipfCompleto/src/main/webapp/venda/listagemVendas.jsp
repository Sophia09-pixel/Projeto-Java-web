<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatório de Vendas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Relatório de Vendas</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Nome do Cliente</th>
                    <th scope="col">Nome do Vendedor</th>
                    <th scope="col">Total da Venda (R$)</th>
                </tr>
            </thead>
            <tbody>
                <!-- As linhas de dados serão inseridas aqui -->
                <tr>
                    <td>João Pereira</td>
                    <td>Maria Oliveira</td>
                    <td>1500.00</td>
                </tr>
                <tr>
                    <td>Ana Costa</td>
                    <td>Carlos Souza</td>
                    <td>1200.50</td>
                </tr>
                <tr>
                    <td>Pedro Lima</td>
                    <td>João Silva</td>
                    <td>875.00</td>
                </tr>
                <!-- Você pode adicionar mais linhas conforme necessário -->
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
