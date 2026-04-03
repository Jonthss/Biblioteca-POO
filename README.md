# 📚 Sistema de Gerenciamento de Biblioteca

> **Projeto Acadêmico** desenvolvido com foco prático em **Programação Orientada a Objetos (POO)**.

---

## 🎯 Sobre o Projeto

Um sistema interativo construído em Java que roda diretamente no terminal (CLI). Ele permite gerenciar o acervo de uma biblioteca de forma simples e direta, aplicando na prática conceitos fundamentais da programação orientada a objetos, como herança e encapsulamento.

---

## ✨ Funcionalidades

O sistema oferece um menu interativo completo. O que é possível fazer:

* **📖 Cadastrar Livros:** Adicione título, autor e escolha o gênero literário a partir de categorias prontas.
* **📰 Cadastrar Revistas:** Registre revistas informando o título, autor e o número da edição.
* **📋 Listar Acervo:** Visualize todos os materiais cadastrados e disponíveis.
* **🔍 Buscar por Título:** Encontre rapidamente um material específico buscando pelo seu nome exato.
* **🏷️ Filtrar por Gênero:** Liste apenas os livros que pertencem a uma categoria específica (Ex: Ficção, Tecnologia).
* **🗑️ Remover Material:** Exclua itens do acervo com confirmação de segurança.

---

## 🛠️ Tecnologias e Conceitos

* **Linguagem:** Java 21
* **Paradigma:** Orientação a Objetos (POO)
* **Armazenamento:** `ArrayList` para manter os dados do acervo em memória durante a execução.
* **Conceitos de POO Aplicados:**
  * **Herança:** As classes `Livro` e `Revista` herdam características da classe mãe `Material`.
  * **Polimorfismo:** Sobrescrita do método `toString()` para exibir os detalhes de cada tipo de material de forma personalizada.
  * **Encapsulamento:** Proteção de dados utilizando modificadores de acesso restritos e métodos *getters/setters*.
  * **Enums:** Criação do `Genero` para categorizar os livros de maneira padronizada e imutável.

---

## 📂 Estrutura do Código

```text
src/
└── biblioteca/
    ├── Biblioteca.java    # Lógica principal, listas e métodos de gerenciamento
    ├── Genero.java        # Enum com as categorias literárias
    ├── Livro.java         # Modelo de Livro (Herda de Material)
    ├── Main.java          # Classe de inicialização e Menu Interativo
    ├── Material.java      # Classe Base (Mãe)
    └── Revista.java       # Modelo de Revista (Herda de Material)
