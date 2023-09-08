// 30/08/2023 09:03 - Criei o arquivo;
// 30/08/2023 09:03 - Usei a base do Github :D
// 30/08/2023 09:36 - Finalizado

// Fiz Sozinho e passou em todos os testes
// Usei a base do Github e implementei a logica das funções :D
// Fiz em 33 Minutos :]





import java.util.*;

class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String toString(){
        return this.name+":"+this.age;    
    }
}

class Motorcycle {
    private Person person = null; //agregacao
    private int power = 1;
    private int time = 0;
    
    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power){
        this.power = power;
        this.time = 0;
        this.person = null;
    }
    public int getPower() {
        return this.power;
    }
    public int getTime() {
        return this.time;
    }
    public Person getPerson() {
        return this.person;
    }
    //Comprar mais tempo
    public void buy(int time){
        this.time += time;
    }
    
    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean enter(Person person) {
        if(this.person == null){
            this.person = person;
            return true;
        }
        System.out.println("fail: busy motorcycle");
        return false;
    }
    public Person leave() {
        if(this.person != null){
            System.out.println(this.person);
            this.person = null;
            return person;
        }
        System.out.println("fail: empty motorcycle");
        return person;
    }
    public void drive(int time){
        if(this.time == 0){
            System.out.println("fail: buy time first");
        }else if(this.person == null){
            System.out.println("fail: empty motorcycle");
        }else if(this.person.getAge() > 10){
            System.out.println("fail: too old to drive");
        }else if(time > this.time){
            System.out.printf("fail: time finished after %d minutes\n", time-this.time);
            this.time = 0;
        }else{
            this.time -= time;
        }
        
    }
    //buzinar
    public void honk(){
        System.out.print("P");
        for(int i = 0; i < power; i++){
            System.out.print("e");
        }
        System.out.println("m");
    }
    
    public String toString(){
        if(this.person == null) return "power:"+this.power+", time:" + this.time+", person:(empty)";
        return "power:"+this.power+", time:" + this.time+", person:(" + this.person+")";
    }
}
class L10{
    static Motorcycle motoca = new Motorcycle(1);

    public static void main(String[] args) {    
        while(true) {
            String line = input();
            args = line.split(" ");
            write('$' + line);

            if      (args[0].equals("show"))     { System.out.println(motoca);                         }
            else if (args[0].equals("init"))     { motoca = new Motorcycle(number(args[1]));           }  
            else if (args[0].equals("buy"))      { motoca.buy(number(args[1]));                        }
            else if (args[0].equals("drive"))    { motoca.drive(number(args[1]));                      }
            else if (args[0].equals("enter"))    { motoca.enter(new Person(args[1], number(args[2]))); }
            else if (args[0].equals("honk"))     { motoca.honk();                                      }
            else if (args[0].equals("leave"))    {
                Person person = motoca.leave();
                if(person != null) {
                    System.out.println(person.toString());
                }
            }
            else if (args[0].equals("end"))      { break;                                              }
            else
                System.out.println("fail: comando invalido");
        }
        scanner.close();
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static int number(String str)   { return Integer.parseInt(str); }
}