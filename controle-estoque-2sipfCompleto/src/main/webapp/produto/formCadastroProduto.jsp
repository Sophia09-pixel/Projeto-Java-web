<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usu�rio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <!-- Barra de navegação simples -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Gerenciamento de Produtos</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/dashboard.jsp">Voltar ao Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Sair</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Conteúdo principal -->
    <div class="container mt-5">
        <h2 class="text-center">Cadastrar Produto</h2>

        <!-- Formulário de Cadastro de Usuário -->
        <form action="../CadastroProduto" method="post" class="mt-4">
            <!-- Nome do Usuário -->
            <div class="mb-3">
                <label for="nome" class="form-label">Nome do Produto</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>

            <!-- E-mail do Usuário -->
            <div class="mb-3">
                <label for="qtdEstoque" class="form-label">Quantidade no estoque</label>
                <input class="form-control" id="qtdEstoque" name="qtdEstoque" required>
            </div>

            <!-- Senha do Usuário -->
            <div class="mb-3">
                <label for="preco" class="form-label">Preço R$</label>
                <input class="form-control" id="preco" name="preco" required>
            </div>

            <!-- Seleção do Perfil -->
            <div class="mb-3">
                <label for="fornecedor" class="form-label">Fornecedor</label>
                <select class="form-control" id="fornecedor" name="fornecedor" required>
                    <option value="" disabled selected>Selecione um fornecedor</option>
                    
                    <c:forEach var="fornecedor" items="${lista}">
                    	<option value="${fornecedor}">${fornecedor}</option>
                    </c:forEach>
                    
                </select>
            </div>

            <!-- Botão de Cadastro -->
            <button type="submit" class="btn btn-primary">Cadastrar Produto</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
