# tamagotchi-lp1
Projeto final da matéria Linguagem de Programação 1.
---
### **Alunos** 
Nome | Matrícula
-|-
Lucas Rondineli Lucena Fragoso | 20220005932
Luiz Gustavo Paixão da Gama | 20220005834
### **Professora**
Nome | Disciplina
-|-
Danielle Rousey Dias Ricarte | Linguagem de Programação I


# Introdução 
O projeto em questão é uma reimaginação de um Tamagotchi, o mascote virtual que foi famoso nos anos 90, onde o usuário o levava no bolso para qualquer lugar e deveria suprir as necessidades do mascote para mantê-lo vivo.
O tamagotchi criado tem 4 necessidades: a fome, a felicidade, a limpeza e a energia, cada uma delas tem o nível de 0 a 100, a fome começa com 0, enquanto a felicidade, limpeza e energia começa com 100. Caso alguma delas atinja o valor crítico (100 para a fome e 0 para os demais), o Tamagotchi morre.
A criação deste projeto utilizou threads para a atualização constante dos dados na tela do usuário, animações feitas frame por frame pelo grupo e também foram utilizados áudios para manter a experiência do Tamagotchi mais parecida o possível com o original.

# Packages e Classes: 
O programa conta 5 packages, com 25 classes e uma interface.
Cada package junta as classes de acordo com a sua função no projeto para facilitar a legibilidade do código.

## Package criatura: 
Agrupa o conjunto de classes que trabalha com a criação do Tamagotchi, bem como as Threads e status da animação.

### AnimacaoRunnable:
Essa classe implementa a interface `Runnable` , que é utilizada por uma `Thread` para executar uma tarefa em paralelo. Essa `Thread` utilizará a `AnimacaoRunnable` para executar a animação relativa ao estado atual na qual o Tamagotchi se encontra enquanto ele estiver vivo, ela é finalizada quando o Tamagotchi morre.

### StatusRunnable: 
Assim como a classe anterior, essa também implementa a interface `Runnable` e é utilizada por outra `Thread`. Esse `Thread` utilizará o método `cicloDosStatus()` para atualizar os status dos pet, aumentando continuamente a fome e diminuindo a felicidade, energia e limpeza.

### TamagotchiBase: 
É uma classe abstrata que engloba todos as constantes do Tamagotchi, assim como todos os seus atributos como nome, fome, se ele está vivo ou não, o tipo da animação utilizada e as Threads que controlam seu estado e animação, onde serão utilizadas a `AnimacaoRunnable` e `StatusRunnable`.
Essa classe também tem os métodos que iniciam suas Threads, que mudam seus status, que redefinem as Threads e sons do Tamagotchi (para quando ele é lido do arquivo), fora mais algumas funções de suporte como getters e setters.
O método `cicloDosStatus()` é utilizado continuamente para atualizar todos os dados do Tamagotchi ao mesmo tempo. Sendo chamado a todo momento que o Tamagotchi está vivo e aguardando um tempo que é dado pela constante `RELOGIO_DOS_STATUS` antes de ser chamado novamente.
```
void cicloDosStatus() {
   this.fome++;
   this.felicidade--;
   this.energia--;
   this.limpeza--;
}
```

### TamagotchiUrso e TamagotchiSapo:
São duas classes que herdam de `TamagotchiBase` e servem para criar o Tamagotchi desejado, a diferença entre os dois Tamagotchis é que cada um deles possui uma animação única.

## Package animacao: 
Esse pacote reúne o conjunto de classes relativas a animação. Cada ação do Tamagotchi tem uma animação diferente com diversos frames. Cada frame foi feito totalmente pelo grupo dentro das classes com base nas animações dos Tamagotchis originais.

### IAnimacao: 
É uma interface que tem como constantes o tempo de cada animação, bem como os métodos: `parado()`, `comendo()`, `brincando()`, `dormindo()`, `limpado()`, `morto()`, `mostrarStatus()`, `limpaTela()`, `esperar()` e `reiniciarSom()`. Esse métodos foram adicionandos em uma interface para garantir que sejam incorporadas obrigatoriamente nas classes que venham implementar essa interface.

## Package animacao.sapinho e animacao.ursinho: 
Esses pacotes agrupam todas as classes relativas a animação e frames dos Tamagotchis, o conteúdo desses pacotes possui classes parecidas, o que difere em cada uma delas é que a primeira se refere às animações do sapo e a outra se refere ao urso.

### Brincar, Comer, Coco, Dormir, Limpar, Padrao, Maca e Morrer: 
Todas essas classes servem para armazenar os frames do urso e do sapo, cada método estático representa um frame que será utilizado nos métodos das classes `AnimacaoSapo` e `AnimacaoUrso`.

