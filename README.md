# Aplicativo CRUD em JDBC (Java Database Connectivity)

Este é um aplicativo CRUD (Create, Read, Update, Delete) simples em Java que utiliza JDBC para interagir com um banco de dados MySQL. Os métodos para cada ação foram separados em classes para fins didáticos.

## Funcionalidades

O aplicativo oferece as seguintes funcionalidades:

* **Inserir um novo filme**: Adicione um novo filme à base de dados.
* **Atualizar informações de um filme**: Atualize informações de um filme existente com base no ID.
* **Exibir informações de um filme**: Visualize informações de um filme com base no ID.
* **Excluir um filme**: Remova um filme com base no ID.

## Pré-requisitos

Antes de executar o aplicativo, certifique-se de que você tenha:

* Um banco de dados MySQL configurado com uma tabela chamada `filmes`.
* As configurações de conexão ao banco de dados estejam corretamente definidas nas classes de conexão.

## Uso

### Inserir um Filme

Para inserir um novo filme, trate todos os campos solicitados como strings. Após a inserção, você verá uma das seguintes mensagens:
* "Filme cadastrado com sucesso!" em caso de sucesso.
* "Falha ao adicionar filme!" em caso de erro.

### Deletar um Filme

A exclusão de um filme é feita com base no ID. Recomenda-se usar a opção "Exibir todos os filmes" antes de excluir para identificar o ID do filme a ser removido.

### Atualizar Informações de um Filme

A atualização de informações de um filme é feita com base no ID. Recomenda-se usar a opção "Exibir todos os filmes" antes de atualizar para identificar o ID do filme a ser modificado.

### Exibir Todos os Filmes

Selecionando a opção "Exibir todos os filmes", você verá a lista de todos os filmes no banco de dados. Se nenhum filme estiver cadastrado, a mensagem "Não há filmes cadastrados!" será exibida.

### Exibir um Filme

Para exibir informações de um filme com base no ID, informe o ID do filme desejado. Recomenda-se usar a opção "Exibir todos os filmes" antes para encontrar o ID desejado.

