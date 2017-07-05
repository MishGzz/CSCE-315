package application;

//Node class (neurons, output, and input nodes)
class Node{
	private double [] input_weights;
	private double threshold;
	private double input;
	private double raw_output;

		//Creates the correct length of 
		//weight outputs based on the
		//next layer, and fills with 
		//default thresh and weight vals
	public Node(double def_weight, double def_thresh, int num_weights)
	{
		input = 0;
		threshold = 2*Math.random()-1;
		input_weights = new double[num_weights];
		for(int i = 0; i < num_weights; ++i)
		{
			input_weights[i] = 2*Math.random()-1;
		}
	}
	
	//getter functions
	public int get_num_weights()
	{
		return input_weights.length;
	}

	public double get_weight(int index)
	{
		return input_weights[index];
	}

	public double get_threshold()
	{
		return threshold;
	}

	public double get_input()
	{
		return input;
	}

	public double get_raw_output()
	{
		return raw_output;
	}

	//setter functions
	public void set_weight(int index, double weight)
	{
		input_weights[index] = weight;
	}
	public void set_num_weights(int num){
		input_weights = new double [num];
	}

	public void set_threshold(double thresh)
	{
		threshold = thresh;
	}
	
	public void set_input(double i)
	{
		input = i;
	}

	public void add_input(double a)
	{
		input += a;
	}

	public void set_raw_output(double o)
	{
		raw_output = o;
	}
}
