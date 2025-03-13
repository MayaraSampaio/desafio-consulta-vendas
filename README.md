# Sales Query Challenge / Desafio Consulta Vendas

This repository contains the implementation of a sales and seller query system, as requested in the challenge.

Este repositório contém a implementação de um sistema de consulta de vendas e vendedores, conforme solicitado no desafio.

![image](https://github.com/user-attachments/assets/f2ee0511-c1f4-47ea-a890-18bb00e91f30)


## Features / Funcionalidades

### 1. **Sales Report / Relatório de Vendas**
- **Endpoint**: `GET /sales/report`
- **Parameters / Parâmetros**:
  - `minDate` (optional / opcional)
  - `maxDate` (optional / opcional)
  - `name` (optional / opcional)
- **Response / Saída**: Paginated list of sales, including ID, date, amount sold, and seller name.

### 2. **Sales Summary by Seller / Sumário de Vendas por Vendedor**
- **Endpoint**: `GET /sales/summary`
- **Parameters / Parâmetros**:
  - `minDate` (optional / opcional)
  - `maxDate` (optional / opcional)
- **Response / Saída**: Seller name and total sales in the given period.

## Strategy to Avoid N+1 Queries / Estratégia para Evitar N+1 Consultas

Custom **queries** were implemented in the repository to avoid the N+1 query problem. This was achieved using `@Query` from Spring Data JPA, optimizing database queries and improving performance.

As consultas foram implementadas utilizando **queries personalizadas** no repositório, garantindo que o problema de N+1 consultas fosse evitado. Isso foi alcançado utilizando o `@Query` do Spring Data JPA, otimizando as consultas ao banco de dados e melhorando a performance.

## How to Run the Project / Como Rodar o Projeto

1. Clone this repository / Clone este repositório:
    ```bash
    git clone https://github.com/seu-usuario/desafio-consulta-vendas.git
    cd desafio-consulta-vendas
    ```

2. Run the application with Maven / Rode a aplicação com Maven:
    ```bash
    mvn spring-boot:run
    ```

3. The application will be available at / A aplicação estará disponível em `http://localhost:8080`.

## Testing the API / Testando a API

Test the endpoints using the Postman collection:
[Postman Collection - Sales Query Challenge](https://www.getpostman.com/collections/dea7904f994cb87c3d12)

Implemente os testes com a collection do Postman:
[Postman Collection - Desafio Consulta Vendas](https://www.getpostman.com/collections/dea7904f994cb87c3d12)

### Challenge


This challenge was proposed by **DevSuperior**, a company focused on creating high-quality educational content for developers.

Este desafio foi proposto pela **DevSuperior**, uma empresa focada na criação de conteúdo educacional de alta qualidade para desenvolvedores.


