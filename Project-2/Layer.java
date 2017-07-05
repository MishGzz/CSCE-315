package application;

//Vector container for nodes with locational
//information

class public Layer{
	private Node [] nodes;
	private int length;//how many nodes
	private int index; //which layer, from 0 (input)

	//To set the index value and length of each layer
	public Layer(int i, int l)
	{
		index = i;
		length = l;
		nodes = new Node[length];
	}

	public void init_nodes(double def_weight, double def_thresh,
			       int prev_layer_length, double margin)
	{
		for (int i = 0; i < length; ++i)
		{
			nodes[i] = new Node(0, 0, prev_layer_length);
		}
	}

	public int get_length()
	{
		return length;
	}

	public int get_index()
	{
		return index;
	}

	public Node get_node(int index)
	{
		return nodes[index];
	}
	
	public void set_length(int l)
	{
		length = l;
	}
	
	public void set_index(int i)
	{
		index = i;
	}
	
	public void set_node(int i, Node n)
	{
		if(n != null){
			nodes[i] = n;
		}
		else{
			System.out.println("n was null");
		}
	}
}
