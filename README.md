# tamagotchi-lp1
Projeto final da matéria Linguagem de Programação 1.
---
### *__Alunos__* 
Num | Nome | Matrícula
-|-|-
1 | Lucas Rondineli Lucena Fragoso | 20220005932
2 | Luiz Gustavo Paixão da Gama | 20220005834

Disciplina | Linguagem de Programação I
Professora | Danielle Rousey Dias Ricarte

<h1>Introdução</h1>  
O projeto em questão é uma reimaginação de um Tamagotchi, o mascote virtual que foi famoso nos anos 90, onde o usuário o levava no bolso para qualquer lugar e deveria suprir as necessidades do mascote para mantê-lo vivo.<p>
  O tamagotchi criado tem 4 necessidades: a fome, a felicidade, a limpeza e a energia, cada uma delas tem o nível de 0 a 100, a fome começa com 0, enquanto a felicidade, limpeza e energia começa com 100. Caso alguma delas atinja o valor crítico (100 para a fome e 0 para os demais), o Tamagotchi morre.<p>
  A criação deste projeto utilizou threads para a atualização constante dos dados na tela do usuário, animações feitas frame por frame pelo grupo e também foram utilizados áudios para manter a experiência do Tamagotchi mais parecida o possível com o original.

# Packages e Classes: 
O programa conta 5 packages, com 25 classes e uma interface.
Cada package junta as classes de acordo com a sua função no projeto para facilitar a legibilidade do código

## Package criatura : 
Agrupa o conjunto de classes que trabalha com a criação do tamagotchi, bem como as threads e status da animação, 

<h3>AnimacaoRunnable:</h3> 
Essa classe implementa a interface Runnable, que cria uma thread para executar uma tarefa em paralelo, essa thread verifica o estado, se está vivo ou morto, caso esteja vivo, executa a animação relativa ao Tamagotchi naquele momento;

<h3>StatusRunnable::</h3> 
Assim como a classe anterior, essa também implementa a interface Runnable e utiliza o método “cicloDosStatus” para atualizar os status dos pet, diminuindo aumentando continuamente a fome e diminuindo a felicidade, energia e limpeza.;

### TamagotchiBase: 
É uma classe abstrata que engloba todos os atributos do Tamagotchi, como todos os atributos máximos e mínimos das necessidades, assim como dados relativos ao nome do Tamagotchi, o tempo em que cada thread é executada, entre outras funções, essa classe também instancia o AnimaçãoRunnable e StatusRunnable. 
Essa classe também tem os métodos que iniciam as animações e os status (iniciar, alimentar, brincar, dormir, matar e reiniciar), cada um desses métodos modifica as necessidades de acordo com a ação desejada.
	O método cicloDosStatus é utilizado continuamente para atualizar todos os dados do tamagotchi ao mesmo tempo.
void cicloDosStatus() {
   this.fome++;
   this.felicidade--;
   this.energia--;
   this.limpeza--;
}


### TamagotchiUrso e TamagotchiSapo:
	São duas classes que herdam de TamagotchiBase e servem para criar o tamagotchi desejado, a diferença entre os dois tamagotchis é que cada um deles possui uma animação única.

## Package animacao: 
Esse pacote reúne o conjunto de classes relativas a animação. Cada ação do tamagotchi tem uma animação diferente com diversos frames. Cada frame foi feito totalmente pelo grupo dentro das classes com base nas animações dos tamagotchis originais 

### IAnimacao: 
É uma interface que tem como constantes o tempo de cada animação, bem como os métodos: parado(), comendo(), brincando(), dormindo(), limpado(), morto(), mostrarStatus(), limpaTela(); esperar() e reiniciarSom(). Esse métodos foram adicionandos em uma interface para garantir que sejam incorporadas obrigatoriamente nas classes que venham implementar essa interface.

## Package animacao.sapinho e animacao.ursinho: 
esses pacotes agrupam todas as classes relativas a animação e frames dos tamagotchis, o conteúdo desses pacotes possui classes parecidas, o que difere em cada uma delas é que a primeira se refere às animações do sapo e a outra se refere ao urso.

### Brincar, Comer, Coco, Dormir, Limpar, Padrao, Maca e Morrer: 
Todas essas classes servem para armazenar os frames do urso e do sapo, cada método estático representa um frame que será utilizado nos métodos das classes AnimacaoSapo e AnimacaoUrso.

### AnimacaoSapo e AnimacaoUrso: 
Essas classes implementam a interface IAnimacao e Serializable (classe que marca o arquivo como seriálizável em uma sequência de bytes para salvá-lo em arquivo posteriormente. São nessas classes que cada animação é executada manualmente através da chamada do método estático.<p>
Enquanto o Tamagotchi não estiver executando nenhuma ação, as animações da classe “Padrao” são executadas continuamente. Caso o usuário selecione alguma opção, essa ação é executada e após sua execução, o Tamagotchi volta para o seu movimento padrão. AnimacaoUrso e AnimacaoSapo também instanciam a classe “Som”, que executa determinados sons em cada animação<p>
Junto com o frame, também é exibido o status do Tamagotchi e o menu de opções através do método “mostrarStatus()”, Logo em seguida a thread atualiza através do método “esperar()”, que recebe tempo em que será atualizada, trazendo o próximo frame.<p>
Antes de cada frame, é utilizado o método “limpaTela()”, que limpa o terminal através de uma sequência de caracteres de escape, o que permite que a animação seja executada sempre de forma limpa no prompt de comando.<p>
*public void limpaTela() {<p>
   System.out.print("\033[H\033[2J");<p>
   System.out.flush();<p>
}*

Essas três funções (mostrarStatus, esperar e limpaTela) foram incluídas no método “cicloDeAnimacao” para facilitar a legibilidade do código e é executada após cada frame:
SapoPadrao.padrao1();
cicloDeAnimacao(tempoDoFrame);

## Package tools: 
conjunto de ferramentas utilizadas no projeto para auxiliar na resolução de problemas.

### FolderFinder:
	Classse utilizada para…
### Validator:
	Classe utilizada para….

## Package controle: 
esse pacote contém uma única classe que serve para controlar o uso do Tamagotchi.

### Entrada: 
  A classe Entrada contém o método main do projeto e instancia um Validator, TamagotchiBase e tem um atributo de caminhoDosDados (obtido através da classe FolderFinder) e um atributo “opt”, que irá receber as opções de ação do Tamagotchi.<p>
  Primeiramente, é verificado se há algum Tamagotchi salvo, se houver, ele é recuperado da memória e executado, se não houver, é criado um novo no diretório especificado pela string “caminhoDeDados”.<p>
  O segundo passo é atribuir um nome ao Tamagotchi, utilizando a classe Validator para verificar se a string está dentro dos parâmetros, ao ser criado, o usuário escolhe se deseja criar um Tamagotchi Sapinho ou Tamagotchi Ursinho e então, começa o ciclo de animações e dos status, recebendo continuamente as ações do Tamagotchi.<p>
  A opção 1) alimentar zera os status de fome, enquanto 2) brincar, 3)banheiro e 4) dormir recuperam respectivamente os status de felicidade, limpeza e energia para 100. Caso algum desses valores atinja o ponto crítico, o programa é finalizado. Se o usuário selecionar a opção 0) Sair enquanto o Tamagotchi está vivo, ele é salvo em um arquivo e será aberto automaticamente na próxima vez que o projeto é executado.

