import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

public class MyViewerComparator extends ViewerComparator {
    private int propertyIndex;
    private static final int DESCENDING = 1;
    private int direction = DESCENDING;

    public MyViewerComparator() {
        this.propertyIndex = 0;
        direction = DESCENDING - 1; //sort ascending by first call
    }

    public int getDirection() {
        return direction == 1 ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(int column) {
        if (column == this.propertyIndex) {
            // Same column as last sort; toggle the direction
            direction = 1 - direction;
        } else {
            // New column; do an ascending sort
            this.propertyIndex = column;
            direction = DESCENDING;
        }
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        Data p1 = (Data) e1;
        Data p2 = (Data) e2;
        int rc = 0;
        switch (propertyIndex) {
	        case 0:
	            rc = p1.getFirst().compareTo(p2.getFirst());
	            break;
	        case 1:
	            rc = p1.getSecond().compareTo(p2.getSecond());
	            break;
	        case 2:
	            rc = String.valueOf(p1.getThird()).compareTo(String.valueOf(p2.getThird()));
	            break;
	        case 3:
	        	rc = p1.getCombo().compareTo(p2.getCombo());
	        	break;
	        default:
	            rc = 0;
        }
        // If descending order, flip the direction
        if (direction == DESCENDING) {
            rc = -rc;
        }
        return rc;
    }

}
