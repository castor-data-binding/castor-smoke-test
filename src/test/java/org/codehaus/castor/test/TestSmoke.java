package org.codehaus.castor.test;

import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.InputSource;

public class TestSmoke {
	
	@Test
	public void testSuccessfully() {
		XMLContext content = new XMLContext();
		Assert.assertNotNull(content);
	}

	@Test
    public void testXMLContextByPackage() throws Exception {
        XMLContext context = new XMLContext();
        context.addPackage("org.castor.test.entity");
        Assert.assertNotNull("context is null", context);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Assert.assertNotNull(unmarshaller);
        
        unmarshaller.setClass(Entity.class);
        String resource = getResource("org/codehaus/castor/test/input.xml");
        InputSource source = new InputSource(resource);
        Entity entity = (Entity) unmarshaller.unmarshal(source);
        Assert.assertNotNull(entity);
        
    }
    
    private String getResource(final String resource) {
        ClassLoader loader = getClass().getClassLoader();
        return loader.getResource(resource).toExternalForm();
    }

}
