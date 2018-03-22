# Trabalho de Linguagens Formais e Automatos
### Alunos: Alexandre Thurow, Gabriel Todesco, Gustavo Merini

# kmRegex - ^([0-9]{1,3}\\.[0-9]{3}|[0-9]{1,3})$

* números que iniciam 0-9(pois existe o KM 0) separados por "." quando forem milhares ou números que iniciam de 0-9 com menor igual a 3 casas

# yearRegex - ^\\d{4}$

* qualquer número com 4 digitos

# engineRegex - ^([1-9]['.'][0-9])$

* Iniciado com um digito de 1-9 seguido por "." e seguido de um número de 0-9

# checkZero_Digit - ^[0]

* Match no caracter "0" na primeira posição da String, é usado apenas dentro do if de verificação de números

# fuelRegex - ^(Álcool|Biocombustível|Diesel|Gasolina)$

* Match apenas nas palavras(case sensitive/acento sensitive): Álcool, Biocombustível, Diesel, Gasolina

# symbolRegex - ^([Á]|[B]|[D]|[G]|[R]);

* Match nos caracteres(case sensitive/acento sensitive) que se iniciam em: Á,B,D,G,R
# valueRegex - ^(R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2}|R\\$[0-9]{1,3}\\,[0-9]{2});/// (R\\$[0-9]{1,3}\\.[0-9]{3}\\,[0-9]{2});

* Match nos valores válidos, R$20,00 R$0,32
# invalidValueRegex - (R\\$[0]{2,}|R\\$[0]\\,[0]{2,}|R\\$[0]{1,}[1-9]);

* Match nos valores considerados inválidos - R$01,00 R$00,00

# isFuelRegex - ^([Á]|[B]|[D]|[G]);

* Match em String que se iniciam com os caracteres(case sensitive/acento sensitive): Á, B, D, G . É usado para saber quando estamos tratando com um possivel Combustível
# isValueRegex - ^R\\$;

* Match em String iniciados em "R$", usado para saber se é dinheiro.
