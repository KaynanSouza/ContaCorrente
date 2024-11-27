# 🏦 Projeto Conta Corrente em Java

Este é um projeto simples em Java para gerenciar contas correntes. Ele permite realizar operações bancárias como **criar contas**, **sacar valores**, **depositar valores**, **transferências entre contas**, e **exibir extratos detalhados**. Um excelente exemplo para aprender **Programação Orientada a Objetos (POO)** e manipulação de coleções no Java.

---

## 🚀 Funcionalidades

- **Criar uma conta** com dados do cliente, número de conta e agência gerados automaticamente.
- **Depositar valores** em contas.
- **Sacar valores**, com validação de saldo.
- **Transferir valores** entre contas.
- **Consultar saldo disponível**.
- **Exibir extrato detalhado** entre duas datas.
- **Exibir lista de contas criadas**, com informações dos clientes.

---

## 🛠️ Tecnologias Utilizadas

- **Java (JDK 8+)**
- Manipulação de coleções com **ArrayList**.
- **Scanner** para entrada de dados do usuário.
- Manipulação de datas com **SimpleDateFormat**.
- Lógica baseada em **Programação Orientada a Objetos (POO)**.

---

## 📦 Estrutura do Projeto

O projeto está organizado em três classes principais:

1. **`ContaCorrente`**
    - Representa uma conta bancária com métodos para gerenciar saldo e transações.
    - **Principais métodos**:
        - `sacarValor`: Realiza saques.
        - `depositarValor`: Realiza depósitos.
        - `transferir`: Transfere valores entre contas.
        - `exibirExtrato`: Exibe o extrato filtrado por intervalo de datas.

2. **`Transacao`**
    - Representa uma transação bancária (saque, depósito ou transferência).
    - Contém informações como data, valor e descrição.

3. **`Main`**
    - Classe responsável pela interface com o usuário.
    - Exibe o menu principal e gerencia as interações, como criar contas e realizar operações.

---

## 🎮 Como Usar

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/KaynanSouza/ContaCorrente.git
   cd ContaCorrente
Claro! Aqui está o texto formatado em Markdown:

---

## 📋 Exemplo de Uso

### Criar uma Conta

**Entrada:**

```yaml
Nome do cliente: João
Data de nascimento: 01/01/1990
```

**Saída:**

```
Conta criada com sucesso!
Número da conta: 1
Agência: 82
```

### Depositar Valor

**Entrada:**

```yaml
Número da conta: 1
Valor a ser depositado: 500.00
Data da transação: 25/11/2024
```

**Saída:**

```
Depósito realizado com sucesso!
```

### Exibir Saldo

**Entrada:**

```
Número da conta: 1
```

**Saída:**

```
Saldo disponível: R$ 500.00
```

### Transferir Valor

**Entrada:**

```yaml
Conta remetente: 1
Conta destinatária: 2
Valor a ser transferido: 200.00
Data da transação: 26/11/2024
```

**Saída:**

```
Transferência realizada com sucesso!
```

---

## 🧩 Melhorias Futuras

- Implementar persistência de dados usando arquivos ou bancos de dados (SQLite, MySQL, etc.).
- Adicionar autenticação para clientes.
- Melhorar o tratamento de erros e validação de entrada.
- Criar uma interface gráfica usando JavaFX ou Swing.
- Migrar manipulação de datas para LocalDate e LocalDateTime (API de datas moderna do Java).

---

## 🖋️ Licença

Este projeto está licenciado sob a [licença MIT](https://opensource.org/licenses/MIT). Você pode utilizá-lo e modificá-lo livremente.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um **fork** do repositório.

2. Crie uma branch para suas alterações:

   ```bash
   git checkout -b minha-mudanca
   ```

3. Faça o commit de suas alterações:

   ```bash
   git commit -m "Adicionei nova funcionalidade"
   ```

4. Envie suas mudanças para o repositório remoto:

   ```bash
   git push origin minha-mudanca
   ```

5. Abra um **Pull Request**.

---

## ✨ Autor

- **Kaynan Souza**
- GitHub: [KaynanSouza](https://github.com/KaynanSouza)

---