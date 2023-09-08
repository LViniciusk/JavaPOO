// Fiz tudo e passou em todos os testes
// Fiz sozinho
// Levei alguns minutos pra fazer, n lembro com precisão


import java.util.Scanner;

class Aluno{
    String nome;
    float n1, n2, n3;
    
    void ler(){
        Scanner in = new Scanner(System.in);
        nome = in.nextLine();
        n1 = Float.parseFloat(in.nextLine());
        n2 = Float.parseFloat(in.nextLine());
        n3 = Float.parseFloat(in.nextLine());
    }
    
    float calculaMedia(){
        return (n1+n2+n3)/3;
    }
}


class L2{
    public static void main (String[] args) {
        Aluno al = new Aluno();
        
        al.ler();
        System.out.printf("%.2f\n",  al.calculaMedia()); 
    }
}