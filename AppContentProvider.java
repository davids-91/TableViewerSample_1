import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class AppContentProvider implements IStructuredContentProvider {
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
	
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof DataModel) return ((DataModel)inputElement).getData().toArray();
		return null;
	}
	
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
	public void dipose() {}
	
    /* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
}
