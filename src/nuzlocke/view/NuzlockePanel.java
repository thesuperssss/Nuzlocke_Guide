package nuzlocke.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import nuzlocke.controller.NuzlockeController;

public class NuzlockePanel extends JPanel
{
	private NuzlockeController baseController;
	private SpringLayout baseLayout;
	private JTextArea nuzlockeRulesTextArea;
	private JTextArea nuzlockeStrategyTextArea;
	private JTextArea nuzlockeMainMenuTextArea;
	private JTextArea titleTextArea;
	private JButton StrategyButton;
	private JButton RulesButton;
	private JButton MainMenuButton;
	private JScrollPane textPane;

	private ImageIcon pictureSource6;
	private Image baseImage;

	/**
	 * Paint the background image and scale it to fill the entire Panel.
	 */
	protected void paintComponent(Graphics panelGraphics)
	{
		super.paintComponent(panelGraphics);
		baseImage = pictureSource6.getImage();

		panelGraphics.drawImage(baseImage, 0, 0, getWidth(), getHeight(), null);

	}

	public NuzlockePanel(NuzlockeController baseController)
	{
		this.baseController = baseController;

		pictureSource6 = new ImageIcon(getClass().getResource("/nuzlocke/view/images/Pokemon-Reveal.jpg"));

		baseLayout = new SpringLayout();
		
		nuzlockeStrategyTextArea = new JTextArea(45, 50);	
		nuzlockeMainMenuTextArea = new JTextArea(45, 50);
		nuzlockeRulesTextArea = new JTextArea(45, 50);
		
		titleTextArea = new JTextArea(5, 100);
		
		textPane = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 590, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, -352, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 328, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -577, SpringLayout.EAST, this);
		
		MainMenuButton = new JButton("Main menu");
		StrategyButton = new JButton("Strategy");
		baseLayout.putConstraint(SpringLayout.WEST, MainMenuButton, 195, SpringLayout.EAST, StrategyButton);
		RulesButton = new JButton("Rules");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		
		this.setSize(1000, 950);
		this.setLayout(baseLayout);
		this.setBackground(new Color(120, 50, 220));
		this.add(MainMenuButton);
		this.add(RulesButton);
		this.add(StrategyButton);
		this.add(textPane);
		this.add(titleTextArea);
		textPane.add(nuzlockeMainMenuTextArea);
		
		titleTextArea.setText("Main Menu");
		titleTextArea.setVisible(true);
		titleTextArea.setEditable(false);
		titleTextArea.setLineWrap(true);
		titleTextArea.setWrapStyleWord(true);

		nuzlockeRulesTextArea = new JTextArea(45, 50);
		nuzlockeRulesTextArea.setWrapStyleWord(true);
		nuzlockeRulesTextArea.setLineWrap(true);
		nuzlockeRulesTextArea.setEditable(false);
		nuzlockeRulesTextArea.setVisible(true);
		RulesButton.setVisible(true);

		nuzlockeStrategyTextArea = new JTextArea(45, 50);
		nuzlockeStrategyTextArea.setWrapStyleWord(true);
		nuzlockeStrategyTextArea.setLineWrap(true);
		nuzlockeStrategyTextArea.setEditable(false);
		nuzlockeStrategyTextArea.setVisible(true);
		StrategyButton.setVisible(true);

