package kr.ac.ajou.group_Seven.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import kr.ac.ajou.group_Seven.Question.Block;

import kr.ac.ajou.group_Seven.end.CheckEnd;
import kr.ac.ajou.group_Seven.end.Fileinout;
import kr.ac.ajou.group_Seven.end.ResultPrint;
import kr.ac.ajou.group_Seven.end.history;
import kr.ac.ajou.group_Seven.play.Player;


public class MakeGui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel big_cardPanel;
	private JPanel menubar, intro, prologue, game_rule1, game_rule2;	
	private JPanel game_setting, game_playing, result_panel;
	private JPanel game_setting_in;
	
	private JButton intro_background_btn;
	private JButton prologue_Background_btn;
	private JButton game_rule1_btn;
	private JButton game_rule2_btn;
	private JButton setting_startgame;
	private JButton startGame_btn;
	private JButton history_btn;
	private JButton dice_btn;
	private JButton giveup_btn;
	private JButton take_btn;
	private JButton notake_btn;
	
	private final ButtonGroup buttonGroup_3;
	private final ButtonGroup buttonGroup_4;
	private final ButtonGroup buttonGroup_5;
	
	JCheckBox chckPerson1;
	JCheckBox chckPerson2;
	JCheckBox chckPerson3;
	JCheckBox chckCoins1;
	JCheckBox chckCoins2;
	JCheckBox chckCoins3;
	JCheckBox chckCoins4;
	JCheckBox chckTurns1;
	JCheckBox chckTurns2;
	JCheckBox chckTurns3;
	private JPanel player_img1;
	private JPanel player_img2;
	private JPanel player_img3;
	private JPanel player_img4;
	private JPanel diceBackground;
	private JPanel stateFlow;
	private JPanel realDice;
	private JPanel block_panel;
	private JPanel block1;
	private JPanel block2;
	private JPanel block3;
	private JPanel block4;
	private JPanel block5;
	private JPanel block6;
	private JPanel block7;
	private JPanel block8;
	private JPanel block9;
	private JPanel block10;
	private JPanel block11;
	private JPanel block12;
	private JPanel Right_panel;
	private JPanel question_bgd_panel;
	private JPanel answer_bgd_panel;
	
	private JLabel lblStone;
	private JLabel lblBlock;
	private JLabel label_p1;
	private JLabel label_p2;
	private JLabel label_p3;
	private JLabel label_p4;
	private JPanel score_panel;
	private JLabel turn_label;
	private JTextField turn_textfield;
	private JPanel question_inner_panel;
	private JTextField question_text;
	private JPanel answer_inner_panel;
	private JTextField answer_text;
	private JTextArea stateFlow_text;
	private JTextField state_1_1;
	private JTextField state_1_2;
	private JTextField state_1_3;
	private JTextField state_1_4;
	private JTextField state_2_1;
	private JTextField state_2_2;
	private JTextField state_2_3;
	private JTextField state_2_4;
	
	
	
	
	private int number_of_player;
	private int number_of_coin;
	private int number_of_turn;
	private int[] set = new int[3];
	
	private ArrayList<Block> mapBlock;
	private Block block = new Block();
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	private int dicenum;
	private int seq_player;
	private int answer;
	private String question;
	private int response;
	
	

	private CheckEnd checkend = new CheckEnd();
		
	
	int result_is;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeGui frame = new MakeGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MakeGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Math Witch and Colorful Kingdom");
		setBounds(100, 100, 1282, 722);
		
		big_cardPanel = new JPanel(); // card panel
		big_cardPanel.setLayout(new CardLayout()); // set layout to CardLayout
		setContentPane(big_cardPanel);
		
		
		CardLayout cl = (CardLayout) (big_cardPanel.getLayout()); // to use cardLayout
		
		Image bgd = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		Image menu_bgd = new ImageIcon(this.getClass().getResource("/menu.jpg")).getImage();
		
		
		// make new panel
		menubar = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(menu_bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		intro = new JPanel();
		prologue = new JPanel();
		game_rule1 = new JPanel();
		game_rule2 = new JPanel();
		game_setting = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		game_playing = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		}; 
		
		
		
		// result panel
		Image end_img1 = new ImageIcon(this.getClass().getResource("/end1.jpg")).getImage();
		Image end_img2 = new ImageIcon(this.getClass().getResource("/end2.jpg")).getImage();
		Image end_img3 = new ImageIcon(this.getClass().getResource("/end3.jpg")).getImage();
		Image end_img4 = new ImageIcon(this.getClass().getResource("/end4.jpg")).getImage();

		
		result_panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				
				ResultPrint res = new ResultPrint(players);
				result_is = res.res_print(); // check winner
				
				if(result_is == 1) // winner is 1
					g.drawImage(end_img1, 0, 0, null);
				else if(result_is == 2) // winner is 2
					g.drawImage(end_img2, 0, 0, null);
				else if(result_is == 3) // winner is 3
					g.drawImage(end_img3, 0, 0, null);
				else // winner is 4
					g.drawImage(end_img4, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
				
			}
		};
		
		
		
		// menubar
		startGame_btn = new JButton(""); // start game button
		startGame_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.next(big_cardPanel);
			}
		});
		Image img_start = new ImageIcon(this.getClass().getResource("/start.jpg")).getImage();
		startGame_btn.setIcon(new ImageIcon(img_start));
		
		
		
		
		
		
		
		history_btn = new JButton("");	// history button
		history_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				history frame = new history();
				frame.setVisible(true);
				
				File myFile = new File("History.txt");
				frame.loadFile(myFile); // get history file


			}
		});
		Image img_history = new ImageIcon(this.getClass().getResource("/history_btn.jpg")).getImage();
		history_btn.setIcon(new ImageIcon(img_history));

		
		
		
		
		
		GroupLayout gl_menubar = new GroupLayout(menubar);
		gl_menubar.setHorizontalGroup(
			gl_menubar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_menubar.createSequentialGroup()
					.addContainerGap(864, Short.MAX_VALUE)
					.addGroup(gl_menubar.createParallelGroup(Alignment.LEADING, false)
						.addComponent(startGame_btn, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(history_btn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 365, Short.MAX_VALUE))
					.addGap(53))
		);
		gl_menubar.setVerticalGroup(
			gl_menubar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menubar.createSequentialGroup()
					.addContainerGap(422, Short.MAX_VALUE)
					.addComponent(startGame_btn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(history_btn)
					.addGap(35))
		);
		

		
		
		
		// playing panel character image
		Image character_img1 = new ImageIcon(this.getClass().getResource("/name1.jpg")).getImage();
		Image character_img1x = new ImageIcon(this.getClass().getResource("/name1x.jpg")).getImage();
		Image character_img2 = new ImageIcon(this.getClass().getResource("/name2.jpg")).getImage();
		Image character_img2x = new ImageIcon(this.getClass().getResource("/name2x.jpg")).getImage();
		Image character_img3 = new ImageIcon(this.getClass().getResource("/name3.jpg")).getImage();
		Image character_img3x = new ImageIcon(this.getClass().getResource("/name3x.jpg")).getImage();
		Image character_img4 = new ImageIcon(this.getClass().getResource("/name4.jpg")).getImage();
		Image character_img4x = new ImageIcon(this.getClass().getResource("/name4x.jpg")).getImage();
		
		
		player_img1 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(p1.isAlive()){ // if p1 is alive, set image which hasn't X
					g.drawImage(character_img1, 0, 0, null);
				}
				else{ // if p1 is alive, set image which has X
					g.drawImage(character_img1x, 0, 0, null);
				}
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		player_img2 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(p2.isAlive()){ // if p2 is alive, set image which hasn't X
					g.drawImage(character_img2, 0, 0, null);
				}
				else{ // if p2 is alive, set image which has X
					g.drawImage(character_img2x, 0, 0, null);
				}				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		player_img3 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(p3.isAlive()){ // if p3 is alive, set image which hasn't X
					g.drawImage(character_img3, 0, 0, null);
				}
				else{ // if p3 is alive, set image which has X
					g.drawImage(character_img3x, 0, 0, null);
				}
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		player_img4 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(p4.isAlive()){ // if p4 is alive, set image which hasn't X
					g.drawImage(character_img4, 0, 0, null);
				}
				else{ // if p4 is alive, set image which has X
					g.drawImage(character_img4x, 0, 0, null);
				}
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		
		
		
//		dice background
//		real dice 
//		state flow 
//		block panel 
//		right panel
//		stateflow text area 
		
		
		Image diceback_img = new ImageIcon(this.getClass().getResource("/dice_back.jpg")).getImage();
		
		diceBackground = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(diceback_img, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		
		Image realdice_img1 = new ImageIcon(this.getClass().getResource("/dice1.png")).getImage();
		Image realdice_img2 = new ImageIcon(this.getClass().getResource("/dice2.png")).getImage();
		Image realdice_img3 = new ImageIcon(this.getClass().getResource("/dice3.png")).getImage();
		Image realdice_img4 = new ImageIcon(this.getClass().getResource("/dice4.png")).getImage();
		Image realdice_img5 = new ImageIcon(this.getClass().getResource("/dice5.png")).getImage();
		Image realdice_img6 = new ImageIcon(this.getClass().getResource("/dice6.png")).getImage();
		
		realDice = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(dicenum == 1) // if dice number 1, change dice picture to 1
					g.drawImage(realdice_img1, 0, 0, null);
				else if(dicenum == 2) // if dice number 2, change dice picture to 2
					g.drawImage(realdice_img2, 0, 0, null);
				else if(dicenum == 3) // if dice number 3, change dice picture to 3
					g.drawImage(realdice_img3, 0, 0, null);
				else if(dicenum == 4) // if dice number 4, change dice picture to 4
					g.drawImage(realdice_img4, 0, 0, null);
				else if(dicenum == 5) // if dice number 5, change dice picture to 5
					g.drawImage(realdice_img5, 0, 0, null);
				else // if dice number 6, change dice picture to 6
					g.drawImage(realdice_img6, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		
		Image block_panel_bgd = new ImageIcon(this.getClass().getResource("/block_panel_bgd.png")).getImage();
		
		block_panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(block_panel_bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		Image right_panel_bgd = new ImageIcon(this.getClass().getResource("/info.jpg")).getImage();
		
		Right_panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(right_panel_bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		
		stateFlow = new JPanel();
		stateFlow.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		stateFlow.add(scrollPane, BorderLayout.CENTER);
		
		stateFlow_text = new JTextArea();
		stateFlow_text.setText("Welcome to Math Witch and Colorful Kingdom!\n");
		stateFlow_text.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		scrollPane.setViewportView(stateFlow_text); // always scroll bar goes down
		stateFlow_text.setCaretPosition(stateFlow_text.getDocument().getLength()); // always scroll bar goes down
		
		
		
		
		GroupLayout gl_game_playing = new GroupLayout(game_playing);
		gl_game_playing.setHorizontalGroup(
			gl_game_playing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_game_playing.createSequentialGroup()
					.addGroup(gl_game_playing.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_game_playing.createSequentialGroup()
							.addComponent(diceBackground, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stateFlow, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_game_playing.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_game_playing.createParallelGroup(Alignment.LEADING)
								.addComponent(player_img4, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(player_img3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(player_img2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addComponent(player_img1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addComponent(block_panel, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Right_panel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_game_playing.setVerticalGroup(
			gl_game_playing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_game_playing.createSequentialGroup()
					.addGroup(gl_game_playing.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_game_playing.createSequentialGroup()
							.addGap(158)
							.addComponent(player_img1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(player_img2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(player_img3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(player_img4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_game_playing.createSequentialGroup()
							.addGap(169)
							.addComponent(block_panel, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_game_playing.createParallelGroup(Alignment.TRAILING)
						.addComponent(diceBackground, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addGroup(gl_game_playing.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stateFlow, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
				.addGroup(gl_game_playing.createSequentialGroup()
					.addComponent(Right_panel, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
		
		
		
		

		
		
		Image question_panel_bgd = new ImageIcon(this.getClass().getResource("/question.jpg")).getImage();
		
		question_bgd_panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(question_panel_bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		Image answer_panel_bgd = new ImageIcon(this.getClass().getResource("/answer.png")).getImage();
		
		answer_bgd_panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(answer_panel_bgd, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		
		
		dice_btn = new JButton("");
		dice_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				admin_operation_openall(); // make all components available
				
				dicenum = players.get(seq_player).getDice(); // get player's dice number
				
				stateFlow_text.append("Dice Number is " + dicenum + "!\n"); 
				
				players.get(seq_player).setLocation(players.get(seq_player).move(dicenum, stateFlow_text)); // move player
				
				refresh_score(); // after plus 1 coin, refresh score
				stateFlow_text.append("Player " + (seq_player+1) + " goes to Block number " + (players.get(seq_player).getLocation()+1) + ".\n");
				
				if(mapBlock.get(players.get(seq_player).getLocation()).getBlockOwner() != seq_player){ // if block owner is different to seq_player
					mapBlock.get(players.get(seq_player).getLocation()).plusVisitNumber(); // plus block visit number
					stateFlow_text.append("This block is another player's block! You should solve Question.\n");
					if(mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() == 1){ // if visit number is 1, get Question level 1
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(1);
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(1);

					}else if(mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() == 2){ // if visit number is 2, get Question level 2
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(2);
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(2);

					}else if(mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() == 3){ // if visit number is 3, get Question level 3
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(3);
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(3);

					}else if(mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() == 4){ // if visit number is 4, get Question level 4
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(4);
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(4);

					}else if(mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() == 5){ // if visit number is 5, get Question level 5
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(5);
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(5);

					}else{
						question = mapBlock.get(players.get(seq_player).getLocation()).getQuestion(6); // if visit number is 6, get Question level 6
						answer = mapBlock.get(players.get(seq_player).getLocation()).getAnswer(6);

					}
					
					
					// select question level
					
					question_text.setText(question); 
					
					stateFlow_text.append("Solve Question Level " + mapBlock.get(players.get(seq_player).getLocation()).getVisitNumber() + ".\n");
					
					refresh_answer(); // erase answer textfield
					repaint();
					admin_opertion_closeall(); // make all components unavailable
					user_operation_answer(); // make only answer textfield available
					
				}else{ // if block owner is equal to seq_player
					stateFlow_text.append("This block is your block! You are not solve Question.\n");
					mapBlock.get(players.get(seq_player).getLocation()).plusVisitNumber(); // plus visit number
					players.get(seq_player).minusTurn(); // minus player's turn
					if(checkend.turnOver(players)){ // if turn is over
						cl.next(big_cardPanel); // go to result panel
						repaint();
					}
					refresh_question(); // erase question textfield
					refresh_answer(); // erase answer textfield
					refresh_score(); // refresh score field
					refresh_turn(); // refresh turn field
					repaint();
					plus_seq_player(); // make next player start game
					stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
					admin_opertion_closeall(); // make all components unavailable 
					user_operation_dice(); // make dice & give up button available
				}
						
	
			}
		});
		Image dice_btn_img = new ImageIcon(this.getClass().getResource("/dice_btn.png")).getImage();
		dice_btn.setIcon(new ImageIcon(dice_btn_img));
		
		
		
		
		giveup_btn = new JButton("");
		giveup_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				admin_operation_openall();
				
				players.get(seq_player).giveup(mapBlock, seq_player); // kill player and return all blocks.
				stateFlow_text.append("Player " + (seq_player+1) + " is dead.\n");
				
				if(checkend.howAlive(players)) // if only 1 player alive
				{
					cl.next(big_cardPanel);
					repaint();
				}
				else{
					
					players.get(seq_player).minusTurn(); // minus player's turn
					if(checkend.turnOver(players)){
						cl.next(big_cardPanel);
						repaint();
					}
					refresh_question(); 
					refresh_answer();
					refresh_score();
					refresh_turn();
					repaint();
					plus_seq_player();
					stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
					admin_opertion_closeall();
					user_operation_dice();
				}
				
			}
		});
		Image giveup_btn_img = new ImageIcon(this.getClass().getResource("/giveup_btn.png")).getImage();
		giveup_btn.setIcon(new ImageIcon(giveup_btn_img));
		
		
		
		
		take_btn = new JButton("");
		take_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				admin_operation_openall();
				
				
				
				if(players.get(seq_player).getCoin() > 0){ // if player coin is bigger then 0
					
					
					if(mapBlock.get(players.get(seq_player).getLocation()).getBlockOwner() == -1){ // if block doesn't have master
						block.buyEmptyBlock(players.get(seq_player), seq_player, mapBlock.get(players.get(seq_player).getLocation())); // buy block
					}
					else{ // if block has master 
						block.buyBlock(players.get(seq_player), seq_player, players.get(mapBlock.get(players.get(seq_player).getLocation()).getBlockOwner()), mapBlock.get(players.get(seq_player).getLocation())); // buy block in another method
					}
					stateFlow_text.append("Player " + (seq_player+1) + " buy block number " + (players.get(seq_player).getLocation()+1) + ".\n");
					
					
					if(checkend.howManyblock(players)){ //if all blocks have master
						cl.next(big_cardPanel); // go to result panel
						repaint();
					}
					players.get(seq_player).minusTurn(); // minus player's turn
					if(checkend.turnOver(players)){ // if turn is over
						cl.next(big_cardPanel);
						repaint();
					}

					refresh_question();
					refresh_answer();
					refresh_score();
					refresh_turn();
					repaint();
					plus_seq_player();
					stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
					admin_opertion_closeall();
					user_operation_dice();
				}
				else{
					
					
					stateFlow_text.append("You cannot buy Block. You have no stone.\n");
					players.get(seq_player).minusTurn();
					
					
					
					if(checkend.turnOver(players)){ // if only 1 player left
						cl.next(big_cardPanel);
						repaint();
					}
					
					refresh_question();
					refresh_answer();
					refresh_score();
					refresh_turn();
					repaint();
					plus_seq_player();
					stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
					admin_opertion_closeall();
					user_operation_dice();
					
				}
				
			}
		});
		Image take_btn_img = new ImageIcon(this.getClass().getResource("/take_btn.png")).getImage();
		take_btn.setIcon(new ImageIcon(take_btn_img));
		
		
		
		
		notake_btn = new JButton("");
		notake_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				stateFlow_text.append("You were not buy Block.\n");
				
				players.get(seq_player).minusTurn(); // minus player's turn
				if(checkend.turnOver(players)){
					cl.next(big_cardPanel);
					repaint();
				}
				refresh_question();
				refresh_answer();
				refresh_score();
				refresh_turn();
				repaint();
				plus_seq_player();
				stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
				admin_opertion_closeall();
				user_operation_dice();
			}
		});
		Image notake_btn_img = new ImageIcon(this.getClass().getResource("/notake_btn.png")).getImage();
		notake_btn.setIcon(new ImageIcon(notake_btn_img));
		
		
		
		
		
		label_p1 = new JLabel("P1");
		label_p2 = new JLabel("P2");
		label_p3 = new JLabel("P3");
		label_p4 = new JLabel("P4");
		
		lblStone = new JLabel("Stone");
		
		lblBlock = new JLabel("Block");
		
		score_panel = new JPanel();
		
		turn_label = new JLabel("TURN");
		turn_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		turn_textfield = new JTextField();
		turn_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		turn_textfield.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		turn_textfield.setColumns(10);
		GroupLayout gl_Right_panel = new GroupLayout(Right_panel);
		gl_Right_panel.setHorizontalGroup(
			gl_Right_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(question_bgd_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(answer_bgd_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_Right_panel.createSequentialGroup()
					.addContainerGap(85, Short.MAX_VALUE)
					.addComponent(label_p1)
					.addGap(48)
					.addComponent(label_p2)
					.addGap(44)
					.addComponent(label_p3)
					.addGap(47)
					.addComponent(label_p4)
					.addGap(39))
				.addGroup(gl_Right_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Right_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_Right_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addComponent(dice_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(giveup_btn, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE))
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addComponent(take_btn, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(notake_btn, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Right_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addComponent(turn_label)
									.addGap(15))
								.addComponent(turn_textfield, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addGroup(gl_Right_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBlock)
								.addComponent(lblStone))
							.addGap(27)
							.addComponent(score_panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		gl_Right_panel.setVerticalGroup(
			gl_Right_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Right_panel.createSequentialGroup()
					.addComponent(question_bgd_panel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(answer_bgd_panel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_Right_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_p1)
						.addComponent(label_p2)
						.addComponent(label_p3)
						.addComponent(label_p4))
					.addGroup(gl_Right_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(lblStone)
							.addGap(34)
							.addComponent(lblBlock))
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(score_panel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_Right_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addGroup(gl_Right_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(dice_btn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
								.addComponent(giveup_btn, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
							.addGroup(gl_Right_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(take_btn, GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE))
								.addGroup(gl_Right_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(notake_btn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
							.addGap(17))
						.addGroup(gl_Right_panel.createSequentialGroup()
							.addComponent(turn_label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(turn_textfield, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addGap(16))
		);
		score_panel.setLayout(new GridLayout(2, 4, 1, 1));
		
		state_1_1 = new JTextField();
		state_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		state_1_2 = new JTextField();
		state_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		state_1_3 = new JTextField();
		state_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		state_1_3.setToolTipText("");
		state_1_4 = new JTextField();
		state_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		state_2_1 = new JTextField();
		state_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		state_2_2 = new JTextField();
		state_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		state_2_3 = new JTextField();
		state_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		state_2_4 = new JTextField();
		state_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		score_panel.add(state_1_1);
		score_panel.add(state_1_2);
		score_panel.add(state_1_3);
		score_panel.add(state_1_4);
		score_panel.add(state_2_1);
		score_panel.add(state_2_2);
		score_panel.add(state_2_3);
		score_panel.add(state_2_4);
		
		
		
		
		question_inner_panel = new JPanel();
		GroupLayout gl_question_bgd_panel = new GroupLayout(question_bgd_panel);
		gl_question_bgd_panel.setHorizontalGroup(
			gl_question_bgd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_question_bgd_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(question_inner_panel, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_question_bgd_panel.setVerticalGroup(
			gl_question_bgd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_question_bgd_panel.createSequentialGroup()
					.addGap(64)
					.addComponent(question_inner_panel, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addContainerGap())
		);
		question_inner_panel.setLayout(new BorderLayout(0, 0));
		
		question_text = new JTextField();
		question_text.setHorizontalAlignment(SwingConstants.CENTER);
		question_inner_panel.add(question_text, BorderLayout.CENTER); // set question in question textfield
		question_text.setColumns(10);
		question_bgd_panel.setLayout(gl_question_bgd_panel);
		
		answer_inner_panel = new JPanel();
		GroupLayout gl_answer_bgd_panel = new GroupLayout(answer_bgd_panel);
		gl_answer_bgd_panel.setHorizontalGroup(
			gl_answer_bgd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_answer_bgd_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(answer_inner_panel, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_answer_bgd_panel.setVerticalGroup(
			gl_answer_bgd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_answer_bgd_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(answer_inner_panel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addContainerGap())
		);
		answer_inner_panel.setLayout(new BorderLayout(0, 0));
		
		answer_text = new JTextField();
		answer_text.setHorizontalAlignment(SwingConstants.CENTER);
		answer_text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try{ // to prevent player doesn't enter integer
					response = Integer.parseInt(answer_text.getText()); // get playser's answer
					
					admin_operation_openall();
					
					if(response != answer){ // if player give wrong answer
						stateFlow_text.append("You give me Wrong answer! Real answer is " + answer + ".\n");
						players.get(seq_player).minusCoin(); 
						stateFlow_text.append("Your Stone minus 1.\n");
						if(players.get(seq_player).getCoin()<0) // if coin number is -1
						{
							players.get(seq_player).giveup(mapBlock, seq_player); // kill player
							stateFlow_text.append("Player " + (seq_player+1) + " is dead.\n");
							if(checkend.howAlive(players)){ // if player number is 1
								cl.next(big_cardPanel);
								repaint();
							}
						}
						players.get(seq_player).minusTurn();
						if(checkend.turnOver(players)){
							cl.next(big_cardPanel);
							repaint();
						}
						refresh_question();
						refresh_answer();
						refresh_score();
						refresh_turn();
						repaint();
						plus_seq_player();
						stateFlow_text.append("Next turn! player " + (seq_player+1) + " start!\n");
						admin_opertion_closeall();
						user_operation_dice();
						
					}else{ // if player gives right answer
						stateFlow_text.append("You give me Right answer! You can buy this block! Would you take this?\n");
						admin_opertion_closeall();
						user_operation_block(); // make take and no take button available
					}
					
					
				}catch(NumberFormatException ex){ // if player doesn't enter integer
					admin_operation_openall();
					stateFlow_text.append("You have to give me Integer! Write again!\n");
					answer_text.setText(""); // clear answer textfield
					admin_opertion_closeall();
					user_operation_answer(); // make answer textfield available
				}
				
				
				
			}
		});
		
		answer_inner_panel.add(answer_text, BorderLayout.CENTER);
		answer_text.setColumns(10);
		answer_bgd_panel.setLayout(gl_answer_bgd_panel);
		Right_panel.setLayout(gl_Right_panel);
		
		
		Image block_img1 = new ImageIcon(this.getClass().getResource("/block1.png")).getImage();
		Image block_img2 = new ImageIcon(this.getClass().getResource("/block2.png")).getImage();
		Image block_img3 = new ImageIcon(this.getClass().getResource("/block3.png")).getImage();
		Image block_img4 = new ImageIcon(this.getClass().getResource("/block4.png")).getImage();
		Image block_img5 = new ImageIcon(this.getClass().getResource("/block5.png")).getImage();
		Image block_img6 = new ImageIcon(this.getClass().getResource("/block6.png")).getImage();
		Image block_img7 = new ImageIcon(this.getClass().getResource("/block7.png")).getImage();
		Image block_img8 = new ImageIcon(this.getClass().getResource("/block8.png")).getImage();
		Image block_img9 = new ImageIcon(this.getClass().getResource("/block9.png")).getImage();
		Image block_img10 = new ImageIcon(this.getClass().getResource("/block10.png")).getImage();
		Image block_img11 = new ImageIcon(this.getClass().getResource("/block11.png")).getImage();
		Image block_img12 = new ImageIcon(this.getClass().getResource("/block12.png")).getImage();
		
		Image block_img1_p1 = new ImageIcon(this.getClass().getResource("/block1_p1.png")).getImage();
		Image block_img1_p2 = new ImageIcon(this.getClass().getResource("/block1_p2.png")).getImage();
		Image block_img1_p3 = new ImageIcon(this.getClass().getResource("/block1_p3.png")).getImage();
		Image block_img1_p4 = new ImageIcon(this.getClass().getResource("/block1_p4.png")).getImage();
		
		Image block_img2_p1 = new ImageIcon(this.getClass().getResource("/block2_p1.png")).getImage();
		Image block_img2_p2 = new ImageIcon(this.getClass().getResource("/block2_p2.png")).getImage();
		Image block_img2_p3 = new ImageIcon(this.getClass().getResource("/block2_p3.png")).getImage();
		Image block_img2_p4 = new ImageIcon(this.getClass().getResource("/block2_p4.png")).getImage();
		
		Image block_img3_p1 = new ImageIcon(this.getClass().getResource("/block3_p1.png")).getImage();
		Image block_img3_p2 = new ImageIcon(this.getClass().getResource("/block3_p2.png")).getImage();
		Image block_img3_p3 = new ImageIcon(this.getClass().getResource("/block3_p3.png")).getImage();
		Image block_img3_p4 = new ImageIcon(this.getClass().getResource("/block3_p4.png")).getImage();
		
		Image block_img4_p1 = new ImageIcon(this.getClass().getResource("/block4_p1.png")).getImage();
		Image block_img4_p2 = new ImageIcon(this.getClass().getResource("/block4_p2.png")).getImage();
		Image block_img4_p3 = new ImageIcon(this.getClass().getResource("/block4_p3.png")).getImage();
		Image block_img4_p4 = new ImageIcon(this.getClass().getResource("/block4_p4.png")).getImage();
		
		Image block_img5_p1 = new ImageIcon(this.getClass().getResource("/block5_p1.png")).getImage();
		Image block_img5_p2 = new ImageIcon(this.getClass().getResource("/block5_p2.png")).getImage();
		Image block_img5_p3 = new ImageIcon(this.getClass().getResource("/block5_p3.png")).getImage();
		Image block_img5_p4 = new ImageIcon(this.getClass().getResource("/block5_p4.png")).getImage();
		
		Image block_img6_p1 = new ImageIcon(this.getClass().getResource("/block6_p1.png")).getImage();
		Image block_img6_p2 = new ImageIcon(this.getClass().getResource("/block6_p2.png")).getImage();
		Image block_img6_p3 = new ImageIcon(this.getClass().getResource("/block6_p3.png")).getImage();
		Image block_img6_p4 = new ImageIcon(this.getClass().getResource("/block6_p4.png")).getImage();
		
		Image block_img7_p1 = new ImageIcon(this.getClass().getResource("/block7_p1.png")).getImage();
		Image block_img7_p2 = new ImageIcon(this.getClass().getResource("/block7_p2.png")).getImage();
		Image block_img7_p3 = new ImageIcon(this.getClass().getResource("/block7_p3.png")).getImage();
		Image block_img7_p4 = new ImageIcon(this.getClass().getResource("/block7_p4.png")).getImage();
		
		Image block_img8_p1 = new ImageIcon(this.getClass().getResource("/block8_p1.png")).getImage();
		Image block_img8_p2 = new ImageIcon(this.getClass().getResource("/block8_p2.png")).getImage();
		Image block_img8_p3 = new ImageIcon(this.getClass().getResource("/block8_p3.png")).getImage();
		Image block_img8_p4 = new ImageIcon(this.getClass().getResource("/block8_p4.png")).getImage();
		
		Image block_img9_p1 = new ImageIcon(this.getClass().getResource("/block9_p1.png")).getImage();
		Image block_img9_p2 = new ImageIcon(this.getClass().getResource("/block9_p2.png")).getImage();
		Image block_img9_p3 = new ImageIcon(this.getClass().getResource("/block9_p3.png")).getImage();
		Image block_img9_p4 = new ImageIcon(this.getClass().getResource("/block9_p4.png")).getImage();
		
		Image block_img10_p1 = new ImageIcon(this.getClass().getResource("/block10_p1.png")).getImage();
		Image block_img10_p2 = new ImageIcon(this.getClass().getResource("/block10_p2.png")).getImage();
		Image block_img10_p3 = new ImageIcon(this.getClass().getResource("/block10_p3.png")).getImage();
		Image block_img10_p4 = new ImageIcon(this.getClass().getResource("/block10_p4.png")).getImage();
		
		Image block_img11_p1 = new ImageIcon(this.getClass().getResource("/block11_p1.png")).getImage();
		Image block_img11_p2 = new ImageIcon(this.getClass().getResource("/block11_p2.png")).getImage();
		Image block_img11_p3 = new ImageIcon(this.getClass().getResource("/block11_p3.png")).getImage();
		Image block_img11_p4 = new ImageIcon(this.getClass().getResource("/block11_p4.png")).getImage();
		
		Image block_img12_p1 = new ImageIcon(this.getClass().getResource("/block12_p1.png")).getImage();
		Image block_img12_p2 = new ImageIcon(this.getClass().getResource("/block12_p2.png")).getImage();
		Image block_img12_p3 = new ImageIcon(this.getClass().getResource("/block12_p3.png")).getImage();
		Image block_img12_p4 = new ImageIcon(this.getClass().getResource("/block12_p4.png")).getImage();
		
		
		
		
		block1 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				
				if(mapBlock.get(0).getBlockOwner()==0){ // if block's master is p1
					g.drawImage(block_img1_p1, 0, 0, null);
				}
				else if(mapBlock.get(0).getBlockOwner()==1){ // if block's master is p2
					g.drawImage(block_img1_p2, 0, 0, null);
				}
				else if(mapBlock.get(0).getBlockOwner()==2){ // if block's master is p3
					g.drawImage(block_img1_p3, 0, 0, null);
				}
				else if(mapBlock.get(0).getBlockOwner()==3){ // if block's master is p4
					g.drawImage(block_img1_p4, 0, 0, null);
				}
				else // if there is not block's master
					g.drawImage(block_img1, 0, 0, null);
									
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block2 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				
				if(mapBlock.get(1).getBlockOwner()==0){
					g.drawImage(block_img2_p1, 0, 0, null);
				}
				else if(mapBlock.get(1).getBlockOwner()==1){
					g.drawImage(block_img2_p2, 0, 0, null);
				}
				else if(mapBlock.get(1).getBlockOwner()==2){
					g.drawImage(block_img2_p3, 0, 0, null);
				}
				else if(mapBlock.get(1).getBlockOwner()==3){
					g.drawImage(block_img2_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img2, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block3 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(2).getBlockOwner()==0){
					g.drawImage(block_img3_p1, 0, 0, null);
				}
				else if(mapBlock.get(2).getBlockOwner()==1){
					g.drawImage(block_img3_p2, 0, 0, null);
				}
				else if(mapBlock.get(2).getBlockOwner()==2){
					g.drawImage(block_img3_p3, 0, 0, null);
				}
				else if(mapBlock.get(2).getBlockOwner()==3){
					g.drawImage(block_img3_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img3, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block4 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(3).getBlockOwner()==0){
					g.drawImage(block_img4_p1, 0, 0, null);
				}
				else if(mapBlock.get(3).getBlockOwner()==1){
					g.drawImage(block_img4_p2, 0, 0, null);
				}
				else if(mapBlock.get(3).getBlockOwner()==2){
					g.drawImage(block_img4_p3, 0, 0, null);
				}
				else if(mapBlock.get(3).getBlockOwner()==3){
					g.drawImage(block_img4_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img4, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block5 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(4).getBlockOwner()==0){
					g.drawImage(block_img5_p1, 0, 0, null);
				}
				else if(mapBlock.get(4).getBlockOwner()==1){
					g.drawImage(block_img5_p2, 0, 0, null);
				}
				else if(mapBlock.get(4).getBlockOwner()==2){
					g.drawImage(block_img5_p3, 0, 0, null);
				}
				else if(mapBlock.get(4).getBlockOwner()==3){
					g.drawImage(block_img5_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img5, 0, 0, null);				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block6 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(5).getBlockOwner()==0){
					g.drawImage(block_img6_p1, 0, 0, null);
				}
				else if(mapBlock.get(5).getBlockOwner()==1){
					g.drawImage(block_img6_p2, 0, 0, null);
				}
				else if(mapBlock.get(5).getBlockOwner()==2){
					g.drawImage(block_img6_p3, 0, 0, null);
				}
				else if(mapBlock.get(5).getBlockOwner()==3){
					g.drawImage(block_img6_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img6, 0, 0, null);				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block7 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(6).getBlockOwner()==0){
					g.drawImage(block_img7_p1, 0, 0, null);
				}
				else if(mapBlock.get(6).getBlockOwner()==1){
					g.drawImage(block_img7_p2, 0, 0, null);
				}
				else if(mapBlock.get(6).getBlockOwner()==2){
					g.drawImage(block_img7_p3, 0, 0, null);
				}
				else if(mapBlock.get(6).getBlockOwner()==3){
					g.drawImage(block_img7_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img7, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block8 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(7).getBlockOwner()==0){
					g.drawImage(block_img8_p1, 0, 0, null);
				}
				else if(mapBlock.get(7).getBlockOwner()==1){
					g.drawImage(block_img8_p2, 0, 0, null);
				}
				else if(mapBlock.get(7).getBlockOwner()==2){
					g.drawImage(block_img8_p3, 0, 0, null);
				}
				else if(mapBlock.get(7).getBlockOwner()==3){
					g.drawImage(block_img8_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img8, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block9 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(8).getBlockOwner()==0){
					g.drawImage(block_img9_p1, 0, 0, null);
				}
				else if(mapBlock.get(8).getBlockOwner()==1){
					g.drawImage(block_img9_p2, 0, 0, null);
				}
				else if(mapBlock.get(8).getBlockOwner()==2){
					g.drawImage(block_img9_p3, 0, 0, null);
				}
				else if(mapBlock.get(8).getBlockOwner()==3){
					g.drawImage(block_img9_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img9, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block10 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(9).getBlockOwner()==0){
					g.drawImage(block_img10_p1, 0, 0, null);
				}
				else if(mapBlock.get(9).getBlockOwner()==1){
					g.drawImage(block_img10_p2, 0, 0, null);
				}
				else if(mapBlock.get(9).getBlockOwner()==2){
					g.drawImage(block_img10_p3, 0, 0, null);
				}
				else if(mapBlock.get(9).getBlockOwner()==3){
					g.drawImage(block_img10_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img10, 0, 0, null);				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block11 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(10).getBlockOwner()==0){
					g.drawImage(block_img11_p1, 0, 0, null);
				}
				else if(mapBlock.get(10).getBlockOwner()==1){
					g.drawImage(block_img11_p2, 0, 0, null);
				}
				else if(mapBlock.get(10).getBlockOwner()==2){
					g.drawImage(block_img11_p3, 0, 0, null);
				}
				else if(mapBlock.get(10).getBlockOwner()==3){
					g.drawImage(block_img11_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img11, 0, 0, null);				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		block12 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				if(mapBlock.get(11).getBlockOwner()==0){
					g.drawImage(block_img12_p1, 0, 0, null);
				}
				else if(mapBlock.get(11).getBlockOwner()==1){
					g.drawImage(block_img12_p2, 0, 0, null);
				}
				else if(mapBlock.get(11).getBlockOwner()==2){
					g.drawImage(block_img12_p3, 0, 0, null);
				}
				else if(mapBlock.get(11).getBlockOwner()==3){
					g.drawImage(block_img12_p4, 0, 0, null);
				}
				else
					g.drawImage(block_img12, 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		

		
		
		
		
		GroupLayout gl_block_panel = new GroupLayout(block_panel);
		gl_block_panel.setHorizontalGroup(
			gl_block_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_block_panel.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_block_panel.createSequentialGroup()
							.addComponent(block11, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(block10, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(block9, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(block8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addComponent(block12, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_block_panel.createSequentialGroup()
							.addComponent(block1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(block2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(block3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(block4, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(block5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block6, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block7, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(79))
		);
		gl_block_panel.setVerticalGroup(
			gl_block_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_block_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_block_panel.createSequentialGroup()
							.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(block1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(block5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(block12, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(block6, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
						.addComponent(block4, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_block_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(block7, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block9, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block10, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(block11, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		block_panel.setLayout(gl_block_panel);
		
		
		
		
		
		
		
		
		// real dice
		
		GroupLayout gl_diceBackground = new GroupLayout(diceBackground);
		gl_diceBackground.setHorizontalGroup(
			gl_diceBackground.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diceBackground.createSequentialGroup()
					.addGap(22)
					.addComponent(realDice, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_diceBackground.setVerticalGroup(
			gl_diceBackground.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diceBackground.createSequentialGroup()
					.addGap(16)
					.addComponent(realDice, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		diceBackground.setLayout(gl_diceBackground);
		
		
		
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		menubar.setLayout(gl_menubar);
		intro.setLayout(new BorderLayout());
		prologue.setLayout(new BorderLayout());
		game_rule1.setLayout(new BorderLayout());
		game_rule2.setLayout(new BorderLayout());
		game_playing.setLayout(gl_game_playing);
		
		
		
		
		
		big_cardPanel.add(menubar, "zero");
		big_cardPanel.add(intro, "first");
		big_cardPanel.add(prologue, "second");
		big_cardPanel.add(game_rule1, "third");
		big_cardPanel.add(game_rule2, "fourth");
		big_cardPanel.add(game_setting, "fifth");
		big_cardPanel.add(game_playing, "sixth");
		big_cardPanel.add(result_panel, "seventh");
		
		JButton exit_btn = new JButton("Good Bye!");
		exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Fileinout testfile = new Fileinout();
				
				testfile.save_and_goout(result_is); // save winner into history
				
			}
			
		});
		
		exit_btn.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		GroupLayout gl_result_panel = new GroupLayout(result_panel);
		gl_result_panel.setHorizontalGroup(
			gl_result_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_result_panel.createSequentialGroup()
					.addContainerGap(1116, Short.MAX_VALUE)
					.addComponent(exit_btn)
					.addGap(19))
		);
		gl_result_panel.setVerticalGroup(
			gl_result_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_result_panel.createSequentialGroup()
					.addContainerGap(591, Short.MAX_VALUE)
					.addComponent(exit_btn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		result_panel.setLayout(gl_result_panel);
		
		
		
		
		
		
		
		

		intro_background_btn = new JButton();
		intro_background_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.next(big_cardPanel);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/intro.jpg")).getImage();
		intro_background_btn.setIcon(new ImageIcon(img));
		intro.add(BorderLayout.CENTER, intro_background_btn);
		
		
		
		
		prologue_Background_btn = new JButton();
		prologue_Background_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.next(big_cardPanel);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/prologue.jpg")).getImage();
		prologue_Background_btn.setIcon(new ImageIcon(img2));
		prologue.add(BorderLayout.CENTER, prologue_Background_btn);
		
		
		
		
		game_rule1_btn = new JButton();
		game_rule1_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.next(big_cardPanel);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/rule1.jpg")).getImage();
		game_rule1_btn.setIcon(new ImageIcon(img3));
		game_rule1.add(BorderLayout.CENTER, game_rule1_btn);
		
		
		
		
		game_rule2_btn = new JButton();
		game_rule2_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.next(big_cardPanel);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/rule2.jpg")).getImage();
		game_rule2_btn.setIcon(new ImageIcon(img4));
		game_rule2.add(BorderLayout.CENTER, game_rule2_btn);
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////Gamesetting section//////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		Image game_setting_in_img = new ImageIcon(this.getClass().getResource("/game_setting.jpg")).getImage();
		
		game_setting_in = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(game_setting_in_img, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		GroupLayout gl_game_setting = new GroupLayout(game_setting);
		gl_game_setting.setHorizontalGroup(
			gl_game_setting.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_game_setting.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(game_setting_in, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
		);
		gl_game_setting.setVerticalGroup(
			gl_game_setting.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_game_setting.createSequentialGroup()
					.addContainerGap(177, Short.MAX_VALUE)
					.addComponent(game_setting_in, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
		);
		
		
		
		
		JLabel lblTheNumber = new JLabel("1. The number of player :");
		lblTheNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lblANumber = new JLabel("2. A number of stones :");
		lblANumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lblANumber_1 = new JLabel("3. A number of Thurn :");
		lblANumber_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		
		new ButtonGroup();
		new ButtonGroup();
		new ButtonGroup();
		buttonGroup_3 = new ButtonGroup();
		buttonGroup_4 = new ButtonGroup();
		buttonGroup_5 = new ButtonGroup();
		
		
		
		chckPerson1 = new JCheckBox("2 person");
		chckPerson1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckPerson1.isSelected()){
					number_of_player=2;
					set[0]=number_of_player; // set default number of player
				}
			}			
		});
		buttonGroup_3.add(chckPerson1);
		chckPerson1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckPerson2 = new JCheckBox("3 person");
		chckPerson2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckPerson2.isSelected()){
					number_of_player=3;
					set[0]=number_of_player;
				}
			}			
		});
		buttonGroup_3.add(chckPerson2);
		chckPerson2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckPerson3 = new JCheckBox("4 person");
		chckPerson3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckPerson3.isSelected()){
					number_of_player=4;
					set[0]=number_of_player;
				}
			}			
		});
		buttonGroup_3.add(chckPerson3);
		chckPerson3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckCoins1 = new JCheckBox("3 stones");
		chckCoins1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckCoins1.isSelected()){
					number_of_coin=3;
					set[1]=number_of_coin; // set default number of coin
				}
			}			
		});
		buttonGroup_4.add(chckCoins1);
		chckCoins1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckCoins2 = new JCheckBox("5 stones");
		chckCoins2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckCoins2.isSelected());
				number_of_coin=5;
				set[1]=number_of_coin;
			}			
		});
		buttonGroup_4.add(chckCoins2);
		chckCoins2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckCoins3 = new JCheckBox("10 stones");
		chckCoins3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckCoins3.isSelected());
				number_of_coin=10;
				set[1]=number_of_coin;
			}			
		});
		buttonGroup_4.add(chckCoins3);
		chckCoins3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckCoins4 = new JCheckBox("15 stones");
		chckCoins4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckCoins4.isSelected());
				number_of_coin=15;
				set[1]=number_of_coin;
			}			
		});
		buttonGroup_4.add(chckCoins4);
		chckCoins4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckTurns1 = new JCheckBox("10 turns");
		chckTurns1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckTurns1.isSelected());
				number_of_turn=10;
				set[2]=number_of_turn; // set default number of turn
			}			
		});
		buttonGroup_5.add(chckTurns1);
		chckTurns1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckTurns2 = new JCheckBox("15 turns");
		chckTurns2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckTurns2.isSelected());
				number_of_turn=15;
				set[2]=number_of_turn;
			}			
		});
		buttonGroup_5.add(chckTurns2);
		chckTurns2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		chckTurns3 = new JCheckBox("20 turns");
		chckTurns3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chckTurns3.isSelected());
				number_of_turn=20;
				set[2]=number_of_turn;
			}			
		});
		buttonGroup_5.add(chckTurns3);
		chckTurns3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		
		
		
		setting_startgame = new JButton("Start Game!");
		setting_startgame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(chckPerson1.isSelected() || chckPerson2.isSelected() || chckPerson3.isSelected())
					if(chckCoins1.isSelected() || chckCoins2.isSelected() || chckCoins3.isSelected() || chckCoins4.isSelected())
						if(chckTurns1.isSelected() || chckTurns2.isSelected() || chckTurns3.isSelected()){
							
							admin_operation_openall();
							
							mapBlock = block.setBlock(); // make blocks
							
							p1 = new Player("p1", -1, set[1], 0, set[2], true);
							p2 = new Player("p2", -1, set[1], 0, set[2], true);
							p3 = new Player("p3", -1, set[1], 0, set[2], true);
							p4 = new Player("p4", -1, set[1], 0, set[2], true);
							// ( name,location,coin, blockNumber,turn, alive )
							
							
							players.add(p1); // add player to player arraylist
							players.add(p2);
							players.add(p3);
							players.add(p4);
							
							if(set[0]==2){ // if player number is 2
								p3.setAlive(false); // kill 2 player
								p4.setAlive(false);
							}else if (set[0]==3){ // if player number is 3
								p4.setAlive(false); // kill 1 player
							}
							
							cl.next(big_cardPanel);
							
							stateFlow_text.append("Let's Start Game!\n");
							stateFlow_text.append("Player " + (seq_player+1) + " choose Dice or Give up\n");
							
							refresh_question();
							refresh_answer();
							refresh_score();
							refresh_turn();
							repaint();
							admin_opertion_closeall();
							user_operation_dice();

						}
							
			}
		});
		
		
		
		
		
		GroupLayout gl_game_setting_in = new GroupLayout(game_setting_in);
		gl_game_setting_in.setHorizontalGroup(
			gl_game_setting_in.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_game_setting_in.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTheNumber)
						.addComponent(lblANumber_1)
						.addComponent(lblANumber))
					.addGap(78)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.LEADING)
						.addComponent(chckPerson1)
						.addComponent(chckCoins1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckTurns1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.LEADING)
						.addComponent(chckPerson2)
						.addComponent(chckCoins2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckTurns2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_game_setting_in.createSequentialGroup()
							.addGroup(gl_game_setting_in.createParallelGroup(Alignment.LEADING)
								.addComponent(chckPerson3)
								.addComponent(chckCoins3))
							.addGap(67)
							.addComponent(chckCoins4))
						.addComponent(chckTurns3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(gl_game_setting_in.createSequentialGroup()
					.addContainerGap(928, Short.MAX_VALUE)
					.addComponent(setting_startgame)
					.addGap(15))
		);
		gl_game_setting_in.setVerticalGroup(
			gl_game_setting_in.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_game_setting_in.createSequentialGroup()
					.addGap(166)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTheNumber)
						.addComponent(chckPerson1)
						.addComponent(chckPerson2)
						.addComponent(chckPerson3))
					.addGap(73)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckCoins1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblANumber)
						.addComponent(chckCoins2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckCoins3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckCoins4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(gl_game_setting_in.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblANumber_1)
						.addComponent(chckTurns1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckTurns2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckTurns3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(setting_startgame)
					.addGap(20))
		);
		game_setting_in.setLayout(gl_game_setting_in);
		game_setting.setLayout(gl_game_setting);

		
		
		setSize(1282, 722);
		setVisible(true);
		
		
		
	}
	
	private void admin_opertion_closeall(){ // set all components in game playing panel unavailable
		
		question_text.setEnabled(false);
		state_1_1.setEnabled(false);
		state_1_2.setEnabled(false);
		state_1_3.setEnabled(false);
		state_1_4.setEnabled(false);
		state_2_1.setEnabled(false);
		state_2_2.setEnabled(false);
		state_2_3.setEnabled(false);
		state_2_4.setEnabled(false);
		turn_textfield.setEnabled(false);
		stateFlow_text.setEnabled(false);
		
		dice_btn.setEnabled(false);
		giveup_btn.setEnabled(false);
		take_btn.setEnabled(false);
		notake_btn.setEnabled(false);
		answer_text.setEnabled(false);
	}
	
	private void admin_operation_openall(){ // set all components in game playing panel available
		
		question_text.setEnabled(true);
		state_1_1.setEnabled(true);
		state_1_2.setEnabled(true);
		state_1_3.setEnabled(true);
		state_1_4.setEnabled(true);
		state_2_1.setEnabled(true);
		state_2_2.setEnabled(true);
		state_2_3.setEnabled(true);
		state_2_4.setEnabled(true);
		turn_textfield.setEnabled(true);
		stateFlow_text.setEnabled(true);
		
		dice_btn.setEnabled(true);
		giveup_btn.setEnabled(true);
		take_btn.setEnabled(true);
		notake_btn.setEnabled(true);
		answer_text.setEnabled(true);
		
	}
	
	private void user_operation_dice(){ // set dice components in game playing panel available
		
		dice_btn.setEnabled(true);
		giveup_btn.setEnabled(true);
		take_btn.setEnabled(false);
		notake_btn.setEnabled(false);
		answer_text.setEnabled(false);
		
	}
	
	private void user_operation_answer(){ // set answer textfield components in game playing panel available
		
		dice_btn.setEnabled(false);
		giveup_btn.setEnabled(false);
		take_btn.setEnabled(false);
		notake_btn.setEnabled(false);
		answer_text.setEnabled(true);
		
	}
	
	private void user_operation_block(){ // set take and no take btn components in game playing panel available
		
		dice_btn.setEnabled(false);
		giveup_btn.setEnabled(false);
		take_btn.setEnabled(true);
		notake_btn.setEnabled(true);
		answer_text.setEnabled(false);
		
	}
	
	private void refresh_score(){ // refresh score textfield
		
		
		state_1_1.setText("");
		state_2_1.setText("");
		state_1_2.setText("");
		state_2_2.setText("");
		state_1_3.setText("");
		state_2_3.setText("");
		state_1_4.setText("");
		state_2_4.setText("");
		
			
		for(int i=0; i<4; i++){
			if(players.get(i).isAlive()){
				if(i==0){
					state_1_1.setText(""+players.get(0).getCoin());
					state_2_1.setText(""+players.get(0).getBlockNumber());
				}else if(i==1){
					state_1_2.setText(""+players.get(1).getCoin());
					state_2_2.setText(""+players.get(1).getBlockNumber());
				}else if(i==2){
					state_1_3.setText(""+players.get(2).getCoin());
					state_2_3.setText(""+players.get(2).getBlockNumber());
				}else if(i==3){
					state_1_4.setText(""+players.get(3).getCoin());
					state_2_4.setText(""+players.get(3).getBlockNumber());
				}
			}
		}
			
	}
	
	private void refresh_turn(){ // refresh turn
		
		int tmp=0;
		
		turn_textfield.setText("");
		
		for(int i=0; i<4; i++){
			if(players.get(i).isAlive()){
				if(players.get(i).getTurn()>tmp)
					tmp=players.get(i).getTurn();

			}
		}
		turn_textfield.setText(""+tmp);
		tmp=0;
	}
	
	private void refresh_question(){ // clear question textfield
		question_text.setText("");
	}
	
	private void refresh_answer(){ // clear answer textfield
		answer_text.setText("");
	}
	
	private void plus_seq_player(){ // pass turn to next playser
		
		while(true){
			seq_player++;
			if(seq_player==4) // if current turn is player 4, go back to player 1
				seq_player=0;
			if(players.get(seq_player).isAlive() == true){ // select player who is alive
				break;
			}
		}
	}
}




