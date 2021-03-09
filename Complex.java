/** 
 * Every instance of Complex will have a Double real, which represents the
 * real number in a complex number arrangement, along with a Double imag, 
 * which represents the imaginary number in a complex number arrangement.
 * Class methods add(), sub(), mult(), and div() will allow for a Complex
 * number object to undergo any of the respective mathematical operations
 * with another Complex object. Accessors will allow for the return of either
 * one of a complex number’s parameters. toString() returns the complex
 * number in “[real] +/- [imaginary]i” format. equals() returns a Boolean
 * indicating whether or not two Complex objects are equal.  
*/
public final class Complex 
{
    /**
     * Constructs a complex number. 
     * @param real The real number of a complex number. 
     * @param imag The imaginary number of a complex number.
     * @precondition Complex(num1, num2) == NULL
     * @postcondition Complex(num1, num2) == Complex(real, imag)
     */
    public Complex(final Double real, final Double imag) 
    {
        this.real = real;
        this.imag = imag; 
    }
    
    /**
     * Constructs a complex number without the imaginary number (defaults 0.00). 
     * @param num1 The real number of a complex number.
     * @precondition Complex(num1) == NULL
     * @postcondition Complex(num1) == Complex(real, 0.00)
     */
    public Complex(final Double real)
    {
        this.real = real;
        this.imag = 0.00;
    }

    /**
     * Takes a Complex object and returns a string of its real 
     * and imaginary number in proper complex number format.  
     * @precondition Complex class object had real and imaginary number.
     * @postcondition Complex class object complex number returned as
     * String "[real] +/- [imaginary]i"
     */
    public String toString()
    {
        //Check imaginary number for signage. Return appropriate string. 
        if (Math.signum(imag) == -1.0){
            return this.r() + " - " + Math.abs(imag) + "i";
        } else {
            return real.toString() + " + " + this.i();
        }
    }

    /**
     * Takes a Complex object and returns a stringified version of 
     * its real number.  
     * @postcondition Real number of Complex object returned as string.
     */
    public String r()
    {
        return real.toString();
    }

    /**
     * Takes a Complex object and returns a stringified version of 
     * its imaginary number.  
     * @postcondition Imaginary number of Complex object returned as string.
     */
    public String i()
    {
        return imag.toString() + "i";
    }

    /**
     * Adds two Complex objects' real and imaginary numbers.
     * @param othernum Other complex object.  
     * @precondition Two Complex objects.   
     * @postcondition Returned new Complex object that is the
     * result of the addition. 
     */
    public Complex add(final Complex othernum) 
    {
        return new Complex(this.real + othernum.real, this.imag + othernum.imag);
    }

    /**
     * Subtracts two Complex objects' real and imaginary numbers.
     * @param othernum Other complex object.
     * @precondition Two Complex objects.   
     * @postcondition Returned new Complex object that is the
     * result of the subtraction. 
     */
    public Complex sub(final Complex othernum)
    {
        return new Complex(this.real - othernum.real, this.imag - othernum.imag);
    }

    /**
     * Forms the conjugation of a complex number. 
     * @precondition Non-conjugated Oomplex object.   
     * @postcondition Returned new Complex object that is the
     * result of the conjugation. 
     */
    public Complex conj() 
    {
        //"-" operator invoked on this.imag to flip its sign
        if (Math.signum(this.imag) == -1.0) {
            return new Complex(this.real, Math.abs(this.imag));
        } else {
            return new Complex(this.real, -this.imag);
        }
    }

    /**
     * Multiples two Complex objects' real and imaginary numbers
     * using FOIL method and conjugation.
     * @param othernum Other complex object. 
     * @precondition Two Complex objects.   
     * @postcondition Returned new Complex object that is the
     * result of the muliplication. 
     */
    public Complex mult(final Complex othernum)
    {
        //First
        Double firsts = this.real * othernum.real; 
        //Outer
        Double outers = this.real * othernum.imag;
        //Inner
        Double inners = this.imag * othernum.real;
        //Last
        Double lasts = this.imag * othernum.imag;

        //FOIL

        //-lasts: i^2 = -1
        return new Complex(firsts + -lasts, outers + inners);
    }

    /**
     * Divides two Complex objects' real and imaginary numbers
     * using the second's conjugation. 
     * @param othernum Other Complex object.
     * @precondition Two Complex objects.   
     * @postcondition Returned new Complex object resultant of 
     * the division. 
     */
    public Complex div(final Complex othernum)
    {
        Complex numer = this.mult(othernum.conj());
        Complex denom = othernum.mult(othernum.conj());

        //Create denominator for complex division
        Double denomsum = denom.real + denom.imag;

        return new Complex(numer.real / denomsum, numer.imag / denomsum);
    }

    /**
     * Checks if two Complex objects are equal based on their
     * Complex.toString() outputs. 
     * @param othernum Other complex object. 
     * @precondition Two Complex objects.   
     * @postcondition Returned "true" or "false" Boolean after 
     * comparing both Complex.toString() strings with .equals(). 
     */
    public Boolean equals(final Complex othernum)
    {
        if (this.toString().equals(othernum.toString())) {
            return true;
        } else {
            return false;
        }
    }

    //Instance variables
    private final Double real;
    private final Double imag;
}