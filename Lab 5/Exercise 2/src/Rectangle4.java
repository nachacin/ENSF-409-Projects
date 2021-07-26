

class Rectangle extends Shape
{
	protected Double width, length;
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}

    //public void enlarge(double d) {
    //}

	@Override
	public void shrink(Double divisor) throws SizeFactorException {
		// TODO Auto-generated method stub
		
		if(divisor >= LIMIT) {
			length = this.length/divisor;
			width = this.width/divisor;	
		}
		else
			throw new SizeFactorException();
		
	}

	@Override
	public void enlarge(Double multiplier) throws SizeFactorException {
		// TODO Auto-generated method stub
		if(multiplier >= LIMIT)
		{
			this.length = length * multiplier;
			this.width = width * multiplier;	
		}
		else
			throw new SizeFactorException();
		
	}
        	
}