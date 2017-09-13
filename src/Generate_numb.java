import java.util.Random;

    public class Generate_numb {
        public Generate_numb() {
        }

        public static void go() {
            MainCond result = new MainCond();
            new game_start();
            Random gen = new Random();
            boolean guessed = false;

            int numb;
            while(hasDupes(numb = gen.nextInt(9000) + 1000)) {
                ;
            }

            System.out.println(numb);
            String numbStr = numb +"";
            result.cond(numbStr);
        }

        public static boolean hasDupes(int num) {
            for(boolean[] digs = new boolean[10]; num > 0; num /= 10) {
                if(digs[num % 10]) {
                    return true;
                }

                digs[num % 10] = true;
            }

            return false;
        }
    }

