package controller;

import model.Carteira;
import model.Investidor;
import model.Tarifacao;
import view.MostraCot;

public class ControllerMostraCotacao implements Tarifacao {
    private MostraCot view;
    private Investidor investidor;
    private Carteira c1;
    private ControllerAtCot controllerAtCot;

    public ControllerMostraCotacao(MostraCot view, Investidor investidor, Carteira c1) {
        this.view = view;
        this.investidor = investidor;
        this.c1 = c1;
        this.controllerAtCot = new ControllerAtCot(investidor, c1);
    }

    public boolean mostraCota() {
        view.getBtVendaBit().setText(String.format("%.2f", getCotacao(0)));
        view.getBtCompraEt().setText(String.format("%.2f", getCotacao(1)));
        view.getBtVendaRi().setText(String.format("%.2f", getCotacao(2)));
        return true;
    }
}