		nuzlockeMainMenuTextArea.setWrapStyleWord(true);
		nuzlockeMainMenuTextArea.setLineWrap(true);
		nuzlockeMainMenuTextArea.setEditable(false);
		nuzlockeMainMenuTextArea.setVisible(true);
		MainMenuButton.setVisible(false);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, nuzlockeMainMenuTextArea, 200, SpringLayout.WEST, titleTextArea);
		baseLayout.putConstraint(SpringLayout.NORTH, nuzlockeRulesTextArea, 0, SpringLayout.NORTH, nuzlockeMainMenuTextArea);
		baseLayout.putConstraint(SpringLayout.WEST, nuzlockeRulesTextArea, 0, SpringLayout.WEST, nuzlockeMainMenuTextArea);
		baseLayout.putConstraint(SpringLayout.NORTH, nuzlockeStrategyTextArea, 0, SpringLayout.NORTH, nuzlockeMainMenuTextArea);
		baseLayout.putConstraint(SpringLayout.WEST, nuzlockeStrategyTextArea, 0, SpringLayout.WEST, nuzlockeMainMenuTextArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, nuzlockeRulesTextArea, -91, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, nuzlockeRulesTextArea, 143, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nuzlockeMainMenuTextArea, 200, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, nuzlockeMainMenuTextArea, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, StrategyButton, 195, SpringLayout.EAST, RulesButton);
		baseLayout.putConstraint(SpringLayout.WEST, RulesButton, 195, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, RulesButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, MainMenuButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, StrategyButton, -10, SpringLayout.SOUTH, this);

	}

	private void setupListeners()
	{

		RulesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				titleTextArea.setText("Rules");

				RulesButton.setVisible(false);
				StrategyButton.setVisible(true);
				MainMenuButton.setVisible(true);
				
				nuzlockeRulesTextArea.setText("so you think pokemon is a baby game well maybe you should try pokemon this way \n1. you can only catch one pokemon per route, even if you hate it it is the only one. (are you scared yet) \n2. If a pokemon faints IT IS DEAD and must be released NO MATTER WHAT. \n3. I hate you die in fire. \nWhy would someone do this you ask \nFor the thrill of challenge \nFor the glory of victory \nBut mostly for the friends you’ll make. Friends you didn’t choose or want. \nFriends you’ll cherish that must more knowing you could lose them at any moment \noptional rules to make it more easy/fun \n1. duplicates clause- if you already have that pokemon you can have another chance for another pokemon\n2. shiny clause - if you find a shiny pokemon you can catch it even if it isn’t your first pokemon in that route\n3. nickname every pokemon\n4.etc.\noptional rules to make it more hard\n1. no useing items in battle \n2. etc.");
				textPane.removeAll();
				textPane.add(nuzlockeRulesTextArea);
				nuzlockeRulesTextArea.setVisible(true);
				textPane.setVisible(true);
			}
		});
		StrategyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				titleTextArea.setText("Strategy");

				StrategyButton.setVisible(false);
				RulesButton.setVisible(true);
				MainMenuButton.setVisible(true);

				textPane.removeAll();
				textPane.add(nuzlockeStrategyTextArea);
				nuzlockeStrategyTextArea.setText("The first thing we must discuss is the disadvantages of not being able to faint. Think about it, do you remember how you would walk into a gym thinking, “I’m going to use my weak peeps to get the gym Leader down and then finish him off with my big guns!” well you can’t do that anymore. Every single battle you come into you have to know what’s good against what, you will lose all of your team and maybe even get a “game over” if you do not prepare. You can’t just grind your pokemon to the ground until they faint and then start over, why? Cause their dead XD! BUT you still have to train your pokemon, probably even more so than you do right now! But you have to go about this training very carefully, if your Budew is two thirds of the way dead and you run into a herd of zigzagoons that all have headbutt who happen to all use headbutt, then you should run; not only should you run but you should pray that it works, so that you don’t have to slowly witness your Budew (his name was Francel, was…) get Headbutted to death by a freaking gang of  Zigzagoons!!! So basically for your first strategy, Be Careful. The Next thing you should know, Potions and Pokemon are your friends. I don’t care if you hate Bidoofs, that stupid beaver looking thing could save your life and save you from a “game over”; you may even learn to love the little guy, by both naming him you set yourself up for heartache , and the longer you keep ‘em the harder it is to be rid of ‘em. You need to have pokemon and you need to have potions those are key. Some others things you absolutely need, antidotes, if you get poisoned and you have no antidotes...you better run fast sucka, cause that pikachu is ganna die. Basically your second strategy is, Buy Potions and Get Pokemon. One of our final points we wanna “point” out to you, is get a type chart. Google it, look into it, study it...yes spend 5 minutes to learn the type chart. Learn what is good against what, you need to know that your Grass-type Pansage is not a good choice to fight against a Mega-evolved Charzard….just saying. If that doesn’t make sense to you, imagine trying to extinguish a forest fire...with more forest. Learn the chart its not hard, water drowns rock and ground, fire burns grass to the ground, and grass eats water for breakfast. Of course there are more types but not that many… :D So our Final tip, Learn about thy enemy...so you can destroy them XD");
				nuzlockeStrategyTextArea.setVisible(true);
				textPane.setVisible(true);

			}

		});
		MainMenuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				titleTextArea.setText("Main Menu");

				MainMenuButton.setVisible(false);
				StrategyButton.setVisible(true);
				RulesButton.setVisible(true);

				textPane.removeAll();
				textPane.add(nuzlockeMainMenuTextArea);
				nuzlockeMainMenuTextArea.setVisible(true);
				textPane.setVisible(true);
			}
		});

	}
}
