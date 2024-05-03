package Task2;

public class Main {
    public static void main(String[] args) {
        try{
            int a = 5 / 0;
        }catch (ArithmeticException e){
            System.out.println("Арифметическая ошибка " + e);
            System.exit(0);
        }finally {
            System.out.println("Этот текст будет выводится всегда");
        }
    }
}
