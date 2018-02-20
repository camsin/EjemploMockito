
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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
       
       //stubbing usando anyInt() argument matcher
       when(mockedList.get(anyInt())).thenReturn("element");

       //stubbing usando hamcrest (libreria de matchers) (digamos que isValid() devuelve tu propio matcher):
       //when(mockedList.contains(argThat(isValid()))).thenReturn("element");

       //imprime "element"
       System.out.println(mockedList.get(999));
       System.out.println(mockedList.get(28));
       
       assertEquals(mockedList.get(45), "element");
       assertEquals(mockedList.get(0), "element");

       //tambien se puede verificar usando argument matchers
       
       verify(mockedList).get(45);
       verify(mockedList).get(28);
       //verify(mockedList).get(anyInt());
       
       

   }
   
   @Test
   public void test2(){
       List mockedList = mock(List.class);
       
       //usando mock 
       mockedList.add("once");

       mockedList.add("twice");
       mockedList.add("twice");

       mockedList.add("three times");
       mockedList.add("three times");
       mockedList.add("three times");
       mockedList.add("three times");
       mockedList.add("three times");
       
       mockedList.add("five times");
       mockedList.add("five times");

       //las dos verificaciones siguientes trabajan de la misma manera (times(1) se usa por defecto)
       verify(mockedList).add("once");
       verify(mockedList, times(1)).add("once");

       //verificacion de numero exacto de invaciones
       verify(mockedList, times(2)).add("twice");
       //verify(mockedList, times(3)).add("three times");

       //verificacion utilizando never. never() es un alias de times(0)
       verify(mockedList, never()).add("never happened");

       //verificacion utilizando atLeast()/atMost()
       verify(mockedList, atLeastOnce()).add("three times");
       verify(mockedList, atLeast(2)).add("five times");
       verify(mockedList, atMost(5)).add("three times");
   }
   
   /**
    * Prueba con mockito para simulacion de un login y su banneo.
    */
   @Test
   public void login(){
       
    //Declaro al usuario
    Usuario usuario = mock(Usuario.class);
       
    //Le meto el nombre y la contra
    when(usuario.getUsername()).thenReturn("ararat");
    when(usuario.getPassword()).thenReturn("1111");
    
    //Aqui comprobamos que su contraseña esta mal
    assertEquals(usuario.baneado(1,usuario.getUsername(), usuario.getPassword()), false);
    
      
    //Le meto el nombre y la contra
    when(usuario.getUsername()).thenReturn("ararat");
    when(usuario.getPassword()).thenReturn("1233");
    
    //Aqui comprobamos que su contraseña esta mal
    assertEquals(usuario.baneado(2, usuario.getUsername(), usuario.getPassword()), false);
    
    when(usuario.getUsername()).thenReturn("ararat");
    when(usuario.getPassword()).thenReturn("1223");
  
    assertEquals(usuario.baneado(3, usuario.getUsername(), usuario.getPassword()), false);
    
       
    when(usuario.getUsername()).thenReturn("ararat");
    when(usuario.getPassword()).thenReturn("1111");
  
   assertEquals(usuario.baneado(4, usuario.getUsername(), usuario.getPassword()), true);
     
       
   }
 
}
