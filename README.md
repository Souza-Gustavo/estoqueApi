# 🏢 API Estoque e Financeiro

API em **Java 17** e **Spring Boot 3** para gerenciar **produtos, entradas financeiras e despesas**, com **resumo financeiro**.  
Documentada com **Swagger / OpenAPI** para testes interativos.

---

## 🚀 Tecnologias

- ☕ Java 17  
- 🟢 Spring Boot 3  
- 💾 Spring Data JPA  
- 🗄 H2 Database  
- 📄 Springdoc OpenAPI (Swagger UI)  
- 📦 Maven  

---

## 💡 Funcionalidades

- 🛒 CRUD de **Produtos** (`/products`)  
- 💰 CRUD de **Entradas Financeiras** (`/incomes`)  
- 💸 CRUD de **Despesas** (`/expenses`)  
- 📊 **Resumo Financeiro** (`/financial-summary`)  

---

## ⚡ Executando a API

```bash
git clone <URL_DO_REPOSITORIO>
cd estoqueApi
./mvnw spring-boot:run
```

📝 Exemplos Rápidos

Criar Produto
```
POST /products
{ "name": "Caneta Azul", "quantity": 100, "price": 2.5 }
```

Criar Entrada
```
POST /incomes
{ "description": "Venda Caneta", "amount": 250.0, "date": "2025-08-14" }
```

Criar Despesa
```
POST /expenses
{ "description": "Compra de Papel", "amount": 50.0, "date": "2025-08-14" }
```

Resumo Financeiro
```
GET /financial-summary
{ "totalIncome": 250.0, "totalExpense": 50.0, "balance": 200.0 }
```



# 🔮 Melhorias Futuras


* Persistência em PostgreSQL/MySQL
* Validação de campos com @NotNull e @Positive
* Endpoint de estoque baixo
* Resumo financeiro por período ou categoria
* Autenticação e autorização de usuários
* Tratamento global de exceções com @ControllerAdvice

# 👍 Observações

* IDs gerados automaticamente pelo H2
* Use POST antes de PUT ou DELETE para evitar erros
* Documentação Swagger facilita testes e visualização de dados

  ## ✍️ Criado por

**Gustavo Souza**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gustavo-souza-521864153/)  
