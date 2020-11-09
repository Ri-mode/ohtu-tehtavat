package ohtu.verkkokauppa;

public class Kauppa {

    private Varasto_rajapinta varasto;
    private Pankki_rajapinta pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori_rajapinta viitegeneraattori;
    private String kaupanTili;

//    public Kauppa() {
//        varasto = Varasto.getInstance();
//        pankki = Pankki.getInstance();
//        viitegeneraattori = Viitegeneraattori.getInstance();
//        kaupanTili = "33333-44455";
//    }
    
    public Kauppa(Varasto_rajapinta varasto, Pankki_rajapinta pankki, Viitegeneraattori_rajapinta viitegeneraattori) {
        this.varasto = Varasto.getInstance();
        this.pankki = Pankki.getInstance();
        this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
