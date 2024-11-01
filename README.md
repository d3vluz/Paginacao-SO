# Projeto de Simulação de Algoritmos de Substituição de Páginas

Este projeto implementa e compara diferentes algoritmos de substituição de páginas, com uma interface gráfica em Java Swing. Ele foi desenvolvido como trabalho acadêmico para a disciplina de Sistemas Operacionais, com o objetivo de simular e analisar o desempenho de algoritmos clássicos de gerenciamento de memória.

## Descrição do Projeto

A substituição de páginas é uma técnica utilizada em sistemas operacionais para gerenciar o espaço de memória quando este é limitado. Quando uma página precisa ser carregada na memória, mas todos os quadros estão ocupados, um algoritmo de substituição de página decide qual página será removida para dar espaço à nova. Este projeto implementa quatro algoritmos principais de substituição de páginas:

- **FIFO (First-In, First-Out)**: Remove a página que está há mais tempo na memória.
- **LRU (Least Recently Used)**: Remove a página menos recentemente utilizada.
- **Clock (Segunda Chance)**: Dá uma segunda chance para as páginas com referência recente antes de removê-las.
- **NFU (Not Frequently Used)**: Remove a página menos frequentemente utilizada.

Cada algoritmo foi implementado em uma classe própria que segue uma interface comum, permitindo a comparação entre eles.

## Estrutura do Código

O projeto é organizado em várias classes Java, divididas conforme suas responsabilidades:

- **Interface** (`Interface.java`): Define o método `executar(int[] paginas, int quadros)` que todos os algoritmos devem implementar.
- **AlgoritmoClock** (`AlgoritmoClock.java`): Implementa o algoritmo de substituição de página do tipo Clock (Segunda Chance).
- **AlgoritmoFIFO** (`AlgoritmoFIFO.java`): Implementa o algoritmo FIFO.
- **AlgoritmoLRU** (`AlgoritmoLRU.java`): Implementa o algoritmo LRU.
- **AlgoritmoNFU** (`AlgoritmoNFU.java`): Implementa o algoritmo NFU.
- **InterfaceFaltasPagina** (`InterfaceFaltasPagina.java`): Classe principal que configura a interface gráfica para visualização dos resultados.
- **PainelGrafico** (`PainelGrafico.java`): Componente gráfico personalizado que desenha um gráfico de barras para exibir o número de faltas de página e o tempo de execução de cada algoritmo.

## Como Usar o Projeto

1. **Requisitos**: Certifique-se de que possui o JDK instalado (versão 8 ou superior) e uma IDE de sua preferência, como Eclipse ou Visual Studio Code, para compilar e executar o código.

2. **Execução**: Para executar o projeto, abra o arquivo `InterfaceFaltasPagina.java` em sua IDE e execute-o. Esta classe contém o método `main`, que inicializa o programa, executa os algoritmos de substituição de páginas e exibe os resultados na interface gráfica.

3. **Interface Gráfica**: A interface gráfica exibe:
   - **Tempo de Simulação**: Duração total da simulação, exibida no topo da janela.
   - **Gráfico de Barras**: Mostra o número de faltas de página para cada algoritmo, com o tempo de execução indicado acima de cada barra e o nome do algoritmo na parte inferior.
   - O gráfico facilita a comparação entre os algoritmos em termos de desempenho e tempo.

### Navegação no Código

Cada classe foi desenvolvida para representar um algoritmo específico ou uma função específica do programa:

- **Interface.java**: Define uma interface para os algoritmos. Ela possui o método `executar(int[] paginas, int quadros)` que cada algoritmo deve implementar.
  
- **AlgoritmoClock.java**: Classe que implementa o algoritmo Clock. Ele usa um ponteiro para circular pelos quadros, dando uma "segunda chance" para as páginas antes de removê-las.
  
- **AlgoritmoFIFO.java**: Classe que implementa o algoritmo FIFO, que remove a página que está há mais tempo na memória.
  
- **AlgoritmoLRU.java**: Implementa o algoritmo LRU. Ele remove a página que foi usada há mais tempo, simulando uma lista de páginas com uso recente.
  
- **AlgoritmoNFU.java**: Classe que implementa o algoritmo NFU, que mantém uma contagem do uso de cada página e remove a menos frequentemente utilizada.

- **InterfaceFaltasPagina.java**: Classe principal responsável pela interface gráfica. Ela configura a janela, adiciona o painel superior para o tempo de simulação e o `PainelGrafico` para mostrar os resultados.

- **PainelGrafico.java**: Classe que estende `JPanel` e é responsável por desenhar o gráfico de barras. Exibe as faltas de página dentro de cada barra e o tempo de execução acima de cada barra.

## Configurações e Personalizações

Para alterar os dados de entrada e simular diferentes cenários:

- No arquivo `InterfaceFaltasPagina.java`, na seção `main`, você pode alterar o vetor `paginas` e o número de `quadros` para simular diferentes cargas de trabalho e tamanhos de memória.
  
  ```java
  int[] paginas = {1, 3, 0, 3, 5, 6, 3, 1, 0, 5, 6, 2}; 
  int quadros = 4;
