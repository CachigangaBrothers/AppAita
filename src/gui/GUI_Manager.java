package gui;


public class GUI_Manager {
	
	private static GUI_Manager instance = null;
	private GUI gui_component;
	
	
	private GUI_Manager(GUI gui){
		
	}
	
	/**
	 * Returns the singleton instance of the GUI_Manager.
	 * 
	 * @return GUI_Manager
	 */
	public static GUI_Manager getInstance(){
		if (instance == null)
			instance = new GUI_Manager(new GUI());
		return instance;
	}
	
	/**
	 * Returns the component of the instance, in this case the GUI.
	 * 
	 * @return GUI
	 */
	public GUI getComponent(){
		return gui_component;
	}
}
