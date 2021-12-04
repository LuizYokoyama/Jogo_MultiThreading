# Jogo MultiThreading
Jogo desenvolvido para a disciplina de Algoritmos e Programação 2 do meu curso de Engenharia de Computação na UFG

Este jogo foi desenvolvido com a interface gráfica Java Swing e multithreading.

Assim cada uma das diversas naves e cada tiro é um thread diferente. Cada thread
“nave Tie Fighter” precisa ler a posição na tela dos seus threads “tiros” e comparar com a
posição da nave inimiga para saber se ela foi “atingida” e, depois, passar essa informação
para a nave correspondente para que ela possa “explodir”.
Como todos os threads devem estar sincronizados, então cada thread se auto-bloqueia
através do método suspend() para aguardar que outro thread o acorde, com o método
resume() , após atualizar sua posição na tela.

Como foi ultilizada a IDE NetBeans, também estão incluídos os arquivos gerados por ela.

Para rodar o jogo, basta executar o projeto no NetBeans.

Todas as imagens e sons foram adapdados a partir de fontes disponíveis na internet. 

Exemplo de tela do jogo:

![image](https://user-images.githubusercontent.com/95327592/144541209-2ea547e2-911a-4609-b27b-97e97d5f4a67.png)
