import model.Task;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by employee on 11/15/16.
 */
public class TaskTest {

    @Test
    public void assertActiveTask(){
        Task expectedTask = new Task("1", "test task");
        Task task = new Task("1", "expected task");
        assertThat(expectedTask.isActive(), is(task.isActive()));
    }



}
