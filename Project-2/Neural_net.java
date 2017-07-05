package application;

import java.io.*;
import java.util.*;

//Vector of layers, with capability to
//store state information of network
//for restoration, capability to 
//store statistical information,
//(backprop iterations vs. accuracy)
//and ownership of bp.
public class Neural_net{
	private Layer input_layer;
	private Layer output_layer;
	private Layer [] all_layers;
	private Training_pair [] training_alphabet;

	private int inputs;
	private int outputs;
	private int num_layers;
	private int hidden_length;
	private double learning_rate;
	private double [] current_keys;
	private static final double INIT_WEIGHT = 0;
	private static final double INIT_THRESH = 0;
	private static final double INIT_LEARN = 0.3;
	private static final double MARGIN = 1;
	private static final double TRAINING_CYCLES = 400;

	public static void main(String [] args) throws FileNotFoundException
	{
		
		System.out.println("Enter s to train and save the Neural Network  -or- Enter l to load a saved Neural Network");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		//if else statment is for saving the best results in a file
		if(answer.equals("s"))
		{
			System.out.println("Enter how many inner layers the network should have: ");
			int inner_layers = input.nextInt();
			
			Neural_net net = new Neural_net(35, 26, inner_layers + 2, 30);
			
			double[][] in = new double[26][35];
			double[][] out = new double[26][26];
			
			Scanner scanner = new Scanner(new File("training_alphabet.txt"));
			for(int i = 0; i < 26; ++i)
			{
				for(int j = 0; j < 35; ++j)
				{
					if(i == 0 && j == 0)
					{
						in[i][j] = 0;
						scanner.next();
					}
					else
						in[i][j] = scanner.nextInt();
				}
				for(int j = 0; j < 26; ++j)
				{
					out[i][j] = scanner.nextInt();
				}
			}
			scanner.close();
			
			//for accuracy check
			for(int i = 0; i < TRAINING_CYCLES; ++i)
			{
				int correct = 0;
				for(int j = 0; j < 26; ++j)
				{
					if(net.train(in[j], out[j], INIT_LEARN))
						++correct;
				}
				System.out.println(correct + "/26\t" + (correct/26.0*100) + "%" + " -- Cycle # " + (i +1));
			}
			net.save_net("save");
			
		}
		else if(answer.equals("l"))
		{
			Neural_net net = new Neural_net();
			net.load_net("save");
		
			double[][] in = new double[26][35];
			double[][] out = new double[26][26];
			
			Scanner scanner = new Scanner(new File("training_alphabet.txt"));
			for(int i = 0; i < 26; ++i)
			{
				for(int j = 0; j < 35; ++j)
				{
					if(i == 0 && j == 0)
					{
						in[i][j] = 0;
						scanner.next();
					}
					else
						in[i][j] = scanner.nextInt();
				}
				for(int j = 0; j < 26; ++j)
				{
					out[i][j] = scanner.nextInt();
				}
			}
			scanner.close();
			
			for(int i = 0; i < TRAINING_CYCLES; ++i)
			{
				int correct = 0;
				for(int j = 0; j < 26; ++j)
				{
					if(net.train_test(in[j], out[j], INIT_LEARN))
						++correct;
				}
				System.out.println(correct + "/26\t" + (correct/26.0*100) + "%" + " -- Cycle # " + (i +1));
			}
		}
		else{
			System.out.println("Unknown command...terminating program");
		}
	}

	//Creates specified number of
	//nodes with correct length and 
	//number of inputs & ouputs
	//initialize weights of all
	//nodes to INIT_WEIGHT and INIT_THRESH
	public Neural_net(int inputs, int outputs,
			  int num_layers, int hidden_length) throws FileNotFoundException{
		//Create all layers with correct lengths and indices
		this.outputs = outputs;
		this.inputs = inputs;
		this.num_layers = num_layers;
		this.hidden_length = hidden_length;
		all_layers = new Layer [num_layers];
		for (int i = 0; i < num_layers; ++i)
		{
			if(i == 0)
			{
				input_layer = new Layer(0, inputs);
				all_layers[0] = input_layer;
			}
			else if(i == (num_layers - 1))
			{
				output_layer = new Layer(num_layers - 1, outputs);
				all_layers[num_layers - 1] = output_layer;
			}
			else
			{
				all_layers[i] = new Layer(i, hidden_length);
			}
		}

		//Initialize all nodes
		for (int i = 0; i < num_layers; ++i)
		{
			if(i == (num_layers - 1))
			{
				all_layers[i].init_nodes(0, INIT_THRESH, all_layers[i-1].get_length(), MARGIN);
			}
			else if(i == 0)
			{
				all_layers[i].init_nodes(INIT_WEIGHT, 0, 0, MARGIN);
			}
			else
			{
				all_layers[i].init_nodes(INIT_WEIGHT, INIT_THRESH,
							 all_layers[i-1].get_length(), MARGIN);
			}
		}
	}
	
