package nuzlocke.controller;

import nuzlocke.view.NuzlockeFrame;
import nuzlocke.model.Nuzlocke;
import nuzlocke.view.NuzlockeFrame;

public class NuzlockeController
{
	private NuzlockeFrame appFrame;
	private Nuzlocke myNuzlocke;
	private int clickCount;
	
	NuzlockeController()
	{
		this.myNuzlocke = new Nuzlocke();

	}
	
	public void start()
	{
		appFrame = new NuzlockeFrame(this);		
		
	}

	public String getNuzlockeResults()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
