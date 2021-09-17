# jogo-do-labirinto
Paradigmas de Linguagens de Programação (CEUB, 2021/02)

## Parte 1

### Atividade 1

1. **Implemente o programa Labirinto, de acordo com a versão mostrada, só para apresentar o tabuleiro vazio. Tente não copiar o código mostrado, mas fazer sem olhar o material da aula. Relate o que você fez de diferente em termos de implementação ou se a sua implementação ficou igual à mostrada na aula.**

A implementação foi equivalente, com a única adição de um caractere separado para representar as esquinas das paredes externas (`+`) -- a qual foi acompanhada por uma modificação no loop que desenha tais paredes.

2. **Altere o valor da constante que representa o tamanho do tabuleiro. Relate o que houve com o tabuleiro mostrado pelo programa e explique como a alteração dessa constante afetou o resto do programa.**

O tabuleiro foi desenhado (corretamente) com as novas dimensões fornecidas, sem quaisquer outras alterações.

### Atividade 2

1. **Altere sua implementação do programa Labirinto para apresentar o tabuleiro com as paredes internas (obstáculos), como mostrado nessa segunda parte da aula. Tente não copiar o código mostrado, mas fazer sem olhar o material da aula. Relate o que você fez de diferente em termos de implementação ou se a sua implementação ficou igual à mostrada na aula.**

Testei outros caracteres para representar as paredes internas (as quais chamei de `OBSTACULO`s), e no final decidi usar o caractere `L`. A comparação feita no sorteio foi da forma `Math.random() < PROBABILIDADE`, ao invés de `>`. Assim, a probabilidade usada é o complemento da probabilidade do programa original (e seu valor foi devidamente reduzido), de forma que ela representa a probabilidade de um dado espaço ser ocupado (ao invés de ser livre).

2. **Execute várias vezes o programa Labirinto e relate se houve mudanças na posição e quantidade de obstáculos que formam as paredes internas do labirinto.**

Tanto as posições quanto a quantidade das paredes internas se alteram entre execuções do programa.

3. **Teste o uso de outros caracteres para as constantes usadas no programa e indique se você encontrou valores mais adequados que os mostrados na aula (deixam o tabuleiro mais bonito, são mais simples de serem visualizados etc.).**

Os caracteres usados para representar as paredes externas foram mantidos, (com a adição de `+` para as esquinas) e as paredes internas foram representadas por `X`s.

4. **Altere o valor da constante PROBABILIDADE e relate o que acontece quando aumentamos ou diminuímos o seu valor.**

A densidade de paredes internas aumenta com o aumento de `PROBABILIDADE`, e diminui com sua redução. (Minha implementação inverteu a interpretação dessa constante, conforme dito no exercício 1.)

### Autoavaliação

1. **Qual a estrutura de dados que se pode utilizar para representar o tabuleiro do jogo de labirinto?**

Uma matriz (array bidimensional) de caracteres.

2. **Como podemos preencher os obstáculos (paredes internas) no tabuleiro do jogo, de forma que toda vez que se jogue, um novo tabuleiro seja mostrado?**

Usando a função `Math.random`.

## Parte 2 - Recursão

### Atividade 1

1. **Altere sua implementação do programa Labirinto para apresentar o tabuleiro com as posições de início e destino, como mostrado nesta parte da aula. Tente não copiar o código mostrado, mas fazer sem olhar o material da aula. Relate se você conseguiu fazer a implementação sem copiar, se você fez algo de diferente em termos de implementação ou se a sua implementação ficou igual à mostrada na aula.**

A implementação foi equivalente à da aula.

2. **Execute várias vezes o programa Labirinto e relate se houve mudanças na posição dos pontos de início e destino do labirinto.**

Os pontos de início e destino são trocados em cada nova execução, assim como as posições dos obstáculos.

3. **Teste o uso de outros caracteres para as constantes de INICIO e DESTINO usadas no programa e indique se você encontrou valores mais adequados (para deixar o tabuleiro mais bonito, mais simples de ser visualizado etc. que os mostrados na aula).**

Foram utilizados os caracteres `o` e `*` para representar o início e o destino, respectivamente.

4. **Altere a função "inicializarMatriz()" para posicionar o caractere de início na parte inferior à esquerda do tabuleiro, e para posicionar o caractere de destino na parte superior à direita do tabuleiro. Execute e confira se sua implementação está correta.**

Foi adicionado um parâmetro booleano à função, cujo valor indica se os pontos de início e destino devem ser randomizados. Um simples `if`/`else` no corpo da função seleciona as coordenadas desses pontos, conforme o valor do parâmetro.

### Atividade 2

1. **Altere sua implementação do programa Labirinto para ele procurar e mostrar um caminho válido, como mostrado nesta última parte da aula. Tente não copiar o código mostrado, mas fazer sem olhar o material da aula. Relate se você conseguiu fazer a implementação sem copiar, se você fez algo de diferente em termos de implementação ou se a sua implementação ficou igual à mostrada na aula.**

[...]

2. **Execute várias vezes o programa Labirinto e relate se houve mudanças na posição dos pontos de início e destino e nos caminhos encontrados. Eles foram os menores caminhos possíveis dentro do tabuleiro? Sempre foi possível encontrar caminhos válidos?**

[...]

3. **Teste o uso de outros caracteres para as constantes de CAMINHO e SEM_SAIDA usadas no programa e indique se você encontrou valores mais adequados (para deixar o tabuleiro mais bonito, mais simples de ser visualizado etc.) que os mostrados na aula.**

[...]

4. **Altere o tempo em "milissegundo"s do comando "Thread.sleep()" para mais e para menos. Relate o que acontece com essas mudanças, e qual seria o melhor valor para você poder acompanhar a execução do algoritmo de busca.**

[...]

### Autoavaliação

1. **Qual a ideia do uso da recursão utilizada na programação do programa Labirinto?**

[...]

2. **Na sua opinião, códigos que utilizam recursão são intuitivos? Você conseguiu entender facilmente o código recursivo do programa Labirinto?**

[...]
