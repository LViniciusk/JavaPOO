Intro
Você deverá implementar a classe Pessoa e a class Moto.
Iniciar
A moto inicia com 1 de potência, sem minutos e sem ninguém.
Subir
Só pode estar uma pessoa na moto por vez. Para subir, informe nome e idade de quem está subindo.
Descer
Só pode descer se tiver alguém na moto.
Comprar tempo
O tempo em minutos é comprado e enquanto houver tempo, qualquer pessoa pode dirigir.
Dirigir tempo
Se houver uma pessoa com 10 anos ou menos e houver minutos, então ela pode passear de moto.
Se o tempo acabar no meio do passeio, informe o quanto a pessoa andou.
Buzinar
Qualquer pessoa pode buzinar(honk)
O barulho da buzina é “Pem”, porém o número de e é igual ao valor da potência.
Ex: se a potência for 5, buzinar deve gerar: Peeeeem
Draft
Solver.java
solver.cpp
solver.ts
Guide
diagrama
diagrama
class Motorcycle {
  - person : Person | null
  - power  : int
  - time   : int
  __
  
  ' a moto inicia com 1 de potência, sem minutos e sem ninguém
  + Motorcycle(power : int)
  '
  ' só pode estar uma pessoa na moto por vez
  ' para subir, informe nome e idade de quem está subindo
  + insertPerson(person : Person) : boolean
  
  ' só pode descer se estiver alguém na moto
  + remove() : Person | null
  + buyTime(time : int)
  
  ' só pessoas de 10 anos ou menos podem passear na moto
  ' uma pessoa só pode passear na moto se a moto estiver tempo
  ' se o tempo acabar no meio do passeio, informe o quanto a pessoa andou
  + drive(time : int)
  
  ' qualquer pessoa pode buzinar a moto
  ' o barulho da buzina é "Pem"
  ' o "e" deve ser repetido power vezes
  + honk()
  __
  + getPerson() : Person
  + getPower()  : int
  + getTime()   : int
  __
  
  ' retorna o tempo, potencia e o nome da pessoa
  ' ex: power:5, time:0, person:(marcos:4)
  + toString()  : string
}
  
class Person {
  - age  : int
  - name : string
  __
  + Person(name : string, age : int)
  __
  + getAge()  : int
  + getName() : string
  __
  
  ' retorna o nome e a idade da pessoa
  ' nome:idade
  + toString() : string
}
Lembre de inicializar o objeto Pessoa antes de chamar o método embarcar.
Para buzinar, utilize o for gerando várias vezes o e.
Shell

#__case subindo e buzinando
$show
power:1, time:0, person:(empty)

#__case subindo
$enter marcos 4
$show
power:1, time:0, person:(marcos:4)

#__case ocupada
$enter marisa 2
fail: busy motorcycle

$show
power:1, time:0, person:(marcos:4)
$end
#__case subindo2
$init 5
$show
power:5, time:0, person:(empty)

#__case buzinando
$enter marcos 4
$show
power:5, time:0, person:(marcos:4)
$end
#__case subindo e trocando
$init 7
$enter heitor 6
$show
power:7, time:0, person:(heitor:6)
$leave
heitor:6

#__case empty
$leave
fail: empty motorcycle

#__case replace
$enter suzana 8
$show
power:7, time:0, person:(suzana:8)
$end
#__case no time
$init 7
$buy 30
$show
power:7, time:30, person:(empty)
$buy 10
$show
power:7, time:40, person:(empty)
$end
#__case buy time 
$init 7
$drive 10
fail: buy time first
$buy 50
#__case empty
$drive 10
fail: empty motorcycle
$enter suzana 8

#__case driving
$drive 30
$show
power:7, time:20, person:(suzana:8)
$end
#__case limite de idade
$init 7
$buy 20
$enter andreina 23
$drive 15
fail: too old to drive
$show
power:7, time:20, person:(andreina:23)
$end
#__case acabou o tempo
$init 7
$buy 20
$enter andreina 6
$drive 15
$show
power:7, time:5, person:(andreina:6)
$drive 10
fail: time finished after 5 minutes
$show
power:7, time:0, person:(andreina:6)
$end
#__case buzinando
$init 1
$honk
Pem
$init 5
$honk
Peeeeem
$end