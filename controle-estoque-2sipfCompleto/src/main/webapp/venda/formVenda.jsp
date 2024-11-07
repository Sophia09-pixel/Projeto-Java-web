<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Vendas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Registrar Venda</h2>
        <form action="/registrarVenda" method="POST">
            
            <!-- Caixa de Seleção para Nome do Vendedor -->
            <div class="mb-3">
                <label for="vendedorSelect" class="form-label">Nome do Vendedor</label>
                <select class="form-select" id="vendedorSelect" name="idVendedor" required>
                    <option value="" disabled selected>Selecione um vendedor</option>
                    <!-- Os valores dos options devem ser os IDs dos vendedores, mas o texto exibido é o nome -->
                    <option value="1">João Silva</option>
                    <option value="2">Maria Oliveira</option>
                    <option value="3">Carlos Souza</option>
                </select>
            </div>

            <!-- Caixa de Seleção para Nome do Produto -->
            <div class="mb-3">
                <label for="produtoSelect" class="form-label">Nome do Produto</label>
                <select class="form-select" id="produtoSelect" name="idProduto" required>
                    <option value="" disabled selected>Selecione um produto</option>
                    <!-- Os valores dos options devem ser os IDs dos produtos, mas o texto exibido é o nome -->
                    <option value="101">Produto A</option>
                    <option value="102">Produto B</option>
                    <option value="103">Produto C</option>
                </select>
            </div>

            <!-- Campo Data da Venda -->
            <div class="mb-3">
                <label for="dataVenda" class="form-label">Data da Venda</label>
                <input type="date" class="form-control" id="dataVenda" name="dataVenda" required>
            </div>
            
            <!-- Campo Total da Venda -->
            <div class="mb-3">
                <label for="totalVenda" class="form-label">Total da Venda (R$)</label>
                <input type="number" class="form-control" id="totalVenda" name="totalVenda" step="0.01" min="0" required>
            </div>
            
            <!-- Botão para Enviar o Formulário -->
            <button type="submit" class="btn btn-primary">Registrar Venda</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


