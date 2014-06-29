public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length() <= nRows || nRows == 1)
            return s;
        //here the column number may need optimization
        char[][] holder = new char[nRows][s.length()];
        int index = 0;
        boolean diag = false;
        int row = 0;
        int col = 0;
        while(index < s.length()){
            holder[row][col] = s.charAt(index);
            if(row == nRows - 1)
                diag = true;
            else if(row == 0)
                diag = false;
            if(diag){
                row--;
                col++;
            }
            else
                row++;
            index++;
        }
        StringBuffer temp = new StringBuffer();
        for(int i = 0; i < holder.length; i++)
            for(int j = 0; j < holder[0].length; j++){
                if(holder[i][j] > 0)
                    temp.append(holder[i][j]);
            }
        return temp.toString();
    }
}