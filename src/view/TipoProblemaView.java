package view;

import controller.TipoProblemaController;
import model.vo.Ticket;
import model.vo.TipoProblema;

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

        System.out.println("--- Tipos de Problemas ---");
        for (TipoProblema tipoProblema : controller.listar()) {
            System.out.println(tipoProblema.getId() + " - " + tipoProblema.getNome());
        }
        System.out.print("Selecione o tipo de problema: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        // Buscar o TipoProblema escolhido
        for (TipoProblema tipo : controller.listar()) {
            if (tipo.getId() == opcao) {
                return tipo; // retorna o objeto escolhido
            }
        }

        System.out.println("Opção inválida.");
        return null;

    }
}
