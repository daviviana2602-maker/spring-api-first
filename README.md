# 🍰 CakeShop API

API REST para gerenciamento de usuários, produtos e pedidos com foco em segurança, autenticação e boas práticas de arquitetura backend.

---

## 🚧 Status do projeto
Em desenvolvimento (backend completo em evolução contínua)

---

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- PostgreSQL

---

## 📌 Funcionalidades

### 🔐 Autenticação & Segurança
- Registro de usuários
- Login com autenticação JWT
- Hash de senhas com BCrypt
- Controle de acesso baseado em roles (ADMIN / USER)
- Controle de ownership (usuário só acessa/edita seus próprios recursos)

### 👤 Usuários
- CRUD de usuários (restrito por permissão)
- Proteção de dados sensíveis

### 🍰 Produtos
- CRUD completo de produtos
- Endpoints protegidos por autorização (Somente ADMIN)

### 🛒 Sistema de pedidos (base)
- Estrutura de carrinho com uso de tabela "temporária"
- Funcionamento de pedidos por status (CANCELED, PENDING, CONCLUDED)

---

## 🧠 Arquitetura

- Arquitetura em camadas
- Separação de responsabilidades
- Uso de Spring Security para controle de acesso
- Integração com PostgreSQL via JPA/Hibernate

---

## ▶️ Como rodar o projeto

```bash
git clone https://github.com/daviviana2602-maker/CakeShop-API.git
cd CakeShop-API
mvn spring-boot:run