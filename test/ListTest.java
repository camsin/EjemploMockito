
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ListTest {
   @Test
   public void test(){
       //creacion de mock
       List mockedList = mock(List.class);

        //utilizando el mock object
       mockedList.add("one");
       mockedList.clear();

        //verificacion
       verify(mockedList).add("one");
       verify(mockedList).clear();
       
       assertTrue(mockedList.size() == 0);
       assertEquals(mockedList.size(), 0);

        //stubbing
       when(mockedList.get(0)).thenReturn("first");
       when(mockedList.get(1)).thenThrow(new RuntimeException());

        //imprime "first"
       System.out.println(mockedList.get(0));

        //lanza runtime exception
       //System.out.println(mockedList.get(1));

        //imprime "null" porque no se ha hecho stubbing de get(999)
       System.out.println("-->" + mockedList.get(999));

       verify(mockedList).get(0);
       System.out.println("La verificacion del la llamada a cero paso");

       verify(mockedList).get(999);
       System.out.println("La verificacion del la llamada a 999 paso");
   }
}
