package view;

import controller.TipoProblemaController;
import model.vo.Consulta;
import model.vo.Ticket;
import model.vo.TipoProblema;

import java.util.List;
import java.util.Scanner;

public class TipoProblemaView {

    private TipoProblemaController controller;

    public TipoProblemaView(){
        controller = new TipoProblemaController();
    }

    public void inserirTipoProblema(TipoProblema tipoProblema) {
        controller.inserir(tipoProblema);
    }



    public TipoProblema listarTiposProblemas() {
        Scanner sc = new Scanner(System.in);

        List<TipoProblema> tiposProblemas = controller.listar();

        System.out.println("--- Tipos de Problemas ---");
        for (int i = 0; i < tiposProblemas.size(); i++) {
            System.out.println((i + 1) + " - " + tiposProblemas.get(i).getNome());
        }

        System.out.print("Selecione o tipo de problema: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        // Validar opção escolhida
        if (opcao > 0 && opcao <= tiposProblemas.size()) {
            return tiposProblemas.get(opcao - 1); // retorna o objeto na posição escolhida
        }

        System.out.println("Opção inválida.");
        return null;
    }




//    public void listarTiposProblemas() {
//        System.out.println("Listando Tipos de Problemas...");
//        for (TipoProblema tipoProblema : controller.listar()) {
//            System.out.println("------------------------------------------");
//            System.out.println("ID: " + tipoProblema.getId());
//            System.out.println("Nome: " + tipoProblema.getNome());
//        }
//    }
//
//    public void excluirTipoProblema(int id) {
//        controller.excluir(id);
//    }

}
