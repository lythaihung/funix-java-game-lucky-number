import java.util.Scanner;
public class LuckyNumber {
    public static void main(String[] args){
        // total guess increase each time guess
        int totalGuess = 0;
        // total guess per game
        int totalGuessPerGame = 0;
        // total game increase each game
        int totalGame = 0;
        // min guess
        int bestGuess = Integer.MAX_VALUE;
        // create Scanner to input value from user
        Scanner cs = new Scanner(System.in);
        String confirm = "y";
        // welcome tense
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100...");
        do {
            totalGame++ ; //increase each time game
            // create a lucky number by random
            int secretNumber = Math.round((float) Math.random() * 100);
            // run method play() and get return value
            totalGuessPerGame=play(cs, secretNumber, totalGuessPerGame);
            // save total guess
            totalGuess+=totalGuessPerGame;
            // save best guess each time play game
            if( totalGuessPerGame<=bestGuess) {
                bestGuess=totalGuessPerGame;
            }
            // reset guess per game
            totalGuessPerGame =0;
            System.out.print("Bạn có muốn tiếp tục chơi không?");
            confirm=cs.next();
        } while (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes"));
        do {
            //set cs to empty cause keep "n" that computer will go to infinite
            confirm="";
            report(totalGame,totalGuess,bestGuess);
        } while (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no"));

    }
    public static int  play(Scanner cs, int secretNumber,int totalGuessPerGame) {
//        System.out.println(secretNumber); //test
        System.out.print("Bạn đoán?");
        int x = cs.nextInt();
        totalGuessPerGame++; //increase 1 by each guess
        //condition to continue or stop guess
        if (x>secretNumber){
            System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            return play(cs, secretNumber,totalGuessPerGame);
        } else if (x<secretNumber){
            System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
            return play(cs, secretNumber,totalGuessPerGame);
        } else {
            System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau "+  totalGuessPerGame +" lần dự đoán!");
            return totalGuessPerGame;
        }
    }
    public static void report(int a, int b, int c) {
        System.out.println("Kết quả tổng quát của trò chơi:");
        System.out.println("Tổng số lần chơi = "+a);
        System.out.println("Tổng số lần dự đoán = "+b);
        System.out.println("Số lần dự đoán trung bình mỗi lượt = "+ (float)a/b);  // avg guess was solve after stop game
        System.out.println("Số lần dự đoán ít nhất = "+c);
    }

}
