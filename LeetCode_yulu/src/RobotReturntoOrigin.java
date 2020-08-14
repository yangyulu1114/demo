public class RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int uCount = 0, dCount = 0, lCount = 0, rCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
               case 'U' :
                   uCount++;
                   break;
                case 'D' :
                    dCount++;
                    break;
                case 'L':
                    lCount++;
                    break;
                case 'R' :
                    rCount++;
                    break;
            }
        }
        return uCount == dCount && lCount == rCount;
    }

    public boolean judgeCircle2(String moves) {
        int uCount = 0, dCount = 0, lCount = 0, rCount = 0;
        for (char c : moves.toCharArray() ) {
            switch (c) {
                case 'U' :
                    uCount++;
                    break;
                case 'D' :
                    dCount++;
                    break;
                case 'L':
                    lCount++;
                    break;
                case 'R' :
                    rCount++;
                    break;
            }
        }
        return uCount == dCount && lCount == rCount;
    }
}
