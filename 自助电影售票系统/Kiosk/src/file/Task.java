package file;

import java.util.TimerTask;

public class Task extends TimerTask {

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	public void run() {

		Mess GUI = new Mess();
		GUI.go();
	}

}
