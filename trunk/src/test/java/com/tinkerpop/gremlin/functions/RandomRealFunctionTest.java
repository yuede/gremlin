package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.statements.EvaluationException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RandomRealFunctionTest extends BaseTest {

    public void testRandomNaturalFunction() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluate("g:rand_real()").size(), 1);
        assertEquals(xe.evaluate("g:type(g:rand_real())").get(0), "number");
        assertTrue(((Double)xe.evaluate("g:rand_real()").get(0)) < 1.00001d);
        try {
            xe.evaluate("g:rand_real('marko')");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            xe.evaluate("g:rand_real(1000)");
            assertTrue(false);
        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

}
