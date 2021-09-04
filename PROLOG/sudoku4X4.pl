/*Valores válidos*/
num(1).
num(2).
num(3).
num(4).


/*Regras do sudoku*/
diferente(A,B,C,D) :- num(A), num(B), num(C), num(D), A \= B, A \= C, A \= D, B \= C, B \= D, C \= D.

/*Imprime posições equivalentes*/
/*Cada lista representa uma linha*/
sudoku([[L1C1, L1C2, L1C3, L1C4],[L2C1, L2C2, L2C3, L2C4],[L3C1, L3C2, L3C3, L3C4],[L4C1, L4C2, L4C3, L4C4]]):- 
  
  /*verifica elementos linhas*/
  diferente(L1C1, L1C2, L1C3, L1C4), 
  diferente(L2C1, L2C2, L2C3, L2C4), 
  diferente(L3C1, L3C2, L3C3, L3C4), 
  diferente(L4C1, L4C2, L4C3, L4C4),
  
  /*verifica elementos colunas*/
  diferente(L1C1, L2C1, L3C1, L4C1), 
  diferente(L1C2, L2C2, L3C2, L4C2), 
  diferente(L1C3, L2C3, L3C3, L4C3), 
  diferente(L1C4, L2C4, L3C4, L4C4),
  
  /*verifica elementos blocos*/
  diferente(L1C1, L1C2, L2C1, L2C2), 
  diferente(L1C3, L1C4, L2C3, L2C4), 
  diferente(L3C1, L3C2, L4C1, L4C2), 
  diferente(L3C3, L3C4, L4C3, L4C4). 
