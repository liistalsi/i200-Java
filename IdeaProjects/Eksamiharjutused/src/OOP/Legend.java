
/**
 * Loo klass Zelda, mis käitub nii nagu käesolev programm ootab.
 *
 * Reeglid:
 * 1. Legend klassi muuta ei tohi.
 * 2. Zelda kaotab nii palju elusid kui kollil elusid on.
 */
public class Legend{

    public static void main(String[] args) {

        int kollilElusid;

        int elusid = 35;
        Zelda zelda = new Zelda(elusid);

        kollilElusid = 25;
        zelda.kaklusKolliga(kollilElusid);

        zelda.prindiMituEluAlles();

        kollilElusid = 57;
        zelda.kaklusKolliga(kollilElusid);

        zelda.prindiKasOnElus();

    }
}
