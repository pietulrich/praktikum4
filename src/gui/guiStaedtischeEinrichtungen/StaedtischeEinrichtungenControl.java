package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer{
	private StaedtischeEinrichtungenView view;
	private BuergeraemterModel model;

	public StaedtischeEinrichtungenControl(Stage fensterStaedtischeEinrichtungen) {
		model = BuergeraemterModel.getInstance();
		view = new StaedtischeEinrichtungenView(this, fensterStaedtischeEinrichtungen, model);
		model.addObserver(this);
	}

	@Override
	public void update() {
		view.zeigeBuergeraemterAn();
		
	}
	

}
