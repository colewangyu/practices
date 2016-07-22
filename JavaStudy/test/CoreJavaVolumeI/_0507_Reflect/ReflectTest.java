package CoreJavaVolumeI._0507_Reflect;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-07-22.
 */
public class ReflectTest {
    Reflect t;

    @Before
    public void setUp() throws Exception {
        t = (Reflect) Class.forName("CoreJavaVolumeI._0507_Reflect.Reflect").newInstance();
    }

    @Test
    public void testGetClassByMethod() throws Exception {
        t.getClassByMethod();
    }

    @Test
    public void testGetClassByName() throws Exception {
        t.getClassByName();
    }

    @Test
    public void testGetClassByProperty() throws Exception {
         t.getClassByProperty();
    }

    @Test
    public void testGetFields() throws Exception {
        t.getFields("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetMethods() throws Exception {
        t.getMethods("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetConstructors() throws Exception {
        t.getConstructors("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetDeclaredFields() throws Exception {
        t.getDeclaredFields("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetDeclaredMethods() throws Exception {
        t.getDeclaredMethods("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetDeclaredConstructors() throws Exception {
        t.getDeclaredConstructors("CoreJavaVolumeI._0507_Reflect.Manager");
    }

    @Test
    public void testGetFieldValue() throws Exception {
        t.getFieldValue();
    }
}