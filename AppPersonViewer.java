import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class AppPersonViewer extends TableViewer {

	private MyViewerComparator comparator;
	public static final String[] columnTitles = {"String", "String", "Integer"};
	private static final int[] bounds = {150, 150, 100};
	
	public AppPersonViewer(Composite composite, int style) {
		super(composite, style);
		Table table = getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);
		createColumns();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		setContentProvider(new AppContentProvider());
		comparator = new MyViewerComparator();
		setComparator(comparator);
	}
	
	private void createColumns() {
		TableViewerColumn column = createTableViewerColumn(columnTitles[0], bounds[0], 0);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getFirst();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 0));
		
		column = createTableViewerColumn(columnTitles[1], bounds[1], 1);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getSecond();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 1));
		
		column = createTableViewerColumn(columnTitles[2], bounds[2], 2);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ""+((Data)element).getThird();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 2));
	}
	
	private TableViewerColumn createTableViewerColumn(String header, int width, final int index) {
		TableViewerColumn viewerColumn = new TableViewerColumn(this, SWT.LEFT, index);
		TableColumn column = viewerColumn.getColumn();
		column.setText(header);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);
		column.addSelectionListener(getSelectionAdapter(column, index));
		return viewerColumn;
	}
	
    private SelectionAdapter getSelectionAdapter(final TableColumn column,
            final int index) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                comparator.setColumn(index);
                int dir = comparator.getDirection();
                getTable().setSortDirection(dir);
                getTable().setSortColumn(column);
                refresh();
            }
        };
        return selectionAdapter;
    }
    
    public void setFocus() {
        getControl().setFocus();
    }
}
