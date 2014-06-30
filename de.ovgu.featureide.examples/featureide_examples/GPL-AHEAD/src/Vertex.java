
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Integer;

abstract class Vertex$$Base {
  public String name = null;

  public  Vertex assignName( String name ) {
      ((Vertex) this).name = name;
      return ( Vertex ) ((Vertex) this);
  }

  public String getName( ) {  return ((Vertex) this).name; }
}



// ************************************************************

abstract class Vertex$$DirectedGR extends  Vertex$$Base  implements EdgeIfc, NeighborIfc
{
    public LinkedList adjacentVertices = new LinkedList();

    public  Vertex assignName( String name ) {
        ((Vertex) this).name = name;
        return ( Vertex ) ((Vertex) this);
    }

    public void addAdjacent( Vertex n ) {
        adjacentVertices.add( n );
    }

    public void adjustAdorns( Vertex the_vertex, int index ){}

    public VertexIter getNeighbors( )
    {
        return new VertexIter( )
        {
            private Iterator iter = adjacentVertices.iterator( );
            public Vertex next( )
            {
               return ( Vertex )iter.next( );
            }

            public boolean hasNext( )
            {
               return iter.hasNext( );
            }
        };
    }

    public void display() {
        int s = adjacentVertices.size();
        int i;

        System.out.print( "Vertex " + name + " connected to: " );

        for ( i=0; i<s; i++ )
            System.out.print( ( ( Vertex )adjacentVertices.get( i ) ).name+", " );
        System.out.println();
    }

//--------------------
// from EdgeIfc
//--------------------

    public Vertex getStart( ) { return null; }
    public Vertex getEnd( ) { return null; }

    public void setWeight( int weight ){}
    public int getWeight() { return 0; }

    public Vertex getOtherVertex( Vertex vertex )
    {
        return ((Vertex) this);
    }



    public void adjustAdorns( EdgeIfc the_edge )
    {
    }

}



// *************************************************************************

abstract class Vertex$$SearchCommon extends  Vertex$$DirectedGR 
{
    public boolean visited = false;

    public void init_vertex( WorkSpace w )
    {
        visited = false;
        w.init_vertex( ( Vertex ) ((Vertex) this) );
    }

    public void display( )
    {
        if ( visited )
            System.out.print( "  visited" );
        else
            System.out.println( " !visited" );
        super.display( );
    }
}

abstract class Vertex$$DFS extends  Vertex$$SearchCommon 
{
    public void nodeSearch( WorkSpace w )
    {
        Vertex v;

        // Step 1: Do preVisitAction.
        //            If we've already visited this node return
        w.preVisitAction( ( Vertex ) ((Vertex) this) );

        if ( visited )
            return;

        // Step 2: else remember that we've visited and
        //         visit all neighbors
        visited = true;

        for ( VertexIter  vxiter = getNeighbors(); vxiter.hasNext(); )
        {
            v = vxiter.next( );
            w.checkNeighborAction( ( Vertex ) ((Vertex) this), v );
            v.nodeSearch( w );
        }

        // Step 3: do postVisitAction now
        w.postVisitAction( ( Vertex ) ((Vertex) this) );
    } // of dftNodeSearch
}



// *************************************************************************
   
public class Vertex extends  Vertex$$DFS  {
    public int VertexCycle;
    public int VertexColor; // white ->0, gray ->1, black->2
      
    public void display() {
        System.out.print( " VertexCycle# " + VertexCycle + " " );
        super.display();
    }
}