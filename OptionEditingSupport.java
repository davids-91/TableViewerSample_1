import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

public class OptionEditingSupport extends EditingSupport {
//    private ComboBoxCellEditor cellEditor;
//    private CellEditor cellEditor;
	final int COLUMN_COUNT = AppPersonViewer.columnTitles.length;
    private CellEditor[] cellEditors = new CellEditor[COLUMN_COUNT];
    int columnIndex = 0;

    public OptionEditingSupport(ColumnViewer viewer, int columnIndex) {
        super(viewer);
//        cellEditor = new ComboBoxCellEditor(((TableViewer)viewer).getTable(), new String[]{"Y", "N"});
        for (int i = 0; i < COLUMN_COUNT; i++) {
	        cellEditors[i] = new TextCellEditor(((TableViewer)viewer).getTable());
    	}
        this.columnIndex = columnIndex;
    }
    protected CellEditor getCellEditor(Object element) {
        return cellEditors[columnIndex];
    }
    protected boolean canEdit(Object element) {
        return true;
    }
    protected Object getValue(Object element) {
//        return 0;
    	Data data = (Data) element;
    	Object result = null;
    	switch(columnIndex) {
    		case 0:
    			result = ""+data.getFirst();
    			break;
    		case 1:
    			result = ""+data.getSecond();
    			break;
    		case 2:
    			result = ""+data.getThird();
    			break;
    	}
    	return result;
    }
    protected void setValue(Object element, Object value) 
    {
//        if((element instanceof Data) && (value instanceof Integer)) {
//            Integer choice = (Integer)value;
//            String option = (choice == 0? "Y":"N");
//            ((Data)element).setLikes( option );
//            getViewer().update(element, null);
//        }
    	switch(columnIndex) {
			case 0:
		    	if((element instanceof Data)) {
		    		try {
			    		Data data = (Data) element;
			    		data.setFirst(value.toString());
			    		getViewer().update(element, null);
		    		} catch (Exception e) {
		    			showError("Data format error");
		    		}
		    	}
				break;
			case 1:
		    	if((element instanceof Data)) {
		    		try {
			    		Data data = (Data) element;
			    		data.setSecond(value.toString());
			    		getViewer().update(element, null);
		    		} catch (Exception e) {
		    			showError("Data format error");
		    		}
		    	}
				break;
			case 2:
		    	if((element instanceof Data)) {
		    		try {
			    		Data data = (Data) element;
			    		data.setThird(Integer.parseInt(value.toString()));
			    		getViewer().update(element, null);
		    		} catch (NumberFormatException e) {
		    			showError("Input data should be Integer");
		    		}
		    	}
				break;
		}
    }
	private void showError(String message) {
	MessageDialog.openError(
		getViewer().getControl().getShell(),
		"Error",
		message);
	}
}
