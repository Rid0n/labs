public class Lab1{
	public static void main(String[] args){
		System.out.println("Hello, Alexander");
		
		long[] h = {19,17,15,13,11,9,7,5}; // creating an arrayeeee
		double[] x = new double[17];
		double[][] p = new double[8][17];
		for (int j=0;j<(x.length);j++){
			x[j] = (Math.random() * 15) - 9; //from -9.0 to 5.0 - /
		}
		for (int i=0;i<p.length;i++){
			for (int j=0;j<(p[i].length);j++){
				if (h[i]==19){
					p[i][j] = Math.cbrt(Math.sin(Math.log(Math.abs(x[j]))));
				}
				else if (h[i] == 5 || h[i] == 7 || h[i] == 13 || h[i] == 17){
					p[i][j] = Math.pow((4.0/(0.5 + Math.exp(Math.pow(2*x[j],x[j])))),2);
				}
				else {
					p[i][j] = Math.log(Math.pow(Math.cos(Math.pow((Math.log(Math.abs(x[j]))/2),((Math.cbrt(Math.exp(x[j]))-1)/4))),2));
				}
				System.out.print(Math.round(p[i][j]*10000.0)/10000.0 + " ");
			}
			System.out.println("");
		}
		
	}
}
 