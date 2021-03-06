# Lista 04 - Exerc�cio 04
# Alunos: Pedro Henrique Resende Ribeiro - 12011BCC004
#         Kemuel Santos Peres  - 11811BCC035
#         Nayara Terezinha Nunes - 11911BCC006

pinguins <- read.csv(file = "penguins_size.csv", header = TRUE, sep = ",")
str(pinguins)

# LETRA A - C�LCULO DO PESO M�DIO, TAMANHO M�DIO DA ASA E DESVIO PADR�O

peso_medio <- mean(pinguins$body_mass_g, na.rm = TRUE)
peso_medio
desvio_peso <- sd(pinguins$body_mass_g, na.rm = TRUE)
desvio_peso

asa_media <- mean(pinguins$flipper_length_mm, na.rm = TRUE)
asa_media
desvio_asa <- sd(pinguins$flipper_length_mm, na.rm = TRUE)
desvio_asa

# LETRA B - C�LCULO DAS VARI�VEIS ANTERIORES POR ESP�CIE

# pm = peso m�dio e dpm = desvio peso m�dio
# am = asa m�dia e dam = desvio asa m�dia

adelie <- pinguins[pinguins$species == "Adelie", ]
chinstrap <- pinguins[pinguins$species == "Chinstrap", ]
gentoo <- pinguins[pinguins$species == "Gentoo", ]

pm_adelie <- mean(adelie$body_mass_g, na.rm = TRUE)
pm_adelie
dpm_adelie <- sd(adelie$body_mass_g, na.rm = TRUE)
dpm_adelie

am_adelie <- mean(adelie$flipper_length_mm, na.rm = TRUE)
am_adelie
dam_adelie <- sd(adelie$flipper_length_mm, na.rm = TRUE)
dam_adelie

pm_chinstrap <- mean(chinstrap$body_mass_g, na.rm = TRUE)
pm_chinstrap
dpm_chinstrap <- sd(chinstrap$body_mass_g, na.rm = TRUE)
dpm_chinstrap

am_chinstrap <- mean(chinstrap$flipper_length_mm, na.rm = TRUE)
am_chinstrap
dam_chinstrap <- sd(chinstrap$flipper_length_mm, na.rm = TRUE)
dam_chinstrap

pm_gentoo <- mean(gentoo$body_mass_g, na.rm = TRUE)
pm_gentoo
dpm_gentoo <- sd(gentoo$body_mass_g, na.rm = TRUE)
dpm_gentoo

am_gentoo <- mean(gentoo$flipper_length_mm, na.rm = TRUE)
am_gentoo
dam_gentoo <- sd(gentoo$flipper_length_mm, na.rm = TRUE)
dam_gentoo

# COMENT�RIO
# Com rela��o ao peso m�dio, fica evidente que a esp�cie Gentoo possui
# um peso m�dio maior do que os das esp�cies Adelie e Chinstrap. Isso
# faz com que a m�dia de todas as esp�cies se localize em um valor
# intermedi�rio a 3700 (peso m�dio das esp�cies Adelie e Chinstrap) e
# 5076 (peso m�dio da esp�cie Gentoo). Calcular a m�dia apenas das
# esp�cies Adelie e Chinstrap produz um valor mais correto do que o valor
# m�dio das 3 esp�cies juntas.
# Com rela��o ao tamanho m�dio da asa, pode-se considerar que a m�dia
# conjunta das 3 esp�cies n�o produzir� um resultado muito confi�vel
# pelo fato de que os valores m�dios para cada esp�cie s�o diferentes uns
# dos outros. O tamanho m�dio da asa para as esp�cies Adelies e Chinstrap
# se interceptam quando o desvio padr�o � considerado, por�m o valor para
# a asa da esp�cie Gentoo fica fora do valor m�dio das outras duas esp�cies.

# LETRA C - C�LCULO DO PESO E DO TAMANHO DA ASA M�DIO CONSIDERANDO O SEXO

macho <- pinguins[pinguins$sex == "MALE", ]
femea <- pinguins[pinguins$sex == "FEMALE", ]

pm_macho <- mean(macho$body_mass_g, na.rm = TRUE)
pm_macho
dpm_macho <- sd(macho$body_mass_g, na.rm = TRUE)
dpm_macho

am_macho <- mean(macho$flipper_length_mm, na.rm = TRUE)
am_macho
dam_macho <- sd(macho$flipper_length_mm, na.rm = TRUE)
dam_macho

