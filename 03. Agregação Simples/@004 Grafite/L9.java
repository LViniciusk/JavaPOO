// passou em todos os testes
// Fiz sozinho
// Levei alguns minutos pra fazer, n lembro com precisão

//OBS: usei a base do github e só implementei as funções :D 


import java.text.DecimalFormat;
import java.util.Scanner;

class Lead {
    private float thickness; //calibre
    private String hardness; //dureza
    private int size; //tamanho em mm

    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public float getThickness() {
        
        return this.thickness;
    }

    public String getHardness() {
        return this.hardness;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int usagePerSheet() {
        if(hardness.equals("HB"))
            return 1;
        else if(hardness.equals("2B"))
            return 2;
        else if(hardness.equals("4B"))
            return 4;
        else
            return 6;
    }

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
}


class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasGrafite() {
        if(this.tip != null) return true;
        else return false;
    }

    public boolean insert(Lead grafite) {
        if(this.tip != null){
            System.out.println("fail: ja existe grafite");
            return false;
        }else{
            if(this.thickness != grafite.getThickness()){
                System.out.println("fail: calibre incompativel");
                
            }else{
                this.tip = grafite;
                return true;
            }
        }
        return false;  
        
    }

     public Lead remove() {
         if(this.tip != null){
            this.tip = null;
            return this.tip;
         }else{
             return null;
         }
         
     }

     public void writePage() {
         if(this.tip != null){
             if(this.tip.getSize() > 10){
                 this.tip.setSize(this.tip.getSize()- this.tip.usagePerSheet());
                 if(this.tip.getSize() < 10){
                     System.out.println("fail: folha incompleta");
                     this.tip.setSize(10);
                     
                 }
                
                
             }else{
                 System.out.println("fail: tamanho insuficiente");
             }
             
             
         }else{
             System.out.println("fail: nao existe grafite");
         }
     }
    
    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}

public class L9 {
    public static void main(String[] args) {
        Pencil lap = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);

            if      ("end".equals(argsL[0])   ) { break;                                                                    }
            else if ("init".equals(argsL[0])  ) { lap = new Pencil(number(argsL[1]));                                       }
            else if ("insert".equals(argsL[0])) { lap.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3]))); }
             else if ("remove".equals(argsL[0])) { lap.remove();                                                             }
             else if ("write".equals(argsL[0]) ) { lap.writePage();                                                          }
            else if ("show".equals(argsL[0])  ) { write(lap.toString());                                                               }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static float number(String str) { return Float.parseFloat(str); }
}