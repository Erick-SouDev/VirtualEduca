# Sistema EAD de Cursos Livres

Este é um sistema de Ensino a Distância (EAD) desenvolvido com Spring Boot, PostgreSQL, HTML, Thymeleaf e Spring Email.

## Funcionalidades Principais

## Requisitos Funcionais

### Aluno:

- Cadastrar Aluno
- Editar Dados do Aluno
- Recuperar Senha do Aluno
- Cancelar Conta do Aluno
- Gerar Certificado Apos Aluno Concluir o curso

### Aluno Gerenciar Seus Cursos:

- Adicionar Curso na Grade do Aluno
- Cancelar ou Remover Curso da Grade do Aluno
- Visualizar Progresso do Curso do Aluno

### Instrutor:

- Instrutor de Cadastramento
- Editar Dados do Instrutor
- Recuperar Senha do Instrutor
- Cancelar Conta do Instrutor

### Instrutor - Cursos e Aulas:

- Cadastrar Curso e Aula
- Atualizar Aulas e Cursos
- Excluir Curso
- Organizar Cursos por Categoria

### Mecanismo de Busca de Cursos:

- Buscar Curso por Nome
- Buscar Curso por Categoria
- Buscar Curso por Nome do Instrutor

### Notificações:

- Sistema deve Enviar Notificações para Alunos sobre Novos Cursos

### Caderno de Anotações:

- Sistema deve Ter Caderno de Anotações do Aluno

### Aluno-Instrutor de Comunicação Através do protocolo Http 

- Aluno pode enviar perguntas para o instrutor
- Listar Perguntas e Visualizar Mensagens do Instrutor
- Instrutor Pode Visualizar Mensagens do Aluno
- Instrutor pode enviar respostas para os alunos

# Sala de Bate-papo entre Alunos
- A ideia é criar uma interação via protocolo WebSocket onde os alunos conversem entre si, discutindo sobre uma aula qualquer e ajudando uns aos outros em tempo real. Além disso, os alunos terão a capacidade de visualizar quem está online, quem saiu da sala e outras informações relevantes sobre a presença dos colegas.

### Login e Acesso à Área do Aluno:

- Aluno realizar login se estiver cadastrado no sistema
- Aluno não pode acessar a área do aluno se não tiver logado
- A página principal é bloqueada caso o usuário não esteja logado; se ele tentar acessar pela URL via GET enviar mensagem de alerta de erro 

## Requisitos Não Funcionais

- Controle de dados em memória (cache)
- Envio de serviços de email em background ou assíncrono, rodar o serviço em um thread
- Respostas do servidor: mínimo 10s, máximo 30s de tempo de resposta
- Tratamento de erros do servidor e do cliente
- Gerenciamento e configurações do pool de conexões
- Tempo de resposta máximo de 2s
- Máximo de conexões: 30
- Mínimo de conexões que não estão sendo usadas: 10
- Limitar o tamanho do upload para vídeo e imagem
- Manter a segurança do sistema através do mecanismo de segurança contra fraudes e acesso indevido

## Tecnologias Utilizadas

- Spring Boot: framework Java para desenvolvimento rápido de aplicações
- PostgreSQL: sistema de gerenciamento de banco de dados relacional
- HTML: linguagem de marcação para construção da interface do usuário
- Thymeleaf: mecanismo de template para integração do backend com o frontend
- Spring Email: biblioteca para envio de e-mails na aplicação

## Pré-requisitos

Antes de iniciar, certifique-se de ter o seguinte instalado em sua máquina:

- Java Development Kit (JDK) 8 ou superior
- Maven
- PostgreSQL

## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `ead_cursos_livres`.
2. Configure as credenciais do banco de dados no arquivo `application.properties`.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ead_cursos_livres
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
