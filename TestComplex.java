import org.junit.*;

public class TestComplex {    
    @Test
    public void testAdd() {
        System.out.println("run test add");
        double a = 1, b = 2, c = -3, d = 4;
        double e = a + c, f = b + d;

        // set up Complex objects
        Complex x = new Complex(a, b);
        Complex y = new Complex(c, d);
        Complex w = x.add(y);
        Complex z = new Complex(e,f);

        // test condition using the Complex equals() method:
        Assert.assertTrue(z.equals(w));
        System.out.println("test add passed");
    }

    @Test
    public void testSub() {
        System.out.println("run test sub");
        double a = 1, b = 2, c = -3, d = 4;
        double e = a - c, f = b - d;

        // set up Complex objects
        Complex x = new Complex(a, b);
        Complex y = new Complex(c, d);
        Complex w = x.sub(y);
        Complex z = new Complex(e,f);

        // test condition using the Complex equals() method:
        Assert.assertTrue(z.equals(w));
        System.out.println("test sub passed");
    }

    @Test
    public void testMult() {
        System.out.println("run test mult");
        double a = 1, b = 2, c = -3, d = 4;
        double e = a * c, f = a * d, g = b * c, h = b * d;

        // set up Complex objects
        Complex x = new Complex(a, b);
        Complex y = new Complex(c, d);
        Complex w = x.mult(y);
        Complex z = new Complex(e + -h, f + g); //-h: i^2 = -1

        // test condition using the Complex equals() method:
        Assert.assertTrue(z.equals(w));
        System.out.println("test mult passed");
    }

    @Test
    public void testDiv() {
        System.out.println("run test div");
        double a = 1, b = 2, c = -3, d = 4;
        double denom = (c * c) + (4 * 4);
        double e = ((a * c) + (b * d)) / denom;
        double f = (b * c - a * d) / denom;

        //set up complex objects
        Complex x = new Complex(a, b);
        Complex y = new Complex(c, d);
        Complex w = x.div(y);
        Complex z = new Complex(e, f);               

        // test condition using the Complex equals() method:
        Assert.assertTrue(z.equals(w));
        System.out.println("test div passed");
    }

    @Test
    public void testEquals() {
        System.out.println("run test equals");
        double a = 1, b = 2; 

        // set up Complex objects
        Complex z = new Complex(1.00, 2.00);
        Complex y = new Complex(a, b);

        // test condition using the Complex equals() method:
        Assert.assertTrue(z.equals(y));
        System.out.println("test equals passed");
    }
}
