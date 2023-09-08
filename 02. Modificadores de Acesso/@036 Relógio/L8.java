// Salve engano essa tambem ja estava 100% respondida no github, só copiei e colei
// OBS; como dito anteriormente na questão ANIMAL, eu tenho conhecimento do assunto, por isso não vi problema em não refazer




import java.util.*;

class Time {
    private int hour   = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            System.out.println("fail: hora invalida");
        } else {
            this.hour = hour;
        }
    }
    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            System.out.println("fail: minuto invalido");
        } else {
            this.minute = minute;
        }
    }
    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            System.out.println("fail: segundo invalido");
        } else {
            this.second = second;
        }
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }
    public void nextSecond() {
        second++;
        if (second > 59) {
            second = 0;
            minute++;
            if (minute > 59) {
                minute = 0;
                hour++;
                if (hour > 23) {
                    hour = 0;
                }
            }
        }
    }
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

public class L8 {
    public static void main(String[] a) {
        Time time = new Time(0, 0, 0);
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { 
                break; 
            }
            else if (args[0].equals("show"))  { 
                System.out.println(time); 
            }
            else if (args[0].equals("next"))  { 
                time.nextSecond(); 
            }
            else if (args[0].equals("set")) {
                time.setHour((int)number(args[1]));
                time.setMinute((int)number(args[2]));
                time.setSecond((int)number(args[3]));
            }
            else if (args[0].equals("init")) {
                time = new Time((int)number(args[1]), (int)number(args[2]), (int)number(args[3]));
            }
            else { 
                write("fail: comando invalido"); 
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}