### AnimacaoSapo e AnimacaoUrso: 
Essas classes implementam a interface `IAnimacao` e `Serializable` (classe que marca o arquivo como seriálizável em uma sequência de bytes para salvá-lo em arquivo posteriormente). São nessas classes que cada animação é executada manualmente através da chamada do método estático.
Enquanto o Tamagotchi não estiver executando nenhuma ação, as animações da classe “Padrao” são executadas continuamente. Caso o usuário selecione alguma opção, essa ação é executada e após sua execução, o Tamagotchi volta para o seu movimento padrão. `AnimacaoUrso` e `AnimacaoSapo` também instanciam a classe `Som`, que executa determinados sons em cada animação.
Junto com o frame, também é exibido o status do Tamagotchi e o menu de opções através do método `mostrarStatus()`. Logo em seguida a `Thread` atualiza através do método `esperar()`, que recebe tempo em que será atualizada, trazendo o próximo frame.
Antes de cada frame, é utilizado o método `limpaTela()`, que limpa o terminal através de uma sequência de caracteres de escape, o que permite que a animação seja executada sempre de forma limpa no prompt de comando.`
```
public void limpaTela() {
   System.out.print("\033[H\033[2J");
   System.out.flush();
}
```

Essas três funções (`mostrarStatus()`, `esperar()` e `limpaTela()`) foram incluídas no método `cicloDeAnimacao()` para facilitar a legibilidade do código e é executada após cada frame no seguinte formato:
```
SapoPadrao.padrao1();
cicloDeAnimacao(tempoDoFrame);
```

## Package tools: 
Conjunto de ferramentas auxiliares utilizadas no projeto para resolução de alguns problemas. Ambas as classes, apesar de terem padrões de escrita diferentes dos padrões utilizados no projeto, foram criadas pelos membros desse projeto.

### FolderFinder:
Classe utilizada dentro das classes `Entrada` e `Som` para encontrar um diretório específico dentro da pasta de trabalho do usuário, permitindo que o código não necessite mais ser executado apenas dentro de uma diretório específico para que os sons e a escrita/leitura de arquivos funcionem corretamente.
A classe possui apenas métodos estáticos e funciona buscando de forma recursiva pelo diretório *tamagotchi*, dando ao programa o local exato com o caminho absoluto de onde estão os diretórios *tamagotchi\dados* e  *tamagotchi\som\sonsDB*.

### Validator:
Classe utilizada apenas dentro da classe `Entrada` para garantir a entrada correta do usuário.
Ela funciona quase como uma "subclasse" da classe `Scanner`. Ela é composta por alguns métodos que possuem em si um *while* que executa um bloco *try..catch* onde uma mensagem é mostrada ao usuário, uma entrada é recebida utilizando um `Scanner` e, caso a entrada do usuário passe por um teste indicado por um `Predicate` que é passado como parâmetro para seus métodos, a entrada será retornada no fim da função, garantindo assim que o usuário entre apenas com valores desejados. Porém, caso o usuário entre com um valor inválido, esse bloco *try..catch* será executado novamente até que a entrada se torna válida.
O uso dessa classe não era completamente necessário, porém considerando as entradas constantes do usuário que são necessárias, ela permite uma escrita bem mais enxuta de todos os trechos que exigem esse tipo de entrada.

## Package controle: 
Esse pacote contém uma única classe que serve para controlar o uso do Tamagotchi e para dar início ao programa.

### Entrada: 
A classe `Entrada` contém o método `main()` do projeto e instancia um `Validator`, `TamagotchiBase` e tem os atributos de `caminhoDosDados` (obtido através da classe `FolderFinder`) e `opt`, que irá receber as opções de ação do Tamagotchi.
Primeiramente, é verificado se há algum Tamagotchi salvo, se houver, ele é recuperado da memória e executado, se não houver, é criado um novo no diretório especificado pela `String` "`caminhoDeDados`".
O segundo passo é atribuir um nome ao Tamagotchi, utilizando a classe `Validator` para verificar se a `String` está dentro dos parâmetros. Ao ser criado, o usuário escolhe se deseja criar um Tamagotchi Sapinho ou Tamagotchi Ursinho e então, começa o ciclo de animações e dos status, recebendo continuamente as ações do Tamagotchi.
A opção **1) alimentar** zera os status de fome, enquanto **2) brincar**, **3) banheiro** e **4) dormir** recuperam respectivamente os status de felicidade, limpeza e energia para 100. Caso algum desses valores atinja o ponto crítico, o programa é finalizado.
Se o usuário selecionar a opção **0) Sair** enquanto o Tamagotchi está vivo, ele é salvo em um arquivo e será aberto automaticamente na próxima vez que o programa for executado.