pm_femea <- mean(femea$body_mass_g, na.rm = TRUE)
pm_femea
dpm_femea <- sd(femea$body_mass_g, na.rm = TRUE)
dpm_femea

am_femea <- mean(femea$flipper_length_mm, na.rm = TRUE)
am_femea
dam_femea <- sd(femea$flipper_length_mm, na.rm = TRUE)
dam_femea

# COMENT�RIO
# Calcular o peso m�dio avaliando apenas o sexo (macho) n�o resulta em
# um valor muito confi�vel. Considerando que o desvio padr�o foi de
# aproximadamente 17% do valor do peso m�dio, pode-se concluir que a
# amostra possui uma grande dispers�o. Como j� notado, os pinguins da
# esp�cie Gentoo s�o mais pesados, contribuindo para o aumento do peso
# m�dio. Com rela��o ao valor do tamanho m�dio da asa, considerando que
# o desvio padr�o representa cerca de 7% do valor m�dio do tamanho da asa,
# percebe-se que a amostra, para este caso, � um pouco menos dispersa.
# Para o peso m�dio e o tamanho m�dio da asa para as f�meas, a conclus�o
# � semelhante ao explicado para os machos.

# LETRA D - GR�FICO DO TAMANHO DA ASA VERSUS PESO

# Identifica��o de dados inv�lidos
indices_asa <- is.na(pinguins$flipper_length_mm)
indices_peso <- is.na(pinguins$body_mass_g)

asa <- c()
peso <- c()
j <- 1

# Remo��o de dados inv�lidos
for(i in 1:length(pinguins$species)){
  
  if(indices_asa[i] == FALSE & indices_peso[i] == FALSE){
    
    asa[j] <- pinguins$flipper_length_mm[i]
    peso[j] <- pinguins$body_mass_g[i]
    j <- j + 1
    
  }
  
}

# Neste caso: (somente dados v�lidos)
# asa = pinguins$flipper_length_mm
# peso = pinguins$body_mass_g
plot(asa, peso, pch = 16)

# LETRA E - CORRELA��O ENTRE TAMANHO DA ASA E PESO

# Neste caso: (somente dados v�lidos)
# asa = pinguins$flipper_length_mm
# peso = pinguins$body_mass_g
r <- cor(asa, peso)
r

# LETRA F - AN�LISE DO GR�FICO E DA CORRELA��O

# COMENT�RIO
# Pode-se perceber, atrav�s do gr�fico e do valor de r dado pela fun��o cor
# que existe uma correla��o entre o tamanho da asa e o peso dos pinguins e
# que � uma correla��o forte, pois r = 0.8712 > 0.75. Al�m disso, pode-se
# concluir que a correla��o � positiva, pois, quando o valor da asa aumenta
# o peso do pinguim tamb�m aumenta.

# LETRA G - CRIA��O DA RETA MODELO DE REGRESS�O LINEAR

# Neste caso: (somente dados v�lidos)
# asa = pinguins$flipper_length_mm
# peso = pinguins$body_mass_g
fit <- lm(peso ~ asa)
fit

plot(asa, peso, pch = 16, title("Regress�o linear simples"))
abline(fit, col = "red", lwd = 2)

# LETRA H - EXPLICAR COEFICIENTE ANGULAR

# COMENT�RIO
# O coeficiente angular significa o quanto ser� incrementada a vari�vel
# dependente se a vari�vel independente for incrementada de 1 unidade.
# Neste caso, quando o tamanho da asa aumenta de 1 mm, o peso do
# pinguim � incrementado de aproximadamente 49,5 gramas.

# LETRA I - ESTIMATIVA PARA ASA = 204 MM E 168 MM

min(asa) # min = 172 mm
max(asa) # max = 231 mm

a <- as.numeric(fit$coefficients[1])
b <- as.numeric(fit$coefficients[2])

# Peso m�dio de um pinguim com asa = 204 mm
peso_204 <- a + b * 204
peso_204

# COMENT�RIO
# N�o � poss�vel estimar o peso de um pinguim que possui uma asa com
# tamanho igual a 168 mm. Isso se deve pelo fato de que o modelo obtido
# tem os dados no intervalo [172,231]. Qualquer valor fora deste intervalo
# n�o pode ser estimado com confian�a.
