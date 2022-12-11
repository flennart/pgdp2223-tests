package pgdp.pools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class simpleTaskpoolTest {
    static TaskPool<Integer, Integer> tp = new TaskPool<>();

    @Test
    @DisplayName("Taskpool should not return null for getByValue() for these two Tasks")
    void getByValueTest(){
        TaskFunction<Integer, Integer> f1 = new TaskFunction<>(FunctionLib.SQUARE);
        TaskFunction<Integer, Integer> f2 = new TaskFunction<>(FunctionLib.SUM_OF_HALFS);
        Task<Integer,Integer> tf3 = new Task<>(1,f2);
        Task<Integer,Integer> tf4 = new Task<>(-1108378656,f1);
        tp.insert(tf4);
        tp.insert(tf3);
        Assertions.assertNotNull(tp.getByValue(-1108378656,f1));
        Assertions.assertEquals(tf4, tp.getByValue(-1108378656,f1));
    }
}
