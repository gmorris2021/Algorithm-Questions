import java.util.*;

public class Dice {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] num = new int[d + 1][target + 1];
        for (int j = 0; j < num[0].length; j++) {
        for (int i = 0; i < num.length; i++) {
            num[i][j] = -1;
        }
        }
        return rec(d, f, target, num);
    }
    
    public int rec(int d, int f, int target, int[][] num) {
        int sum = 0;
        if (d == 1) {
            if (target <= f && target >= 1) {
                num[1][target] = 1;
                return 1;
            } else {
                num[1][target] = 0;
                return 0;
            }
        } else {       
          for(int i = 1; i <= f; i++) {
              if (target - i < 0) {
                  continue;
              }
              if(num[d - 1][target - i] != -1) {
                  sum += num[d - 1][target - i];
              } else {
                  sum += rec(d - 1, f, target - i, num);
              }
              sum = sum % 1000000007;
            }
            num[d][target] = sum % 1000000007;
            return num[d][target];
          }
        }
    }