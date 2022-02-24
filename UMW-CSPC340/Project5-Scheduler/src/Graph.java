// Graph.java

class Graph<Type>
{
    // the matrix stores the edge information
    private boolean[][] matrix;

    // this stores the values being stored by this graph
    private Type[] values;
    
    // this stores the number of edges pointing to this value
    private int[] edges;

    // the size of the graph
    private int size;

    // set the graph as empty
    public Graph(int size)
    {
        matrix = new boolean[size][size];
        this.size = size;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                matrix[i][j] = false;
            }
        }

        // make space for the values (and ignore the cast warning)
        @SuppressWarnings("unchecked")
        Type[] values = (Type[]) new Object[size];
        this.values = values;
        
        edges = new int[size];
    }

    // lookup a node number by value
    public int lookup(Type value)
    {
        for (int i = 0; i < size; i++)
        {
            if (values[i] != null && values[i].equals(value))
            {
                return i;
            }
        }
        return -1;
    }

    // insert an edge by index
    // returns true if an edge was added, false if there was already an edge
    public boolean insertEdge(int from, int to)
    {
        if (!matrix[from][to])
        {
            matrix[from][to] = true;
            edges[to]++;
            return true;
        }
        return false;
    }

    // insert an edge by value
    // returns true if an edge was added, false if there was already an edge
    public boolean insertEdge(Type from, Type to)
    {
        int fromIndex = lookup(from);
        int toIndex = lookup(to);
        return insertEdge(fromIndex, toIndex);
    }

    // remove an edge by value
    // returns true if an edge was removed, false if there was no edge
    public boolean removeEdge(Type from, Type to)
    {
        int fromIndex = lookup(from);
        int toIndex = lookup(to);
        return removeEdge(fromIndex, toIndex);
    }
    
    // remove an edge by index
    // returns true if an edge was removed, false if there was no edge
    public boolean removeEdge(int from, int to)
    {
        if(matrix[from][to])
        {
            edges[to]--;
            matrix[from][to] = false;
            return true;
        }
        return false;
    }

    // return whether these are connected
    public boolean isEdge(int from, int to)
    {
        return matrix[from][to];
    }

    // add a node's data to the graph
    public void setValue(int node, Type value)
    {
        values[node] = value;
    }

    // return the size of the graph
    public int getSize()
    {
        return size;
    }

    // get the value of a node
    public Type getValue(int index)
    {
        return values[index];
    }
    
 // get the number of edges pointing towards a node
    public int getEdges(Type value)
    {
        return edges[lookup(value)];
    }
    
    // get the number of edges pointing towards a node
    public int getEdges(int index)
    {
        return edges[index];
    }
}
