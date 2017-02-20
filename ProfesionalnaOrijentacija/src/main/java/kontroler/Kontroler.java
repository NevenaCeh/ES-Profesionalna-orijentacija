package kontroler;

import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import db.DBKonekcija;
import domen.Ispitanik;

public class Kontroler {

	private static Kontroler instanca;
	private Ispitanik ispitanik;
	DBKonekcija db;
	
	private Kontroler(){
		ispitanik = new Ispitanik();
		db = new DBKonekcija();
	}
	
	public static Kontroler getInstanca() {
		if (instanca == null) {
			instanca = new Kontroler();
		}
		return instanca;
	}
	
	public void postaviPrvePodatke(String ime, String jmbg, double prosek, String izabrano){
		// TODO Auto-generated method stub
		ispitanik.setImePrezime(ime);
		ispitanik.setJmbg(jmbg);
		ispitanik.setProsek(prosek);
		ispitanik.setIzabranoZanimanje(izabrano);
		db.ubaciUBazu(jmbg, ime, prosek);
	}
	
	public void postaviBodoveAdministracije(int poen){
		int sadIma = ispitanik.getBodoviAdministracija();
		ispitanik.setBodoviAdministracija(sadIma+poen);
	}
	
	public void postaviBodoveBezbednost(int poen){
		int sadIma = ispitanik.getBodoviBezbednost();
		ispitanik.setBodoviBezbednost(sadIma+poen);
	}
	
	public void postaviBodoveTehnicke(int poen){
		int sadIma = ispitanik.getBodoviTehnicki();
		ispitanik.setBodoviTehnicki(sadIma+poen);
	}
	
	public void postaviBodoveKultura(int poen){
		int sadIma = ispitanik.getBodoviKultura();
		ispitanik.setBodoviKultura(sadIma+poen);
	}
	
	public void postaviBodoveNauka(int poen){
		int sadIma = ispitanik.getBodoviNauka();
		ispitanik.setBodoviNauka(sadIma+poen);
	}
	
	public void postaviBodovePoljoprivreda(int poen){
		int sadIma = ispitanik.getBodoviPoljoprivreda();
		ispitanik.setBodoviPoljoprivreda(sadIma+poen);
	}
	
	public void postaviBodovePrehrana(int poen){
		int sadIma = ispitanik.getBodoviPrehrana();
		ispitanik.setBodoviPrehrana(sadIma+poen);
	}
	
	public void postaviBodoveTrgovina(int poen){
		int sadIma = ispitanik.getBodoviTrgovina();
		ispitanik.setBodoviTrgovina(sadIma+poen);
	}
	
	public void postaviBodoveEstObl(int poen){
		int sadIma = ispitanik.getBodoviEstetOblik();
		ispitanik.setBodoviEstetOblik(sadIma+poen);
	}
	
	public void postaviBodoveHumRad(int poen){
		int sadIma = ispitanik.getBodoviHumRad();
		ispitanik.setBodoviHumRad(sadIma+poen);
	}

	public void odradiEspertDeo() throws Exception {
		// TODO Auto-generated method stub
		try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
            kSession.insert(ispitanik);
            //kSession.setGlobal("ef", ef);
            kSession.fireAllRules();
            System.out.println(ispitanik);
        } catch (Throwable t) {
        	throw new Exception("Greska jer "+t.getMessage());
        	//JOptionPane.showMessageDialog(null, "problem zbog "+t.getMessage());
        }		
	}

	public Ispitanik getIspitanik() {
		return ispitanik;
	}

	public void proveriImaLiGA(String jmbg) throws Exception{
		List<Ispitanik> lista = db.vratiListuIspitanika();
		for (Ispitanik isp : lista) {
			if (isp.getJmbg().equals(jmbg)) {
				throw new Exception("Osoba sa ovim podacima je vec radila test!!!");
			}			
		}		
	}
	
	
	
}
