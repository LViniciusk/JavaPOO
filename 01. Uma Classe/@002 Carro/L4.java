// passou em todos os testes
// Fiz sozinho
// Levei alguns minutos pra fazer, n lembro com precisão

//OBS: usei a base do github e só implementei as funções :D






import java.util.*;


class Carro{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem

    public Carro() {
        this.pass = 0;
        this.passMax = 2;
        this.km = 0;
        this.gas = 0;
        this.gasMax = 100;
    }

    public void enter() {
        if(this.pass < this.passMax) this.pass++;
        else System.out.println("fail: limite de pessoas atingido");
    }

    public void leave() {
        if(this.pass > 0) this.pass--;
        else System.out.println("fail: nao ha ninguem no carro");
    }
    
    public void fuel(int gas) {
        if(gas > this.gasMax) this.gas = this.gasMax;
        else this.gas += gas;
    }

    public void drive (int km) {
        if(this.pass > 0){
            if(km > this.gas && this.gas > 0){
                System.out.println("fail: tanque vazio apos andar " + this.gas +" km");
                this.km += this.gas;
                this.gas = 0;
                
            }else if(this.gas == 0) System.out.println("fail: tanque vazio");
            else{
                this.km += km;
                this.gas -= km;
            }    
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
         
    }    
}



class L4{
    public static void main (String[] args) {
        Carro car = new Carro();
        
        while (true) {
            
            var line = input();
            write("$" + line);
            var argsa = line.split(" ");

            if      (argsa[0].equals("end"))   { break; }
            else if (argsa[0].equals("show"))  { System.out.printf("pass: %d, gas: %d, km: %d\n", car.pass, car.gas, car.km); }
            else if (argsa[0].equals("enter")) { car.enter(); }
            else if (argsa[0].equals("leave")) { car.leave(); }
            else if (argsa[0].equals("drive")) { car.drive((int) number(argsa[1])); }
            else if (argsa[0].equals("fuel"))  { car.fuel((int) number(argsa[1])); }
            else { write("fail: comando invalido"); }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
    }
