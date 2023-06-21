package edu.psgv.sweng861;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

/**
 * Displays and runs the UI for the flight app
 * @author zachb
 *
 */
public class FlightAppUi {

	private JFrame applicationFrame;
	private JPanel flightSearchPanel;
	private JPanel flightDisplayPanel;
	private JPanel errorPanel;
	private JPanel flightInfoPanel;
	private Dictionaries dictionaries;
	
	/**
	 * Constructor, displays the initial panel
	 */
	public FlightAppUi() {
		applicationFrame = new JFrame();
		applicationFrame.setSize(1000, 1000);
		try {
			initializeFlightSearchPanel();
			initializeErrorPanel();
			initializeFlightDisplayPanel();
			initializeFlightInfoPanel();
			applicationFrame.add(flightSearchPanel);
		} catch (ParseException e) {
			displayErrorPanel("Initialization Error");
		}
		applicationFrame.setVisible(true);
	}
	
	/**
	 * Instantiates a new JPanel for the flightInfoPanel
	 */
	private void initializeFlightInfoPanel() {
		flightInfoPanel = new JPanel();
	}
	
	/**
	 * Instantiates a new JPanel for the errorPanel
	 */
	private void initializeErrorPanel() {
		errorPanel = new JPanel();
	}
	
	/**
	 * Instantiates a new JPanel for the flightDisplayPanel
	 */
	private void initializeFlightDisplayPanel() {
		flightDisplayPanel = new JPanel();
	}
	
	/**
	 * Displays the flightSearchPanel and turns off the other two panels.
	 */
	private void displayflightSearchPanel() {
		flightSearchPanel.setVisible(true);
		errorPanel.setVisible(false);
		flightDisplayPanel.setVisible(false);
	}
	
