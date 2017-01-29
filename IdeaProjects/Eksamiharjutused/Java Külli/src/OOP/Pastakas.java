package OOP;


public class Pastakas {
    int tint;
    int kulutatudTint;
    int tintiAlles;

    public static void main(String[] args) {  
        System.out.print("seesiinonkonstruktorPastakas");
   }
    
    public Pastakas(int tindiKogus) {
        tint = tindiKogus;
        System.out.println(tint);
    }
    public void kirjuta(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isSpaceChar(c)) {
                count++;
            }
        }
        kulutatudTint = count;
        System.out.println(kulutatudTint);
    }

    public void prindiPaljuTintiAlles() {
        tintiAlles = tint - kulutatudTint;
        System.out.println(tintiAlles);
    }
}

