import java.util.ArrayList;

public class Agenda extends Pessoa{

    private static ArrayList<Pessoa>listaPessoa = new ArrayList<>();

    public Agenda(String nome, String sobrenome, String telefone) {
        super(nome, sobrenome, telefone);
    }

    public static ArrayList<Pessoa>getListaPessoa(){
        return listaPessoa;
    }

    static public void adiciona(Pessoa P){
        listaPessoa.add(P);
    }

    static public String listar () {
        String saida = "";
        int i = 1;
        for (Pessoa P : listaPessoa) {
            saida += i + " " + P.imprimir() + "\n";
            i++;
        }
        return saida;
    }

    static public boolean remove (String nome){
        for(Pessoa P:listaPessoa){
            if(P.getNome().equalsIgnoreCase(nome)) {
                listaPessoa.remove(P);
                return true;
            }
        }return false;
    }

}
