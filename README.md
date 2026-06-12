# 🏥 HospitalFlow API

Backend API para gerenciamento de fluxo hospitalar, incluindo controle de senhas, cadastro de pacientes e registro de atendimentos.

Projeto desenvolvido com Java + Spring Boot, aplicando arquitetura em camadas e boas práticas de API REST.

---

## 🚀 Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🎯 Objetivo do sistema

Simular o fluxo real de atendimento hospitalar:

- Geração de senhas para fila de espera
- Controle de atendimento por status
- Cadastro de pacientes
- Registro de fichas de atendimento
- Controle de alta hospitalar

---

## 🧠 Arquitetura

O projeto segue arquitetura em camadas:

- Controller → Endpoints REST
- Service → Regras de negócio
- Repository → Acesso ao banco de dados
- Entity → Modelagem de dados

---

## 🔁 Fluxo do sistema

1. Paciente chega ao sistema
2. Retira senha no totem (Ticket)
3. Recepção chama a senha
4. Atendimento é iniciado (Attendance)
5. Médico finaliza atendimento
6. Alta é registrada

---

## 📦 Endpoints

### 🎟️ Tickets

- `POST /tickets` → Gera nova senha
- `POST /tickets/chamar` → Chama próxima senha
- `PUT /tickets/{id}/finalizar` → Finaliza atendimento

---

### 🧾 Attendances

- `POST /attendances` → Cria ficha de atendimento

---

## 💡 Conceitos aplicados

- API REST com Spring Boot
- Separação de responsabilidades (Clean Architecture básica)
- JPA / Hibernate
- Enum para controle de status
- Modelagem de sistema real
- Boas práticas de backend

---

## 📊 Status do projeto

🚧 Em desenvolvimento (projeto de portfólio)

---

## 👨‍💻 Autor

**Lucas Ramalho**
Backend Developer | Java | Spring Boot | REST APIs | SQL