% MASTER MIND %
% EXISTEM 6 VARIAVEIS
% SEGREDO = MASTER escolhe uma quadra ordenada 
% OBJETIVO = descobrir o segredo
% JOGADOR = chuta uma senha e recebe uma dica [R,W]
% R = Um pino vermelho para cada acerto completo
% W = Um pino branco para cada cor correta

cor(1).
cor(2).
cor(3).
cor(4).
cor(5).
cor(6).

%Verifica pino VERMELHO
certo([],[],0) :- !.
certo([Hsenha|Tsenha],[Hchute|Tchute],R) :-
    Hsenha =:= Hchute, 
    certo(Tsenha,Tchute,R1), R is R1+1,!;
    certo(Tsenha,Tchute,R).

%Verifica pino BRANCO
certocor([],_,0) :- !.
certocor([Hsenha|Tsenha],Chute,W) :-
    member(Hsenha,Chute), 
    certocor(Tsenha,Chute,W1), W is W1+1,!;
    certocor(Tsenha,Chute,W).

%Dada uma senha (lista de 4 cores) e um chute, gerar a dica (lista:[R,W])
master(Lsenha,Lchute,[R,W]) :-
    certo(Lsenha,Lchute,R), 
    certocor(Lsenha,Lchute,W1), 
    % OU EXCLUSIVO soh eh branco se n vermelho
    W is W1-R. 

%Dada uma dica e chute, gerar uma lista de possibilidades
adv([R1,W1],Chute,[T1,T2,T3,T4]) :-
    cor(T1), cor(T2), cor(T3), cor(T4), 
    %manda todas as possibilidades recebe todas as dicas[R,W] possiveis
    master([T1,T2,T3,T4],Chute,[R,W]), 
    %verifica se as dicas conferem
    R is R1, W is W1. 
    
%Dado uma lista de dicas e chutes, gerar um lista de possibilidades
adv3([],[],_). %caso base
adv3([[R1,W1]|TD],[Chute|TC],T) :- adv([R1,W1],Chute,T), adv3(TD,TC,T).