	/**
	 * Displays the flightListPanel, and adds a button to the scroll pane for each flight offer
	 * @param AmadeusFlightOffersResponse flightOffersResponse
	 */
	private void displayFlightListPanel(AmadeusFlightOffersResponse flightOffersResponse) {

		if(flightOffersResponse == null || flightOffersResponse.getData() == null) {
			displayErrorPanel("Error Retriving Flight Information");
		} else {
			dictionaries = flightOffersResponse.getDictionaries();
			applicationFrame.remove(flightDisplayPanel);
			flightDisplayPanel = new JPanel();
			flightDisplayPanel.setLayout(new BoxLayout(flightDisplayPanel, BoxLayout.Y_AXIS));
			JLabel flightDisplayPanelLabel = new JLabel("Flights Found");
			flightDisplayPanel.add(flightDisplayPanelLabel);
			JPanel scrollingPanel = new JPanel();
			scrollingPanel.setLayout(new BoxLayout(scrollingPanel, BoxLayout.Y_AXIS));
			JScrollPane scrollPane = new JScrollPane(scrollingPanel);
			scrollPane.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
			for(AmadeusFlightOffer flightOffer: flightOffersResponse.getData()) {
				scrollingPanel.add(formatFlightInfoButton(flightOffer));
			}
			flightDisplayPanel.add(scrollPane);
			JButton newSearchButton = new JButton("New Search");
			newSearchButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 displayflightSearchPanel();
		         }
		       });
			flightDisplayPanel.add(newSearchButton);
			applicationFrame.add(flightDisplayPanel);
			errorPanel.setVisible(false);
			flightSearchPanel.setVisible(false);
			flightDisplayPanel.setVisible(true);
			System.out.println("Displaying FlightListPanel");
		}
	}
	
	/**
	 * Creates a JButton with text of basic flight info and when clicked launches the FlightInfoPanel for the flight offer
	 * @param AmadeusFlightOffer flightOffer
	 * @return JButton
	 */
	private JButton formatFlightInfoButton(AmadeusFlightOffer flightOffer) {
		String stopString = "";
		if (flightOffer.getItineraries().get(0).getFlightSegments().size() == 1) {
			stopString= "nonstop";
		} else if (flightOffer.getItineraries().get(0).getFlightSegments().size() == 2) {
			stopString = "1 stop";
		} else {
			stopString = "" + (flightOffer.getItineraries().get(0).getFlightSegments().size() - 1) + " stops";
		}

		JButton flightButton = new JButton("" + flightOffer.getPrice().getTotal() + " " + dictionaries.getCarriers().get(flightOffer.getItineraries().get(0).getFlightSegments().get(0).getCarrierCode()) + " " + stopString);
		flightButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 displayFlightInfoPanel(flightOffer);
	          }
	       });
		flightButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		return flightButton;
	}
	
	/**
	 * Displays the FlightInfoPanel
	 * @param AmadeusFlightOffer flightOffer
	 */
	private void displayFlightInfoPanel(AmadeusFlightOffer flightOffer) {
		applicationFrame.remove(flightInfoPanel);
		flightInfoPanel = new JPanel();
		flightInfoPanel.setLayout(new BoxLayout(flightInfoPanel, BoxLayout.Y_AXIS));
		String flightInfoText = flightOffer.toString(dictionaries);
		JLabel flightInfoLabel = new JLabel("<html><pre>" + flightInfoText + "</pre></html>");
		flightInfoPanel.add(flightInfoLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 flightInfoPanel.setVisible(false);
	        	 flightDisplayPanel.setVisible(true);
	        	 
	          }
	       });
		flightInfoPanel.add(backButton);
		
		
		
		errorPanel.setVisible(false);
		flightSearchPanel.setVisible(false);
		flightDisplayPanel.setVisible(false);
		
		applicationFrame.add(flightInfoPanel);
	}
	
	/**
	 * Displays the error panel
	 * @param String error
	 */
	private void displayErrorPanel(String error) {
		applicationFrame.remove(errorPanel);
		errorPanel = new JPanel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));
		JLabel errorPanelLabel = new JLabel("AN ERROR HAS OCCURED");
		errorPanel.add(errorPanelLabel);
		JLabel errorLabel = new JLabel(error);
		errorPanel.add(errorLabel);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayflightSearchPanel();
	          }
	       });
		errorPanel.add(backButton);
		applicationFrame.add(errorPanel);
		flightSearchPanel.setVisible(false);
		flightDisplayPanel.setVisible(false);
		errorPanel.setVisible(true);
	}
	
	/**
	 * Initializes the flightSearchPanel, creates all of the data entry UI elements
	 * @throws ParseException
	 */
	private void initializeFlightSearchPanel() throws ParseException {
		flightSearchPanel = new JPanel();
		flightSearchPanel.setLayout(new BoxLayout(flightSearchPanel, BoxLayout.Y_AXIS));
		JLabel flightSearchPanelLabel = new JLabel("Find Flights");
		flightSearchPanel.add(flightSearchPanelLabel);
		JPanel dataEntryPanel = new JPanel();
		dataEntryPanel.setLayout(new BoxLayout(dataEntryPanel, BoxLayout.X_AXIS));
		JLabel startingIataCodeLabel = new JLabel("Starting Airport IATA Code");
		dataEntryPanel.add(startingIataCodeLabel);
		final JFormattedTextField startingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		startingIataCodeField.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(startingIataCodeField);
		JLabel endingIataCodeLabel = new JLabel("Ending Airport IATA Code");
		dataEntryPanel.add(endingIataCodeLabel);
		final JFormattedTextField endingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		endingIataCodeField.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(endingIataCodeField);
		JLabel travelClassLabel = new JLabel("Class");
		dataEntryPanel.add(travelClassLabel);
		JComboBox<TravelClass> travelClassComboBox = new JComboBox<TravelClass>();
		travelClassComboBox.setModel(new DefaultComboBoxModel<TravelClass>(TravelClass.values()));
		travelClassComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(travelClassComboBox);
		JLabel ticketsLabel = new JLabel("Tickets");
		dataEntryPanel.add(ticketsLabel);
		JComboBox<Integer> ticketsComboBox = new JComboBox<Integer>();
		Integer[] ticketArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; 
		ticketsComboBox.setModel(new DefaultComboBoxModel<Integer>(ticketArray));
		ticketsComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(ticketsComboBox);
		JLabel nonStopLabel = new JLabel("Nonstop Flight");
		dataEntryPanel.add(nonStopLabel);
		JCheckBox nonStopCheckBox = new JCheckBox();
		dataEntryPanel.add(nonStopCheckBox);
		JLabel flightDateLabel = new JLabel("Date");
		dataEntryPanel.add(flightDateLabel);
		JComboBox<String> monthComboBox = new JComboBox<String>();
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthComboBox.setModel(new DefaultComboBoxModel<String>(months));
		monthComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(monthComboBox);
		JComboBox<String> dayComboBox = new JComboBox<String>();
		String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		dayComboBox.setModel(new DefaultComboBoxModel<String>(days));
		dayComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(dayComboBox);
		JComboBox<String> yearComboBox = new JComboBox<String>();
		String[] years = {"2023", "2024", "2025"};
		yearComboBox.setModel(new DefaultComboBoxModel<String>(years));
		yearComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(yearComboBox);
		
		flightSearchPanel.add(dataEntryPanel);
		
		JButton findFlightsButton = new JButton("Find Flights");
		findFlightsButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 try {
	        		 System.out.println("StartingCode:" + startingIataCodeField.getText().getBytes());
	        		 if(startingIataCodeField.getText().trim().equals("") || endingIataCodeField.getText().trim().equals("")) {
	        			 throw new Exception("IATA codes required");
	        			 
	        		 }
	        		 String dateString = createDateString((String)monthComboBox.getSelectedItem(), (String)dayComboBox.getSelectedItem(), (String)yearComboBox.getSelectedItem());
	        		 if(isDateValid(dateString)) {
	        			 findFlightsButtonClicked(startingIataCodeField.getText(), endingIataCodeField.getText(), dateString, (TravelClass)travelClassComboBox.getSelectedItem(), (Integer)ticketsComboBox.getSelectedItem(), nonStopCheckBox.isSelected());
	        		 } else {
	        			 throw new Exception("Date must not be before today");
	        		 }
				} catch (Exception exception) {
					displayErrorPanel(exception.getMessage());
				}
	          }
	       });
		flightSearchPanel.add(findFlightsButton);
	}
	
	/**
	 * Called when the User clicks the Find Flights button, initializes a new AmadeusClient and makes a call to get flights for the
	 * user provided info.
	 * @param String startingAirport
	 * @param Stirng endingAirport
	 * @param String date
	 * @param TravelClass travelClass
	 * @param int tickets
	 * @param boolean nonStop
	 */
	private void findFlightsButtonClicked(String startingAirport, String endingAirport, String date, TravelClass travelClass, int tickets, boolean nonStop) {
		AmadeusClient client = new AmadeusClient();
		try {
			displayFlightListPanel(client.getFlights(startingAirport, endingAirport, date, travelClass, tickets, nonStop));
		} catch (Exception e) {
			displayErrorPanel("Error getting access token. " + e.getMessage());
		}
	}
	
	/**
	 * Formats the separate date UI fields into the date format the AmadeusAPI expects
	 * @param String month
	 * @param String day
	 * @param String year
	 * @return String the formatted date
	 * @throws Exception, throws an exception if an invalid date was selected
	 */
	private String createDateString(String month, String day, String year) throws Exception {
		String monthNumber;
		switch(month) {
			case "January":
				monthNumber="01";
				break;
			case "February":
				if(year.equals("2024")) {
					if(day.equals("30") || day.equals("31")) {
						throw new Exception("Please Select a Valid Date");
					}
				} else{
					if(day.equals("29") || day.equals("30") || day.equals("31")) {
						throw new Exception("Please Select a Valid Date");
					}
				}
				monthNumber = "02";
				break;
			case "March":
				monthNumber="03";
				break;
			case "April":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="04";
				break;
			case "May":
				monthNumber="05";
				break;
			case "June":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="06";
				break;
			case "July":
				monthNumber="07";
				break;
			case "August":
				monthNumber="08";
				break;
			case "September":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="09";
				break;
			case "October":
				monthNumber="10";
				break;
			case "November":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="11";
				break;
			default:
				monthNumber="12";
				break;
		}
		
		return year + "-" + monthNumber + "-" + day;
	}
	
	/**
	 * Returns true if the provided dateString is either after today, or is today.
	 * @param String dateString
	 * @return boolean
	 */
	private boolean isDateValid(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(new Date());
		String[] splitInput = dateString.split("-");
		String[] splitToday = today.split("-");
		
		//Make sure the year isn't before the current year
		if(Integer.parseInt(splitInput[0]) < Integer.parseInt(splitToday[0])) {
			return false;
		}
		
		//If the input year is after the current one, the date is valid
		if(Integer.parseInt(splitInput[0]) > Integer.parseInt(splitToday[0])) {
			return true;
		}
		
		//Year is the same
		
		//Check if the input month is after the current month
		if(Integer.parseInt(splitInput[1]) > Integer.parseInt(splitToday[1])) {
			return true;
		}
		
		//Check if the input month is before the current month
		if(Integer.parseInt(splitInput[1]) < Integer.parseInt(splitToday[1])) {
			return false;
		}
		//Month is the same
		//Check if the input day is after or equal to today
		if(Integer.parseInt(splitInput[2]) >= Integer.parseInt(splitToday[2])) {
			return true;
		} else {
			return false;
		}
	}
}