	public Neural_net()
	{
		inputs = 0;
		outputs = 0;
		num_layers = 0;
		hidden_length = 0;
	}
	
	public void save_net(String file_name)
	{
		FileOutputStream ofs;
		
		try
		{
			ofs = new FileOutputStream(file_name);
			DataOutputStream dos = new DataOutputStream(ofs);
			
			dos.writeInt(this.get_num_inputs());
			dos.writeInt(this.get_num_outputs());
			dos.writeInt(this.get_num_layers());
			dos.writeInt(this.get_hidden_length());

			
			for(int i=0; i< this.get_num_layers();++i)
			{
				Layer current_layer = this.get_layer(i);
				dos.writeInt(current_layer.get_length());
				dos.writeInt(current_layer.get_index());
				for(int j=0; j<this.get_layer(i).get_length();++j)
				{
					Node current_node = current_layer.get_node(j);
					dos.writeDouble(current_node.get_threshold());
					dos.writeInt(current_node.get_num_weights());
					for(int k=0; k<current_node.get_num_weights();++k)
					{
						dos.writeDouble(current_node.get_weight(k));
					}
				}
			}
			
			dos.close();
			ofs.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Your file couldn't be found.");
		}
		catch (IOException ex)
		{
			System.out.println("An IO Exception occured.");
		}
	}
	
	public void load_net(String file_name)
	{
		FileInputStream ifs;
		
		try
		{
			ifs = new FileInputStream(file_name);
			DataInputStream dis = new DataInputStream(ifs);
			
			this.set_num_inputs(dis.readInt());
			this.set_num_outputs(dis.readInt());
			this.set_num_layers(dis.readInt());
			this.set_hidden_length(dis.readInt());
			
			all_layers = new Layer [num_layers];
			for (int i = 0; i < num_layers; ++i)
			{
				if(i == 0)
				{
					input_layer = new Layer(0, inputs);
					all_layers[0] = input_layer;
				}
				else if(i == (num_layers - 1))
				{
					output_layer = new Layer(num_layers - 1, outputs);
					all_layers[num_layers - 1] = output_layer;
				}
				else
				{
					all_layers[i] = new Layer(i, hidden_length);
				}
			}
			
			for(int i=0; i< this.get_num_layers();++i)
			{
				Layer current_layer = this.get_layer(i);
				current_layer.set_length(dis.readInt());
				current_layer.set_index(dis.readInt());
				for(int j=0; j<this.get_layer(i).get_length();++j)
				{
					Node current_node = new Node(0.0,0.0,0);
					current_node.set_threshold(dis.readDouble());
					current_node.set_num_weights(dis.readInt());for(int k=0; k<current_node.get_num_weights();++k)
					{
						current_node.set_weight(k,dis.readDouble());
					}
					current_layer.set_node(j, current_node);
				}
			}
			
			dis.close();
			ifs.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Your file couldn't be found.");
		}
		catch (IOException ex)
		{
			System.out.println("An IO Exception occured.");
		}
	}
	
	public boolean train(double[] in, double[] out, double learnRate)
	{
		current_keys = out;
		learning_rate = learnRate;
		double[] actual = feed_forward(in);
		back_prop();
		
		return max(actual) == max(out);
	}
	public boolean train_test(double[] in, double[] out, double learnRate)
	{
		current_keys = out;
		learning_rate = learnRate;
		double[] actual = feed_forward(in);
		
		return max(actual) == max(out);
	}
	
