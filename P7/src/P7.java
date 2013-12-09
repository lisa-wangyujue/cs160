// P7 Assignment
// Author: Bobby (Robert) Signor
// Date:   11/21/13
// Class:  CS160
// Email:  bobbysig@rams.colostate.edu

public class P7 {
    private Picture picture;
    private int imgWidth = 0, imgHeight = 0;
    private int[][] data;

    public P7() {
        picture = new Picture();
    }

    public void readImage(String inFile) {
        try {
            picture.readPGM(inFile);
            imgHeight = picture.getHeight();
            imgWidth = picture.getWidth();
            data = picture.getData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeImage(String outFile) throws Exception{
        try {
            picture.setData(imageData());
            picture.writePGM(outFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int[][] imageData() {
        return data;
    }

    public void invert() {
        int[] temp;
        int top = 0, bottom = data.length - 1;
        while (bottom >= top) {
            temp = data[top];
            data[top++] = data[bottom];
            data[bottom--] = temp;
        }
    }

    public void exchange() {
        if (imgWidth >= 425 && imgHeight >= 280) {
            int topR = 80, col1 = 50, col2 = 275, temp;
            for (int r = 0; r < 150; r++) {
                for (int c = 0; c < 200; c++) {
                    temp = data[topR + r][col1 + c];
                    data[topR + r][col1 + c] = data[topR + r][col2 + c];
                    data[topR + r][col2 + c] = temp;
                }
            }
        }
    }

    public void decode() {
       for (int r = 0; r < data.length; r++) {
           for (int c = 0; c < data[r].length; c++) {
               data[r][c] &= 0b00111111;
               data[r][c] <<= 2;
               data[r][c] |= 0b00000011;
           }
       }
    }

    public void swap() {
        int t1, t2, t3;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                t1 = data[i][j] & 0b11100000;
                t2 = data[i][j] & 0b00000111;
                t3 = data[i][j] & 0b00011000;
                data[i][j] = (t1 >> 5) | (t2 << 5) | t3;
            }
        }
    }
}
