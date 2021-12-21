package recursion;

public class Hanoi {


    void hanoi_tower(int n, char from, char tmp, char to) {
        if(n == 1) {
            return;
        }
        else {
            hanoi_tower(n-1, from, to, tmp);
            //
            hanoi_tower(n-1, tmp, from, to);
        }
    }
}
