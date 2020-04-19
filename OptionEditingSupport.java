import java.util.Arrays;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

public class OptionEditingSupport extends EditingSupport {
	final int COLUMN_COUNT = AppPersonViewer.columnTitles.length;
    private CellEditor[] cellEditors = new CellEditor[COLUMN_COUNT];
    private ComboBoxCellEditor cellEditor;
    int columnIndex = 0;
    private String[] choices = Data.COMBO_ITEMS;

    public OptionEditingSupport(ColumnViewer viewer, int columnIndex) {
        super(viewer);
        for (int i = 0; i < COLUMN_COUNT; i++) {
	        cellEditors[i] = new TextCellEditor(((TableViewer)viewer).getTable());
    	}
        cellEditor = new ComboBoxCellEditor(((TableViewer)viewer).getTable(), choices);
        this.columnIndex = columnIndex;
    }
    protected CellEditor getCellEditor(Object element) {
    	if (columnIndex!=3) return cellEditors[columnIndex];
    	else return cellEditor;
    }
    protected boolean canEdit(Object element) {
        return true;
    }
    protected Object getValue(Object element) {
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
    		case 3:
    			result = Arrays.asList(choices).indexOf(data.getCombo());
    			break;
    	}
    	return result;
    }
    protected void setValue(Object element, Object value)
    {
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
			case 3:
		        if((element instanceof Data) && (value instanceof Integer)) {
		            Integer choice = (Integer)value;
		            String option = (choices[choice]);
		            Data data = (Data) element;
		            data.setCombo(option);
		            getViewer().update(element, null);
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
