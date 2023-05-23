package sparse_matrix;

public class SparseMatrix <T>{
    int maxRow=0, maxCol=0;
    SparseMatrixNode<T>[] rowRefs=null;
    SparseMatrixNode<T>[] colRefs=null;

    public SparseMatrix(int maxR, int maxC) {
        maxRow=maxR;
        maxCol=maxC;
        rowRefs =  new SparseMatrixNode[maxR];
        colRefs = new SparseMatrixNode[maxC];
        int i=0;
        for (i = 0; i < maxR; i++) rowRefs[i] = null;
        
        for (i = 0; i < maxC; i++) colRefs[i] = null;
        
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public SparseMatrixNode<T>[] getRowRefs() {
        return rowRefs;
    }

    public void setRowRefs(SparseMatrixNode<T>[] rowRefs) {
        this.rowRefs = rowRefs;
    }

    public SparseMatrixNode<T>[] getColRefs() {
        return colRefs;
    }

    public void setColRefs(SparseMatrixNode<T>[] colRefs) {
        this.colRefs = colRefs;
    }
    
    public boolean add (int r, int c, T info){
        boolean result=true;
        SparseMatrixNode beforeInRow=null, afterInRow=rowRefs[r];
        while (afterInRow!=null && afterInRow.col<c){
            beforeInRow=afterInRow;
            afterInRow=afterInRow.nextInRow;
        }
        
        SparseMatrixNode beforeInCol=null, afterInCol=colRefs[c];
        while(afterInCol!=null && afterInCol.row<r){
            beforeInCol=afterInCol;
            afterInCol=afterInCol.nextInCol;
        }
        
        if (afterInRow != null && afterInRow==afterInCol) result = false;
        else{
            SparseMatrixNode node = new SparseMatrixNode(r, c, info);
            if (rowRefs[r]==null) rowRefs[r]=node;
            else if (afterInRow==rowRefs[r]){
                node.nextInRow=rowRefs[r];
                rowRefs[r]=node;
            }
            else {
                node.nextInRow=afterInRow;
                beforeInRow.nextInRow=node;
            }
            
            if (afterInCol==null) colRefs[c]=node;
            else if (afterInCol==colRefs[c]){
                node.nextInCol=colRefs[c];
                colRefs[c]=node;
            }
            else {
                node.nextInCol=afterInCol;
                beforeInCol.nextInCol=node;
            }
        }
        return result;
    }
    
    public T get(int r , int c){
        if (rowRefs[r]!=null && colRefs[c]!=null){
            SparseMatrixNode<T> node = rowRefs[r];
            while(node!=null && node.col<c) node = node.nextInRow;
            if (node == null) return null;
            return (node.col==c)? node.info: null;
        }
        return null;
    }
    
    public SparseMatrixNode<T> getNode (int r, int c){
        SparseMatrixNode<T> node = colRefs[r];
        while (node!=null && node.col<r) node = node.nextInRow;
        return (node == null || node.col>c)? null : node;
    }
    
    public boolean update (int r, int c, T newInfo){
        SparseMatrixNode<T> node = getNode(r, c);
        if ( node == null) return false;
        node.setInfo(newInfo);
        return true;
    }
    
    
}
