package edu.psgv.sweng861;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

public class FlightAppUi {

	private JFrame applicationFrame;
	private JPanel dataEntryPanel;
	private JPanel flightDisplayPanel;
	private JPanel errorPanel;
	
	public FlightAppUi() {
		applicationFrame = new JFrame();
		try {
			initializeDataEntryPanel();
			initializeErrorPanel();
			applicationFrame.add(dataEntryPanel);
		} catch (ParseException e) {
			
		}
		applicationFrame.setVisible(true);
	}
	
	private void findFlightsButtonClicked(String startingAirport, String endingAirport) {
		AmadeusClient client = new AmadeusClient();
		displayFlightListPanel(client.getFlights(startingAirport, endingAirport, "2023-11-01", TravelClass.ECONOMY, 1, false));
	}
	
	private void displayDataEntryPanel() {
		applicationFrame.removeAll();
		applicationFrame.add(dataEntryPanel);
	}
	
	private void displayFlightListPanel(AmadeusFlightOffersResponse flightOffersResponse) {
		applicationFrame.removeAll();
		flightDisplayPanel = new JPanel();
		if(flightOffersResponse == null) {
			displayErrorPanel("Error Retriving Flight Information");
		} else {
			JPanel scrollingPanel = new JPanel();
			scrollingPanel.setLayout(new BoxLayout(scrollingPanel, BoxLayout.Y_AXIS));
			JScrollPane scrollPane = new JScrollPane(scrollingPanel);
			
			flightDisplayPanel.add(scrollPane);
		}
	}
	
	private JButton formatFlightInfoButton() {
		JButton flightButton = new JButton();
		
		return flightButton;
	}
	
	private void displayErrorPanel(String error) {
		JLabel errorLabel = new JLabel(error);
		errorPanel.add(errorLabel);
		applicationFrame.removeAll();
		applicationFrame.add(errorPanel);
	}
	
	private void initializeDataEntryPanel() throws ParseException {
		dataEntryPanel = new JPanel();
		dataEntryPanel.setLayout(new BoxLayout(dataEntryPanel, BoxLayout.X_AXIS));
		JLabel startingIataCodeLabel = new JLabel("Starting Airport IATA Code");
		dataEntryPanel.add(startingIataCodeLabel);
		final JFormattedTextField startingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		dataEntryPanel.add(startingIataCodeField);
		JLabel endingIataCodeLabel = new JLabel("Ending Airport IATA Code");
		dataEntryPanel.add(endingIataCodeLabel);
		final JFormattedTextField endingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		dataEntryPanel.add(endingIataCodeField);
		
		JButton findFlightsButton = new JButton("Find Flights");
		findFlightsButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 findFlightsButtonClicked(startingIataCodeField.getText(), endingIataCodeField.getText());
	          }
	       });
	}
	
	private void initializeErrorPanel() {
		errorPanel = new JPanel();
		
	}
}