	public double[] feed_forward(double[] in)
	{
		
		for(int i = 0; i < input_layer.get_length(); ++i)
			input_layer.get_node(i).set_raw_output(in[i]);
		
		forward_prop();
		
		double[] out = new double[output_layer.get_length()];
		for(int i = 0; i < out.length; ++i)
		{
			out[i] = output_layer.get_node(i).get_raw_output();
		}
		
		return out;
	}
	
	public static int max(double[] array)
	{
		
		int best = 0;
		for(int i = 1; i < array.length; ++i)
		{
			if(array[i] > array[best])
				best = i;
		}
		
		return best;
	}

	//takes weighted input
	//and apply the sigmoid, test against
	//threshold, and output another output
	//to be multiplied against output_weights,
	//which will then update 'input' of
	//next layer's nodes
	public void forward_prop()
	{

		for(int i=1;i<this.get_num_layers();++i)
		{
			Layer current_layer = this.get_layer(i);
			Layer prev_layer = this.get_layer(i-1);
			for(int j=0;j<current_layer.get_length();++j)
			{
				Node current_node = current_layer.get_node(j);
				double input = current_node.get_threshold();
				for(int k=0;k<current_node.get_num_weights(); ++k)
				{
					input += prev_layer.get_node(k).get_raw_output() * current_node.get_weight(k);
				}
				current_node.set_input(input);
				current_node.set_raw_output(act_fnctn(input));
			}
		}
	}

	public void back_prop()
	{
		double [] deltas;
		double [] prev_deltas = this.output_deltas();
		
		this.update_thresh(this.get_num_layers()-1, this.output_deltas(), learning_rate); //Updating output layer
		this.update_weights(this.get_num_layers()-1, this.output_deltas(), learning_rate);
		
		for(int i=this.get_num_layers()-2; i>0;--i)
		{
			deltas = this.internal_deltas(i, prev_deltas);
			this.update_thresh(i, deltas, learning_rate);
			this.update_weights(i, deltas, learning_rate);
			prev_deltas = deltas;
		}
	}

	//Backprop helper functions

	//Calculates the differences
	//between the ideal output from
	//the keys and the actual output for backprop.
	//Scales the difference with a weight
	//provided by the derivative of the
	//activation function on the input to the node.
	//See class handout, backprop eq.1 for reference.
	public double [] output_deltas()
	{
		double [] output_deltas = new double [this.get_num_outputs()];
		for (int i=0; i<this.get_num_outputs();++i)
		{
			double delta = this.output_val(i) - this.get_current_keys(i);
			delta = delta * act_fnctn_deriv(this.output_layer.get_node(i).get_input());
			output_deltas[i] = delta;
		}
		return output_deltas;
	}

	//Calculates the new delta for backprop,
	//using the current weights of the layers
	//scaled by their corresponding deltas
	//from the next layer and the derivative
	//of the activation function on their input.
	//See class handout, backprop eq.2 for reference.
	public double[] internal_deltas(int layer, double [] prev_deltas)
	{
		double [] internal_deltas = new double [this.get_layer(layer).get_length()];
		Layer left_layer = this.get_layer(layer);
		Layer right_layer = this.get_layer(layer+1);

		for(int i=0; i<left_layer.get_length(); ++i)
		{
			double current_delta = 0.0;
			for(int j=0; j<right_layer.get_length();++j)
			{
				current_delta += right_layer.get_node(j).get_weight(i) * prev_deltas[j];
			}
			current_delta = current_delta * act_fnctn_deriv(left_layer.get_node(i).get_input());
			internal_deltas[i] = current_delta;
		}
		return internal_deltas;
	}

	//Calculates the new weights for left_layer for backprop.
	//Multiplies the raw output of the left_layer by
	//the learning rate and the delta from the right_layer
	//that corresponds to the weight being changed,
	//and then adds it to the current weight.
	//See class handout, backprop eq.3 for reference.
	public void update_weights(int layer, double [] deltas, double learning_rate)
	{
		Layer current_layer = this.get_layer(layer);
		Layer left_layer = this.get_layer(layer-1);
		for(int i = 0; i < current_layer.get_length(); i++)
		{
			Node current_node = current_layer.get_node(i);
			for(int j = 0; j < left_layer.get_length(); j++)
			{
				double new_weight = left_layer.get_node(j).get_raw_output() * deltas[i] * learning_rate;
				current_node.set_weight(j, current_node.get_weight(j)-new_weight);
			}
		}
	}

