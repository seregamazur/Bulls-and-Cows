package logics;
class Move{

    public static int getSum(String a,String b) {
        int cowcount = 0;
        int bullcount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.contains(b.charAt(i) + "")) {
                cowcount++;
            }
            else if (b.charAt(i) == a.charAt(i)) {
                bullcount++;

    }} return bullcount + cowcount;}


}