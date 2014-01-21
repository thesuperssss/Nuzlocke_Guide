package nuzlocke.view;

import javax.swing.JFrame;

import nuzlocke.controller.NuzlockeController;
/**
 * Main GUI Framework for the Nuzlocke Project.
 * @author jwil1446
 * @version
 */
public class NuzlockeFrame extends JFrame
{
	/**
	 * The referenced controller object.
	 */
	private NuzlockeController baseController;
	/**
	 * The application main panel for GUI.
	 */
	private NuzlockePanel basePanel;
	/**
	 * Creates a NuzlockeFrame object with a linked NuzlockeController for the MVC paradigm.
	 * @param baseController The referring controller.
	 */
	public NuzlockeFrame(NuzlockeController baseController)
	{
		this.baseController = baseController;
		basePanel = new NuzlockePanel(baseController);

		setupFrame();
	}
	/**
	 *  Sets the content, size and visibility of the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(1000, 950);
		this.setVisible(true);
	}
	
}
