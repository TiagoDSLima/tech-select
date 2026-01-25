# 🧠 TechSelect

## 📖 Visão Geral

O **TechSelect** é um sistema de **recrutamento e seleção** baseado em uma **arquitetura monolítica**. A aplicação tem como objetivo centralizar o cadastro de vagas, candidaturas e realizar uma **avaliação automática de candidatos** com base em critérios técnicos definidos pelos recrutadores.

> ⚠️ **Status do projeto**: em fase de finalização.


---

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=java)&nbsp;
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen?style=for-the-badge&logo=springboot)&nbsp;
![Spring Security](https://img.shields.io/badge/Spring%20Security-Security-brightgreen?style=for-the-badge&logo=springsecurity)&nbsp;
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge&logo=jsonwebtokens)&nbsp;
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Persistence-brightgreen?style=for-the-badge)&nbsp;
![Docker](https://img.shields.io/badge/Docker-Containers-blue?style=for-the-badge&logo=docker)&nbsp;
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)&nbsp;
![JUnit](https://img.shields.io/badge/JUnit-Tests-green?style=for-the-badge)&nbsp;

---

## 🏗️ Arquitetura

* Arquitetura **monolítica**
* Camadas bem definidas (controller, service, repository)
* Autenticação e autorização integradas ao núcleo da aplicação

---

## 🧩 Entidades Principais

### 📄 Candidatura

Representa a candidatura de um candidato a uma vaga específica.

* Armazena dados do candidato
* Vinculada a uma vaga
* Possui status de avaliação automática

### 👤 Recrutador

Usuário responsável pelo cadastro e gerenciamento de vagas.

* Possui **login e autenticação**
* Pode criar, editar e publicar vagas

### 🏢 Setor

Define a área ou departamento da vaga.

* Exemplo: Backend, Frontend, Dados, Infraestrutura

### 🧠 Skill

Representa uma habilidade técnica.

* Utilizada como critério obrigatório ou desejável em vagas

### 💼 Vaga

Entidade central do sistema.

* Cadastrada por recrutadores autenticados
* Contém requisitos obrigatórios e desejáveis
* Fica pública para que candidatos realizem candidaturas

---

## 🔐 Autenticação

* Sistema de autenticação exclusivo para **recrutadores**
* Apenas recrutadores autenticados podem gerenciar vagas
* Candidatos não precisam de login para se candidatar

---

## ⚙️ Fluxo de Funcionamento

1. O recrutador realiza login no sistema
2. O recrutador cadastra uma vaga, definindo:

   * Skills obrigatórias
   * Skills desejáveis
   * Tempo mínimo de experiência
3. A vaga é publicada e fica disponível para candidatos
4. O candidato realiza sua candidatura
5. O sistema executa a **avaliação automática da candidatura**
6. O status da candidatura é definido com base nas regras de negócio

---

## 📊 Regras de Avaliação da Candidatura

* ❌ **INAPTO**:

  * Não possui todas as skills obrigatórias **ou**
  * Não atende ao tempo mínimo de experiência exigido

* ✅ **APTO**:

  * Atende às skills obrigatórias e ao tempo de experiência

* ⭐ **MUITO APTO**:

  * Atende aos requisitos obrigatórios **e**
  * Possui **pelo menos duas skills desejáveis**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Docker e Docker Compose instalados

### Passo a passo

1. Acesse as pastas `bucket` e `database`
2. Crie uma pasta chamada `data` dentro de cada uma delas (caso ainda não exista)

```bash
mkdir data
```

3. Suba os containers Docker em cada pasta:

```bash
docker compose up -d
```

4. Após o PostgreSQL estar em execução, execute o script SQL localizado no arquivo:

```text
database.sql
```

Esse script é responsável por criar a estrutura inicial do banco de dados.

5. Com a infraestrutura ativa, execute a aplicação normalmente.

---

## 🏢 Isolamento de Dados por Recrutador

O sistema utiliza **segregação lógica de dados por recrutador**, onde os registros são associados a um `idRecrutador`.

Atualmente, a aplicação segue um modelo **single-tenant com isolamento lógico**, servindo como base para uma futura evolução para **multitenancy**, caso necessário.

---

## 📌 Observações

* As regras de avaliação são centralizadas no domínio da aplicação
* O sistema prioriza clareza de regras e facilidade de manutenção
* Projeto focado em regras de negócio e fluxo de recrutamento

---
