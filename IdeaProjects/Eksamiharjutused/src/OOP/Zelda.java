public class Zelda extends Legend {

    private int elusid;

    public Zelda(int elusid) {

        this.elusid = elusid;

    }

    public void kaklusKolliga(int kollilElusid) {

        this.elusid = this.elusid - kollilElusid;

    }

    public void prindiMituEluAlles() {

        System.out.println(this.elusid);
    }

    public void prindiKasOnElus() {

        if (this.elusid > 0) {

            System.out.println("Elus");
        }
        else{
            System.out.println("Surnud");
        }
    }
}