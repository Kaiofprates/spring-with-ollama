# Rullo Board Solver

Este projeto é uma implementação do jogo matemático Rullo em Java, utilizando a biblioteca LangChain para se comunicar com o modelo de linguagem LLM (Large Language Model) Ollama. O objetivo é resolver quebra-cabeças Rullo, onde os números em um tabuleiro devem ser selecionados de forma que suas somas correspondam a um conjunto de regras especificadas.

## Estrutura do Projeto

- **RulloBoard**: Classe responsável por gerar o tabuleiro e calcular as somas das linhas e colunas.
- **LocalOllama**: Classe principal que conecta ao modelo de linguagem e gera um prompt para resolver o quebra-cabeça.

## Funcionalidades

- Geração de um tabuleiro de Rullo com números aleatórios.
- Cálculo das somas das linhas e colunas.
- Comunicação com o modelo Ollama para resolver o quebra-cabeça.
- Impressão do tabuleiro e das somas em formato de string.

## Como Usar

1. Certifique-se de que o servidor Ollama está em execução em `http://localhost:11434`.
2. Compile e execute o projeto.
3. O programa gerará um tabuleiro e enviará um prompt ao modelo Ollama para resolver o quebra-cabeça.

## Exemplo de Saída

Após a execução, o programa imprimirá:

- O tabuleiro gerado.
- As somas das linhas e colunas.
- A solução gerada pelo modelo de linguagem.

## Diagrama de Lógica do Projeto

```mermaid
graph TD;
    A[RulloBoard] -->|Gera| B[Tabuleiro]
    A -->|Calcula| C[Somas das Linhas]
    A -->|Calcula| D[Somas das Colunas]
    E[LocalOllama] -->|Conecta| F[Modelo Ollama]
    F -->|Recebe Prompt| G[Resolver Quebra-Cabeça]
    G -->|Retorna Solução| H[Imprime Solução]
    H -->|Imprime| B
