import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class ClientWS {
    public static void main(String[] args) {
        //Un middleware
        //Application peut communiquer avec le Web Service facilement
        //Programmation oriente objet distribuer
        BanqueService stub=new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(7600));
        Compte cp=stub.getCompte(5);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
    }
}
