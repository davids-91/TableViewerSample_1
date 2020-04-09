import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class AppPersonViewer extends TableViewer {
	public AppPersonViewer(Composite composite, int style) {
		super(composite, style);
		Table table = getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);
		createColumns();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		setContentProvider(new AppContentProvider());
	}

	private void createColumns() {
		String[] titles = {"String", "String", "Integer"};
		int[] bounds = {150, 150, 100};
		TableViewerColumn column = createTableViewerColumn(titles[0], bounds[0], 0);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getFirst();
				return super.getText(element);
			}
		});
		
		column = createTableViewerColumn(titles[1], bounds[1], 1);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getSecond();
				return super.getText(element);
			}
		});
		
		column = createTableViewerColumn(titles[2], bounds[2], 2);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ""+((Data)element).getThird();
				return super.getText(element);
			}
		});
		
		column.setEditingSupport(new OptionEditingSupport(this));
	}
	
	private TableViewerColumn createTableViewerColumn(String header, int width, int index) {
		TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, index);
		column.getColumn().setText(header);
		column.getColumn().setWidth(width);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);
		return column;
	}
}
