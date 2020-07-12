package kr.ac.ajou.group_Seven.end;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class history extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	public history() {
		setTitle("~History~");
		setBounds(200, 200, 300, 350);
			
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		JButton btnReset = new JButton("History Reset");
		btnReset.setBackground(new Color(51, 153, 0));
		btnReset.addActionListener(new ResetListener());
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	// load history file and show textarea
	public void loadFile(File file){
		String list = new String();
		
	try {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line = null;
		while((line=reader.readLine())!=null){
			list = list+line+"\n";
		}
		
		textArea.setText(list);
		reader.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	// when player click the reset button, history file reset.
	public class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			File myFile = new File("History.txt");
			myFile.delete();
			textArea.setText("");
		}
		
	}
}
