/*Contar as ocorrencias de X em uma lista*/
conta(X,[],0).
conta(X,[X|Y],N) :- conta(X,Y,N1), N is N1+1 , !.
conta(X,[_|Y],N) :- conta(X,Y,N1), N is N1.

/*Contar vogais*/
v(a).
v(e).
v(i).
v(o).
v(u).
contaV([],0).
contaV([H|T],N) :- v(H), contaV(T,N1), N is N1+1, !.
contaV([_|T],N) :- contaV(T,N).

/*Somar elementos de uma lista*/
somalista([],0).
somalista([H|T],N) :- somalista(T,N1), N is N1+H.

/*Duplicar as vogais de uma lista*/
v(a).
v(e).
v(i).
v(o).
v(u).
dupv([],[]).
dupv([H|To],[H,H|Td]) :- v(H), dupv(To,Td), !.
dupv([H|To],[H|Td]) :- dupv(To,Td). 

/*Duplicar as consoantes de uma lista*/
v(a). 
v(e).
v(i).
v(o).
v(u).
dupc([],[]).
dupc([H|To],[H|Td]) :- v(H), dupc(To,Td). 
dupc([H|To],[H,H|Td]) :- dupc(To,Td),!.

/*Dada uma lista de pares, determina o somatorio do maior elemento do par
  EXEMPLO: somamaior(X,[[1,2],[3,1],[4,2]]) X= 6 */
somaM([],0).
somaM([[A|B]|T],X) :- A>B, somaM(T,X1), X is X1+A ,!; somaM(T,X1), X is X1+B.

/*Separar um lista em maiores e menores que o head (gera duas novas listas)*/
separar([],[],[],_).
separar([X],[X],[],K) :- X > K,!.
separar([X],[],[X],K) :- X < K,!.
separar([H|T],[H|Tma],Menor,K):- K < H, separar(T,Tma,Menor,K), ! .
separar([H|T],Maior,[H|Tme],K):- K >= H, separar(T,Maior,Tme,K), ! .
resultado_separa([H|T],Lma,Lme):- separar([H|T],Lma,Lme,H).

/*Linearizar uma lista*/
conc([],X,X).
conc([X|Y],Z,[X|W]) :- conc(Y,Z,W).
linear(L,[L]).
linear([],[]) :- !.
linear([L|Ls],ListL) :- !, linear(L,NewL), linear(Ls,News), conc(NewL, News, ListL).

/*Remover o k-ésimo elemento de uma lista*/
insereinicio(H,L,[H|L]):-!.
removeindice(0,[_|T],T):-!.
removeindice(I,[H|T],R):- X is I-1, removeindice(X,T,Y) , insereinicio(H,Y,R).

/*Determinar a posicao de 8 rainhas “seguras” em um tabuleiro 8x8*/
naoatacar(_,[]).
naoatacar(X/Y,[X1/Y1|Z]) :- Y =\= Y1, Y1 - Y =\= X1 - X, Y1 - Y =\= X - X1, naoatacar(X/Y,Z).
member(Item,[Item|Resto]).
member(Item,[Primeira|Resto]) :- member(Item,Resto).
tabuleiro([1/Y1,2/Y2,3/Y3,4/Y4,5/Y5,6/Y6,7/Y7,8/Y8]).
segura([]).
segura([X/Y|Z]) :- segura(Z), member(Y,[1,2,3,4,5,6,7,8]), naoatacar(X/Y,Z).
