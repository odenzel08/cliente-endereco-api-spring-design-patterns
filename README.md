# API de Cadastro de Clientes com Spring Boot e Design Patterns

Este projeto é uma API REST desenvolvida com **Spring Boot**, que permite cadastrar clientes associados a um endereço obtido através da API externa **ViaCEP**.

Além de funcionalidades básicas de CRUD, o projeto aplica os padrões de projeto **Strategy**, **Facade** e **Singleton**, como forma de promover um código mais modular, desacoplado e reutilizável.

---

## 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- OpenFeign
- API externa: ViaCEP
- Design Patterns (GOF)

---

## 📌 Funcionalidades

- ✅ Cadastrar clientes com endereço via CEP (integração ViaCEP)
- ✅ Listar, buscar, atualizar e deletar clientes
- ✅ Endereços são salvos evitando duplicações
- ✅ Uso de padrões Strategy, Facade e Singleton

---

## 🧠 Padrões de Projeto aplicados

### ✅ Strategy
Usado para definir diferentes estratégias de busca de cliente (ex: por ID, por nome, etc.), permitindo fácil extensão de novos tipos de consulta.

### ✅ Facade
A classe `ClienteService` atua como uma fachada para centralizar e simplificar a lógica de negócio e chamadas para repositórios e APIs externas.

### ✅ Singleton
A configuração do serviço de busca de endereços (como o client da API ViaCEP) é tratada como instância única (Bean do Spring), garantindo reutilização e performance.

---

## ▶️ Como executar o projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repositorio

# Acesse a pasta do projeto
cd cliente-endereco-api-spring-design-patterns

# Execute a aplicação (com Maven)
./mvnw spring-boot:run
