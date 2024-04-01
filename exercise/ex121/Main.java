package exercise.ex121;

public class Main {

	public static void main(String[] args) {
		
		Viewer viewer = null;
		
		if(args.length > 0) {
			
			//Viewer viewer = null;
			
			switch(args[0]) {
			
			case"1":
				viewer = new DocumentViewer();
				break;
				
			case"2":
				viewer = new WebBrowser();
				break;
			case"3":
				viewer = new MoviePlayer();
				break;
			default:
				viewer = new Viewer();
				break;
			}
			playViewer(viewer);
		}

	}
	
	private static void playViewer(Viewer viewer) {
		
		viewer.powerOn();
		viewer.browse();
		viewer.powerOff();
	}

}
