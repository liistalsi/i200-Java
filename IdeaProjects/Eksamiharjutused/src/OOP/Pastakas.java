
public class Pastakas extends Kirjanik {

    private int tindiKogus;

    public Pastakas (int tindiKogus){

        this.tindiKogus = tindiKogus;
    }



    public void kirjuta(String tekst) {

        for (int i = 0; i < tekst.length(); i++) {
            if (tindiKogus > 0) {
                System.out.println(tekst.charAt(i));

                if (tekst.charAt(i) != ' ') {
                    tindiKogus--;

                }
            }
        }
    }


    public void prindiPaljuTintiAlles() {

        System.out.println(tindiKogus);

    }





}
