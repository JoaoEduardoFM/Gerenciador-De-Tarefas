# Gerenciador-De-Tarefas
Consultar cotação atualizada em Scheduled
image

Status: Em desenvolvimento ⚠️

Gostaria de apresentar nossa API de Gerenciador de Atividades, uma poderosa solução para o controle e organização de tarefas. Nossa API oferece uma variedade de endpoints que permitem o gerenciamento completo do ciclo de vida das atividades.

Aqui está uma breve visão geral dos principais endpoints disponíveis:

GET /usuario/buscaRegistros: Este endpoint retorna todos os usuários cadastrados, permitindo uma visualização completa da lista de usuários e suas respectivas informações.

GET /usuario/buscaPorId/{id}: Com este endpoint, é possível buscar um usuário específico com base no seu ID. Isso permite a recuperação detalhada das informações de um usuário em particular.

GET /usuario/buscaPorTitulo/{titulo}: Ao utilizar este endpoint, você pode buscar usuários com base no título. Isso é útil para encontrar usuários específicos que possuem um determinado título relacionado às atividades.

GET /usuario/buscaPorDescricao/{descricao}: Aqui, é possível buscar usuários com base em uma descrição específica. Essa funcionalidade permite a localização de usuários que tenham atividades com uma determinada descrição.

GET /usuario/buscaPorDataConclusao/{data}: Com este endpoint, é possível buscar usuários com base em sua data de conclusão. Isso facilita a identificação de usuários que concluíram suas atividades em uma determinada data.

GET /usuario/buscaPorStatus/{status}: Este endpoint permite buscar usuários com base no status de suas atividades, fornecendo uma visão dos usuários com atividades concluídas ou em andamento.

GET /usuario/buscaPorPrioridade/{prioridade}: Com este endpoint, você pode buscar usuários com base na prioridade de suas atividades. Isso permite identificar usuários que possuem atividades de alta prioridade.

POST /usuario/cadastraRegistro: Utilizando este endpoint, é possível cadastrar um novo usuário com suas respectivas informações e atividades relacionadas.

PUT /usuario/atualizaRegistro/{id}: Com esse endpoint, é possível atualizar as informações de um usuário existente com base no seu ID.

PATCH /usuario/atualizaParcialmente/{id}: Este endpoint permite atualizar parcialmente as informações de um usuário, fornecendo apenas os campos que desejam ser modificados.

DELETE /usuario/deletaUsuario/{id}: Com este endpoint, é possível excluir um usuário específico com base no seu ID.

Nossa API de Gerenciador de Atividades é projetada para oferecer flexibilidade e facilidade de uso, permitindo que você controle e acompanhe todas as atividades de seus usuários. Sinta-se à vontade para explorar e utilizar todos os recursos oferecidos.

Sistema integrado:(https://economia.awesomeapi.com.br/)
Retorno exemplo:
{
  "id": 1,
  "nome": "string",
  "sobrenome": "string",
  "email": "string",
  "listaDeTarefas": [
    {
      "id": 2,
      "titulo": "string",
      "descricao": "string",
      "dataConclusao": "string",
      "status": true,
      "prioridade": "string"
    }
  ]
}

Tecnologias usadas:
header header header

Java	spring-boot	H2
17	2.5.3	h2
Esses recursos estão em desenvolvimento:
Em desenvolvimento ⚠️
