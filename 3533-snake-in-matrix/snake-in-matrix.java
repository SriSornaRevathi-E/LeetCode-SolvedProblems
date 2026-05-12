class Solution {

    public int finalPositionOfSnake(int n,
                                    List<String> commands) {

        int position = 0;

        for(String cmd : commands) {

            if(cmd.equals("RIGHT")) {
                position += 1;
            }

            else if(cmd.equals("LEFT")) {
                position -= 1;
            }

            else if(cmd.equals("DOWN")) {
                position += n;
            }

            else {
                position -= n;
            }
        }

        return position;
    }
}