	//To update the threshold internal
	//to each node. The threshold is essentially
	//a negative valued node in the preceding layer
	//and is updated identically to other weights,
	//through the same process.
	public void update_thresh(int layer, double [] deltas, double learning_rate)
	{
		Layer current_layer = this.get_layer(layer);
		for(int i=0; i<current_layer.get_length(); ++i)
		{
			Node current_node = current_layer.get_node(i);
			double new_thresh = learning_rate * deltas[i];
			new_thresh = current_node.get_threshold() - new_thresh;
			current_node.set_threshold(new_thresh);
		}
	}
	

	public double act_fnctn(double x)
	{
		if ((x<=1.22) && (x>=-1.22))
		{
			return linear_approx(x);
		}
		//used limit method for approximating e^-x
		x=(1+x*(.03125));//multiplication is faster than division
		x=x*x;			//faster then using pow function (x^2)
		x=x*x;			//x^4
		x=x*x;			//x^8
		x=x*x;			//x^16
		x=x*x;			//x^32
					//did 5 times because log(32)/log(2)is 5
		return (x / (x + 1));		// use x/(x+1)
	}

	//Derivative of activation function,
	//for use in backpropagation
	double act_fnctn_deriv(double x) //assumes x has already been calculated in the my sigmoid function
	{
		double d = act_fnctn(x);
		return d*(1-d);
	}

	//A helper function for the activation
	//function, to approximate a linear
	//region about 0.
	public double linear_approx(double x)
	{
	//return mx+b
	return (.23105)*x+.5;
	}

	//Receives a key-value pair of Strings
	//and assigns the values to the input 
	//neurons, and the key to the 'keys' arr
	//to be tested against for accuracy scoring
	public void process_input(Training_pair pair)
	{
		String delim = " ";
		String[] vals = pair.get_vals().split(delim);
		String[] keys = pair.get_keys().split(delim);
		this.current_keys = new double [this.get_num_outputs()];
		
		
		for(int i=0;i<vals.length;++i)
		{
			double val = Double.parseDouble(vals[i]);
			this.input_layer.get_node(i).set_raw_output(val);
		}

		for(int i=0;i<keys.length;++i)
		{
			this.current_keys[i] = Double.parseDouble(keys[i]);
		}
	}

	//this is where we read the file with our font into the net
	public void create_alphabet(String alphabet_file, int letters)
	{
		try
		{
			this.training_alphabet = new Training_pair [letters];
			FileInputStream ifs = new FileInputStream(alphabet_file);
			BufferedReader read = new BufferedReader(new InputStreamReader(ifs));
			read.read();
			read.read();
			read.read();

			for(int i=0; i<letters; ++i)
			{
				String values = read.readLine();
				String keys = read.readLine();
				Training_pair pair = new Training_pair(values, keys);
				training_alphabet[i] = pair;
			}
		
			read.close();
			ifs.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Your file couldn't be found.");
		}
		catch (IOException ex)
		{
			System.out.println("An IO Exception occured.");
		}
	}

	//Uses index to reference a node in the
	//output layer, returning the result
	//of the activation function vs. the 
	//threshold
	public double output_val(int index)
	{
		Node current_node = this.output_layer.get_node(index);
		double out_val= current_node.get_raw_output();
		return out_val;
	}


	//Getter functions
		public Layer get_layer(int index)
		{
			return all_layers[index];
		}
	 
		public int get_num_layers()
		{
			return num_layers;
		}
	 
		public int get_num_inputs()
		{
			return inputs;
		}
	 
		public int get_hidden_length()
		{
			return hidden_length;
		}
	 
		public int get_num_outputs()
		{
			return outputs;
		}
	 
		public double get_current_keys(int index)
		{
			return current_keys[index];
		}
	 
		public Training_pair get_letter(int index)
		{
			return training_alphabet[index];
		}
	 
		public int get_alphabet_length()
		{
			return training_alphabet.length;
		}
		
		//Setter functions
		
		public void set_num_inputs(int inputs)
		{
			this.inputs = inputs;
		}
	 
		public void set_num_outputs(int outputs)
		{
			this.outputs = outputs;
		}
		
		public void set_hidden_length(int h_l)
		{
			this.hidden_length = h_l;
		}
		
		public void set_num_layers(int num_layers)
		{
			this.num_layers = num_layers;
		}

}
